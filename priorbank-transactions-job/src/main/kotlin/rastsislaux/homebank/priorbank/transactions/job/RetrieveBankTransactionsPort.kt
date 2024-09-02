package rastsislaux.homebank.priorbank.transactions.job

import java.time.LocalDateTime

interface RetrieveBankTransactionsPort {
    fun getTransactions(startDate: LocalDateTime): List<BankTransaction>
}
