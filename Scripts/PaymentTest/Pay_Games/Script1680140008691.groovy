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

def transactionCategory = 'Payment'

def transactionType = 'Pembayaran Games Item Ku'

//println(((GlobalVariable.MESSAGE + tranCategory) + ' ') + tranType)
WebUI.openBrowser(GlobalVariable.URL)

//WebUI.navigateToUrl('https://10.230.196.17/home/')
WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('Login/ValidLogin'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'MyKeywords.navigateToPaymentPage'()

WebUI.click(findTestObject('Page_DashboardAccount/qp_Payment'))

WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferFrom2'))

WebUI.click(findTestObject('Page_Transfer/qdropdown_PaymentFrom'))

WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferTo2'))

WebUI.click(findTestObject('Modal_PayInsurance/qdropdown_PaymentFor'))

WebUI.click(findTestObject('Modal_PaypersonalLoan/qdropdown_bills'))

WebUI.click(findTestObject('Modal_PayGames/qddown_listOtherBill'))

WebUI.click(findTestObject('Modal_PaypersonalLoan/qddown_slcPayee'))

WebUI.click(findTestObject('Modal_PayGames/qdropdown_listPayee'))

WebUI.setText(findTestObject('Modal_PaypersonalLoan/qinput_custNo'), noVA)

WebUI.setText(findTestObject('Modal_PaypersonalLoan/qinput_payAmount'), amount)

WebUI.click(findTestObject('Modal_PaypersonalLoan/qbutton_pay'))

CustomKeywords.'MyKeywords.requestAndInputTac'()

WebUI.verifyElementText(findTestObject('Page_Result/qp_Text Transfer Type'), tranType)

//WebUI.verifyElementText(findTestObject('Page_Result/qh1_Test Transaksi Sukses'), GlobalVariable.TRANSTATUS)

CustomKeywords.'MyKeywords.logout'()

def amt = WebUI.getText(findTestObject('Object Repository/Page_Result/q_validAmount'))

amt = amt.replace('- IDR ', '').replace(',', '').replace('.00', '')

println(amt)

WebUI.verifyEqual(amt, amount)