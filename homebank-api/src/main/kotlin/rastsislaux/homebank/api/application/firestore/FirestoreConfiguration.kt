package rastsislaux.homebank.api.application.firestore

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.FirestoreOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FirestoreConfiguration(
    firestoreProperties: FirestoreProperties,
) {
    private val firestoreOptions =
        FirestoreOptions
            .getDefaultInstance()
            .toBuilder()
            .setProjectId(firestoreProperties.projectId)
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .build()

    @Bean
    fun firestore(): Firestore = firestoreOptions.service
}
