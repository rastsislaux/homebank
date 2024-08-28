package rastsislaux.homebank.api.bank.cash

import rastsislaux.homebank.api.domain.transaction.BankTransaction
import java.time.LocalDateTime

class CashTransaction(
    override val date: LocalDateTime,
    override val operation: String,
    override val sum: Double,
    override val currency: String,
    override val category: String,
) : BankTransaction {
    override val provider: String
        get() = "Cash"
}
