package rastsislaux.homebank.api.bank.priorbank.webdriver

import org.openqa.selenium.WebDriver
import org.springframework.stereotype.Component
import rastsislaux.homebank.api.application.webdriver.WebDriverFactory
import rastsislaux.homebank.api.bank.priorbank.PriorbankProperties

@Component
class PriorbankAuthenticatedWebDriverFactory(
    private val webDriverFactory: WebDriverFactory,
    private val priorbankProperties: PriorbankProperties,
) {
    fun createAuthenticatedDriver(): WebDriver {
        val driver = webDriverFactory.createDriver()
        val helper = PriorbankWebDriverHelper(driver)
        helper.performLogin(priorbankProperties.login, priorbankProperties.password)
        return driver
    }
}
