package rastsislaux.homebank.api.bank.priorbank

import org.springframework.web.multipart.MultipartFile
import rastsislaux.homebank.api.bank.BankingService

interface PriorbankService : BankingService {
    fun uploadStatement(file: MultipartFile)
}
