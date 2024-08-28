package rastsislaux.homebank.api.bank.cash

interface CashService {
    fun createCashTransaction(cashTransaction: CashTransaction)
}
