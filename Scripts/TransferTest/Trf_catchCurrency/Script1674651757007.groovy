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

//WebUI.maximizeWindow()
'field input username'
WebUI.setText(findTestObject('NewObjRepo/qinput_Username2'), GlobalVariable.USERNAME)

WebUI.click(findTestObject('NewObjRepo/qspan_UsernameMasuk2'))

'konfirmasi security img'
WebUI.waitForElementPresent(findTestObject('NewObjRepo/qspan_SecImgYa2'), 10)

WebUI.click(findTestObject('NewObjRepo/qspan_SecImgYa2'))

'field input passwd'
WebUI.setText(findTestObject('Object Repository/Page_Maybank2u/qinput_Login Password'), GlobalVariable.PASSWORD)

WebUI.click(findTestObject('NewObjRepo/qspan_PasswordMasuk2'))

'icon loading'
WebUI.waitForElementNotVisible(findTestObject('NewObjRepo/qimg_Loading2'), 10)

'transaction page'
WebUI.click(findTestObject('NewObjRepo/qspan_DashboardTransaction2'), FailureHandling.STOP_ON_FAILURE)

'transfer page'
WebUI.click(findTestObject('NewObjRepo/qspan_TransactionTransfer2'))

'expand dropdown list acc'
WebUI.click(findTestObject('NewObjRepo/qdropdown_TransferFrom2'))

'select sof'
WebUI.click(findTestObject('NewObjRepo/qval_SourceAccount2'))

'expand transfer type'
WebUI.click(findTestObject('NewObjRepo/qdropdown_TransferTo2'))

'select transfer type'
WebUI.click(findTestObject('NewObjRepo/qval_TransferType2'))

