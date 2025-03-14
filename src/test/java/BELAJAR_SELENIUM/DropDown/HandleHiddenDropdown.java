package BELAJAR_SELENIUM.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleHiddenDropdown {
    /*
     - Hidden dropdown
           <div>
                <button> </button>
                <div>
                    <a> </a>
                </div>
           </div>

           = untuk mendapatkan elemen yang Hidden dropdown
           gunakan extension SelectorHub -> click Turn on Debugger -> pilih elemen
           hidden dropdown (secara otomatis akan tereliminasi) -> lalu kita inspeksi option
           yang ada di dalam elemen nya.
           = untuk memberhentikan debugger, click Turn [on|off] Debugger nya lagi
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        // Login steps:
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // clicking on PIM
        driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

        // clicked on dropdown
        driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();

        Thread.sleep(5000);
        // Select single option
        driver.findElement(By.xpath("//span[normalize-space='Financial Analyst']")).click();

        // count number of options
        List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
        System.out.println("Number of options: " + options.size());
        driver.close();
    }

}
