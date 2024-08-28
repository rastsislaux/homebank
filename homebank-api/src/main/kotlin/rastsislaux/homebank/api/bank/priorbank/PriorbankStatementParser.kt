package rastsislaux.homebank.api.bank.priorbank

import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import java.io.Reader
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PriorbankStatementParser(
    private val reader: Reader,
) {
    private val dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")

    fun parse(): List<PriorbankTransaction> {
        val csvReader = makeCsvReader(reader)
        val transactions = mutableListOf<PriorbankTransaction>()
        do {
            val next = csvReader.readNext() ?: break
            val line = next.map { it }

            if ((line.size != 10 && line.size != 9) || line[0].equals("Дата транзакции")) {
                continue
            }

            val transaction = convertRowToTransaction(line)
            transactions.add(transaction)
        } while (true)
        return transactions
    }

    private fun convertRowToTransaction(row: List<String>): PriorbankTransaction {
        var sum = row[2].replace(",", ".").replace(" ", "").toDouble()

        val isBlocked = row.size == 9
        if (isBlocked) {
            sum = -sum
        }

        val categoryIdx = row.size - 2

        return PriorbankTransaction(
            date = LocalDateTime.parse(row[0], dateTimeFormatter),
            operation = row[1],
            sum = sum,
            currency = row[3],
            category = row[categoryIdx],
        )
    }

    private fun makeCsvReader(reader: Reader) =
        CSVReaderBuilder(reader)
            .withCSVParser(
                CSVParserBuilder()
                    .withSeparator(';')
                    .withIgnoreQuotations(true)
                    .build(),
            ).build()
}
