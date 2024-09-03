package rastsislaux.homebank.api.application.security.auth

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration(
    private val authenticationConverter: AuthenticationConverter,
    private val authErrorHandler: AuthErrorHandler,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .oauth2ResourceServer { oauth2 ->
                oauth2
                    .jwt { jwt ->
                        jwt.jwtAuthenticationConverter(authenticationConverter)
                    }.authenticationEntryPoint(authErrorHandler)
                    .accessDeniedHandler(authErrorHandler)
            }.csrf { it.disable() }
            .authorizeHttpRequests { it.anyRequest().authenticated() }
            .build()
}
