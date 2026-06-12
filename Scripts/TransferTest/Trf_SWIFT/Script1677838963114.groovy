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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

println(((GlobalVariable.MESSAGE + tranCategory) + ' ') + tranType)

'step login'
WebUI.callTestCase(findTestCase('Login/ValidLogin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotVisible(findTestObject('Page_DashboardAccount/qimg_Loading2'), 20)

'navigate to transfer page'
CustomKeywords.'MyKeywords.navigateToTransferPage'()

'expand dropdown acc list'
WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferFrom2'))

'select sof'
WebUI.click(findTestObject('Page_Transfer/qval_SourceAccount2'))

'expand transfer type'
WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferTo2'))

'select swift'
WebUI.click(findTestObject('Page_Transfer/qval_Transfer SWIFT'))

WebUI.setText(findTestObject('Page_Transfer/qinput_Bank name'), 'mandiri')

WebUI.click(findTestObject('Page_Transfer/qbutton_Search'))

WebUI.click(findTestObject('Page_Transfer/qa_link swift code'))

'input transaction detail'
WebUI.setText(findTestObject('Modal_Transfer SWIFT/qinput_Account number'), customerNumber, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Modal_Transfer SWIFT/qdrop_Currency list'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Modal_Transfer SWIFT/qval_Currency'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Modal_Transfer SWIFT/qinput_Transfer amount'), '12')

WebUI.click(findTestObject('Modal_Transfer SWIFT/qdrop_Transaction charge'))

WebUI.click(findTestObject('Modal_Transfer SWIFT/qval_borne'))

WebUI.setText(findTestObject('Modal_Transfer SWIFT/qinput_Beneficiary name'), 'SIT KATALON')

WebUI.setText(findTestObject('Modal_Transfer SWIFT/qinput_Beneficiary addr 1'), 'Jalan Baru')

WebUI.setText(findTestObject('Modal_Transfer SWIFT/qinput_beneficiary addr 2'), 'Kota Baru')

WebUI.setText(findTestObject('Modal_Transfer SWIFT/qinput_Beneficiary addr 3'), 'Country Baru')

WebUI.setText(findTestObject('Modal_Transfer SWIFT/qinput_Message'), GlobalVariable.MESSAGE)

WebUI.setText(findTestObject('Modal_Transfer SWIFT/qinput_Beneficiary email'), GlobalVariable.EMAIL)

WebUI.scrollToElement(findTestObject('Object Repository/Modal_Transfer SWIFT/qinput_Account number'), 5)

'take screenshot after transaction detail'
Date today = new Date()

GlobalVariable.TIMESTAMP = today.format('MM-dd-yy')

String nowTime = today.format('hh-mm-ss')

WebUI.delay(3)

WebUI.takeFullPageScreenshot(((('D:/.Katalon SS/TFSWIFT' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')

WebUI.click(findTestObject('Modal_Transfer SWIFT/qspan_Button transfer'))

CustomKeywords.'MyKeywords.requestAndInputTac'()

'verify transfer type'
WebUI.verifyElementText(findTestObject('Page_Result/qp_Text Transfer Type'), tranType)

'verify status transaksi'
WebUI.verifyElementText(findTestObject('Page_Result/qh1_Test Transaksi Sukses'), GlobalVariable.TRANSTATUS)

'capture'
WebUI.takeFullPageScreenshot(((('D:/.Katalon SS/TFSWIFT(2)' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')

