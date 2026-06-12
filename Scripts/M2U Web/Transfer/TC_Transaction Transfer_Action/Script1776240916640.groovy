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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

rekening = rekening

amount = amount

type = type

email = email

pesan = pesan

xpath = "//ul/li[@role='option'][$type]"


WebUI.setText(findTestObject('M2U WEB/Transfer/txt_Nomor Rekening'), rekening)

WebUI.delay(3)

if (WebUI.verifyElementPresent(findTestObject('M2U WEB/Transfer/lbl_Transfer Antar Rekening Maybank'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('M2U WEB/Transfer/txt_Pilih Currency'))

    WebUI.click(findTestObject('M2U WEB/Global/lbl_blank', [('xpath') : xpath]))
}

WebUI.setText(findTestObject('M2U WEB/Global/txt_Input Amount'), amount)

WebUI.delay(3)

if (WebUI.verifyElementPresent(findTestObject('M2U WEB/Transfer/lbl_Pesan'), 3, FailureHandling.OPTIONAL)) {
    WebUI.setText(findTestObject('M2U WEB/Transfer/txt_Pesan'), pesan)
}

WebUI.delay(3)

if(WebUI.verifyElementPresent(findTestObject('M2U WEB/Transfer/lbl_Email'), 3, FailureHandling.OPTIONAL)) {
	WebUI.setText(findTestObject('M2U WEB/Transfer/txt_Email'), email)
}

