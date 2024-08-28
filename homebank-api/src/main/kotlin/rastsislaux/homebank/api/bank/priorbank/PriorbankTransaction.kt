package rastsislaux.homebank.api.bank.priorbank

import rastsislaux.homebank.api.domain.transaction.BankTransaction
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
