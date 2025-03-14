package BELAJAR_TestNG;

import org.testng.annotations.Test;

/*
    Grouping merupakan teknik untuk mengelompokkan test case ke dalam kategori tertentu sehingga
    pengujian dapat dikelolan dadijalankan secara lebih terstruktur.

    TestNG mendukung grouping menggunakan anotasi @Test dengan atribute groups.
 */
public class GroupingExample {
    @Test(groups = {"login"})
    public void testLogInWithValidCredentials(){
        System.out.println("Test: Login with valid credentials");
    }

    @Test(groups = {"login", "regression"})
    public void testLogInWithInvalidCredentials(){
        System.out.println("Test: Login with invalid credentials");
    }

    @Test(groups = {"dashboard"})
    public void testDashboardLoad(){
        System.out.println("Test: Dashboard loading");
    }

    @Test(groups = {"logout"})
    public void testLogOut(){
        System.out.println("Test: Logout functionality");
    }

    // grouping memungkinkan anda menjalankan hanya test case dari group tertentu.
    // dijalankan biasanya dengan file XML TestNG
}
