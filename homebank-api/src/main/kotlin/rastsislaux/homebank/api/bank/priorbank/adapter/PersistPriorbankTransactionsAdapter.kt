package rastsislaux.homebank.api.bank.priorbank.adapter

import com.google.cloud.Timestamp
import com.google.cloud.firestore.Firestore
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import rastsislaux.homebank.api.application.firestore.FirestoreProperties
import rastsislaux.homebank.api.bank.priorbank.PriorbankTransaction
import rastsislaux.homebank.api.bank.priorbank.port.PersistPriorbankTransactionsPort

@Component
@ConditionalOnProperty("homebank.priorbank.persistent-adapter", havingValue = "firestore")
class PersistPriorbankTransactionsAdapter(
    private val firestore: Firestore,
    private val firestoreProperties: FirestoreProperties,
) : PersistPriorbankTransactionsPort {
    override fun persist(priorbankTransactions: List<PriorbankTransaction>) {
        val writeBatch = firestore.batch()

        val collection = firestore.collection(firestoreProperties.collections.transactions)
        priorbankTransactions.forEach {
            val docRef = collection.document("PRIORBANK[date=${it.date}, op=${it.operation}]")
            writeBatch.set(
                docRef,
                mapOf(
                    "date" to Timestamp.of(java.sql.Timestamp.valueOf(it.date)),
                    "operation" to it.operation,
                    "sum" to it.sum,
                    "currency" to it.currency,
                    "category" to it.category,
                    "_provider" to "PRIORBANK",
                ),
            )
        }

        writeBatch.commit().get()
    }
}
