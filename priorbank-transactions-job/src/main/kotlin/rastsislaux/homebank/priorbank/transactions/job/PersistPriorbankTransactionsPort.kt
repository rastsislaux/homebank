package rastsislaux.homebank.priorbank.transactions.job

interface PersistPriorbankTransactionsPort {
    fun persist(priorbankTransactions: List<PriorbankTransaction>)
}
