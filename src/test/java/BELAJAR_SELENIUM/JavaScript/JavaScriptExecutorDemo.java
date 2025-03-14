package BELAJAR_SELENIUM.JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavaScriptExecutorDemo {
    /*
        JavaScriptExecutor = antarmuka yang digunakan untuk mengeksekusi kode JavaScript
        langsung di browser dari skrip otomatisasi.
        Fitur ini digunakan ketika Selenium LEARN_SELENIUM.WebDriver tidak dapat berinteraksi langsung
        dengan element tertentu di halaman web

        Kapan digunakan:
        - Elemen tidak dapat diakses
        - Memanipulasi DOM langsung
        - Melakukan Scroll
        - Meningkatkan kinerja

        Ada 2 method utama:
        - executeScript() => menjalankan / mengeksekusi statemen JavScript
        - executeAsyncScript() => mengeksekusi JavaScript asinkron (dengan callback)
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement nameInputBox = driver.findElement(By.xpath("//input[@id='name']"));
        WebElement maleGender = driver.findElement(By.xpath("//input[@id='male']"));

        // Inisialisasi JavaScriptExecutor:
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. cara melakukan sendKeys() dengan JavaScriptExecutor
        js.executeScript("arguments[0].setAttribute('value', 'Mahendra')", nameInputBox);

        // 2. Cara melakukan click() dengan JavaScriptExecutor
        js.executeScript("arguments[0].click()", maleGender);



    }
}
