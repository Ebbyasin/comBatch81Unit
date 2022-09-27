package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Odevler.utilities.TestBaseBeforeAfter;

public class C02_FileExistsDownLoad extends TestBaseBeforeAfter {

    @Test
    public void test1(){

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement dosyaSec=driver.findElement(By.xpath("//*[@id='file-upload']"));
        /*
        Dosyasec butonuna direk click yapamayabiliriz cunku windows a mudahaleye izin vermeyibilir
        Bu yuzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string degiskene atadigimiz dosya
        yolumuzu gondeririz.
         */
        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu="C:\\Users\\toshiba\\Downloads\\test.txt";
        dosyaSec.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());


    }
}
