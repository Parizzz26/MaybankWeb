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

WebUI.navigateToUrl('https://10.230.196.17/home/')

WebUI.maximizeWindow()

'field input username'
WebUI.setText(findTestObject('Object Repository/Page_Maybank2u_01/Page_Maybank2u/qinput_Login Username'), 'uatnewntb020')

WebUI.click(findTestObject('Object Repository/Page_Maybank2u_01/Page_Maybank2u/qspan_Masuk'))

'button konfirmasi security img'
WebUI.click(findTestObject('Object Repository/Page_Maybank2u_01/Page_Maybank2u/qbutton_Ya'))

'field input passwd'
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Maybank2u_01/Page_Maybank2u/qinput_Login Password'), 'ikzSWZQqE6T/nB5w8hjwew==')

WebUI.click(findTestObject('Object Repository/Page_Maybank2u_01/qbutton_Masuk'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_DashboardAccount/qbutton_Transaction'), 20)

'button MY TRANSACTION'
WebUI.click(findTestObject('Object Repository/Page_DashboardAccount/qbutton_Transaction'))

'button TRANSFER'
WebUI.click(findTestObject('Object Repository/Page_DashboardAccount/qp_Transfer'))

'dropdown SOF'
WebUI.click(findTestObject('Object Repository/Page_Transfer/qbody_Dropdown Transfer Source Account and Type'))

'SOF'
WebUI.click(findTestObject('Object Repository/Page_Transfer/qdiv_Source Account'))

'dropdown transfer type'
WebUI.click(findTestObject('Object Repository/Page_Transfer/qbody_Dropdown Transfer Source Account and Type'))

'transfer type'
WebUI.click(findTestObject('Object Repository/Page_Transfer/qdiv_Transfer Type'))

WebUI.click(findTestObject('Object Repository/Page_Transfer/qdiv_Transfer Type'))

'destination acc'
WebUI.click(findTestObject('Object Repository/Page_Transfer/qinput_Beneficiary Own Account v1'))

'amount - modal'
WebUI.setText(findTestObject('Object Repository/Modal_TransferOwnAccount/qinput_Transfer Amount'), '12,000')

'button TRANSFER - modal'
WebUI.click(findTestObject('Object Repository/Modal_TransferOwnAccount/qbutton_Transfer'))

'button Req TAC - confirmation page'
WebUI.click(findTestObject('Object Repository/Page_Confirmation/qbutton_Request TAC'))

'field TAC - confirmation page'
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Confirmation/qinput_TAC Code'), 'RigbBhfdqOBGNlJIWM1ClA==')

'button CONFIRM - confirmation page'
WebUI.click(findTestObject('Object Repository/Page_Confirmation/qbutton_Confirm'))

'text OWN AACCOUNT'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Maybank2u_01/Page_Maybank2u/qp_Text Own Account'), 'Own Account')

'text Transaksi Sukses'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Result/qh1_Test Transaksi Sukses'), 'Transaction successful!')

WebUI.takeFullPageScreenshot('Test/TransferOwnAccount.png')

