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

'select RTGS'
WebUI.click(findTestObject('Page_Transfer/qval_Transfer RTGS'))

WebUI.click(findTestObject('Page_Transfer/qdropdown_Select bank RTGS'))

WebUI.click(findTestObject('Modal_Transfer RTGS/qval_RTGS Bank Amar'))

'input transaction detail'
WebUI.setText(findTestObject('Modal_Transfer RTGS/qinput_Customer Number'), customerNumber, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Modal_Transfer RTGS/qinput_Transfer amount'), transferAmount)

WebUI.setText(findTestObject('Modal_Transfer RTGS/qinput_Beneficiary name'), 'Sit Katalon')

WebUI.click(findTestObject('Modal_Transfer RTGS/qdropdown_Source of fund'))

WebUI.click(findTestObject('Modal_Transfer LLG SKN/qval_List inheritance'))

WebUI.click(findTestObject('Modal_Transfer RTGS/qdropdown_Transaction purpose'))

WebUI.click(findTestObject('Modal_Transfer RTGS/qval_List loan'))

WebUI.click(findTestObject('Modal_Transfer RTGS/qdropdown_Beneficiary type'))

WebUI.click(findTestObject('Modal_Transfer RTGS/qval_List government'))

WebUI.click(findTestObject('Modal_Transfer RTGS/qdropdown_Beneficiary citizen status'))

WebUI.click(findTestObject('Modal_Transfer RTGS/qval_List non-citizen'))

WebUI.verifyElementAttributeValue(findTestObject('Modal_Transfer RTGS/qinput_Beneficiary bank label'), 'value', 'BTPN RTGS', 
    0)

WebUI.click(findTestObject('Modal_Transfer RTGS/q_setReccur'))

WebUI.click(findTestObject('Modal_Transfer RTGS/q_frequency'))

WebUI.click(findTestObject('Modal_Transfer RTGS/q_selectFrequency'))

WebUI.click(findTestObject('Modal_Transfer RTGS/q_startDate'))

WebUI.click(findTestObject('Modal_Transfer RTGS/q_selectStartDate'))

WebUI.click(findTestObject('Modal_Transfer RTGS/q_endDate'))

WebUI.click(findTestObject('Modal_Transfer RTGS/q_nextMonth'))

WebUI.click(findTestObject('Modal_Transfer RTGS/q_selectEndDate'))

WebUI.scrollToElement(findTestObject('Object Repository/Modal_Transfer SWIFT/qinput_Account number'), 5)

'take screenshot after transaction detail'
Date today = new Date()

GlobalVariable.TIMESTAMP = today.format('MM-dd-yy')

String nowTime = today.format('hh-mm-ss')

WebUI.delay(3)

WebUI.takeFullPageScreenshot(((('D:/.Katalon SS/TFRTGSDateRec' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')

WebUI.click(findTestObject('Modal_Transfer LLG SKN/qbutton_Transfer'))

CustomKeywords.'MyKeywords.requestAndInputTac'()

WebUI.takeFullPageScreenshot(((('D:/.Katalon SS/TFRTGSDateRec1' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')

'verify transfer type'
WebUI.verifyElementText(findTestObject('Page_Result/qp_Text Transfer Type'), tranType)

'verify status transaksi'
WebUI.verifyElementText(findTestObject('Page_Result/qh1_Test Transaksi Sukses'), GlobalVariable.TRANSTATUSDATE)

CustomKeywords.'MyKeywords.logout'()

WebUI.click(findTestObject('Page_Maybank2u/q_validNominal'))

