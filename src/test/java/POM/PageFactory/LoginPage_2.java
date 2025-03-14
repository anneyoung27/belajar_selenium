package POM.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_2 {
    WebDriver driver;

    public LoginPage_2(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using= "//input[@placeholder='Username']") // cara 1
    WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password']") // cara 2
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginBtn;

    public void loginApp(String username, String pass_word){
        userName.sendKeys(username);
        password.sendKeys(pass_word);
        loginBtn.click();
    }


}
