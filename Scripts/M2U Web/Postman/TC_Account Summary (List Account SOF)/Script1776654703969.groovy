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
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import groovy.xml.XmlUtil

String cif = cif

// Tentukan path object repository-nya
String myObject = 'Object Repository/M2U WEB/Postman/Post_AccountSummary'

// Panggil keyword dengan menyertakan object as variable
def resp = CustomKeywords.'m2u.webByPass.accountSummary'(myObject, cif)

KeywordUtil.logInfo("Status Code: " + resp.getStatusCode())
WebUI.delay(2) // Saya kurangi delay agar test tidak terlalu lama menunggu

// Ambil raw response
String responseText = resp.getResponseText()
KeywordUtil.logInfo("Response Body: \n" + responseText)

// PARSING XML (Ini yang terlewat di script Anda sebelumnya)
def xml = new XmlSlurper().parseText(responseText)

// ==========================================
// PENDEKATAN BARU: LOOPING SEGMENT ID
// ==========================================

// Masukkan semua Segment ID yang ingin dicari ke dalam sebuah List
def daftarSegment = ['02', '32', '03', '33']

// Lakukan perulangan (looping) untuk setiap segment
daftarSegment.each { segment ->
    
    // Cari node yang sesuai dengan segment yang sedang di-loop
    def targetNodes = xml.'**'.findAll { node ->
        node.name() == 'SegmentID' && node.text() == segment
    }

    if (targetNodes.isEmpty()) {
        KeywordUtil.logInfo("Data dengan SegmentID ${segment} TIDAK DITEMUKAN dalam response.")
    } else {
        String hasilFilter = ""
        targetNodes.each { node ->
            def parentNode = node.parent()
            hasilFilter += XmlUtil.serialize(parentNode) + "\n"
        }
        
        KeywordUtil.logInfo("Filtered Response (Hanya SegmentID ${segment}):\n" + hasilFilter)
    }
    
    WebUI.delay(2)
}
