package rastsislaux.homebank.api.bank.cash

import rastsislaux.homebank.api.domain.account.BankAccount

class CashAccount(
    override val accountName: String,
    override val balance: Double,
    override val currency: String,
) : BankAccount {
    override val bank
        get() = "Cash"
}
