package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_SwitchToWindows extends TestBase {

    @Test
    public void test01(){

        // amazon anasayfaya gidip, arama kutusunun erisilebilir oldugunu test edin
       driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());

        //amazona tekrar gelebilmek icin windowHandel degerini aldik
        String amazonWindowHandel=driver.getWindowHandle();
        bekle(2);

        // yeni bir tab olarak wisequarter.com'a gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String wiseWuarterWH= driver.getWindowHandle();
        /* once yeni bir tab olusturup
           driver'i o sayfaya gecirmeliyiz (switch)
         */


        // url'in wisequarter icerdigini test edin
        String actualURL=driver.getCurrentUrl();
        String expectedIcerik="wisequarter";
        Assert.assertTrue(actualURL.contains(expectedIcerik));

        // amazon'un acik oldugu tab'a geri donup
        driver.switchTo().window(amazonWindowHandel);
        /*
            Daha once acilmis olan bir window'a gecis yapmak icin
            O sayfanin windowHandle degerine ihtiyacimiz var

            Testimiz boyle bir gorevi iceriyorsa
            o sayfada iken windowHandle degerini alip kayit yapmaliyiz
         */


        // Nutella icin arama yapin
        aramaKutusu.sendKeys("Nutella"+Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edin
        expectedIcerik="Nutella";
        String actualSonuc= driver
                .findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText();
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));

        // yeni bir window olarak youtube.com'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        // Url'in youtube icerdigini test edin
        expectedIcerik="youtube";
         actualURL=driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedIcerik));
        bekle(2);

        // wisequarter'in acik oldugu sayfaya donun
        driver.switchTo().window(wiseWuarterWH);

        // Title'in Wise Quarter icerdigini test edin
        expectedIcerik="Wise Quarter";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        bekle(3);

    }
}
