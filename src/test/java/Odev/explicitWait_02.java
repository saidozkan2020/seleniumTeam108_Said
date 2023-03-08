package Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class explicitWait_02 extends TestBase {




        //    Explicit Wait

    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()

        @Test
        public void isEnabled(){

     //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
     driver.get("https://the-internet.herokuapp.com/dynamic_controls");

     //4. Textbox’in etkin olmadigini(enabled) dogrulayın
     WebElement texbox=driver.findElement(By.xpath("(//input[@type='text'])[1]"));
     Assert.assertFalse(texbox.isEnabled());

     //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
     driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
     WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
     wait.until(ExpectedConditions.elementToBeClickable(texbox));

     //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
     WebElement enabled=driver.findElement(By.xpath("//p[@id='message']"));
     Assert.assertTrue(enabled.isDisplayed());

     //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
     texbox= driver.findElement(By.xpath("(//input[@type='text'])[1]"));
     Assert.assertTrue(texbox.isEnabled());

        }
    }


