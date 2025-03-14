package BELAJAR_SELENIUM.AlertsAndFrames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleAlertsUsingExplicitWait {
    public static void main(String[] args) {
        /*
            Q) How to capture alert box without using switchTo().alert()
            A) Using Explicit Wait.
         */
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();

        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent()); // check sampai Alert nya muncul.

        myAlert.accept();

        driver.quit();
    }
}
