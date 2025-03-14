package BELAJAR_SELENIUM.AdvancedTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HeadlessBrowser {
    /*
        Headless Browser:
        = jenis browser yang berjalan tanpa antarmuka grafis pengguna (GUI).
        Dengan kata lain, proses browser berlangsung di latar belakang tanpa jendela browser yang terlihat

        - Biasa nya digunakan untuk pengujian Headless (Headless Testing)
        - Kecepatan: tanpa rendering GUI
        - Efisiensi: cocok menjalankan pengujian pada server
        - Menghemat sumber daya: Membutuhkan lebih sedikit memori dan CPU
        - Automasi Backend: Berugna untuk scraping data atau proses yang tidak membutuhkan interaksi
        langsung dengan GUI

        Kapan digunakan?:
        - Saat Anda perlu memverifikasi elemen visual, seperti tata letak, warna, dan elemen desain.
        - Saat debugging masalah pada UI.
        - Saat aplikasi memiliki mekanisme deteksi headless dan memblokir akses.

        Kekurangan:
        - Tidak bisa melihat flow secara visual
        - SSL handling
     */
    public static void main(String[] args) {
        // Untuk Chrome browser (bisa untuk semua tipe browser)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // setting for headless mode of execution
        options.addArguments("--disable-gpu"); // Opsional: Menghindari masalah rendering di beberapa sistem
        options.addArguments("--window-size=1920,1080"); // Opsional: Menyediakan ukuran tampilan default

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // Tidak membuka browser chrome..
    }
}
