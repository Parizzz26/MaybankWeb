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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

//System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())
//
//ChromeOptions options = new ChromeOptions()
//
//// ================================================================
//// JURUS MUTLAK: PAKSA KATALON PAKAI PROFIL PERMANEN INI
//// Ganti path di bawah dengan lokasi folder kosong yang baru Anda buat
//// ================================================================
Path = profilePath

url = url

//
//options.addArguments('user-data-dir=' + profilePath)
//
//// Opsi standar
//options.addArguments('--start-maximized')
//
//options.addArguments('--ignore-certificate-errors')
//
//// Buka browser
//WebDriver driver = new ChromeDriver(options)
//
//DriverFactory.changeWebDriver(driver)
//CustomKeywords.'m2u.webByPass.openWeb'(profilePath)

CustomKeywords.'m2u.webByPass.openPermanentChrome'(Path)

// Buka web target
WebUI.navigateToUrl(url)

// Beri jeda 30 detik agar Anda punya waktu untuk install ekstensi di percobaan pertama
WebUI.delay(5)

