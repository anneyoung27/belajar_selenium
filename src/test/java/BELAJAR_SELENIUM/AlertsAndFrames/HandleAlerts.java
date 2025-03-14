package BELAJAR_SELENIUM.AlertsAndFrames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // 1) Normal alert with OK button
        // driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click(); // open the alert
        // Thread.sleep(5000);
        Alert myAlert = driver.switchTo().alert();
        // myAlert.accept();
        // atau => driver.switchTo().alert().accept();

        // 2) Confirmation alert with OK and Cancel button
        // driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        // myAlert.accept(); // close alert window using OK button
        // Thread.sleep(5000); -> membuat jeda saat click OK dan click Cancel
        // myAlert.dismiss(); // close alert window using Cancel button

        // 3) Prompt alert with OK and Cancel button
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        System.out.println("Text msg on alert: " + myAlert.getText());

        myAlert.sendKeys("Welcome"); // mengisi prompt pada alert nya
        myAlert.accept(); // close alert window using OK button
        myAlert.dismiss(); // close alert window using Cancel button


        driver.close();
    }
}
