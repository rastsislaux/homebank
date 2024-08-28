package rastsislaux.homebank.api.bank.priorbank.adapter

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.springframework.stereotype.Component
import rastsislaux.homebank.api.application.webdriver.WebDriverHelper
import rastsislaux.homebank.api.bank.priorbank.PriorbankAccount
import rastsislaux.homebank.api.bank.priorbank.port.RetrievePriorbankAccountsPort
import rastsislaux.homebank.api.bank.priorbank.webdriver.PriorbankAuthenticatedWebDriverFactory
import rastsislaux.homebank.api.bank.priorbank.webdriver.PriorbankWebDriverHelper
import rastsislaux.homebank.api.domain.account.BankAccount

@Component
class RetrievePriorbankAccountsAdapter(
    private val driverFactory: PriorbankAuthenticatedWebDriverFactory,
) : RetrievePriorbankAccountsPort {
    override fun getAccounts(): List<BankAccount> {
        val driver = driverFactory.createAuthenticatedDriver()
        val helper = WebDriverHelper(driver)
        val priorbankDriver = PriorbankWebDriverHelper(driver)

        priorbankDriver.navigateToCards()

        val tbody = helper.waitElement(By.tagName("tbody"))
        val rows = tbody.findElements(By.tagName("tr"))
        val accounts =
            rows
                .stream()
                .map { row: WebElement ->
                    PriorbankAccount(
                        parseAccountName(row),
                        parseBalance(row),
                        "BYN",
                    )
                }.toList()
        driver.quit()
        return accounts
    }

    private fun parseBalance(row: WebElement): Double =
        row
            .findElement(By.className("total-amount"))
            .findElement(By.className("sum"))
            .getAttribute("innerHTML")
            .replace(" ", "")
            .toDouble()

    private fun parseAccountName(row: WebElement): String {
        val accountNameHTML =
            row
                .findElement(By.className("cards-row-text"))
                .getAttribute("innerHTML")
        val sb = StringBuilder()
        for (ch in accountNameHTML.toCharArray()) {
            if (ch == ' ') break
            sb.append(ch)
        }
        return sb.toString()
    }
}
