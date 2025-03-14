package BELAJAR_SELENIUM.Calenders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePicker {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        // Switch to frame (contoh dari web di atas, bahwa element calender nya ada di dalam <iframe> </iframe>
        // jadi perlu masuk ke Frame terlebih dahulu.
        driver.switchTo().frame(0);

        // Method 1: using sendKeys()
        // driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("19/01/2025");

        // Method 2: using Data picker
        // this is expected data (lihat default data pada calendar nya)
        String year = "2027";
        String month = "February";
        String day = "19";

        driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // -> open Data Picker

        // Progrem untuk menyocokkan dengan default data yang ada di calendar.
        while(true){
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)){
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        // memilih date nya
        // perlu di ketahui bahwa struktur tanggal pada Calender itu seperti table, jadi perlu mengambil data tanggal nya
        // layaknya table
        List<WebElement> pickDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

        for (WebElement dates : pickDate){
            if(dates.getText().equals(day)){
                dates.click();
            }
        }
    }
}
