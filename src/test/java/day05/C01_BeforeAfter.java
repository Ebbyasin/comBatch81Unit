package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfter {
    WebDriver driver;  //kullanabilmek icin class seviyesine tanımlandı

    @Before
    // Before notasyonu her testten önce çalışır
    public void setUp(){
        // @Before kullaniyorsak method icin istedigimiz ismi kullanabiliriz
        // ancak genel olarak kullanımı setUp seklindedir
        //@Before kullandığımızda testlerimizden önce yapmak zorunda oldugumuz
        // driver objelerini yazmak yerine @Before ile bir kere yazarız
        //yani her testten önce burayı calıstır, sonra testlerimizi calıstır.
        // diğer testlerimizde rahat kullanabilmek icin bunu class seviyesinde tanımlamamız gerekir.
        //driver objesini direk kullanabilmek icin class seviyesine WebDriver driver yaz!!

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void method1() {
        //1 defa before methodu çalışır
        driver.get("https://amazon.com");
        //1 defa da after methodu çalışır
        //yani burada 3 defa method calısır, before, meethod1 ve after methodları.
    }
    @Test
    public void method2() {
        //1 defa before methodu çalışır
        driver.get("https://techproeducation.com");
        //1 defa da after methodu çalışır
    }
    @Test
    public void method3() {
        //1 defa before methodu çalışır
        driver.get("https://hepsiburada.com");
        //1 defa da after methodu çalışır
    }
    @After
    //After notasyonu her testten sonra çalışır
    public void tearDown() {
        //en son kullanacağımız methodlar icin @After kullanırız.
        //genelde bunun icin method ismi tearDown kullanilir

        driver.close();

    /*
    @Before : Önce ; @After : Sonra Demek. @Test kısmında yazdığımız methodlar;
    çalışmaya başlamadan önce @Before yazan method çalışır; sonra kendisi çalışır
    ve en son olarak ta @After da yazılan method çalışır...Bu durum her @Test methodun da
    aynı şekilde devam eder. @After ve @Before methodlarının nerde yazıldığının önemi yoktur (edited)
     */
    }
}

