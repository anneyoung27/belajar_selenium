package BELAJAR_SELENIUM.DataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

public class FDCalculator {

    // Cara melakukan Data Driven Testing
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
        driver.manage().window().maximize();

        // Set File path Excel nya
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\testData\\FixedDepositData.xlsx";

        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

        for(int i = 1; i <= rows; i++){
            // 1. read data from excel (sesuaikan colNum nya dengan urutan index di data Excel nya)

            String price = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String rateOfInterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
            String period = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
            String period_2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
            String frequency = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
            String maturityValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

            // 2. pass above data (from step 1) into application
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(price);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period);
            Select selectPeriod_2 = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            selectPeriod_2.selectByVisibleText(period_2);
            Select selectFrequency = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            selectFrequency.selectByVisibleText(frequency);

            driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click(); // click calculate button

            // 3. validation
            String resultCalculate = driver.findElement(By.xpath("//div[@id='response_div']//span[2]//strong")).getText();

            if(Double.parseDouble(maturityValue) == Double.parseDouble(resultCalculate)){
                System.out.println("PASS");
                // 7 itu posisi untuk column Result
                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "PASSED");
                ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
            }else{
                System.out.println("FAIL");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "FAILED");
                ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='cal_div']//a[2]/img")).click(); // click clear button
        }

        driver.quit();
    }
}
