package rastsislaux.homebank.api.bank.priorbank.port

import org.springframework.web.multipart.MultipartFile

interface HandlePriorbankStatementFilePort {
    fun handleStatementFile(statementFile: MultipartFile)
}
