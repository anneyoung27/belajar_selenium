package BELAJAR_TestNG;

import org.testng.annotations.Test;

public class FirstTestCase {
    /*
           Advantages:
           - Test Cases & Test Suites
           - Grouping of test cases
           - Prioritize
           - Parameterization
           - Parallel testing
           - Reports
        */

    @Test(priority = 1)
    void openApp(){
        System.out.println("Open app...");
    }

    @Test (priority = 2)
    void logIn(){
        System.out.println("Login app..");
    }

    @Test (priority = 3)
    void logOut(){
        System.out.println("Logout app..");
    }

    // @Test(priority=num) => mengontrol urutan eksekusi
}
