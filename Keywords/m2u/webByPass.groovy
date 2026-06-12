package m2u

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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Keys
import java.awt.Robot
import java.awt.event.KeyEvent
import java.text.SimpleDateFormat
import com.kms.katalon.core.testobject.ResponseObject


public class webByPass {

	/**
	 * Membuka Chrome dengan Profil Permanen & DevTools terbuka otomatis
	 * @param url : Alamat website target (misal: 'https://172.21.11.25')
	 * @param profilePath : Lokasi folder profil di Mac Anda
	 */
	@Keyword
	def openPermanentChrome(String profilePath) {
		System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
		ChromeOptions options = new ChromeOptions()

		options.addArguments("user-data-dir=" + profilePath)
		options.addArguments("--start-maximized")
		options.addArguments("--ignore-certificate-errors")
		//options.addArguments("--auto-open-devtools-for-tabs") // Buka Inspect otomatis

		WebDriver driver = new ChromeDriver(options)
		DriverFactory.changeWebDriver(driver)
	}
	
	@Keyword
	def accountSummary(String objectPath,String cifNo) {
		// Bikin tanggal & ID otomatis agar server tidak nolak
		def date = new SimpleDateFormat("dd-MM-yyyy").format(new Date())
		def time = new SimpleDateFormat("HH:mm:ss").format(new Date())
		def msgID = System.currentTimeMillis().toString()
		
		ResponseObject response = WS.sendRequest(findTestObject(objectPath, [
			('cifNo') : cifNo,
			('messageID') : msgID,
			('transactionDate') : date,
			('transactionTime') : time
		]))

		return response
		
	}

	@Keyword
	def openWeb( String profilePath) {
		System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
		ChromeOptions options = new ChromeOptions()

		// ================================================================
		// JURUS MUTLAK: PAKSA KATALON PAKAI PROFIL PERMANEN INI
		// Ganti path di bawah dengan lokasi folder kosong yang baru Anda buat
		// ================================================================

		options.addArguments("user-data-dir=" + profilePath)

		// Opsi standar
		options.addArguments("--start-maximized")
		options.addArguments("--ignore-certificate-errors")

		// Buka browser
		WebDriver driver = new ChromeDriver(options)
		DriverFactory.changeWebDriver(driver)
	}

	//	@Keyword
	//	def openInspect() {
	//		// 1. Buka Jendela DevTools (Shortcut Mac)
	//		Robot robot = new Robot()
	//		robot.keyPress(KeyEvent.VK_META)  // Cmd
	//		robot.keyPress(KeyEvent.VK_ALT)   // Opt
	//		robot.keyPress(KeyEvent.VK_I)     // I
	//
	//		robot.keyRelease(KeyEvent.VK_I)
	//		robot.keyRelease(KeyEvent.VK_ALT)
	//		robot.keyRelease(KeyEvent.VK_META)
	//
	//		WebUI.delay(1)
	//
	//		// 2. PAKSA Chrome pindah fokus ke tab Console
	//		// Kita kirim perintah JavaScript untuk membersihkan console.
	//		// Di Chrome, mengeksekusi console.clear() otomatis akan membawa tampilan ke tab Console.
	//		WebUI.executeJavaScript("console.clear();", null)
	//
	//		WebUI.comment("Inspect Element dibuka dan fokus ke Console")
	//	}

	/**
	 * Keyword: closeInspect
	 * Menutup jendela DevTools/Inspect yang sedang terbuka di Mac
	 */
	//	@Keyword
	//	def openCloseInspect() {
	//		// Karena shortcut buka dan tutup di Mac sama, kita panggil lagi Robot-nya
	//		java.awt.Robot robot = new java.awt.Robot()
	//
	//		// Tekan Cmd + Option + I
	//		robot.keyPress(java.awt.event.KeyEvent.VK_META)  // Cmd
	//		robot.keyPress(java.awt.event.KeyEvent.VK_ALT)   // Option
	//		robot.keyPress(java.awt.event.KeyEvent.VK_I)     // Huruf I
	//
	//		// Lepaskan
	//		robot.keyRelease(java.awt.event.KeyEvent.VK_I)
	//		robot.keyRelease(java.awt.event.KeyEvent.VK_ALT)
	//		robot.keyRelease(java.awt.event.KeyEvent.VK_META)
	//
	//		com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.comment("Inspect Element Open/Close")
	//
	//		WebUI.delay(1)
	//	}

	@Keyword
	def openCloseInspect() {
		java.awt.Robot robot = new java.awt.Robot()

		// Klik ke browser dulu agar fokus (opsional tapi disarankan)
		// WebUI.switchToDefaultContent()

		robot.keyPress(java.awt.event.KeyEvent.VK_META)
		robot.keyPress(java.awt.event.KeyEvent.VK_ALT)
		robot.keyPress(java.awt.event.KeyEvent.VK_I)

		robot.keyRelease(java.awt.event.KeyEvent.VK_I)
		robot.keyRelease(java.awt.event.KeyEvent.VK_ALT)
		robot.keyRelease(java.awt.event.KeyEvent.VK_META)

		// Beri waktu 2 detik bagi Chrome untuk merender jendela DevTools
		// sebelum lanjut ke perintah selanjutnya
		WebUI.delay(2)
	}

	@Keyword
	def openConsole() {
		// PAKSA Chrome pindah fokus ke tab Console
		// Kita kirim perintah JavaScript untuk membersihkan console.
		// Di Chrome, mengeksekusi console.clear() otomatis akan membawa tampilan ke tab Console.
		WebUI.executeJavaScript("console.clear();", null)

		WebUI.comment("Inspect Element dibuka dan fokus ke Console")
	}



	/**
	 * Mengetik layaknya manusia untuk menembus sistem keamanan web perbankan
	 * @param to : Test Object (kolom input)
	 * @param text : Teks yang ingin diketik
	 */
	@Keyword
	def humanType(TestObject to, String text) {
		WebUI.waitForElementClickable(to, 5)
		WebUI.click(to) // Klik agar kursor aktif
		WebUI.delay(1)
		WebUI.sendKeys(to, text) // Eksekusi ketikan asli
	}

	/**
	 * Membersihkan Console Inspect lalu melakukan klik
	 * @param to : Test Object (tombol yang mau diklik)
	 */
	@Keyword
	def clearConsoleAndClick(TestObject to) {
		WebUI.executeJavaScript("console.clear();", null)
		WebUI.delay(1)
		WebUI.click(to)
	}

	@Keyword
	def multipleKlikObject(String to, int klik) {
		KeywordUtil.logInfo('Klik Berkali-kali')

		if(klik>0) {
			for(int i = 1; i <= klik; i++) {

				WebUI.click(findTestObject(to))

				WebUI.delay(1)
			}
		}else {
			KeywordUtil.logInfo('Tidak klik')
		}
	}
}

