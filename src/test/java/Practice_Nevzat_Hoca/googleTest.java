package Practice_Nevzat_Hoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class googleTest {
    WebDriver driver;

    String https="https://www.";

    // ilgili kurulumlari tamamlayalim
    // Kullanici https://www.google.com adresine gider
    // Kullanici cookies i kabul eder
    // Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer
   // Para birimlerinin karsilastirmasini alir
   // Karsilastirilacak olan para biriminin 1.5 den kucuk oldugu test edilir


    @Before
    public void setUo(){
        //il
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void googleTest(){
        driver.get(https+"google.com");
        


    }
    @After
    public void teardown(){
 //        driver.close();
    }

}
