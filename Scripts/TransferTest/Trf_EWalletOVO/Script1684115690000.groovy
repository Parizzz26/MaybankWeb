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

'select e wallet'
WebUI.click(findTestObject('Page_Transfer/qval_Transfer EWallet'))

'expand ewallet option'
WebUI.click(findTestObject('Page_Transfer/qdropdown_EWallet'))

'select OVO'
WebUI.click(findTestObject('Page_Transfer/qval_Payee OVO'))

'input transaction detail'
WebUI.setText(findTestObject('Modal_Transfer EWallet/qinput_Customer Number'), customerNumber)

WebUI.setText(findTestObject('Modal_Transfer EWallet/qinput_Transfer Amount'), transferAmount)

'take screenshot after transaction detail'
Date today = new Date()

GlobalVariable.TIMESTAMP = today.format('MM-dd-yy')

String nowTime = today.format('hh-mm-ss')

WebUI.delay(3)

WebUI.takeScreenshot(((('D:/.Katalon SS/TrfEWallet' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')

WebUI.click(findTestObject('Modal_Transfer EWallet/qbutton_Transfer'))

CustomKeywords.'MyKeywords.requestAndInputTac'()

'verify transfer type'
WebUI.verifyElementText(findTestObject('Page_Result/qp_Text Transfer Type'), tranType)

'verify status transaksi'
WebUI.verifyElementText(findTestObject('Page_Result/qh1_Test Transaksi Sukses'), GlobalVariable.TRANSTATUS)

'capture'
WebUI.takeFullPageScreenshot(((('D:/.Katalon SS/TrfEWallet' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')

CustomKeywords.'MyKeywords.logout'()

//int fee = Integer.parseInt(GlobalVariable.FEE)
//
//int gv = Integer.parseInt(GlobalVariable.AMOUNT)
//
//def total = gv.toInteger() + fee.toInteger()
//
//println(total)

def amt = WebUI.getText(findTestObject('Object Repository/Page_Result/q_validAmount'))

amt = amt.replace('- IDR ', '').replace(',', '').replace('.00', '')

println(amt)

WebUI.verifyEqual(amt, transferAmount)