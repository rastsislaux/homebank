package rastsislaux.homebank.api.domain.account

interface BankAccount {
    val accountName: String
    val bank: String
    val balance: Double
    val currency: String
}
