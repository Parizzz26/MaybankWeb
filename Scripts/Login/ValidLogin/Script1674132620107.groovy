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

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

'field input username'
WebUI.setText(findTestObject('Object Repository/Page_Maybank2u/qinput_Login Username'), GlobalVariable.USERNAME)

WebUI.click(findTestObject('Page_Maybank2u/qspan_Masuk'))

'konfirmasi security img'
WebUI.waitForElementPresent(findTestObject('Page_Maybank2u/qbutton_Ya'), 10)

//Date today = new Date()
//
//GlobalVariable.TIMESTAMP = today.format('MM-dd-yy')
//
//String nowTime = today.format('hh-mm-ss')
//WebUI.delay(3)
//
//WebUI.takeScreenshot(((('D:/.Katalon SS/Login' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')

//WebUI.takeScreenshot('Test/Login' + GlobalVariable.TIMESTAMP + '.png')

//WebUI.takeScreenshot(('Test/Login.png'), (['text' :  GlobalVariable.TIMESTAMP, "fontColor" : "#FF3399"]))

WebUI.click(findTestObject('Page_Maybank2u/qbutton_Ya'))

'field passwd'
WebUI.setText(findTestObject('Object Repository/Page_Maybank2u/qinput_Login Password'), GlobalVariable.PASSWORD)

WebUI.click(findTestObject('Page_Maybank2u/qbutton_Masuk'))

'cek login sukses'
WebUI.verifyElementPresent(findTestObject('Page_DashboardAccount/qimg_Maybank Logo'), 30)

println('Test Valid Login <<< PASS >>>')

