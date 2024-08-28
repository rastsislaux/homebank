package rastsislaux.homebank.api.domain.transaction

import org.springframework.stereotype.Service
import rastsislaux.homebank.api.application.page.PageRequest
import rastsislaux.homebank.api.application.page.PageResponse
import rastsislaux.homebank.api.domain.transaction.port.RetrievePersistedBankTransactionsPort

@Service
class TransactionServiceImpl(
    private val retrievePersistedTransactionsPort: RetrievePersistedBankTransactionsPort,
) : TransactionService {
    override fun getTransactions(pageRequest: PageRequest): PageResponse<BankTransaction> =
        retrievePersistedTransactionsPort.getTransactions(pageRequest)
}
