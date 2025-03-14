package BELAJAR_SELENIUM.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleBootstrapDropdown {
    /*
     - Bootstrap dropdown
           <button>
                <ul>
                    <li>
                    </li>
                </ul>
           </button>
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();

        // 2. Bootstrap dropdown

         driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
         // select single options
         driver.findElement(By.xpath("//input[@value='Java']")).click();
         // capture all options and find out size
         List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//label[@class='checkbox']"));
         for (WebElement allOption : allOptions) {
            System.out.println(allOption.getText());
         }

         System.out.println("Dropdown option size: " + allOptions.size());

        Thread.sleep(1000);
         // select multiple options
         for (WebElement options : allOptions){
            if(options.getText().equals("Java") || options.getText().equals("MS SQL Server")){
                options.click();
           }
         }

         driver.close();

    }
}
