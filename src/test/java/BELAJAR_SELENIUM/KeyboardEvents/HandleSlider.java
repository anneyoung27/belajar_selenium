package BELAJAR_SELENIUM.KeyboardEvents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleSlider {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);


        // A) HANDLE MINIMUM SLIDER
        WebElement min_slider = driver.findElement(By.xpath("//body/div[@class='price-range-block']/div[@id='slider-range']/span[1]"));

        // 1. Kita cari posisi X, Y pada element di slider nya
        System.out.println("Location of minimum slider: "+ min_slider.getLocation()); // x = 59, y = 295

        // 2. Kita gunakan method dragAndDropBy() dengan actions object
        // batas minimum gerak x itu 59 dari yang sudah di tentukan di atas
        // jadi pastikan > 59
        actions.dragAndDropBy(min_slider, 100, 259).perform();

        // 3. Kita pastikan pergerakan nya.
        System.out.println("Location of minimum slider after moving: "+ min_slider.getLocation());

        // B) HANDLE MAXIMUM SLIDER

        WebElement max_slider = driver.findElement(By.xpath("//span[2]"));

        // 1. Kita cari posisi X, Y pada element di slider nya
        System.out.println("Location of minimum slider: "+ max_slider.getLocation()); // x = 317, y = 232

        // 2. Kita gunakan method dragAndDropBy() dengan actions object
        // batas minimum gerak x itu 317 untuk menggeser nya dari posisi maximum slider berarti mundur
        // jadi jgn melewati 317, karena mundur maka harus negative
        actions.dragAndDropBy(max_slider, -100, 232).perform();

        // 3. Kita pastikan pergerakan nya.
        System.out.println("Location of maximum slider after moving: "+ max_slider.getLocation());





    }
}
