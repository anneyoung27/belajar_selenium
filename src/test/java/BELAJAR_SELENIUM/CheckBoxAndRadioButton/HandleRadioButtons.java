package BELAJAR_SELENIUM.CheckBoxAndRadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleRadioButtons {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement male_rb = driver.findElement(By.xpath("//input[@id='male']"));
        WebElement female_rb = driver.findElement(By.xpath("//input[@id='female']"));

        System.out.println("Before selection status of the male radio button: " + male_rb.isSelected());
        System.out.println("Before selection status of the female radio button: " + female_rb.isSelected());

        male_rb.click();
        System.out.println("After selection status of the male radio button: " + male_rb.isSelected());

        driver.close();

    }
}
