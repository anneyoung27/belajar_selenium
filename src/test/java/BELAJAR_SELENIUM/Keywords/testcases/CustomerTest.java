package BELAJAR_SELENIUM.Keywords.testcases;

import BELAJAR_SELENIUM.Keywords.pages.LoginPage;
import common.BaseTest2;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest2 {
    LoginPage loginPage;

    @Test
    public void testAddNewCustomer() {
        String CUSTOMER_NAME = "VTCC Viettel 09/05 A1";

        loginPage = new LoginPage(driver);

        //Fluent design pattern
        loginPage.loginCRM("admin@example.com", "123456")
                .openCustomerPage()
                .verifyRedirectToCustomerPage()
                .addNewCustomer(CUSTOMER_NAME)
                .verifyAddNewCustomer(CUSTOMER_NAME);
    }
}
