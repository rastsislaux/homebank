package rastsislaux.homebank.api.bank.priorbank

import com.google.cloud.firestore.DocumentSnapshot
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class DocumentSnapshotToPriorbankTransactionConverter : Converter<DocumentSnapshot, PriorbankTransaction> {
    override fun convert(source: DocumentSnapshot): PriorbankTransaction {
        if (source.getString("_provider") != "PRIORBANK") {
            throw IllegalStateException("Non priorbank transaction document snapshot was passed to this converter.")
        }

        return PriorbankTransaction(
            date = source.getTimestamp("date")!!.toSqlTimestamp().toLocalDateTime(),
            category = source.getString("category")!!,
            operation = source.getString("operation")!!,
            sum = source.getDouble("sum")!!,
            currency = source.getString("currency")!!,
        )
    }
}
