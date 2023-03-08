package Odev;

import org.junit.Test;
import utilities.TestBase;

public class iframe02 extends TestBase {

    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    @Test
    public void test01(){
        driver.get("http://demo.guru99.com/test/guru99home/");

    }
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke
    //(https://www.guru99.com/live-selenium-project.html) tıklayınız
}
