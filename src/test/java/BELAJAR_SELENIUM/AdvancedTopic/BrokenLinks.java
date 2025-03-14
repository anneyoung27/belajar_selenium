package BELAJAR_SELENIUM.AdvancedTopic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    /* Melakukan pengujian apabila link nya rusak
    = URL yang tidak berfungsi atau menghasilkan kesalahan (seperti 404 Not Found) saat diakses.

    Status code >= 400 itu termasuk broken link
    Status code < 400 itu bukan termasuk broken link
     */

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a")); // lokasi link
        System.out.println("Total number of links: " + links.size());

        int noOfBrokenLinks = 0;

        for(WebElement linkElement : links){
            String hrefValues = linkElement.getAttribute("href"); // mendapatkan attribute dari tiap link nya.
            if(hrefValues == null || hrefValues.isEmpty()){
                System.out.println("Href not possible value is null or empty.");
                continue;
            }

            // hit URL to the server
            URL linkUrl = new URL(hrefValues); // converted href value from string to URL format
            HttpURLConnection connLinkUrl = (HttpURLConnection) linkUrl.openConnection(); // open connection to the server
            connLinkUrl.connect(); // connect to server and sent request the server

            if(connLinkUrl.getResponseCode() >= 400){
                System.out.println("Broken link : " + connLinkUrl.getURL());
                noOfBrokenLinks += 1;
            }else{
                System.out.println("Not a broken link : " + connLinkUrl.getURL());
            }
        }

        System.out.println("Number of broken links: " + noOfBrokenLinks);

    }
}
