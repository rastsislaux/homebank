package rastsislaux.homebank.api.bank.priorbank.adapter

import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import rastsislaux.homebank.api.bank.priorbank.PriorbankStatementParser
import rastsislaux.homebank.api.bank.priorbank.port.HandlePriorbankStatementFilePort
import java.io.InputStreamReader
import java.nio.charset.Charset

@Component
class HandlePriorbankStatementFileAdapter(
    private val persistPriorbankTransactionsAdapter: PersistPriorbankTransactionsAdapter,
) : HandlePriorbankStatementFilePort {
    override fun handleStatementFile(statementFile: MultipartFile) {
        val reader =
            InputStreamReader(
                statementFile.inputStream,
                Charset.forName(
                    PRIORBANK_STATEMENT_ENCODING,
                ),
            )
        val transactions = PriorbankStatementParser(reader).parse()
        persistPriorbankTransactionsAdapter.persist(transactions)
    }

    companion object {
        private const val PRIORBANK_STATEMENT_ENCODING = "windows-1251"
    }
}
