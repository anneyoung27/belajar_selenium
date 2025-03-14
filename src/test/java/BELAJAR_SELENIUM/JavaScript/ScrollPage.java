package BELAJAR_SELENIUM.JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollPage {
    /*
      Melakukan scrolling pada halaman browser.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");

        driver.manage().window().maximize();

        // Inisialisasi JavScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;

        // 1. Scroll down page by pixel number
        js.executeScript("window.scrollBy(0, 3000)", driver);
        // cara mendapatkan pixel number
        System.out.println(js.executeScript("return window.pageYOffset;"));

        // 2. Scroll the page until element is displayed
        WebElement element = driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));

        js.executeScript("arguments[0].scrollIntoView();", element);
        System.out.println(js.executeScript("return window.pageYOffset;"));

        // 3. Scroll page until end of the page
        js.executeScript("arguments[0].scrollBy(0, document.body.scrollHeight);");
        System.out.println(js.executeScript("return window.pageYOffset;"));

        Thread.sleep(5000);
        // 4. Scroll up to initial position
        js.executeScript("arguments[0].scrollBy(0, -document.body.scrollHeight);");


    }
}
