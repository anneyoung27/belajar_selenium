package BELAJAR_SELENIUM.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverMethods {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // 1. GET method.
        // get() -> open the url on the browser
        // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize(); // -> maximize browser's window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // 2. Navigational commands
        driver.navigate().to("https://demo.nopcommerce.com/register"); // -> sama seperti Driver.get() & URL object format
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


        driver.get("https://demo.nopcommerce.com/register"); // -> accepts URL in String format

        // getTitle() -> returns title of the page
        System.out.println("Title: " + driver.getTitle());

        // getCurrentUrl() -> returns URL of the page
        System.out.println(driver.getCurrentUrl());

        // getPageSource() -> returns source code of the page
        System.out.println(driver.getPageSource()); // -> gunakan method ini untuk mencari tahu element (saat menggunakan xpath atau css selector)

        // getWindowHandle() -> returns ID of the single browser window
        System.out.println(driver.getWindowHandle());

        // getWindowHandles() -> returns Id's of the multiple browser windows
        System.out.println(driver.getWindowHandles());

        // 3. Conditional Method (boolean)
        // isDisplayed() -> apakah element nya ada atau tidak?
        System.out.println(driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed());

        // isEnabled() -> apakah element nya dalam keadaaan aktif atau tidak?
        System.out.println(driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled());




        


    }
}
