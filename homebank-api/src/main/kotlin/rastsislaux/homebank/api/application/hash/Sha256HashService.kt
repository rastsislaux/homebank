package rastsislaux.homebank.api.application.hash

import org.springframework.stereotype.Service
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@Service
class Sha256HashService : HashService {
    @OptIn(ExperimentalEncodingApi::class)
    override fun digest(obj: Any): String {
        try {
            val digest = MessageDigest.getInstance("SHA-256")
            val hash: ByteArray = digest.digest(obj.toString().toByteArray())
            return Base64.encode(hash)
        } catch (e: NoSuchAlgorithmException) {
            throw IllegalStateException("SHA-256 not supported", e)
        }
    }
}
