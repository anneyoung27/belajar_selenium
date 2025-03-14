package POM.TanpaPageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// 1. Cara melakukan POM tanpa Page Factory
public class LoginPage {
    // 1. Local variable
    WebDriver driver;

    // 2. Constructor page class
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // 3. Locators
    By userName = By.xpath("//input[@placeholder='Username']");
    By password = By.xpath("//input[@placeholder='Password']");
    By loginBtn = By.xpath("//button[normalize-space()='Login']");

    // 4. Action methods (yang merepresent aksi page class nya)
    public void loginApp(String username, String pass_word){
        driver.findElement(userName).sendKeys(username);
        driver.findElement(password).sendKeys(pass_word);
        driver.findElement(loginBtn).click();
    }



}
