package BELAJAR_SELENIUM.AdvancedTopic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CaptureScreenshots {
    /*
        Melakukan screenshot
        Biasa dilakukan :
        - Saat terjadi error atau exception
        - Setelah setiap langkah pengujian (untuk memverifikasi bahwa setiap langkah dalam
        skenario uji berhasil dilakukan)
        - Untuk membuat laporan hasil pengujian.
        - Saat validasi atau assertion gagal

     */
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // 1. Cara screenshot full page
        TakesScreenshot ts = (TakesScreenshot)driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        File targetDir= new File(System.getProperty("user.dir")+"\\src\\test\\java\\screenshot");

            // Generate a unique filename
        String timestamp = String.valueOf(System.currentTimeMillis());
        File targetFile = new File(targetDir, "screenshot_" + timestamp + ".png");
            // path file untuk meletakkan screenshot nya.

        sourceFile.renameTo(targetFile);

        // 2. cara screenshot untuk spesifik element

        WebElement featuredProducts = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File sourceFile2 = featuredProducts.getScreenshotAs(OutputType.FILE);
        File targetFile2 = new File(targetDir, "screenshot_"+timestamp+".png");
        sourceFile2.renameTo(targetFile2);

        // 3. cara screenshot web element
        WebElement element = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File sourceFile3 = element.getScreenshotAs(OutputType.FILE);
        File targetFile3 = new File(targetDir, "screenshot_"+timestamp+".png");
        sourceFile3.renameTo(targetFile3);

        driver.quit();





    }
}
