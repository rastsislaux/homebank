package rastsislaux.homebank.api.domain.transaction

import rastsislaux.homebank.api.application.page.PageRequest
import rastsislaux.homebank.api.application.page.PageResponse

interface TransactionService {
    fun getTransactions(pageRequest: PageRequest): PageResponse<BankTransaction>
}
