package BELAJAR_SELENIUM.Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleStaticWebTable {
    /*
     Static Web Table, merujuk pada tabel HTML yang struktur dan isinya tidak berubah secara
     dinamis selama waktu runtime (tidak bisa diedit)

     Struktur dari Static Web Table:

     <table>
        <thead>
            <tr>
                <th>  </th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td>  /td>
            </tr>
        </tbody>
     </table>

     Note:
     - <thead> = kolom (column)
     - <tbody> = baris (rows)
     - <th> = Table Header (column)
     - <td> = Table Data (row)

     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // 1. Find total number of rows
        List<WebElement> rowData = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        System.out.println("Total rows: " + rowData.size());

        // 2. Find total number of columns
        List<WebElement> columnData = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
        System.out.println("Total columns: " + columnData.size());

        // 3. Read data from specific row and column (ex. row 5 and column 1)
        String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
        System.out.println("Row 5 and Column 1 data is: " + data);

        System.out.println("=====================");

        // 4. Read data from all the rows and columns
        for(int row = 2; row <= rowData.size(); row++){ // start from row data not row column
            for(int col = 1; col <= columnData.size(); col++){ // start from column data
                String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]//td["+col+"]")).getText();
                System.out.print(value+"\t");
            }
            System.out.println();
        }

        System.out.println("=====================");

        // 5. Books that the author is Mukesh
        for(int row = 2; row <= rowData.size(); row++){ // start from row data not row column
            String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]//td[2]")).getText();
            if(author.equalsIgnoreCase("Mukesh")){
                String books = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]//td[1]")).getText();
                System.out.println(books + "\t" + author);
            }
        }
        System.out.println("=====================");

        // 6. Find total price of all the books
        int total = 0;
        for (int row = 2; row <= rowData.size(); row++){
            String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]//td[4]")).getText();
            total = total += Integer.parseInt(price);
        }
        System.out.println("Total Price of books: "+ total);
    }
}
