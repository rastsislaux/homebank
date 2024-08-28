package rastsislaux.homebank.api.bank.cash.adapter

import com.google.cloud.firestore.Firestore
import org.springframework.stereotype.Component
import rastsislaux.homebank.api.application.firestore.FirestoreProperties
import rastsislaux.homebank.api.bank.cash.CashAccount
import rastsislaux.homebank.api.bank.cash.port.RetrieveCashAccountsPort

@Component
class RetrieveCashAccountsAdapter(
    private val firestore: Firestore,
    private val firestoreProperties: FirestoreProperties,
) : RetrieveCashAccountsPort {
    override fun getAccounts(): List<CashAccount> =
        firestore
            .collection(firestoreProperties.collections.cashAccounts)
            .listDocuments()
            .map { it.get().get().toObject(CashAccount::class.java)!! }
}
