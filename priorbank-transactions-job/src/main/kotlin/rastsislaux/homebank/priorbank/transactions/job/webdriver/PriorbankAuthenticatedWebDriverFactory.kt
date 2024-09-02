package rastsislaux.homebank.priorbank.transactions.job.webdriver

import org.openqa.selenium.WebDriver
import org.springframework.stereotype.Component
import rastsislaux.homebank.priorbank.transactions.job.PriorbankProperties

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
