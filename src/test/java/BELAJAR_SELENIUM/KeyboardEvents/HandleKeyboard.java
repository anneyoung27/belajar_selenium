package BELAJAR_SELENIUM.KeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleKeyboard {
    /*
            Contoh sederhana untuk melakukan pengujian dengan keyboard:
            - Ctrl + A (blok text)
            - Ctrl + C (copy text)
            - Tab (pindah halaman)
            - Ctrl + V (paste text)

            Ibaratkan saat mengoperasikan sesuatu dengan keyboard
            mana yang ditekan terlebih dahulu dan dilepas terlebih dahulu.
            kalau Ctrl + A = tekan Ctrl dulu baru A, lalu lepas Ctrl
          */

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("WELCOME");

        Actions actions = new Actions(driver);
        // 1. Ctrl + A
        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        // 2. Ctrl + C
        actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        // 3. TAB
        actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        // 4. Ctrl + V
        actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        // cth: Ctrl + Shift + A
        actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();



    }
}
