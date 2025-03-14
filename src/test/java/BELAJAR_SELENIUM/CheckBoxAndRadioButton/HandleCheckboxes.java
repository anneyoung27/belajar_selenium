package BELAJAR_SELENIUM.CheckBoxAndRadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckboxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // 1) Select Checkbox
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='sunday']"));

        System.out.println("Before selection: "+ checkBox.isSelected());
        driver.findElement(By.xpath("//input[@id='sunday']")).click();
        System.out.println("After selection:" + checkBox.isSelected());

        // 2) Capturing all the checkboxes
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        System.out.println("Number of checkboxes : " + checkBoxes.size()); // 7

        // 3) Selecting all the checkboxes
        for(int i = 0; i <= checkBoxes.size(); i++){
            checkBoxes.get(i).click();
        }

        // 4) Select last 3 checkboxes
        // total number of check boxes - how many checkboxes do you want to select = starting index
        // 7 - 3 = 4 starting index

        for (int i = 4; i < checkBoxes.size(); i++){
            checkBoxes.get(i).click();
        }

        // 5) Select first 3 checkboxes
        for (int i = 0; i < 3; i++){
            checkBoxes.get(i).click();
        }

        Thread.sleep(5000);

        // 6) select/unselect all the checkboxes
        for(WebElement checkbox: checkBoxes){
            if(checkbox.isSelected()){
                checkbox.click(); // unselect
            }else{
                checkbox.click(); // select
            }
        }

        // 7) Select specific check boxes randomly
        for(int i = 0; i < checkBoxes.size(); i++){
            if(i == 1 || i == 3 || i == 6){
                checkBoxes.get(i).click();
            }
        }
        driver.close();
    }
}
