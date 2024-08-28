package rastsislaux.homebank.api.domain.account.mapping

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import rastsislaux.homebank.api.domain.account.BankAccount
import rastsislaux.homebank.api.domain.account.presentation.BankAccountDto

@Component
class BankAccountDtoConverter : Converter<BankAccount, BankAccountDto> {
    override fun convert(source: BankAccount): BankAccountDto =
        BankAccountDto(
            accountName = source.accountName,
            bank = source.bank,
            balance = source.balance,
            currency = source.currency,
        )
}
