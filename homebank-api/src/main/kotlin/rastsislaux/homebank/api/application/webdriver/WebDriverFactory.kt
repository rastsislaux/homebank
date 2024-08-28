package rastsislaux.homebank.api.application.webdriver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

interface WebDriverFactory {
    fun createDriver(): WebDriver
}

@Component
@ConditionalOnProperty("homebank.web-driver.type", havingValue = "chrome-headless")
class ChromeHeadlessWebDriverFactory : WebDriverFactory {
    override fun createDriver(): WebDriver {
        val options = ChromeOptions()
        options.addArguments("--headless")
        options.addArguments("--disable-gpu")
        options.addArguments("--window-size=1400,800")
        return ChromeDriver(options)
    }
}

@Component
@ConditionalOnProperty("homebank.web-driver.type", havingValue = "chrome")
class ChromeWebDriverFactory : WebDriverFactory {
    override fun createDriver() = ChromeDriver()
}
