package BELAJAR_SELENIUM.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleRightClickActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();


        Actions actions = new Actions(driver);
        // 2. Click kanan dengan contextClick()
        WebElement button = driver.findElement(By.xpath("//span[normalize-space()='right click me']"));
        actions.contextClick(button).perform();

        // click on copy
        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();

        Thread.sleep(2000);

        // close alert box
        driver.switchTo().alert().accept();
    }
}
