package test

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date;
import java.util.StringTokenizer;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import groovy.json.JsonSlurper



@Keyword
def loadCookiesFromFile(String filePath) {
	File cookiesFile = new File(filePath)

	if (cookiesFile.exists()) {
		List<String> cookiesList = cookiesFile.readLines()

		cookiesList.each { cookieString ->
			String[] cookieAttributes = cookieString.split(";")
			String name = cookieAttributes[0]
			String value = cookieAttributes[1]
			String domain = cookieAttributes[2]
			String path = cookieAttributes[3]
			Date expiry = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(cookieAttributes[4])
			boolean isSecure = Boolean.parseBoolean(cookieAttributes[5])

			Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure)
			WebDriver driver = DriverFactory.getWebDriver()
			driver.manage().addCookie(cookie)
		}}}