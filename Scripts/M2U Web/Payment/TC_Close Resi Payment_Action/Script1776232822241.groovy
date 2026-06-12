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

if (WebUI.waitForElementPresent(findTestObject('Object Repository/M2U WEB/Transfer/lbl_Kartu Kredit'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('M2U WEB/Payment/btn_Close Resi Kartu Kredit'), FailureHandling.STOP_ON_FAILURE)
} else if (WebUI.waitForElementPresent(findTestObject('Object Repository/M2U WEB/Payment/lbl_Pembayaran Tagihan Handphone'), 
    5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('M2U WEB/Payment/btn_Close Resi Pembayaran Tagihan Handphone'), FailureHandling.STOP_ON_FAILURE)
} else if (WebUI.waitForElementPresent(findTestObject('Object Repository/M2U WEB/Payment/lbl_Layanan Umum'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('M2U WEB/Payment/btn_Close Resi Layanan Umum'), FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.waitForElementPresent(findTestObject('Object Repository/M2U WEB/Payment/lbl_Tagihan Lainnya'), 5, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('M2U WEB/Payment/btn_Close Resi Tagihan Lainnya'), FailureHandling.STOP_ON_FAILURE)
}

