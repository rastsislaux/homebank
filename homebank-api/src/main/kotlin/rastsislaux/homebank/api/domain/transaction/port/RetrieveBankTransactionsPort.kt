package rastsislaux.homebank.api.domain.transaction.port

import rastsislaux.homebank.api.domain.transaction.BankTransaction
import java.time.LocalDateTime

interface RetrieveBankTransactionsPort {
    fun getTransactions(startDate: LocalDateTime): List<BankTransaction>
}
