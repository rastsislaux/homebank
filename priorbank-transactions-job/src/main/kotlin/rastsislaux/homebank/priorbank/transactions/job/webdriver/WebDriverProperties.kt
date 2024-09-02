package rastsislaux.homebank.priorbank.transactions.job.webdriver

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("homebank.web-driver")
data class WebDriverProperties(
    val type: String,
)
