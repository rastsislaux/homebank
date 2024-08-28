package rastsislaux.homebank.api.bank.priorbank.webdriver

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import rastsislaux.homebank.api.application.webdriver.WebDriverHelper

class PriorbankWebDriverHelper(
    private val driver: WebDriver,
) {
    private val helper = WebDriverHelper(driver)

    fun performLogin(
        login: String,
        password: String,
    ) {
        val helper = WebDriverHelper(driver)

        driver.get("https://www.prior.by/web/")
        helper.waitElement(By.name("UserName")).sendKeys(login)
        helper.waitElement(By.name("Password")).sendKeys(password)
        helper.waitElement(By.name("Password")).sendKeys(Keys.ENTER)
    }

    fun navigateToCards() {
        helper.waitElement(By.className("icon-my-products")).click()
        helper.waitElement(By.cssSelector("a[href='/web/Cabinet/BankCards/']")).click()
    }

    fun downloadBankStatement() {
        helper
            .waitElement(
                By.xpath(
                    "/html/body/main/div/div[3]/div[1]/div/div/div/div/div/div/div[2]/div[1]/div[1]/div/div/table/thead/tr/th[1]/div/input",
                ),
            ).click()
        helper.waitElement(By.xpath("//*[@data-link-action='history']")).click()
        helper
            .waitElement(
                By.xpath("//*[@id=\"cardTabs-2\"]/div/div/div[1]/div[2]/form/div/div[2]/div[1]/div/div/div[2]/div/div/div/label[4]/span"),
            ).click()
        helper.waitElement(By.xpath("//*[@id=\"cardTabs-2\"]/div/div/div[1]/div[2]/form/div/div[2]/div[2]/div/button[2]")).click()
        helper.waitElement(By.className("file-icon-csv")).click()
    }
}
