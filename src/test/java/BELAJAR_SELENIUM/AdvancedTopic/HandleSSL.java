package BELAJAR_SELENIUM.AdvancedTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {
    /*
     Dalam Selenium, pengelolaan SSL menjadi penting
     ketika Anda mengotomatiskan pengujian pada situs web yang menggunakan SSL,
     terutama jika sertifikat SSL situs tersebut tidak valid atau self-signed.
     Browser sering menampilkan peringatan keamanan untuk situs-situs ini, yang dapat mengganggu skrip Selenium.

     Mengapa SSL Penting dalam Selenium?
     - Validasi Sertifikat: Browser memeriksa sertifikat SSL untuk memastikan situs web aman.
      Jika sertifikat tidak valid, browser menampilkan peringatan.
     - Interupsi Otomasi: Peringatan SSL dapat menghentikan eksekusi skrip otomatisasi
     karena Selenium tidak dapat berinteraksi dengan elemen sebelum peringatan diatasi.
     */
    public static void main(String[] args) {
        // bisa untuk semua tipe browser
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); // accept SSL certificates
        options.addArguments("--ignore-certificate-errors");


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");

        System.out.println("Title of the page: " + driver.getTitle());
    }
}
