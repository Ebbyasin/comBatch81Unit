package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {

    /*
  ● Bir class olusturun: IframeTest
  ● https://the-internet.herokuapp.com/iframe adresine gidin.
  ● Bir metod olusturun: iframeTest
     ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
     ○ Text Box’a “Merhaba Dunya!” yazin.
     ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
       dogrulayin ve konsolda yazdirin
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
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
      //  ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());
        //○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBoxFrame=driver.findElement(By.xpath("//*[@id='mce_0_ifr']")); //frame e gecis yapmadan önce frame'i  id ile locate ediyorum
        driver.switchTo().frame(textBoxFrame);//burada  frame e gecis yapiyorum
        Thread.sleep(2000);
        WebElement textBox=driver.findElement(By.xpath("//p"));//yazımı yazmak icin textBox ı locate ediyorum
        textBox.clear();//textBox'in icini temizlemek icin clear kullanıyorum
        Thread.sleep(2000);
        textBox.sendKeys("Merhaba dunya");//yazimi gönderiyorum

        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //       dogrulayin ve konsolda yazdirin

        driver.switchTo().defaultContent(); // Iframe'den çıkıp ana sayfaya geçmek için bu method kullanılır
        WebElement elemantal = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemantal.isDisplayed());
        System.out.println(elemantal.getText());
    }

}
