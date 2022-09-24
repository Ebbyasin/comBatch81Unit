package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;

    public class C01_ReadExcel {
    /*
    /- Dosya yolunu bir String degiskene atayalim
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        //- Row objesi olusturun sheet.getRow(index)
        //- Cell objesi olusturun row.getCell(index)
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
     */

    /*
    Ara-->dosyaYolu
    Windows Gezgini ile ac-->FileInputStream
    Excel i ac-->Workbook
    Sayfa1 e git-->Sheet
    Satiri bul-->Row
    Sutunu bul-->Cell
     */

        @Test
        public void test() throws Exception {
            String dosyaYolu = "src/resources/ulkeler.xlsx";

            FileInputStream fis = new FileInputStream(dosyaYolu);  // Dosyayi isleme alir

            Workbook workbook = WorkbookFactory.create(fis);  // Workbook objesiyle fis objesi ile akisa aldigimiz dosyammizla bir excell dosyasi create ettik

            Sheet sheet = workbook.getSheet("Sayfa1"); // Excel dosyamizda calismak istedigimiz sayfayi seceriz

            Row row = sheet.getRow(3); //Sayfa 1 deki 3. Satiri bu sekilde seceriz

            Cell cell = row.getCell(3);  // Satir secimi yapildiktan sonra hucre secimi bu sekilde yapilir

            System.out.println(cell);

            String expectedData = "Cezayir";
            String actualData = cell.toString();
            Assert.assertEquals(expectedData,actualData);
            Assert.assertEquals(expectedData,cell.getStringCellValue());
        }
    }
