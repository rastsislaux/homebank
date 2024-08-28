package rastsislaux.homebank.api.bank.priorbank

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "homebank.priorbank")
data class PriorbankProperties(
    val login: String,
    val password: String,
    val persistentAdapter: String,
)
