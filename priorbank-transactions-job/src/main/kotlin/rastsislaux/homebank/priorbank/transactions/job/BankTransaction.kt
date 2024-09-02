package rastsislaux.homebank.priorbank.transactions.job

import java.time.LocalDateTime

interface BankTransaction {
    val date: LocalDateTime
    val operation: String
    val sum: Double
    val currency: String
    val category: String
    val provider: String
}
