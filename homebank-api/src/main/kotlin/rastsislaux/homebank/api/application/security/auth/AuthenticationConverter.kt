package rastsislaux.homebank.api.application.security.auth

import org.springframework.core.convert.converter.Converter
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Component

@Component
class AuthenticationConverter : Converter<Jwt, HBAuthentication> {
    override fun convert(jwt: Jwt): HBAuthentication {
        val principal =
            HBPrincipal(
                jwt.getClaimAsString("email"),
                jwt.getClaimAsString("name"),
            )
        return HBAuthentication(jwt, principal, emptyList())
    }
}
