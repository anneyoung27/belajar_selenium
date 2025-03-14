package BELAJAR_TestNG.ParameterMultiBrowser;

import BELAJAR_SELENIUM.Keywords.pages.LoginPage;
import common.BaseTest2;
import org.testng.annotations.Test;

public class DemoMultiBrowser extends BaseTest2 {
    LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        loginPage.logout();
        loginPage.verifyRedirectToLoginPage();
    }

    @Test(priority = 2)
    public void testLoginFailWithEmailInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@email.com", "123456");
        loginPage.verifyLoginFail("Invalid email or password");
    }
}
