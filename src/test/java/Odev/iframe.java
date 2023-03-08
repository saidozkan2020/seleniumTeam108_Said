package Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class iframe extends TestBase {

    //  1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    //  2 ) Bir metod olusturun: iframeTest
    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
      WebElement containing= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(containing.isEnabled());
        //    konsolda yazdirin.
        System.out.println(containing.getText());

      //  WebElement iframeElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(0);

        //            - Text Box’a “Merhaba Dunya!” yazin.
        driver.findElement(By.tagName("p")).sendKeys("Merhaba Dünya");


        bekle(4);
        driver.switchTo().parentFrame();

        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        WebElement ElementalSelenium =driver.findElement(By.linkText("Elemental Selenium"));
         Assert.assertTrue(ElementalSelenium.isDisplayed());
        System.out.println("ElementalSelenium = " + ElementalSelenium.getText());

        //    gorunur oldugunu dogrulayin ve konsolda yazdirin.


    }
}