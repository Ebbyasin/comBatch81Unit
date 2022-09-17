package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {
    WebDriver driver;
    Select select;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test1(){
    //    https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");
    //    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm=driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
    //2.yol
        //System.out.println(select.getFirstSelectedOption().getText());


    //    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        System.out.println("=========================");
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
    //    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        System.out.println("=========================");
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
    //    Tüm dropdown değerleri(value) yazdırın
        System.out.println("=========================");
        List<WebElement> butumDdm=driver.findElements(By.xpath("//option"));
        butumDdm.forEach(t-> System.out.println(t.getText()));

        // List<WebElement> tumDdm=select.getOptions();
        //tumDdm.forEach(t-> System.out.println(t.getText()));

        // System.out.println(select.getAllSelectedOptions().get(0).getText());

    //    Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse
        System.out.println("DropDown Boyutu= "+butumDdm.size());

        if (butumDdm.size()==4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

        Assert.assertNotEquals(butumDdm.size(),4);
    //    False yazdırın.

    }
}
