package rastsislaux.homebank.api.bank.cash.adapter

import com.google.cloud.Timestamp
import com.google.cloud.firestore.Firestore
import org.springframework.stereotype.Component
import rastsislaux.homebank.api.application.firestore.FirestoreProperties
import rastsislaux.homebank.api.bank.cash.CashTransaction
import rastsislaux.homebank.api.bank.cash.port.PersistCashTransactionsPort

@Component
class PersistCashTransactionsAdapter(
    private val firestore: Firestore,
    private val firestoreProperties: FirestoreProperties,
) : PersistCashTransactionsPort {
    override fun persist(transactions: List<CashTransaction>) {
        val writeBatch = firestore.batch()
        val collection = firestore.collection(firestoreProperties.collections.transactions)

        transactions.forEach {
            val docRef = collection.document("CASH[date=${it.date}, op=${it.operation}]")
            writeBatch.set(
                docRef,
                mapOf(
                    "date" to Timestamp.of(java.sql.Timestamp.valueOf(it.date)),
                    "operation" to it.operation,
                    "sum" to it.sum,
                    "currency" to it.currency,
                    "category" to it.category,
                    "_provider" to "CASH",
                ),
            )
        }

        writeBatch.commit()
    }

    override fun persist(transaction: CashTransaction) {
        persist(listOf(transaction))
    }
}
