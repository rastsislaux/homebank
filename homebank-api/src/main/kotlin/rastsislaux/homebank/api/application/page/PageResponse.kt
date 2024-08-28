package rastsislaux.homebank.api.application.page

data class PageResponse<T>(
    val content: List<T>,
    val size: Long,
    val page: Long,
    val totalElements: Long,
    val totalPages: Long,
) {
    constructor(content: List<T>, size: Long, page: Long, totalElements: Long) : this(
        totalElements = totalElements,
        totalPages = totalElements / size,
        page = page,
        size = size,
        content = content,
    )

    companion object {
        fun <T> from(
            list: List<T>,
            pageRequest: PageRequest,
        ) = PageResponse(
            content = list,
            size = pageRequest.size,
            page = pageRequest.page,
            totalElements = -1,
            totalPages = -1,
        )
    }
}
