package rastsislaux.homebank.api.bank.priorbank.adapter

import org.springframework.stereotype.Component
import rastsislaux.homebank.api.application.webdriver.WebDriverHelper
import rastsislaux.homebank.api.bank.priorbank.PriorbankStatementParser
import rastsislaux.homebank.api.bank.priorbank.PriorbankTransaction
import rastsislaux.homebank.api.bank.priorbank.port.RetrievePriorbankTransactionsPort
import rastsislaux.homebank.api.bank.priorbank.webdriver.PriorbankAuthenticatedWebDriverFactory
import rastsislaux.homebank.api.bank.priorbank.webdriver.PriorbankWebDriverHelper
import java.io.FileReader
import java.nio.charset.Charset
import java.time.LocalDateTime

@Component
class RetrievePriorbankTransactionsAdapter(
    private val driverFactory: PriorbankAuthenticatedWebDriverFactory,
) : RetrievePriorbankTransactionsPort {
    override fun getTransactions(startDate: LocalDateTime): List<PriorbankTransaction> {
        val driver = driverFactory.createAuthenticatedDriver()
        val priorbankDriver = PriorbankWebDriverHelper(driver)

        priorbankDriver.navigateToCards()
        priorbankDriver.downloadBankStatement()

        Thread.sleep(2000)
        driver.quit()

        val reader =
            FileReader(
                WebDriverHelper.getLatestDownloadedFile(),
                Charset.forName(
                    PRIORBANK_STATEMENT_ENCODING,
                ),
            )
        val transactions = PriorbankStatementParser(reader).parse()

        return transactions
            .filter { it.date.isAfter(startDate) }
            .sortedByDescending { it.date }
    }

    companion object {
        private const val PRIORBANK_STATEMENT_ENCODING = "windows-1251"
    }
}
