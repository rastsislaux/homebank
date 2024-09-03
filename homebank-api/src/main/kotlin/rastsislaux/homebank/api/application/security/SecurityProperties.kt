package rastsislaux.homebank.api.application.security

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("homebank.security")
data class SecurityProperties(
    val sso: SSO,
) {
    data class SSO(
        val openIdConfigurationUrl: String,
        val clientId: String,
    )
}
