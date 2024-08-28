package rastsislaux.homebank.api.bank.priorbank

import rastsislaux.homebank.api.domain.account.BankAccount
import java.io.Serializable

data class PriorbankAccount(
    override val accountName: String,
    override val balance: Double,
    override val currency: String,
) : BankAccount,
    Serializable {
    override val bank = "Priorbank"
}
