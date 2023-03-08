package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistTesti extends TestBase {

    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
        WebElement logoPng=driver.findElement(By.linkText("logo.png"));
        logoPng.click();

        bekle(5);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosya downloads'a inecegi icin dinamik dosya yolu olusturalim

        String DinamikDosyaYolu= System.getProperty("user.home")+"/Downloads/logo.png";
         Assert.assertTrue(Files.exists(Paths.get(DinamikDosyaYolu)));
    }
}
