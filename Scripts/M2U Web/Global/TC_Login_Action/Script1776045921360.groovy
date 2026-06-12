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

user = user

password = password

WebUI.setText(findTestObject('Object Repository/M2U WEB/Global/txt_Username'), user, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/M2U WEB/Global/btn_Masuk'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/M2U WEB/Global/btn_Ya'), FailureHandling.CONTINUE_ON_FAILURE)

//CustomKeywords.'m2u.webByPass.openCloseInspect'()

WebUI.setText(findTestObject('M2U WEB/Global/txt_Password'), password, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('M2U WEB/Global/btn_Masuk Pass'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('M2U WEB/Transfer/lbl_Rekening Saya'), 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.delay(3)