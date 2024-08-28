package rastsislaux.homebank.api.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import rastsislaux.homebank.api.bank.priorbank.PriorbankService

@RestController
@RequestMapping("/api/v1/priorbank")
class PriorbankRestApiAdapter(
    private val priorbankService: PriorbankService,
) {
    @PostMapping("/bank-statement")
    fun uploadBankStatement(
        @RequestParam file: MultipartFile,
    ) = priorbankService.uploadStatement(file)
}
