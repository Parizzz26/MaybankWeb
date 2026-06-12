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
import com.kms.katalon.core.util.KeywordUtil
import groovy.xml.XmlUtil

String cif = '0003010316'

// Tentukan path object repository-nya
String myObject = 'Object Repository/M2U WEB/Postman/Post_AccountSummary'

// ... (script bagian atas tetap sama) ...
def resp = CustomKeywords.'m2u.webByPass.accountSummary'(myObject, cif)

WebUI.delay(5)

// Cetak Status Code
KeywordUtil.logInfo("Status Code: " + resp.getStatusCode())

// --- PROSES FILTER XML ---
// 1. Ambil teks raw dari response
String responseText = resp.getResponseText()

// 2. Parsing XML menggunakan XmlSlurper
def xml = new XmlSlurper().parseText(responseText)

// 3. Cari bagian yang memiliki tag <SegmentID> dengan nilai '02'
// Simbol '**' artinya mencari ke semua kedalaman XML tanpa peduli bungkusnya apa
def targetNodes = xml.'**'.findAll { node ->
	node.name() == 'SegmentID' && node.text() == '02'
}

// 4. Proses dan Cetak Hasil
if (targetNodes.isEmpty()) {
	KeywordUtil.logInfo("Data dengan SegmentID 02 TIDAK DITEMUKAN dalam response.")
} else {
	String hasilFilter = ""
	targetNodes.each { node ->
		// Kita ambil "parent" (bungkus luar) dari SegmentID tersebut agar datanya utuh
		def parentNode = node.parent()
		// Ubah kembali dari object menjadi teks XML yang rapi
		hasilFilter += XmlUtil.serialize(parentNode) + "\n"
	}
	
	// Cetak ke Report Katalon
	KeywordUtil.logInfo("Filtered Response (Hanya SegmentID 02):\n" + hasilFilter)
}

WebUI.delay(5)