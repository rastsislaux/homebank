package rastsislaux.homebank.api.bank.cash

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("homebank.cash")
data class CashProperties(
    val persistentAdapter: String,
)
