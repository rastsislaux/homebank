package rastsislaux.homebank.api.application.security.auth

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import org.springframework.web.ErrorResponse
import java.io.IOException
import java.io.UncheckedIOException
import java.lang.RuntimeException

@Component
class AuthErrorHandler(
    private val objectMapper: ObjectMapper,
) : AuthenticationEntryPoint,
    AccessDeniedHandler {
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse,
        authException: AuthenticationException,
    ) {
        handleError(response, authException, HttpStatus.UNAUTHORIZED)
    }

    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: AccessDeniedException,
    ) {
        handleError(response, accessDeniedException, HttpStatus.FORBIDDEN)
    }

    private fun handleError(
        response: HttpServletResponse,
        exception: RuntimeException,
        status: HttpStatus,
    ) {
        val errorDto =
            ErrorResponse.builder(exception, status, exception.message ?: "No details.").build()

        try {
            val errorJson = objectMapper.writeValueAsString(errorDto.body)

            response.status = status.value()
            response.setHeader("Content-Type", "application/json")
            response.writer.write(errorJson)
            response.writer.flush()
        } catch (ex: IOException) {
            throw UncheckedIOException(ex)
        }
    }
}
