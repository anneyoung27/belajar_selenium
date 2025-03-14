package BELAJAR_SELENIUM.DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFiles {
    // Cara membaca file properties
    /*
        .properties = biasa digunakan untuk menyimpan dan mengelola konfigurasi
        atau data yang sering digunakan di dalam pengujian otomatis.
        1. Konfigurasi Environment
           - URL aplikasi (misalnya: baseURL=https://example.com)
           - Lokasi driver browser (misalnya: webdriver.chrome.driver=path/to/chromedriver)
           - Port server, waktu tunggu (timeout), dan lain-lain.
        2. Data yang dapat dikonfigurasi
           - Username dan password (jika tidak sensitif atau dienkripsi).
           - Pilihan browser (misalnya: browser=chrome).
           - Informasi pengaturan lokal (misalnya: language=en-US).
        3. Pengelolaan dinamis

        Keuntungan menggunakan Properties:
        - Keterpisahan Konfigurasi dan Kode: Konfigurasi terpisah dari kode membuat framework lebih fleksibel.
        - Mudah Diubah: Anda bisa mengubah konfigurasi tanpa perlu mengompilasi ulang kode.
        - Dukungan untuk Multi-Environment: Satu file untuk masing-masing environment, seperti dev.properties, qa.properties, atau prod.properties.
     */
    public static void main(String[] args) throws IOException {
        // a. Create object of properties class
        Properties properties = new Properties();
        // b. Location of Properties file
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\globalData.properties");
        properties.load(fileInputStream);

        // c. Reading data from properties file
        String url = properties.getProperty("appURL");
        String email = properties.getProperty("email");
        String password = properties.getProperty("password") ;
        String orderID = properties.getProperty("orderID");
        String customerID = properties.getProperty("customerID");




    }
}
