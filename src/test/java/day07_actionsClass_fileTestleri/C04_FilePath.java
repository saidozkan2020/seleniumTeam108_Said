package day07_actionsClass_fileTestleri;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {

    @Test
    public void test01(){

        // bilgisayarimizin temel dosya yolu user.home

         ///Users/saidozkan/Desktop/TheDelta.docx
        //Users/ahmetbulutluoz/Desktop/Thedelta.docx
        //C:\Users\FURKAN\Desktop\TheDelta.docx"
        //C:\Users\Lenovo\Desktop\TheDelta.docx

        String dosyaYolu="/Users/saidozkan/Desktop/TheDelta.docx";
        boolean sonuc =Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);

        // /Users/ahmetbulutluoz/Downloads
        // /Users/saidozkan/Downloads

        // icinde bulundugumuz projenin temel dosya yolu user.dir
        //    /Users/ahmetbulutluoz/IdeaProjects/seleniumTeam108
        //    /Users/saidozkan/IdeaProjects/seleniumTeam108_Said

        //   /Users/ahmetbulutluoz/IdeaProjects/seleniumTeam108/src/test/java/day07_actionsClass_fileTestleri/text.txt
        //  /Users/saidozkan/IdeaProjects/seleniumTeam108_Said/src/test/java/day07_actionsClass_fileTestleri/text2.txt

        // C:\Users\Zafer\Desktop\gitHubTeam108\com.wisequarter1\src\test\java\day07_fileTests\text
        // C:\Users\sevil\IdeaProjects\seleniumTeam108\src\test\java\day07_actionClass_fileTest\text.txt


        System.out.println(System.getProperty("user.dir"));
        /*
            Bilgisayarimizda bir dosyanin var oldugunu test etmek icin
            dosya yoluna ihtiyacimiz var

            Ancak herkesin bilgisayarindaki dosya yollari
            farkliliklar gosterir

            herkesin bilgisayarina gore farkli olan kismi
            java'dan bir komut ile elde edebiliriz - user.home

         */


        System.out.println(System.getProperty("user.home"));
        dosyaYolu="/Users/saidozkan/Desktop/TheDelta.docx";
        dosyaYolu=System.getProperty("user.home")+"/Desktop/TheDelta.docx";

        //System.out.println(dosyaYolu);


    }
}
