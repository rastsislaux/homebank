package rastsislaux.homebank.api.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rastsislaux.homebank.api.bank.cash.CashService
import rastsislaux.homebank.api.bank.cash.CashTransaction

@RestController
@RequestMapping("/api/v1/cash")
class CashRestApiAdapter(
    private val cashService: CashService,
) {
    @PostMapping("/transaction")
    fun createCashTransaction(
        @RequestBody cashTransaction: CashTransaction,
    ) = cashService.createCashTransaction(cashTransaction)
}
