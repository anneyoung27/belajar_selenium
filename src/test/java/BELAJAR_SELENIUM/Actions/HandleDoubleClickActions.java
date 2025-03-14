package BELAJAR_SELENIUM.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleDoubleClickActions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        driver.switchTo().frame(0); // karena elemen yang diinginkan ada didalam <iframe> </iframe>
        // maka dari itu, untuk dapat mengakses elemen nya, perlu pindah frame

        // 3. Double click dengan doubleClick()
        Actions actions = new Actions(driver);
        WebElement clickButton = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        actions.doubleClick(clickButton).perform();

        /*
          Ada beberapa case dimana ketika ingin mendapatkan value dari sebuah
          element, apabila .getText() hasil nya malah blank,
          untuk solusi nya seperti .getAttribute("value"); -> value ini adalah
          attribute yang ingin kita ambil value dari element nya.

          - getText() = mengambil teks yang visible / terlihat dalam halaman.
          - getAttribute() = mengambil nilai atribut tertentu dari tag di dalam HTML,
          termasuk data yang mungkin tidak terlihat di halaman.
         */


    }
}
