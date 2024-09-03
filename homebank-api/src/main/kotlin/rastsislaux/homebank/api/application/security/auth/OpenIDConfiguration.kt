package rastsislaux.homebank.api.application.security.auth

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import rastsislaux.homebank.api.application.security.SecurityProperties
import java.net.MalformedURLException
import java.net.URI
import java.net.URL

@Component
class OpenIDConfiguration(
    securityProperties: SecurityProperties,
) {
    @Suppress("UNCHECKED_CAST")
    private val configuration: Map<String, Any> =
        RestTemplate().getForObject(
            securityProperties.sso.openIdConfigurationUrl,
            MutableMap::class.java,
        ) as Map<String, Any>

    val jwksUrl
        get(): URL {
            try {
                return URI.create(configuration["jwks_uri"] as String).toURL()
            } catch (e: MalformedURLException) {
                throw IllegalStateException(e)
            }
        }

    val authorizationEndpoint
        get(): String = configuration["authorization_endpoint"] as String
}
