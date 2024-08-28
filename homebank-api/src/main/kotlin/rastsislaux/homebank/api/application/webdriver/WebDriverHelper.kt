package rastsislaux.homebank.api.application.webdriver

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.io.File
import java.time.Duration
import java.util.*

class WebDriverHelper(
    private val driver: WebDriver,
) {
    fun waitElement(by: By?): WebElement =
        WebDriverWait(driver, Duration.ofSeconds(10)).until(
            ExpectedConditions.presenceOfElementLocated(by),
        )

    companion object {
        fun getLatestDownloadedFile(): File {
            val path = System.getProperty("user.home") + "/Downloads"
            return getNewestFile(path)
        }

        private fun getNewestFile(dirPath: String): File {
            val directory = File(dirPath)
            val files = directory.listFiles()
            return Arrays
                .stream(files)
                .max(Comparator.comparingLong(File::lastModified))
                .get()
        }
    }
}
