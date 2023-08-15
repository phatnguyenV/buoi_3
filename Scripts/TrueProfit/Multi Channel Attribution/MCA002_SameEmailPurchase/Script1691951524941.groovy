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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import static org.junit.Assert.*
import org.openqa.selenium.Keys as Keys
import test.ReadExcel as ReadExcel

def AdFacebook = [('antique_drawers_1111') : '?tp_source=facebook&tp_adid=1111&tp_productid=8326381666626', ('antique_drawers_1121') : '?tp_source=facebook&tp_adid=1121&tp_productid=8326381666626'
    , ('antique_drawers_1211') : '?tp_source=facebook&tp_adid=1211&tp_productid=8326381666626', ('antique_drawers_1112') : '?tp_source=facebook&tp_adid=1112&tp_productid=8326381666626'
    , ('black_bean_1111') : '?tp_source=facebook&tp_adid=1111&tp_productid=8326382715202']

def AdGoogle = [('antique_drawers_2111') : '?tp_source=google&tp_adid=2111&tp_productid=8326381666626', ('antique_drawers_2112') : '?tp_source=google&tp_adid=2112&tp_productid=8326381666626']

def AdTiktok = [('antique_drawers_3111') : '?tp_source=tiktok&tp_adid=3111&tp_productid=8326381666626', ('antique_drawers_3112') : '?tp_source=tiktok&tp_adid=3112&tp_productid=8326381666626'
    , ('black_bean_3111') : '?tp_source=tiktok&tp_adid=3111&tp_productid=8326382715202']

def AdSnapchat = [('antique_drawers_4111') : '?tp_source=snapchat&tp_adid=4111&tp_productid=8326381666626', ('antique_drawers_4112') : '?tp_source=snapchat&tp_adid=4112&tp_productid=8326381666626'
    , ('antique_drawers_41122') : '?tp_source=snapchat&tp_adid=41122&tp_productid=8326381666626', ('antique_drawers_4113') : '?tp_source=snapchat&tp_adid=4113&tp_productid=8326381666626']

def AdPinterest = [('antique_drawers_5111') : '?tp_source=pinterest&tp_adid=5111&tp_productid=8326381666626', ('antique_drawers_5112') : '?tp_source=pinterest&tp_adid=5112&tp_productid=8326381666626']

