package rastsislaux.homebank.api.api

import org.springframework.core.convert.ConversionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rastsislaux.homebank.api.domain.account.port.RetrieveBankAccountsPort
import rastsislaux.homebank.api.domain.account.presentation.BankAccountDto

@RestController
@RequestMapping("/api/v1/accounts")
class AccountRestAdapter(
    private val retrieveBankAccountsPorts: List<RetrieveBankAccountsPort>,
    private val conversionService: ConversionService,
) {
    @GetMapping
    fun getAccounts() =
        retrieveBankAccountsPorts
            .map { it.getAccounts() }
            .flatten()
            .map { conversionService.convert(it, BankAccountDto::class.java) }
}
