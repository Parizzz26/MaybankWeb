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

def transactionCategory = 'Transfer'

def transactionType = 'Within Maybank'

println(((GlobalVariable.MESSAGE + tranCategory) + ' ') + tranType)

WebUI.openBrowser(GlobalVariable.URL)

//WebUI.navigateToUrl('https://10.230.196.17/home/')
WebUI.maximizeWindow()

'field input username'
WebUI.setText(findTestObject('Object Repository/Page_Maybank2u/qinput_Login Username'), GlobalVariable.USERNAME)

WebUI.click(findTestObject('Page_Maybank2u/qspan_Masuk'))

'button konfirmasi security img'
WebUI.waitForElementPresent(findTestObject('Page_Maybank2u/qbutton_Ya'), 10)

WebUI.click(findTestObject('Page_Maybank2u/qbutton_Ya'))

'field input passwd'
WebUI.setText(findTestObject('Object Repository/Page_Maybank2u/qinput_Login Password'), GlobalVariable.PASSWORD)

WebUI.click(findTestObject('Object Repository/Page_Maybank2u_01/qbutton_Masuk'))

WebUI.waitForElementPresent(findTestObject('Page_DashboardAccount/qbutton_Transaction'), 20)

'button MY TRANSACTION'
WebUI.click(findTestObject('Page_DashboardAccount/qbutton_Transaction'))

'button TRANSFER'
WebUI.click(findTestObject('Page_DashboardAccount/qp_Transfer'))

'expand dropdown acc list'
WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferFrom2'))

'select sof'
WebUI.click(findTestObject('Page_Transfer/qval_SourceAccount2'))

'expand transfer type'
WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferTo2'))

'select within maybank'
WebUI.click(findTestObject('Page_Transfer/qval_Transfer Within Maybank'))

WebUI.setText(findTestObject('Modal_TransferWithinMaybank/qinput_Beneficiary Account'), beneficiaryMaybankAccount)

'dropdown ccy list'
WebUI.click(findTestObject('Modal_TransferWithinMaybank/qdropdown_Currency'))

WebUI.click(findTestObject('Modal_TransferWithinMaybank/qval_Currency IDR'))

'amount to be transfer'
WebUI.setText(findTestObject('Modal_TransferWithinMaybank/qinput_Transfer Amount'), transferAmount)

WebUI.click(findTestObject('Modal_TransferWithinMaybank/qddown_inputTgl'))

WebUI.click(findTestObject('Modal_TransferWithinMaybank/qdropdown_date'))

WebUI.click(findTestObject('Modal_TransferWithinMaybank/q_selectStartDate'))

'message'
WebUI.setText(findTestObject('Modal_TransferWithinMaybank/qinput_Message'), GlobalVariable.MESSAGE)

'take screenshot after transaction detail'
Date today = new Date()

GlobalVariable.TIMESTAMP = today.format('MM-dd-yy')

String nowTime = today.format('hh-mm-ss')

WebUI.delay(3)

//WebUI.takeScreenshot(((('D:/.Katalon SS/TFWithinMaybankDate' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')
'button transfer'
WebUI.click(findTestObject('Object Repository/Modal_TransferWithinMaybank/qbutton_Transfer Within Maybank'))

//'confirm date as desired'
//def slcDate = WebUI.getText(findTestObject('Object Repository/Modal_TransferWithinMaybank/q_selectStartDate'))
//
//def rlDate = WebUI.getText(findTestObject('Object Repository/Page_Transfer/q_validDate'))
//
//WebUI.verifyMatch(slcDate, rlDate, true)

'request and input TAC'
CustomKeywords.'MyKeywords.requestAndInputTac'()

'verify transfer type'
WebUI.verifyElementText(findTestObject('Page_Result/qp_Text Transfer Type'), tranType)

//'verify amount '
//WebUI.verifyTextPresent('IDR 22,000.00', false, FailureHandling.OPTIONAL)
'verify status transaksi'
WebUI.verifyElementText(findTestObject('Page_Result/qh1_Test Transaksi Sukses'), GlobalVariable.TRANSTATUSDATE)

//'capture'
WebUI.takeFullPageScreenshot(((('D:/.Katalon SS/TFWithinMaybankDate(1)' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + 
    '.png')

