package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExists {

    @Test
    public void test1(){

        System.out.println(System.getProperty("user.dir"));//C:\SeleniunBatch81\com.Batch81JUnit
        //Suanki icinde bulundugum yolu gosterir
        System.out.println(System.getProperty("user.home"));//C:\Users\Lenovo
        //Gecerli kullancinin ana dizinini verir
        /*

        String farkliBolum=System.getProperty("user.home");
        //"C:\Users\toshiba\OneDrive\Masaüstü\text.txt" -->masa ustundeki dosyanin yolu
        String ortakBolum="\\OneDrive\\Masaustu\\text.txt";

        String masaustuDosyaYolu=farkliBolum+ortakBolum; // Masaustundeki dosya yolunu gosterir

        System.out.println(masaustuDosyaYolu);//C:\Users\toshiba\OneDrive\Masaüstü\text.txt
        System.out.println(Files.exists(Path.of(masaustuDosyaYolu)));
        Assert.assertTrue(Files.exists(Path.of(masaustuDosyaYolu)));

         */

        String dosyaYolu="C:\\Users\\toshiba\\OneDrive\\Masaüstü\\text.txt.txt";
        //System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Bir
        eb sitesinden indirdigimiz ya da windows icinde olusturdugumuz dosyanin indigini ya ada orda oldugunu
        test edebilmem icin o dosyanin uzerine shift tusuna basili olarak sag klik yapip dosyanin yolunu kopyala
        yip bir string degiskene atariz ve dosyayi dogrulamak  icin
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullaniriz
         */

        //Biz su an UI testi yapiyoruz,frontend...
    }
}
