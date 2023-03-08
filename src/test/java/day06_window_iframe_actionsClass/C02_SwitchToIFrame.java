package day06_window_iframe_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_SwitchToIFrame extends TestBase {


    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/iframe  adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // "Your content goes here." yazisinin gorunur oldugunu test edin
        /*
            Bazen locate islemimizden emin olmamiza ragmen
            Locator calismaz
            Bunun sebebi kullanmak istedigimiz webelement'in
            bir iframe'in child'i olmasi olabilir.

            Eger Kullanmak istedigimiz webelement
            anasayfa icine gomulen baska bir websayfasinin elementi ise
            once gomulu sayfaya gecmemiz gerekir

            HTML komutlarinda sayfa icerisine sayfa gomebilmek icin
            <iframe> kullanilir
            Biz de istedigimiz elementi kullanmak icin once
            o frame'e switch yapmaliyiz

            1- gecis yapmak istediginiz frame'i locate edin
            2- switchTo() ile o frame'e gecis yapin
            3- Sonra istediginiz element ile istediginiz islemi yapin
         */
         //iframe elementini bulunuz
        WebElement iframeElementi=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        //iframe'e gecis yapiniz
        driver.switchTo().frame(iframeElementi);

        //ifarem icindeki yazi elementini aliniz
        WebElement yaziElementi=driver.findElement(By.tagName("p"));

        //Sonra tekrar bir üst html geciniz
        driver.switchTo().parentFrame();// icice frame'lerde bir ust seviyeye cikar
        //driver.switchTo().defaultContent();// direk anasayfaya cikar

        // Elemental Selenium linkine click yapin
        WebElement seleniumLink=driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        seleniumLink.click();
        bekle(3);
        /*
            Bir frame'e gecis yaptiktan sonra
            oradan cikincaya veya baska bir frame'e gecinceye kadar
            driver o frame icerisinde kalir

            isimiz bittiginde veya baska frame'e gecmek istedigimizde
            once calisacagimiz yere gecis yapmaliyiz
         */





    }
}
