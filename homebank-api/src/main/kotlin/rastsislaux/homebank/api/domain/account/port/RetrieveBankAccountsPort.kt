package rastsislaux.homebank.api.domain.account.port

import rastsislaux.homebank.api.domain.account.BankAccount

interface RetrieveBankAccountsPort {
    fun getAccounts(): List<BankAccount>
}
