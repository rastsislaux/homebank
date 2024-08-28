package rastsislaux.homebank.api.bank.priorbank.job

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import rastsislaux.homebank.api.bank.priorbank.PriorbankTransaction
import rastsislaux.homebank.api.bank.priorbank.port.PersistPriorbankTransactionsPort
import rastsislaux.homebank.api.bank.priorbank.port.RetrievePriorbankTransactionsPort
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

@Component
class PersistPriorbankTransactionsJob(
    @Qualifier("retrievePriorbankTransactionsAdapter")
    private val retrievePriorbankTransactionsPort: RetrievePriorbankTransactionsPort,
    private val persistPriorbankTransactionsPort: PersistPriorbankTransactionsPort,
) {
    // @PostConstruct
    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.MINUTES)
    fun persistPriorbankTransactions() {
        val statement = retrievePriorbankTransactionsPort.getTransactions(LocalDateTime.now().minusYears(1))
        @Suppress("UNCHECKED_CAST")
        persistPriorbankTransactionsPort.persist(statement as List<PriorbankTransaction>)
    }
}
