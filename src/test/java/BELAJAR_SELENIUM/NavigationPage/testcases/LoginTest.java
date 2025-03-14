package BELAJAR_SELENIUM.NavigationPage.testcases;

import BELAJAR_SELENIUM.NavigationPage.pages.LoginPage;
import common.BaseTest2;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest2 {
    LoginPage loginPage;

    @Test
    public void testLoginSuccess(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginFail(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@email.com", "123456");
        loginPage.verifyLoginFail();
    }
}
