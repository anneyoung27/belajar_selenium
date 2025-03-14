package BELAJAR_SELENIUM.Calenders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

public class DatePickerDemo2 {

    // User defined function for converting month from String -> Month
    static Month convertMonth(String month){
        HashMap<String, Month> monthMap = new HashMap<>();
        monthMap.put("January", Month.JANUARY);
        monthMap.put("February", Month.FEBRUARY);
        monthMap.put("March", Month.MARCH);
        monthMap.put("April", Month.APRIL);
        monthMap.put("May", Month.MAY);
        monthMap.put("June", Month.JUNE);
        monthMap.put("July", Month.JULY);
        monthMap.put("August", Month.AUGUST);
        monthMap.put("September", Month.SEPTEMBER);
        monthMap.put("October", Month.OCTOBER);
        monthMap.put("November", Month.NOVEMBER);
        monthMap.put("December", Month.DECEMBER);

        Month v_month = monthMap.get(month);
        if(v_month == null){
            System.out.println("Invalid month input..");
        }
        return v_month;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // 1. Date Picker 1 Method

        // Expected data date:
        String year = "2025";
        String month = "February";
        String day = "28";

        driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // click to open date picker

        while(true){
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(currentMonth.equals(month) && currentYear.equals(year)){
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        List<WebElement> allDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));

        for(WebElement pickDate : allDate){
            if (pickDate.getText().equals(day)){
                pickDate.click();
            }
        }

        // 2. Data Picker 2:
        driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // click to open date picker

        // Select month
        String displayMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).getText();

        // Select year
        WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select selectYear = new Select(yearDropDown);
        selectYear.selectByVisibleText(year);


        while (true){
            // convert month and selectMonth to Month Object
            Month expectedMonth = convertMonth(month);
            Month currentMonth = convertMonth(displayMonth);

            // compare
            int result = expectedMonth.compareTo(currentMonth);
            // 0 = months are equal, > 0 = future month , < 0 = past month
            if (result < 0){
                // past month
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            }else if(result > 0){
                // future month
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            }else{
                break;
            }
        }

        List<WebElement> allDate2 = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));

        for(WebElement pickDate : allDate2){
            if (pickDate.getText().equals(day)){
                pickDate.click();
            }
        }
    }
}
