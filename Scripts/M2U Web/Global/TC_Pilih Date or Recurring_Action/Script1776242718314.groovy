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

recurring = recurring

date = date

start = start

end = end

prevS = prevS

nextS = nextS

prevE = prevE

nextE = nextE

frekuensi = frekuensi

xpath = "//div[@role='gridcell' and text()='$date']"

xpath1 = "//ul/li[@role='option'][$frekuensi]"

xpath2 = "//div[@role='gridcell' and text()='$start']"

xpath3 = "//div[@role='gridcell' and text()='$end']"

if (recurring?.toUpperCase() == 'Y') {
    //recurring
    WebUI.click(findTestObject('M2U WEB/Global/btn_Frekuensi'))

    WebUI.delay(3)

    WebUI.click(findTestObject('M2U WEB/Global/lbl_blank', [('xpath') : xpath1]))

    WebUI.click(findTestObject('M2U WEB/Global/btn_Mulai'))

    WebUI.delay(3)
	
	CustomKeywords.'m2u.webByPass.multipleKlikObject'('Object Repository/Page_Maybank2u/btn_Next Month', nextS.toInteger())
	
	CustomKeywords.'m2u.webByPass.multipleKlikObject'('Object Repository/Page_Maybank2u/btn_Prev Month', prevS.toInteger())

    WebUI.click(findTestObject('M2U WEB/Global/lbl_blank', [('xpath') : xpath2]))

    WebUI.click(findTestObject('M2U WEB/Global/btn_Akhir'))

    WebUI.delay(3)
	
	CustomKeywords.'m2u.webByPass.multipleKlikObject'('Object Repository/Page_Maybank2u/btn_Next Month', nextE.toInteger())
	
	CustomKeywords.'m2u.webByPass.multipleKlikObject'('Object Repository/Page_Maybank2u/btn_Prev Month', prevE.toInteger())

    WebUI.click(findTestObject('M2U WEB/Global/lbl_blank', [('xpath') : xpath3])) //date biasa
} else {
    WebUI.click(findTestObject('M2U WEB/Transfer/btn_Tanggal Efektif'))

    WebUI.click(findTestObject('M2U WEB/Global/lbl_blank', [('xpath') : xpath]))

    WebUI.delay(5)

    WebUI.takeScreenshot(FailureHandling.CONTINUE_ON_FAILURE)
}



