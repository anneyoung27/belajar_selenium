package BELAJAR_SELENIUM.JavaScript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZoomInZoomOut {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");

        driver.manage().window().maximize();

        // Inisialisasi JavScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;

        // 1. Zoom in
        js.executeScript("document.body.style.zoom='50%'");

        Thread.sleep(2000);
        // 2. Zoom out
        js.executeScript("document.body.style.zoom='90%'");

    }
}
