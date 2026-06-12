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

def transactionType = 'Own Account'

println(((GlobalVariable.MESSAGE + transactionCategory) + ' ') + transactionType)

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

'SOF'
WebUI.click(findTestObject('Modal_TransferOwnAccount/qdropdown_TransferFrom2'))

WebUI.click(findTestObject('Modal_TransferOwnAccount/qdropdown_PaymentFrom'))

WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferTo2'))

WebUI.click(findTestObject('Modal_TransferOwnAccount/qdropdown_PaymentFor'))

WebUI.click(findTestObject('Modal_TransferOwnAccount/qinput_Beneficiary Own Account v1'))

WebUI.setText(findTestObject('Modal_TransferOwnAccount/qinput_amount'), GlobalVariable.AMOUNT)

WebUI.click(findTestObject('Modal_TransferOwnAccount/qddown_inputTgl'))

WebUI.click(findTestObject('Modal_TransferOwnAccount/qdropdown_date'))

WebUI.click(findTestObject('Modal_TransferOwnAccount/q_selectStartDate'))

'take screenshot after transaction detail'
Date today = new Date()

GlobalVariable.TIMESTAMP = today.format('MM-dd-yy')

String nowTime = today.format('hh-mm-ss')

WebUI.delay(3)

//WebUI.takeScreenshot(((('D:/.Katalon SS/TFOwnAccountDate' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')

WebUI.takeFullPageScreenshot(((('D:/.Katalon Present/TFOwnAccountDate' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')

'button transfer'
WebUI.click(findTestObject('Modal_TransferOwnAccount/qbutton_Transfer'))

CustomKeywords.'MyKeywords.requestAndInputTac'()

WebUI.verifyElementText(findTestObject('Modal_TransferOwnAccount/qp_Text Transfer Type'), transactionType)

WebUI.verifyElementText(findTestObject('Page_Result/qh1_Test Transaksi Sukses'), GlobalVariable.TRANSTATUSDATE)

CustomKeywords.'MyKeywords.logout'()

//WebUI.takeFullPageScreenshot(((('D:/.Katalon SS/TFOwnAccountDate' + GlobalVariable.TIMESTAMP) + '_') + nowTime) + '.png')
'take screenshot after success'
def amt = WebUI.getText(findTestObject('Page_Maybank2u/q_validNominal'))

amt = amt.replace('- IDR ', '').replace(',', '').replace('.00', '')

println(amt)

WebUI.verifyEqual(amt, GlobalVariable.AMOUNT)