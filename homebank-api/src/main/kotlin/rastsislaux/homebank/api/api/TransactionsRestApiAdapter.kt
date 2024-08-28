package rastsislaux.homebank.api.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rastsislaux.homebank.api.application.page.PageRequest
import rastsislaux.homebank.api.domain.transaction.TransactionService

@RestController
@RequestMapping("/api/v1/transactions")
class TransactionsRestApiAdapter(
    private val transactionService: TransactionService,
) {
    @GetMapping
    fun retrieveBankTransactions(pageRequest: PageRequest) = transactionService.getTransactions(pageRequest)
}
