package rastsislaux.homebank.api.bank.cash

import com.google.cloud.firestore.DocumentSnapshot
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class DocumentSnapshotToCashTransactionConverter : Converter<DocumentSnapshot, CashTransaction> {
    override fun convert(source: DocumentSnapshot): CashTransaction {
        if (source.getString("_provider") != "CASH") {
            throw IllegalStateException("Non cash transaction document snapshot was passed to this converter.")
        }

        return CashTransaction(
            date = source.getTimestamp("date")!!.toSqlTimestamp().toLocalDateTime(),
            category = source.getString("category")!!,
            operation = source.getString("operation")!!,
            sum = source.getDouble("sum")!!,
            currency = source.getString("currency")!!,
        )
    }
}
