package rastsislaux.homebank.api.bank.priorbank

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import rastsislaux.homebank.api.bank.priorbank.port.HandlePriorbankStatementFilePort

@Service
class PriorbankServiceImpl(
    private val handlePriorbankStatementFilePort: HandlePriorbankStatementFilePort,
) : PriorbankService {
    override fun uploadStatement(file: MultipartFile) = handlePriorbankStatementFilePort.handleStatementFile(file)
}
