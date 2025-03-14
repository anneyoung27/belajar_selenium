package BELAJAR_SELENIUM.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandleSelectDropdown {
    public static void main(String[] args) throws InterruptedException {
        /*
           Dropdown box:
           - Select dropdown
           <select>
              <option>

              </option>
           </select>

        */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/"); // -> untuk select dropdown

        driver.manage().window().maximize();

        // 1. Select dropdown

         WebElement dropDownCountry = driver.findElement(By.xpath("//select[@id='country']"));
         Select drpCountry = new Select(dropDownCountry);
         drpCountry.selectByVisibleText("France"); // mengambil data untuk France
         drpCountry.selectByValue("japan"); // mengambil data berdasarkan value
         drpCountry.selectByIndex(2); // mengambil data berdasarkan posisi index



        driver.close();
    }
}
