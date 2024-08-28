package rastsislaux.homebank.api.bank.priorbank.adapter

import com.google.cloud.firestore.Firestore
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import rastsislaux.homebank.api.application.firestore.FirestoreProperties
import rastsislaux.homebank.api.bank.priorbank.PriorbankTransaction
import rastsislaux.homebank.api.bank.priorbank.port.RetrievePriorbankTransactionsPort
import rastsislaux.homebank.api.domain.transaction.BankTransaction
import java.time.LocalDateTime

@Component
@ConditionalOnProperty("homebank.priorbank.persistent-adapter", havingValue = "firestore")
@Qualifier("persistentRetrievePriorbankTransactionsAdapter")
class PersistentRetrievePriorbankTransactionsAdapter(
    private val firestore: Firestore,
    private val firestoreProperties: FirestoreProperties,
) : RetrievePriorbankTransactionsPort {
    override fun getTransactions(startDate: LocalDateTime): List<BankTransaction> =
        firestore
            .collection(firestoreProperties.collections.transactions)
            .listDocuments()
            .map {
                it.get().get().toObject(PriorbankTransaction::class.java)!!
            }
}
