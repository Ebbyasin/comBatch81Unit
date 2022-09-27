package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Odevler.utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1(){

        //https://the-internet.herokuapp.com/context_menu sitesine gidelim  3- Cizili alan uzerinde sag click yapalim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Cizgili olan bolum uzerinde sag click yapalim
        WebElement cizgiliAlan=driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();// sag clik;contextClick ile oluyor.
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlertYazisi="You selected a context menu";
        String actualAlertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());--->bu satir
        //-->24-25-26. satirlarin tek satir halinde yapilmisidir..

        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowlist=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());






    }

}
