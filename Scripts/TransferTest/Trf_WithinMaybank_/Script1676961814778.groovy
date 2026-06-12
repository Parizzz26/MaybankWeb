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

//def privTranCategory = tranCategory
//def privTranType = tranType
println(((GlobalVariable.MESSAGE + tranCategory) + ' ') + tranType)

WebUI.verifyCheckpoint(findCheckpoint('Checkpoints/CheckpointTransferWithinMaybank'), true)

//WebUI.openBrowser(GlobalVariable.URL)
//WebUI.maximizeWindow()
//CustomKeywords.'MyKeywords.login'()
'login steps'
WebUI.callTestCase(findTestCase('Login/ValidLogin'), [:], FailureHandling.STOP_ON_FAILURE)

'navigate to transaction page (payment page)'
CustomKeywords.'MyKeywords.navigateToTransactionMainPage'()

//'navigate to transfer page'
//CustomKeywords.'MyKeywords.navigateToTransferPage'()
WebUI.click(findTestObject('Page_DashboardAccount/qp_Transfer'))

//WebUI.click(findTestObject('Page_DashboardAccount/qp_Transfer'))
'dropdown SOF'
WebUI.click(findTestObject('Page_Transfer/qbody_Dropdown Transfer Source Account and Type'))

//WebUI.click(findTestObject('Page_Transfer/qdiv_Source Account Number'))
'SOF'
WebUI.click(findTestObject('Page_Transfer/qdiv_Source Account'))

//WebUI.click(findTestObject('Object Repository/Page_Transfer/body_You need to enable JavaScript to run t_dfbfad'))
'dropdown transfer type'
WebUI.click(findTestObject('Page_Transfer/qbody_Dropdown Transfer Source Account and Type'))

'transfer type'
WebUI.click(findTestObject('Page_Transfer/qdiv_Transfer Type'))

'select within maybank'
WebUI.click(findTestObject('Page_Transfer/qdiv_Transfer Within Maybank'))

'input beneficiary account'
WebUI.setText(findTestObject('Object Repository/Modal_TransferWithinMaybank/qinput_Beneficiary Account'), beneficiaryMaybankAccount)

//'input beneficiary account & dropdown ccy list' 
//WebUI.sendKeys(findTestObject('Page_Transfer/qinput_Beneficiary Account'), Keys.chord('1003760941', Keys.TAB, Keys.ENTER))
'expand dropdown ccy listst'
WebUI.sendKeys(findTestObject('Object Repository/Modal_TransferWithinMaybank/qinput_Beneficiary Account'), Keys.chord(Keys.TAB, 
        Keys.ENTER))

'ccy IDR'
WebUI.click(findTestObject('Object Repository/Modal_TransferWithinMaybank/qlist_Beneficiary Currency'))

'amount to be transfer'
WebUI.setText(findTestObject('Modal_TransferWithinMaybank/qinput_Transfer Amount'), amountTobeTransfered)

'message'
WebUI.setText(findTestObject('Modal_TransferWithinMaybank/qinput_Message'), GlobalVariable.MESSAGE)

WebUI.verifyElementText(findTestObject('Object Repository/Modal_TransferWithinMaybank/span_Amount Transfer'), GlobalVariable.AMOUNT, 
    FailureHandling.OPTIONAL)

'button transfer'
WebUI.click(findTestObject('Object Repository/Modal_TransferWithinMaybank/qbutton_Transfer Within Maybank'))

'request and input TAC'
CustomKeywords.'MyKeywords.requestAndInputTac'()

'verify transfer type'
WebUI.verifyElementText(findTestObject('Page_Result/qp_Text Transfer Type'), tranType)

//'verify amount '
//WebUI.verifyTextPresent('IDR 22,000.00', false, FailureHandling.OPTIONAL)
'verify status transaksi'
WebUI.verifyElementText(findTestObject('Page_Result/qh1_Test Transaksi Sukses'), GlobalVariable.TRANSTATUS)

//'capture'
WebUI.takeFullPageScreenshot('Test/Demo.png')

