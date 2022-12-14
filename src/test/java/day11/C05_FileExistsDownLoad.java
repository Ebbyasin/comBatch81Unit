package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import Odevler.utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExistsDownLoad extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();
        Thread.sleep(2000);
        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu="C:\\Users\\toshiba\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); //exists=var olan,mevcut demek,path=yollar
        //indirildigini konsolda gosterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
    }
}
