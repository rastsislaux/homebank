package rastsislaux.homebank.api.domain.account.presentation

data class BankAccountDto(
    val accountName: String,
    val bank: String,
    val balance: Double,
    val currency: String,
)
