package rastsislaux.homebank.api.application.security.auth

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt

class HBAuthentication(
    private val jwt: Jwt,
    private val principal: HBPrincipal,
    authority: Collection<GrantedAuthority>,
) : AbstractAuthenticationToken(authority) {
    override fun getCredentials() = jwt

    override fun getPrincipal() = principal

    override fun isAuthenticated() = true
}
