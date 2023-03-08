package Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait  {


    //  1. Bir class olusturun : WaitTest
    //  2. Iki tane metod olusturun : implicitWait() , explicitWait()
    // Iki metod icin de asagidaki adimlari test edin.
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin

     public WebDriver driver;
    @Test
      public void implicitWait(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();
           WebElement itsGone=driver.findElement(By.xpath("//p[@id=\"message\"]"));
           Assert.assertTrue(itsGone.isDisplayed());
           driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
           WebElement back=driver.findElement(By.xpath("//p[@id='message']"));
           Assert.assertTrue(back.isDisplayed());

    }

    @Test
    public void explicitWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement itsGone=driver.findElement(By.xpath("//p[@id=\"message\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGone));

        Assert.assertTrue(itsGone.isDisplayed());
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebElement back=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(back.isDisplayed());


    }


}
