package BELAJAR_SELENIUM.KeyboardEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleTabWindows {
    /*
        Kasus:
        = Ada kasus dimana ketika ingin membuka laman A dan pindah ke laman B yang berbeda
     */

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-opencart.com/index.php?route=common/home&language=en-gb");

        driver.switchTo().newWindow(WindowType.TAB); // -> ini untuk membuka tab baru
        driver.switchTo().newWindow(WindowType.WINDOW); // -> ini untuk membuka browser baru

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
}
