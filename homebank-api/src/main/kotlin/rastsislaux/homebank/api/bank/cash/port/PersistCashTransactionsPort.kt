package rastsislaux.homebank.api.bank.cash.port

import rastsislaux.homebank.api.bank.cash.CashTransaction

interface PersistCashTransactionsPort {
    fun persist(transaction: CashTransaction)

    fun persist(transactions: List<CashTransaction>)
}
