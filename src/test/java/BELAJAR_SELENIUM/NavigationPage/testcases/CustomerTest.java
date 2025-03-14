package BELAJAR_SELENIUM.NavigationPage.testcases;

import BELAJAR_SELENIUM.NavigationPage.pages.CustomerPage;
import BELAJAR_SELENIUM.NavigationPage.pages.DashboardPage;
import BELAJAR_SELENIUM.NavigationPage.pages.LoginPage;
import common.BaseTest2;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest2 {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

        //dashboardPage = new DashboardPage(driver);
        customerPage = dashboardPage.openCustomerPage();

        //customerPage = new CustomerPage(driver);
        customerPage.verifyRedirectToCustomerPage();

        customerPage.addNewCustomer("VTCC Viettel 16/04 A1");
        customerPage.verifyAddNewCustomer("VTCC Viettel 16/04 A1");
    }

    @Test
    public void testCheckTotalCustomer() {

    }
}
