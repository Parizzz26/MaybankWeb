import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class MyKeywords {

	@Keyword(keywordObject = 'loginPage' )
	def login() {
		WebUI.setText(findTestObject('Object Repository/Page_Maybank2u/qinput_Login Username'), 'ntbfau35')
		WebUI.click(findTestObject('Object Repository/Page_Maybank2u/qspan_Masuk'))
		WebUI.click(findTestObject('Object Repository/Page_Maybank2u/qbutton_Ya'))
		WebUI.setText(findTestObject('Object Repository/Page_Maybank2u/qinput_Login Password'), 'Mbi123456')
		WebUI.delay(20)
		WebUI.click(findTestObject('Object Repository/Page_Maybank2u/qbutton_Masuk'))
	}

	@Keyword(keywordObject = 'dashboardPage')
	def navigateToTransactionMainPage() {
		'wait button MY TRANSACTION'
		WebUI.waitForElementPresent(findTestObject('Page_DashboardAccount/qbutton_Transaction'), 20)
		'button MY TRANSACTION'
		WebUI.click(findTestObject('Page_DashboardAccount/qbutton_Transaction'))
	}

	@Keyword(keywordObject = 'paymentPage')
	def navigateToPaymentPage() {
		'wait button MY TRANSACTION'
		WebUI.waitForElementPresent(findTestObject('Page_DashboardAccount/qbutton_Transaction'), 20)
		'button MY TRANSACTION'
		WebUI.click(findTestObject('Page_DashboardAccount/qbutton_Transaction'))
		'button PAYMENT'
		WebUI.click(findTestObject('Page_DashboardAccount/qp_Payment'))
	}

	@Keyword(keywordObject = 'transactionPage')
	def navigateToTransferPage() {
		'wait button MY TRANSACTION'
		WebUI.waitForElementPresent(findTestObject('Page_DashboardAccount/qbutton_Transaction'), 20)

		'button MY TRANSACTION'
		WebUI.click(findTestObject('Page_DashboardAccount/qbutton_Transaction'))

		'wait button TRANSFER'
		WebUI.waitForElementPresent(findTestObject('/Page_DashboardAccount/qp_Transfer'), 20)

		'button TRANSFER'
		WebUI.click(findTestObject('Page_DashboardAccount/qp_Transfer'))
	}

	@Keyword(keywordObject = 'confirmationPage')
	def requestAndInputTac() {
		'button Req TAC - confirmation page'
		WebUI.click(findTestObject('Object Repository/Page_Confirmation/qbutton_Request TAC'))
		'field TAC - confirmation page'
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_Confirmation/qinput_TAC Code'), GlobalVariable.TAC)
		'button CONFIRM - confirmation page'
		WebUI.click(findTestObject('Object Repository/Page_Confirmation/qbutton_Confirm'))
	}

	@Keyword(keywordObject = 'logoutPage')
	def logout() {
		'button burger menu'
		WebUI.click(findTestObject('Object Repository/Page_Maybank2u/q_burgerMenu'))
		'button logout'
		WebUI.click(findTestObject('Object Repository/Page_Maybank2u/q_logout'))
	}
	@Keyword(keywordObject = 'loginEmail')
	def loginEmail() {
		//WebUI.openBrowser(GlobalVariable.EMAILURL)
		WebUI.maximizeWindow()
		WebUI.setText(findTestObject('Object Repository/Modal_EmailNotif/q_fieldUsn'), GlobalVariable.EMAILUSN)
		WebUI.setText(findTestObject('Object Repository/Modal_EmailNotif/q_fieldPass'), GlobalVariable.EMAILPWD)
		WebUI.click(findTestObject('Object Repository/Modal_EmailNotif/qbutton_signin'))
		WebUI.click(findTestObject('Object Repository/Modal_EmailNotif/qclick_inbox'))
	}
	@Keyword(keywordObject = 'validate')
	def validasiEmail() {
		def subject = WebUI.getText(findTestObject('Object Repository/Modal_EmailNotif/qfield_subjectEmail'))
		WebUI.verifyMatch(subject, '^M2U ID.*', true)

		def body = WebUI.getText(findTestObject('Object Repository/Modal_EmailNotif/q_bodyEmail'))
		if (body.contains('M2U ID')) {
			println('first text found')
		}
		if (body.contains('OTP, TAC, PIN, CVC / CVV,')) {
			println('second text found')
		}
		if (body.contains('PT Bank Maybank Indonesia Tbk berizin')) {
			println('third text found')
		}
	}
}