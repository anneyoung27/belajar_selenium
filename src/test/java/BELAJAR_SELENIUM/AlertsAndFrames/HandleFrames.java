package BELAJAR_SELENIUM.AlertsAndFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
    public static void main(String[] args) {
        // Dalam Selenium ada 2: Frame dan iFrame
        /*
           Frame = Membagi halaman web menjadi beberapa bagian terpisah.
           a. driver.switchTo().frame(name);
           b. driver.switchTo().frame(id);
           c. driver.switchTo().frame(WebElement);
           d. driver.switchTo().frame(index);

           iFrame (inner Frame) / Nested Frame =
           Menyematkan (embed) konten dari dokumen HTML lain di dalam Frame.
           = Page sebagai Frame 1 lalu di dalam Frame 1 ada Page sebagai Frame 2, di dalam
           Frame 2 ini ada konten yang mesti diautomasi.
         */
        WebDriver driver = new ChromeDriver();

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        // Frame 1
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']")); // ambil element nya dulu
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("WELCOME Frame 1");

        driver.switchTo().defaultContent(); // gunakan ini agar tidak tertabrak dengan frame selanjutnya jika ingin 1x execute

        // Frame 2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("WELCOME Frame 2");

        driver.switchTo().defaultContent();

        // Frame 3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("WELCOME Frame 3");

        driver.switchTo().defaultContent();

        // switch to inner frame (part of frame 3) = karena inner Frame nya berada pada bagian frame 3
        driver.switchTo().frame(0); // switch to inner frame

        // interaksi dengan element di dalam iFrame nya
        driver.findElement(By.xpath("//div[@id='i6']//div[@class='AB7Lab Id5V1']")).click();



    }

}
