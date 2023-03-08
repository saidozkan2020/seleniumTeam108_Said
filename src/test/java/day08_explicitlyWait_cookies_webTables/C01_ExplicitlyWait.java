package day08_explicitlyWait_cookies_webTables;

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

public class C01_ExplicitlyWait {

    @Test
    public void test01(){

        /*
            Implicitly Wait test yaparken ihtiyacimiz olan beklemelerin cogunu halleder
            Nadiren de olsa bazi islemler icin implicitlyWait icin tanimlanan
            sureden daha fazla zamana ihtiyac olabilir

            ExplicitlyWait bir webelement uzerinde gerceklesecek
            TEK BIR gorev icin tanimlanir

            Bunun icin hem webelement tanimlanmali, hem de gorev
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        //4. Remove butonuna basin.

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //   explicitly wait kullanacaksak
        //   A - bir wait objesi olustur

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

        //  B - EGER kullanacagimiz webelement locate edilebilir ise locate yapalim

        // WebElement itsGoneElementi=
                //driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        //  C- EGER locate etmemiz icin zamana ihtiyac varsa,
        //     Locate ve gorev tanimlamayi tek satirda yapiyoruz

        WebElement itsGoneElementi=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        driver.close();

/*
echo "# seleniumTeam108_Said" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M master
git remote add origin https://github.com/saidozkan2020/seleniumTeam108_Said.git
git push -u origin master
 */


    }
}
