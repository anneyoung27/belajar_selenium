package BELAJAR_SELENIUM.AlertsAndFrames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAuthenticatedAlert {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // driver.get("http://the-internet.herokuapp.com/basic_auth");

        // Cara bypass alert yang membutuhkan autentikasi
        // 1. Edit domain nya:
        http://username:password@the-internet.herokuapp.com/basic_auth

        // 2. Inject username dan password nya dengan menulis value nya:
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");


        driver.manage().window().maximize();


    }
}
