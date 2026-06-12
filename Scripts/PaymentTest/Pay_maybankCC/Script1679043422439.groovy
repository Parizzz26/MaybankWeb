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

def transactionType = 'Pembayaran Maybank CC'

//println(((GlobalVariable.MESSAGE + tranCategory) + ' ') + tranType)
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

WebUI.click(findTestObject('Page_DashboardAccount/qbutton_Transaction'))

WebUI.click(findTestObject('Page_DashboardAccount/qp_Payment'))

WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferFrom2'))

WebUI.click(findTestObject('Modal_PayMaybankCC/qdropdown_PaymentFrom'))

WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferTo2'))

WebUI.click(findTestObject('Modal_PayMaybankCC/qdropdown_PaymentFor'))

WebUI.click(findTestObject('Modal_PayMaybankCC/qdropdown_bills'))

WebUI.click(findTestObject('Modal_PayMaybankCC/qddown_listCC'))

WebUI.click(findTestObject('Modal_PayMaybankCC/qdropdown_holderCC'))

WebUI.click(findTestObject('Modal_PayMaybankCC/qdropdown_holder'))

WebUI.setText(findTestObject('Modal_PayMaybankCC/qinput_noCC'), custNo)

WebUI.setText(findTestObject('Modal_PayMaybankCC/qinput_amountCC'), amount)

WebUI.click(findTestObject('Modal_PayMaybankCC/qbutton_pay'))

CustomKeywords.'MyKeywords.requestAndInputTac'()

CustomKeywords.'MyKeywords.logout'()

def amt = WebUI.getText(findTestObject('Page_Maybank2u/q_validNominal'))

amt = amt.replace('- IDR ', '').replace(',', '').replace('.00', '')

println(amt)

WebUI.verifyEqual(amt, amount)