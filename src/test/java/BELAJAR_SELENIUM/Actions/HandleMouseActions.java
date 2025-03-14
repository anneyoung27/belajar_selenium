package BELAJAR_SELENIUM.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleMouseActions {
    /* Mouse Actions:
        = Kemampuan untuk melakukan berbagai interaksi menggunakan mouse.
        Jenis-jenis Mouse Actions:
        - Mouse hover
        - Right click
        - Left click
        - Drag and Drop

        Kelas Actions digunakan untuk melakukan interaksi mouse yang lebih kompleks.
        = Actions actions = new Actions(driver);

        untuk mengeksekusi actions menggunakan method .build().perform() atau .perform() lgsg tidak masalah
        - build() = create an action
        - perform() = run / complete the action

        Method Mouse Actions:
        - click() = klik pada elemen tertentu
        - doubleClick() = klick dua kali pada elemen tertentu
        - contextClick() = klik kanan pada elemen tertentu
        - moveToElement() = memindahkan kursor ke element tertentu (hover)
        - dragAndDrop() = drag elemen dari satu tempat ke tempat lain
        - clickAndHold() = klik dan tahan mouse pada elemen tertentu
        - release() = melepaskan klik yang ditahan
        - moveByOffset() = memindahkan kursor mouse ke lokasi tertentu berdasarkan koordinat
         */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo-opencart.com/index.php?route=common/home&language=en-gb");
        driver.manage().window().maximize();

        WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (0)']"));

        Actions actions = new Actions(driver);
        // 1. Navigasi dengan moveToElement()
        actions.moveToElement(desktop).moveToElement(mac).build().perform(); // -> navigasi
        actions.moveToElement(desktop).moveToElement(mac).click().build().perform(); // -> navigasi + action (click)
















    }
}
