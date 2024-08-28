package rastsislaux.homebank.api.domain.transaction.adapter

import com.google.cloud.firestore.Firestore
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Component
import rastsislaux.homebank.api.application.firestore.FirestoreProperties
import rastsislaux.homebank.api.application.page.PageRequest
import rastsislaux.homebank.api.application.page.PageResponse
import rastsislaux.homebank.api.bank.cash.CashTransaction
import rastsislaux.homebank.api.bank.priorbank.PriorbankTransaction
import rastsislaux.homebank.api.domain.transaction.BankTransaction
import rastsislaux.homebank.api.domain.transaction.port.RetrievePersistedBankTransactionsPort

@Component
class RetrievePersistedTransactionsAdapter(
    private val firestore: Firestore,
    private val firestoreProperties: FirestoreProperties,
    private val conversionService: ConversionService,
) : RetrievePersistedBankTransactionsPort {
    override fun getTransactions(pageRequest: PageRequest): PageResponse<BankTransaction> =
        pageRequest
            .query(
                firestore
                    .collection(firestoreProperties.collections.transactions),
            ).get()
            .get()
            .documents
            .map {
                when (it.getString("_provider")) {
                    "PRIORBANK" -> conversionService.convert(it, PriorbankTransaction::class.java)
                    "CASH" -> conversionService.convert(it, CashTransaction::class.java)
                    else -> throw IllegalStateException(
                        "Can't deserialize transaction from unknown provider: ${
                            it.getString(
                                "_provider",
                            )
                        }",
                    )
                } as BankTransaction
            }.let { PageResponse.from(it, pageRequest) }
}
