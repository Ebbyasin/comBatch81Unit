package day08;

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
import java.util.ArrayList;
import java.util.List;

public class C04_iframe {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1() {

        //soru//https://html.com/tags/iframe/ adresine gidiniz

        //driver.get("https://html.com/tags/iframe/");
        //Youtube videosunu çalıştırınız
        //WebElement youtubeFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        //driver.switchTo().frame(youtubeFrame);
        //driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

        driver.get("https://html.com/tags/iframe/");
        /*
        bir web sitesinde bir video(yotube vb.)varsa <iframe>tag i icerisindeyse bu video yu direk locate edip
        calistirmak dinamik olmaz cunku link degisebilir ve locate imiz calismaz.
        bunun icin butun frame leri bir liste atip bir array liste atif index ile frame yi secip sonrasinda
        play tusunu locate edip calistirabiliriz.
       */

        List<WebElement> iframeList =new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

    }
}
