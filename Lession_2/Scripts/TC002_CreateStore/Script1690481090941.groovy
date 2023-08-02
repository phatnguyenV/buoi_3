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
import com.kms.katalon.core.configuration.RunConfiguration
import org.openqa.selenium.Rectangle as Rectangle
import org.openqa.selenium.remote.server.DriverFactory

import internal.GlobalVariable
import internal.GlobalVariable as GlobalVariablvere
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions 
import org.openqa.selenium.Capabilities
import org.openqa.selenium.remote.DesiredCapabilities


//def storeName = "phatnt-newstore-31"

WebUI.navigateToUrl(url)
WebUI.waitForElementVisible(a_select_1st_account, 10)
WebUI.click(a_select_1st_account)
WebUI.waitForElementVisible(txt_store_name, 5)
WebUI.delay(3)
WebUI.scrollToPosition(0, 300)
WebUI.delay(5)
//WebUI.sendKeys(txt_store_name, GlobalVariable.domain)
WebUI.sendKeys(txt_store_name, domain)
WebUI.delay(2)
WebUI.scrollToElement(btn_create, 5)
WebUI.waitForElementVisible(btn_create, 5)
WebUI.click(btn_create)
WebUI.waitForElementPresent(div_dashboard,90)
WebUI.takeFullPageScreenshot('screenshot/create_store_success.png')