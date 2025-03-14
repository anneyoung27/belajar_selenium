package BELAJAR_SELENIUM.NavigationPage.testcases;

import BELAJAR_SELENIUM.NavigationPage.pages.DashboardPage;
import BELAJAR_SELENIUM.NavigationPage.pages.LoginPage;
import common.BaseTest2;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest2 {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLogout(){
        loginPage = new LoginPage(driver);

        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

        //dashboardPage = new DashboardPage(driver);
        dashboardPage.logout();

        //Verify trở về được trang Login
        loginPage.verifyRedirectToLoginPage();
    }

    @Test
    public void testTotalOfTasksNotFinished(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyRedirectToDashboardPage();

        dashboardPage.verifyTotalOfTasksNotFinished("1 / 1");
    }
}
