package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_SwitchToWindow extends TestBase {

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement ilkYazielementi = driver.findElement(By.tagName("h3"));
        String actualTitle = ilkYazielementi.getText();
        String expectedTitle = "Opening a new window";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //        Assert.assertTrue(ilkYazielementi.isDisplayed());

        //● Sayfa başlığının(title) “The Internet” olduğu
        // nu doğrulayın.
        actualTitle = driver.getTitle();
        expectedTitle = "The Internet";
       Assert.assertEquals(expectedTitle,actualTitle);
        bekle(3);

        String ilkSayfaWHD = driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();


        /*
            Eger switchToNewWindow() method'u kullanilirsa
            driver yeni acilan sayfaya gecis yapar

            Ancak bu method kullanilmadan
            bir link tiklandiginda, yeni bir sayfa aciliyorsa
            driver yeni sayfaya gecis yapmaz

            bizim yeni acilan sayfanin
            windowHandle degerini bulup
            driver'i o sayfaya gecirmemiz GEREKLIDIR

            link'e click yaptigimizda acik 2 sayfamiz oluyor
            bunlardan bir tanesi windowHandle degerini kaydettigimiz ILK SAYFA
            digeri ise windowHandle degerini bilmedigimiz IKINCI SAYFA

            biz getWindowHandles() method'u ile
            bir SET olarak iki sayfanin windowHandle degerlerini alabiliyoruz

            O SET icerisinde
            ilkSayfaWHD'ine esit olmayan String'i
            ikinciSayfaWHD olarak atayabiliriz

         */
   // 1. window'a tekrar gecis yapabilmek icin set olusturuldu ve 2. windowHD kydedildi.

        Set<String> tümsayfalarWHDegerleri = driver.getWindowHandles();

        String ikinciWHD = "?";
        for (String each : tümsayfalarWHDegerleri
        ) {
            if (!each.equals(ilkSayfaWHD)) {
                ikinciWHD = each;
            }

        }
        driver.switchTo().window(ikinciWHD);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        actualTitle = driver.getTitle();
        expectedTitle = "New Window";
         bekle(2);

        Assert.assertEquals(expectedTitle,actualTitle);

        //● Sayfadaki textin (basliktaki textin) “New Window” olduğunu doğrulayın.
        expectedTitle="New Window";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Bir önceki pencereye geri döndükten sonra
         driver.switchTo().window(ilkSayfaWHD);

        // sayfa başlığının “The Internet” olduğunu doğrulayın.
        actualTitle=driver.getTitle();
        expectedTitle="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
