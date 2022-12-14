package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle {

    /*
    Tests package’inda yeni bir class olusturun: WindowHandle2
    https://the-internet.herokuapp.com/windows adresine gidin.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    Click Here butonuna basın.
    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    Sayfadaki textin “New Window” olduğunu doğrulayın.
    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        Thread.sleep(2000);
        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Thread.sleep(2000);

        /*
        //Bir Web sitesine gittiginizde bir webelementi tikladiginizda yeni bir sekme yada pencere acilirsa
        //bu yeni acilan sekmenin handle degerini bulabilmek icin driver.getWindowHandles() methodunu bir Array
        //List atip butun sayfalarin listesine ulasabiliriz. Ilk actigim pencerenin index'i 0'dır,
        // ikinci acilan sekmenin index'i 1'dir
        //ve ikinci acilan pencere veya sekmede islem yapabilmek icin
        //driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
        */

        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Window Handle Değerleri = "+ windowList);
        driver.switchTo().window(windowList.get(1));


        // Set<String> windowHandleseti= driver.getWindowHandles();
        // System.out.println(windowHandleseti);
        // String ikinciSayfaWindowHandleDegeri="";
        // for (String each: windowHandleseti) {
        //   if (!each.equals(ilkSayfaWindowHandleDegeri)){
        //       ikinciSayfaWindowHandleDegeri=each;
        //    }// BU ikinci yol ;kafa karisikligi olusturdugu icin yapmiyoruz..
       //  }


        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        /*
        String expectedTitle="New Window";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        ------>bu uzun yolu,alttaki kisa yol<----------
        */
        Assert.assertEquals(driver.getTitle(),"New Window");

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet",driver.getTitle());
    }

        /* ODEVVV
        Bir class olusturun: IframeTest02
        http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        sayfadaki iframe sayısını bulunuz.
        ilk iframe'deki (Youtube) play butonuna tıklayınız.
        ilk iframe'den çıkıp ana sayfaya dönünüz
        ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        tıklayınız
         */



}
