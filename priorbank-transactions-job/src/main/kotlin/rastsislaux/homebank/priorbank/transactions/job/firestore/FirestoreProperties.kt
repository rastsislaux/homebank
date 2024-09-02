package rastsislaux.homebank.priorbank.transactions.job.firestore

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "homebank.firestore")
data class FirestoreProperties(
    val projectId: String,
    val collections: Collections,
) {
    data class Collections(
        val transactions: String,
        val cashAccounts: String,
    )
}
