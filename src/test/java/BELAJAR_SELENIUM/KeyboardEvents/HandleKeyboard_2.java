package BELAJAR_SELENIUM.KeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HandleKeyboard_2 {
    /*
        Kasus:
        = ada kasus dimana saat membuka sebuah tab di browser, saat mengklick
        element tersebut, maka konten nya akan pindah ke tab baru, jadi tab lama tetap ada.

        Kasus di atas dapat diselesaikan dengan Keyboard actions
        dengan Ctrl + (klik elemen yang ingin ditampilkan)
        maka konten dari elemen akan muncul ke tab baru
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        // Case 1: Membukan laman Register ke tab baru (Ctrl + elemen dari Register)
        // simulasi -> tekan Ctrl lau click element register lalu lepas Ctrl
        WebElement elementRegister = driver.findElement(By.xpath("//a[normalize-space()='Register']"));

        actions.keyDown(Keys.CONTROL).click(elementRegister).keyUp(Keys.CONTROL).perform();

        // Pindah ke tab baru
        List<String> ids = new ArrayList<>(driver.getWindowHandles());
        String childWindow = ids.get(1); // posisi index untuk tab yang baru,
        String parentWindow = ids.get(0); // kalau tab lama 0

        driver.switchTo().window(childWindow);

        // Pindah ke tab lama
        driver.switchTo().window(parentWindow);

    }
}