WebUI.callTestCase(findTestCase('TrueProfit/Multi Channel Attribution/MCA001_NewLastClicked'), [('input_password') : findTestObject('Shopify Admin/StoreFront/input_password')
        , ('btn_enter') : findTestObject('Shopify Admin/StoreFront/btn_enter'), ('main_content') : findTestObject('Shopify Admin/StoreFront/main_content')
        , ('store_url') : 'https://enterprise-new.myshopify.com/', ('btn_buy_it_now') : findTestObject('Shopify Admin/StoreFront/btn_buy_it_now')
        , ('email') : findTestObject('Shopify Admin/StoreFront/input_email'), ('lastname') : findTestObject('Shopify Admin/StoreFront/input_last_name')
        , ('address') : findTestObject('Shopify Admin/StoreFront/input_address'), ('first_address_suggestion') : findTestObject('Shopify Admin/StoreFront/li_first_address')
        , ('temp_email') : findTestObject('Shopify Admin/StoreFront/input_temp_email'), ('duetime') : findTestObject('Shopify Admin/StoreFront/p_duetime')
        , ('get_another_email') : findTestObject('Shopify Admin/StoreFront/a_get_another_email'), ('extend_email') : findTestObject('Shopify Admin/StoreFront/a_extend_email')
        , ('recover_email') : findTestObject('Shopify Admin/StoreFront/a_recover_email'), ('email_timeout') : findTestObject('Shopify Admin/StoreFront/strong_email_timeout')
        , ('btn_continue') : findTestObject('Shopify Admin/StoreFront/btn_continue'), ('card_number') : findTestObject('Shopify Admin/StoreFront/input_card_number')
        , ('name_on_card') : findTestObject('Shopify Admin/StoreFront/input_name_on_card'), ('expiration') : findTestObject('Shopify Admin/StoreFront/input_expiration')
        , ('security_code') : findTestObject('Shopify Admin/StoreFront/input_security_code'), ('btn_close_suggestion') : findTestObject('Shopify Admin/StoreFront/btn_close_suggestion')
        , ('iframe_card_number') : findTestObject('Shopify Admin/StoreFront/iframe_card_number'), ('iframe_name_on_card') : findTestObject('Shopify Admin/StoreFront/iframe_name_on_card')
        , ('iframe_expiration') : findTestObject('Shopify Admin/StoreFront/iframe_expiration'), ('iframe_security_code') : findTestObject('Shopify Admin/StoreFront/iframe_security_code')
        , ('plus_quantity') : findTestObject('Shopify Admin/StoreFront/btn_plus_quantity'), ('add_to_cart') : findTestObject('Shopify Admin/StoreFront/btn_add_to_cart')
        , ('view_cart') : findTestObject('Shopify Admin/StoreFront/a_view_cart'), ('check_out') : findTestObject('Shopify Admin/StoreFront/btn_check_out')
        , ('checkout_in_cart') : findTestObject('Shopify Admin/StoreFront/btn_checkout_in_cart')], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(store_url)

WebUI.waitForPageLoad(5)

WebUI.waitForElementVisible(main_content, 5)

WebUI.navigateToUrl((store_url + 'products/antique-drawers') + AdGoogle.antique_drawers_2111)

WebUI.navigateToUrl((store_url + 'products/black-bean-bag') + AdTiktok.black_bean_3111)

WebUI.waitForElementPresent(btn_buy_it_now, 3)

WebUI.click(btn_buy_it_now)

WebUI.verifyElementPresent(email, 3)

// Specify the Excel file path and sheet name
def excelFilePath = 'TestData/temp_email_mca.xlsx'

def sheetName = 'Sheet1'

def email_10m = ''

// Read data from Excel using the custom keyword
List<Map> excelData = ReadExcel.readExcelData(excelFilePath, sheetName)

// Loop through the data and perform test steps
for (Map rowData : excelData) {
    email_10m = (rowData['Email'])
}

//Show result to Log Viewer
WebUI.comment(email_10m)

WebUI.waitForElementVisible(email, 3)

WebUI.sendKeys(email, email_10m)

WebUI.sendKeys(lastname, email_10m)

Random random = new Random()

def randomNumber = random.nextInt(999) + 1

//Convert randonNumber to a string for sendKeys
def randomInput = Integer.toString(randomNumber)

WebUI.waitForElementPresent(address, 5)

WebUI.sendKeys(address, randomInput)

WebUI.waitForElementPresent(first_address_suggestion, 5)

WebUI.click(first_address_suggestion)

//WebUI.click(btn_close_suggestion)
//click Continue to shipping
WebUI.scrollToPosition(0, 400)

WebUI.click(btn_continue)

//click Continue to payment
WebUI.waitForElementPresent(btn_continue, 2)

WebUI.click(btn_continue)

//click Continue to payment
//WebUI.waitForElementPresent(iframe_card_number, 2)
WebUI.switchToFrame(iframe_card_number, 2)

WebUI.scrollToElement(card_number, 2)

WebUI.sendKeys(card_number, '1')

WebUI.switchToDefaultContent()

WebUI.switchToFrame(iframe_name_on_card, 2)

WebUI.sendKeys(name_on_card, 'Bogus Gateway')

WebUI.switchToDefaultContent()

WebUI.switchToFrame(iframe_expiration, 2)

WebUI.sendKeys(expiration, '03')

WebUI.sendKeys(expiration, '39')

WebUI.switchToDefaultContent()

WebUI.switchToFrame(iframe_security_code, 2)

WebUI.sendKeys(security_code, '111')

WebUI.switchToDefaultContent()

WebUI.click(btn_continue)

WebUI.waitForElementPresent(span_continue_shopping, 10)

WebUI.delay(1)

