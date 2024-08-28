package rastsislaux.homebank.api.domain.transaction

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

interface BankTransaction {
    val date: LocalDateTime
    val operation: String
    val sum: Double
    val currency: String
    val category: String

    @get:JsonProperty("_provider")
    val provider: String
}
