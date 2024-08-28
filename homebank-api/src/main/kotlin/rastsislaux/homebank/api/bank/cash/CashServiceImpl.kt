package rastsislaux.homebank.api.bank.cash

import org.springframework.stereotype.Service
import rastsislaux.homebank.api.bank.cash.port.PersistCashTransactionsPort

@Service
class CashServiceImpl(
    private val persistCashTransactionsPort: PersistCashTransactionsPort,
) : CashService {
    override fun createCashTransaction(cashTransaction: CashTransaction) {
        persistCashTransactionsPort.persist(cashTransaction)
    }
}
