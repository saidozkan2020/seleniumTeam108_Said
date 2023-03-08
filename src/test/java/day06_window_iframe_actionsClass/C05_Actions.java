package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C05_Actions extends TestBase {

    @Test
    public void test01(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement kesikCizgiliKareElementi= driver.findElement(By.id("hot-spot"));
        actions.contextClick(kesikCizgiliKareElementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
          String actualYazi=driver.switchTo().alert().getText();
          String expectedYazi="You selected a context menu";
          Assert.assertEquals(expectedYazi,actualYazi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        String ilkWHD= driver.getWindowHandle();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();

         Set<String >WHdegerleri=driver.getWindowHandles(); // [ilkSayfaWHD,ikinciSayfaWHD]

        String ikinciWHD="";
        for (String each:WHdegerleri
             ) {
            if (!ilkWHD.equals(each)){
                ikinciWHD=each;
            }

        }
        driver.switchTo().window(ikinciWHD);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
         actualYazi=driver.findElement(By.tagName("h1")).getText();
        expectedYazi="Elemental Selenium";
        Assert.assertEquals(expectedYazi,actualYazi);

    }
}
