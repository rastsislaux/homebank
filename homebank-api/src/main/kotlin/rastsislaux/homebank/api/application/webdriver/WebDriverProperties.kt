package rastsislaux.homebank.api.application.webdriver

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("homebank.web-driver")
data class WebDriverProperties(
    val type: String,
)
