package rastsislaux.homebank.api.domain.transaction.port

import rastsislaux.homebank.api.application.page.PageRequest
import rastsislaux.homebank.api.application.page.PageResponse
import rastsislaux.homebank.api.domain.transaction.BankTransaction

interface RetrievePersistedBankTransactionsPort {
    fun getTransactions(pageRequest: PageRequest): PageResponse<BankTransaction>
}
