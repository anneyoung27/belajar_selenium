package BELAJAR_TestNG;

import org.testng.annotations.Test;

/*
Dependency Method, berkaitan dengan strategi pengelolaan alur pengujian dimana suatu pengujian
memiliki ketergantungan terhadap hasil dari pengujian lainnya.
Dalam TestNG, dependency method menggunakan anotasi @Test dengan atribut dependsOnMethods
 */
public class Dependency_Method {
    @Test
    public void loginTest(){
        System.out.println("Login successful");
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void dashboardTest(){
        System.out.println("Dashboard is accessible");
    }

    @Test(dependsOnMethods = {"dashboardTest"})
    public void logOutTest(){
        System.out.println("LogOut successful");
    }

    // dashboardTest hanya akan dijalankan jika loginTest berhasil
    // logoutTest hanya akan dijalankan jika dashboardTest berhasil
}
