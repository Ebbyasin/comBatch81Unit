package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.table.TableRowSorter;
import java.time.Duration;

public class C02_Allerts {

    //Bir class olusturun: Alerts
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an
    // alert” oldugunu test edin.
    // Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    //Collapse

    /*
    NOTLAR.....===================>>>>>
    Bir web sitesine girdigimizde karsimiza bir uyai mesaji yada bir butona tikladigimizda bir uyari
    (alert) cikabilir,Eger bu uyarıya incele(sag tik-inspect) yaoabiliyorsak bu tur alertt'lere HTML alert denir
    ve istedigimiz locate'i alabiliriz fakat gelen uyari kutusuna mudahale (sag tik-incele) edemiyorsak
    bu tur alert'lere jd alert denir. js alert'lere mudahale edebilmek icin
    - tamam yada ok icin --> driver.switchTo().alert().accept() kullanilir
    - iptal icin --> driver.switchTo().alert().dismiss() kullanilir
    - Alert icindekiğ mesaji almak icin --> driver.switchTo().alert().getText() kullanilir
    - Alert bizde bir metin istiyorsa --> driver.switchTo().alert().sendKeys() kullanilir
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an
        // alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        WebElement mesaj=driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj=mesaj.getText();
        String expectedMesaj="You successfully clicked an alert";
        Assert.assertEquals(expectedMesaj,actualMesaj);


    }
    @Test
    public void test2() throws InterruptedException {
        //2. butona tıklayın, uyarıdaki Cancel(iptal) butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        //Alert üzerindeki mesajı yazdırın
        System.out.println("2.Buttonun Alert Mesajı = "+driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        String actualMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj = "successfuly";
        Assert.assertFalse(actualMesaj.contains(expectedMesaj));
    }
    @Test
    public void test3() throws InterruptedException {
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        //Alert üzerindeki mesajı yazdırınız
        Thread.sleep(2000);
        System.out.println("3. Butonun alert mesaji : "+driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Yasin Mesekoparan");
        driver.switchTo().alert().accept();
        String actualMesaj=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj="Yasin Mesekoparan";
        Assert.assertTrue(actualMesaj.contains(expectedMesaj));
    }

}
