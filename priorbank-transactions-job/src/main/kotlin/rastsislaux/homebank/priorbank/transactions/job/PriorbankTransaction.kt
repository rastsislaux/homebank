package rastsislaux.homebank.priorbank.transactions.job

import java.time.LocalDateTime

class PriorbankTransaction(
    override val date: LocalDateTime,
    override val operation: String,
    override val sum: Double,
    override val currency: String,
    override val category: String,
) : BankTransaction {
    override val provider: String
        get() = "PRIORBANK"
}
