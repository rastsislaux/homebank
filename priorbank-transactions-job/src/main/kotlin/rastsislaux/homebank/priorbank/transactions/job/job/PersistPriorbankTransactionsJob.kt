package rastsislaux.homebank.priorbank.transactions.job.job

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import rastsislaux.homebank.priorbank.transactions.job.PersistPriorbankTransactionsPort
import rastsislaux.homebank.priorbank.transactions.job.PriorbankTransaction
import rastsislaux.homebank.priorbank.transactions.job.RetrievePriorbankTransactionsPort
import java.time.LocalDateTime

@Component
class PersistPriorbankTransactionsJob(
    @Qualifier("retrievePriorbankTransactionsAdapter")
    private val retrievePriorbankTransactionsPort: RetrievePriorbankTransactionsPort,
    private val persistPriorbankTransactionsPort: PersistPriorbankTransactionsPort,
) {
    fun persistPriorbankTransactions() {
        val statement = retrievePriorbankTransactionsPort.getTransactions(LocalDateTime.now().minusYears(1))
        @Suppress("UNCHECKED_CAST")
        persistPriorbankTransactionsPort.persist(statement as List<PriorbankTransaction>)
    }
}
