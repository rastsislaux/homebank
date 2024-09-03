package rastsislaux.homebank.api.application.security.auth

import com.nimbusds.jose.proc.JWSAlgorithmFamilyJWSKeySelector
import com.nimbusds.jose.proc.JWSKeySelector
import com.nimbusds.jose.proc.SecurityContext
import com.nimbusds.jwt.proc.DefaultJWTProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.core.OAuth2Error
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
import rastsislaux.homebank.api.application.security.SecurityProperties

@Configuration
class JwtDecoderConfiguration(
    private val openIDConfiguration: OpenIDConfiguration,
    private val securityProperties: SecurityProperties,
) {
    @Bean
    fun jwsKeySelector(): JWSKeySelector<SecurityContext> = JWSAlgorithmFamilyJWSKeySelector.fromJWKSetURL(openIDConfiguration.jwksUrl)

    @Bean
    fun jwtProcessor(selector: JWSKeySelector<SecurityContext>): DefaultJWTProcessor<SecurityContext> =
        DefaultJWTProcessor<SecurityContext>().apply {
            setJWSKeySelector(selector)
        }

    @Bean
    fun jwtDecoder(processor: DefaultJWTProcessor<SecurityContext>) =
        NimbusJwtDecoder(processor).apply {
            setJwtValidator(::validator)
        }

    fun validator(token: Jwt): OAuth2TokenValidatorResult {
        // TODO: Replace with proper check
        if (token.getClaimAsString("email") != "rostislav.lipsky@gmail.com") {
            return OAuth2TokenValidatorResult.failure(NOT_IN_WHITELIST)
        }

        val audience = token.audience

        val isClientIdCorrect = audience.contains(securityProperties.sso.clientId)
        if (!isClientIdCorrect) {
            return OAuth2TokenValidatorResult.failure(INVALID_CLIENT_ID_ERROR)
        }

        return OAuth2TokenValidatorResult.success()
    }

    companion object {
        val INVALID_CLIENT_ID_ERROR: OAuth2Error =
            OAuth2Error("invalid_client_id", "Invalid client ID.", null)
        val NOT_IN_WHITELIST: OAuth2Error =
            OAuth2Error("not_in_whitelist", "Not in whitelist", null)
    }
}
