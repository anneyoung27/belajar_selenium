package POM.TanpaPageFactory;

// implementasi POM tanpa Page Factory dari page class LoginPage

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    void testLogin(){
        loginPage = new LoginPage(driver);
        loginPage.loginApp("Admin", "admin123");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }

}
