package rastsislaux.homebank.api.application.page

import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.Query

data class PageRequest(
    val size: Long,
    val page: Long,
    val sortBy: String,
    val sortOrder: SortOrder = SortOrder.ASC,
) {
    val offset = page * (size - 1)

    enum class SortOrder(
        val firestoreValue: Query.Direction,
    ) {
        ASC(Query.Direction.ASCENDING),
        DESC(Query.Direction.DESCENDING),
    }

    fun query(collection: CollectionReference): Query =
        collection
            .offset(offset.toInt())
            .limit(size.toInt())
            .orderBy(sortBy, sortOrder.firestoreValue)
}
