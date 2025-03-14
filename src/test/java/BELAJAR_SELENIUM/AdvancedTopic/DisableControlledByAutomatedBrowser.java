package BELAJAR_SELENIUM.AdvancedTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableControlledByAutomatedBrowser {
    // Untuk menghilangkan kata "This browser controlled by automated browser"
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("excludeSwitches", new String [] {"enable-automation"});

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.nopcommerce.com/");

        String act_title = driver.getTitle();

        if(act_title.equals("Your Store")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
    }
}
