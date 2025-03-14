package BELAJAR_SELENIUM.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindow {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Set<String> windowIDs = driver.getWindowHandles();

        // Cara ke-1:
        List<String> windowsList = new ArrayList<>(windowIDs);
        String parentID = windowsList.get(0);
        String childID = windowsList.get(1);

        driver.switchTo().window(childID); // dari parent ke child
        driver.switchTo().window(parentID); // dari child ke parent

        // Cara ke-2:
        for(String winID : windowIDs){
            String title = driver.switchTo().window(winID).getTitle();

            if(title.equalsIgnoreCase("OrangeHRM")){ // parent window
                System.out.println(driver.getCurrentUrl());
            }else{
                System.out.println(driver.getCurrentUrl());
            }
        }
    }
}
