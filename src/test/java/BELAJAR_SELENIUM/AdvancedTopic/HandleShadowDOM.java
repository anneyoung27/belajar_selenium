package BELAJAR_SELENIUM.AdvancedTopic;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleShadowDOM {
    /*
        - DOM (Document Object Model) yang terisolasi.
        - Shadow DOM sering ditemukan pada elemen web modern, seperti yang dibuat menggunakan
        framework components (mis. <vaadin-grid>, <paper-input> )
        - Karena isolasi, tidak bisa mengakses secara lansung elemen nya dengan perintah Selenium
        standar seperti driver.findElement().

        Ada 3 jenis Shadow:
        - Shadow Root = bagian terisolasi yang melekat pada elemen host. (untuk yang menyimpan satu elemen)
        - Shadow Host = elemen di mana shadow root melekat (biasa menjadi host untuk Shadow Root) (untuk yang menyimpan elemen bercabang / nested)
        - Shadow Tree = semua elemen, gaya, dan komponen yang didefinisikan di dalam shadow DOM

        urutan nya => HOST -> ROOT -> TREE

        Ciri-ciri Shadow DOM:
        - Ada tag <shadow-root> :
        a. Langsung
        <div id="shadow-host">
            #shadow-root
                <input type="text" id="shadow-input">
        </div>

        b. Nested
        <div id="outer-shadow-host">
            #shadow-root
              <div id="inner-shadow-host">
             #shadow-root
              <input type="text" id="nested-input">
              </div>
        </div>


        - Elemen di dalam Shadow DOM tidak dapat dijangkau dengan metode XPath

        Cara mengakses Shadow DOM -> menggunakan JavaScriptExecutor

        Tips:
        - Cari elemen induk yang memiliki properti shadowRoot
        - Gunakan JavaScriptExecutor
        - Gunakan Try-catch / throws untuk menghindari error
        - Hindari terlalu banyak akses nested shador DOM dalam satu test untuk menjaga performa.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        /* 1. Shadow Element
         =  Solusi untuk yang single shadow DOM: (GUNAKAN CSS SELECTOR)
            kita ambil parent pertama dari elemen, kalau misalnya ada #shadow-root
            cari tag di atas dari #shadow-root nya. (cth. gambar di Shadow Element (DOM) di folder GAMBAR PENJELASAN)
         */
        SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        Thread.sleep(1000);
        shadow.findElement(By.cssSelector("#shadow-element"));


        /* 2. Nested Shadow Element (Shadow beracbang)
         =  Solusi untuk yang nested shadow element (GUNAKAN CSS SELECTOR)
         karena posisi 'Nested Shadow Element' elemen nya ada di dalam 2 #shadow-root
         maka kita ambil dari parent pertama #shadow-root nya lalu parent kedua #shadow-root nya
         lalu element dari 'Nested Shadow Element'
         (cth. gambar di Nested Shadow Element (DOM) di folder GAMBAR PENJELASAN)
         */
        SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot(); // dari parent pertama #2
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot(); // parent kedua #1
        Thread.sleep(1000);
        shadow1.findElement(By.cssSelector("#nested-shadow-element")); // element nya


        /*  3. Multi Nested Shadow (Element bercabang-cabang)
        = Solusi nya gunakan CSS SELECTOR
        lakukan dari yang parent paling atas dilanjutkan ke parent parent nya sampai dengan
        element nya (cth. gambar Multi Nested Shadow Element (DOM) di folder GAMBAR PENJELASAN
         */
        SearchContext shadow0_0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1_1 = shadow0_0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow_2 = shadow1_1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
        Thread.sleep(1000);
        shadow_2.findElement(By.cssSelector("#multi-nested-shadow-element"));

        /* 4. Kasus = Bagaimana kalau #shadow-root nya lebih dari > 3
         Solusi = kita bisa melompat atau mengabaikan parent paling atas, jadi fokus ke parent di atas
         element yang dibutuhkan.
        (cth. gambar Multi multi nested shadow element (DOM) di folder GAMBAR PENJELASAN)
         */

        driver.get("https://books-pwakit.appspot.com");
        driver.manage().window().maximize();
        SearchContext shadow_multi = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot(); // dari parent ke #4
        Thread.sleep(1000);
        shadow.findElement(By.cssSelector("#input")).sendKeys("WELCOME");// langsung ke element nya (jadi parent 3 sampai 1 di lewati)


    }
}
