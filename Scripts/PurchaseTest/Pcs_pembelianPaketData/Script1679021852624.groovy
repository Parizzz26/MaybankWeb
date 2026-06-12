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

def transactionCategory = 'Purchase'

def transactionType = 'Pembelian Paket Data'

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

WebUI.click(findTestObject('Page_DashboardAccount/qp_Purchase'))

WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferFrom2'))

WebUI.click(findTestObject('Page_Transfer/qval_SourceAccount2'))

'pilih jenis purchase'
WebUI.click(findTestObject('Page_Transfer/qdropdown_TransferTo2'))

WebUI.click(findTestObject('Modal_PrcPaketData/qdropdown_pulsa'))

WebUI.click(findTestObject('Modal_PrcPaketData/qdropdown_provider'))

WebUI.click(findTestObject('Modal_PrcPaketData/qval_provider'))

'input nomor telepon'
WebUI.setText(findTestObject('Modal_PrcPulsa/qinput_provNo'), mobileNo)

WebUI.click(findTestObject('Modal_PrcPulsa/qdrop_amountPulsa'))

WebUI.click(findTestObject('Modal_PrcPulsa/qval_amountPulsa'))

WebUI.click(findTestObject('Page_Transfer/qbutton_Purchase'))

CustomKeywords.'MyKeywords.requestAndInputTac'()

WebUI.verifyElementText(findTestObject('Page_Result/qp_Text Transfer Type'), tranType)

CustomKeywords.'MyKeywords.logout'()

