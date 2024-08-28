package rastsislaux.homebank.api.application.hash

interface HashService {
    fun digest(obj: Any): String
}
