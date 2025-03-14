package BELAJAR_SELENIUM.JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UploadFiles {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        driver.manage().window().maximize();

        // 1. Single file upload by location path
        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("file_path_location");

        // 2. Multiple file upload
        String file1 = "path_location";
        String file2 = "path_location";

        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);

    }
}
