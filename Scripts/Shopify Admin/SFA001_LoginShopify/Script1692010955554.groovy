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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.Capabilities as Capabilities
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Cookie as Cookie

//// Initialize Chrome Driver
//System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())
//// Initialize Chrome Option to customize the Chrome Driver
//ChromeOptions options = new ChromeOptions()
//
//options.addArguments('start-maximized')
//
//WebDriver driver = new ChromeDriver(options)
////Update the Web Driver with customized options
//DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl(url)

WebUI.waitForElementVisible(h2_yourstore, 5)

WebUI.click(h2_yourstore)

WebUI.waitForElementVisible(txt_email, 3)

WebUI.sendKeys(txt_email, username)

WebUI.waitForElementVisible(btn_continue, 5)

WebUI.click(btn_continue)

WebUI.waitForElementVisible(txt_password, 3)

WebUI.setEncryptedText(txt_password, GlobalVariable.default_password)

WebUI.click(btn_login, FailureHandling.STOP_ON_FAILURE)

// Skip two-factor authentication if reminded
while (WebUI.verifyElementPresent(a_remind_later, 3, FailureHandling.OPTIONAL)) {
    try {
		
		WebUI.click(a_remind_later, FailureHandling.STOP_ON_FAILURE)
 
    }
    catch (Exception e) {
        println(e)
    }
} 

WebUI.takeFullPageScreenshot('screenshot/loginSPF_success.png')