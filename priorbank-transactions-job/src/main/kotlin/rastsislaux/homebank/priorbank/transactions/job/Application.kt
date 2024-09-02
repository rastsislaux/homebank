package rastsislaux.homebank.priorbank.transactions.job

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import rastsislaux.homebank.priorbank.transactions.job.job.PersistPriorbankTransactionsJob

@SpringBootApplication
@ConfigurationPropertiesScan
class Job(
    private val persistPriorbankTransactionsJob: PersistPriorbankTransactionsJob,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        logger.atInfo().log("Starting transactions job")
        persistPriorbankTransactionsJob.persistPriorbankTransactions()
        logger.atInfo().log("Finished transactions job")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(Job::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<Job>(*args)
}
