package day07_actionsClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyboardActions extends TestBase {


    @Test
    public void test01() {
        //1- https://www.facebook.com adresine gidelim
       driver.get("https://www.facebook.com");
        //2- Cookies'i kabul edip Yeni hesap olustur butonuna basalim
        WebElement cookiesButton=driver.findElement(By.xpath("(//button[@value='1'])[3]"));
        cookiesButton.click();
        WebElement yeniHesapOlustur=driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]"));
        yeniHesapOlustur.click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
         WebElement isimWebElement=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
         Actions actions=new Actions(driver);

         Faker faker=new Faker();
         String fakerEmailAdress=faker.internet().emailAddress();

         actions.click(isimWebElement)
                 .sendKeys(faker.name().firstName())
                 .sendKeys(Keys.TAB)
                 .sendKeys(faker.name().lastName())
                 .sendKeys(Keys.TAB)
                 .sendKeys(fakerEmailAdress)
                 .sendKeys(Keys.TAB)
                 .sendKeys(fakerEmailAdress)
                 .sendKeys(Keys.TAB)
                 .sendKeys(faker.internet().password())
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys("20")
                 .sendKeys(Keys.TAB)
                 .sendKeys("Jan")
                 .sendKeys(Keys.TAB)
                 .sendKeys("1990")
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.ARROW_RIGHT)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)


                 //4- Kaydol tusuna basalim
                 .sendKeys(Keys.ENTER).perform();

         bekle(10);



    }

}