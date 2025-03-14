package BELAJAR_SELENIUM.Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleDynamicWebTableWithPagination {
     /*
     Dynamic Web Table, merujuk pada tabel HTML yang struktur dan isinya berubah secara
     dinamis selama waktu runtime (akan berubah apabila terjadi perubaha, penambahan)

     Table ini sering digunakan di aplikasi web modern, seperti dashboard, halaman pencarian,
     atau sistem e-commerce

     Struktur dinamik table:

     <table>
        <thead>
            <tr>
                <th> </th>
            </tr>
        </thead>
        <tbody>
            # Baris ini dimuat secara dinamis melalui Javascript
        </tbody>
     </table>

     Note:
     1. Ketika halaman dimuat, bagian <tbody> kosong
     2. Javascript mengambil data dari server dan memperbarui <tbody> secara dinamis
     dengan baris dan kolom

     Masalah umum dan solusi:

     1) Masalah: Data Tidak Dimuat Tepat Waktu
     Solusi: Gunakan WebDriverWait untuk memastikan elemen tabel atau data tertentu telah dimuat.
     2) Masalah: Pagination
     Solusi: Navigasikan ke setiap halaman tabel (jika ada pagination) menggunakan Selenium, lalu ambil data dari setiap halaman.
     3) Masalah: Data Dalam Shadow DOM
     Solusi: Jika tabel berada di dalam Shadow DOM, gunakan execute_script untuk mengakses elemen tersebut.
     4) Masalah: Scroll untuk Memuat Data
     Solusi: Gunakan JavaScript untuk menggulir ke bagian tabel yang dimuat secara lazy-loading.


     */
     public static void main(String[] args) throws InterruptedException {
         WebDriver driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         driver.get("https://demo3x.opencartreports.com/admin/");
         driver.manage().window().maximize();

         WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
         userName.clear();
         userName.sendKeys("demo");

         WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
         password.clear();
         password.sendKeys("demo");

         driver.findElement(By.xpath("//button[@type='submit']")).click();

         Thread.sleep(2000);
         // Find Customer in Navigation menu
         driver.findElement(By.xpath("//i[@class='fa fa-user fw']")).click();
         driver.findElement(By.xpath("//ul[@id='collapse5']//li//a[normalize-space()='Customers']")).click();

         // 1. Capture number of pages in the table (task = Showing 1 to 7 of 7 (1 Pages) )
         String totalPages = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
         int pages = Integer.parseInt(totalPages.substring(totalPages.indexOf("(")+1, totalPages.indexOf(" Pages")).trim());
         System.out.println("Total pages: " + pages);

         // 2. Repeating pages
         for (int p = 1; p <= pages; p++){
             if(pages > 1){
                 WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
                 active_page.click();
                 Thread.sleep(2000);
             }
             // 3. Read data from the page
             int no_of_rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();

             for(int r = 1; r <= no_of_rows; r++){
                 String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText();
                 String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();

                 System.out.println(customerName +"\t" + email);
             }

         }













     }
}
