package rastsislaux.homebank.api.bank.priorbank.port

import rastsislaux.homebank.api.bank.priorbank.PriorbankTransaction

interface PersistPriorbankTransactionsPort {
    fun persist(priorbankTransactions: List<PriorbankTransaction>)
}
