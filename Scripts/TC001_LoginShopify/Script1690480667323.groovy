import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.Rectangle as Rectangle
import org.openqa.selenium.remote.server.DriverFactory as DriverFactory
import internal.GlobalVariable as GlobalVariablvere
import test.CookieRead as CookieRead
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.Capabilities as Capabilities
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import internal.GlobalVariable as GlobalVariable

System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())

ChromeOptions options = new ChromeOptions()

options.addArguments('start-maximized')

WebDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

driver.get(url)

WebUI.waitForElementVisible(h2_yourstore, 5)

WebUI.click(h2_yourstore)

WebUI.waitForElementVisible(txt_email, 3)

WebUI.sendKeys(txt_email, username)

WebUI.waitForElementVisible(btn_continue, 5)

WebUI.click(btn_continue)

WebUI.waitForElementVisible(txt_password, 3)

WebUI.setEncryptedText(txt_password, password)

WebUI.click(btn_login, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.takeFullPageScreenshot('screenshot/login_success.png')

CustomKeywords.'test.CookieRead.storeCookiesAsJson'('Cookies.data')