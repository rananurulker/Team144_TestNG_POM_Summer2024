package tests.day15_TestNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C05_SoftAssertion {
    @Test
    public void aramaTesti() {
        /*
        TestNG coklu assertion bulunduran methodlarda failed olan ilk assertionda kodun calismasini
        durdurmadan, testin sonuna kadar calismasini saglayacak bir alternative sunar.
        soft assert kullanildiginda biz raporla diyene kadar
        assertionlarin sonuclarini kaydeder ama calismayi durdurmaz

        biz raporla dersek
        failed olan assertionlari rapor eder
        ve failed olan assertion varsa calismayi durdurur.
         */

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        // url'in "testotomasyonu" icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        //soft assert kullanmak icin 3 adima ihtiyac var
        //1. adim soft assert objesi olusturmak
        SoftAssert softAssert=new SoftAssert();

        //2 yapilacak tum assertionlari softassert objesi ile yapmak
        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik),"Url Testotomasyonu icermiyor");

        // belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigurationReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // bulunan urun sayisinin 3'den fazla oldugunu test edin

        int expectedMinUrunSayisi = 3;
        int actualBulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList
                .size();
        softAssert.assertTrue(actualBulunanUrunSayisi>expectedMinUrunSayisi);

        //ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList
                .get(0)
                .click();

        // acilan sayfada urun isminde case sensitive olmadan
        // aranacak kelimenin bulundugunu test edin

        String actualUrunIsmi = testOtomasyonuPage.ilkUrunSayfasiIsimElementi
                .getText()
                .toLowerCase();
        String expectedisimIcerik = ConfigurationReader.getProperty("toAranacakKelime");
        softAssert.assertTrue(actualUrunIsmi.contains(expectedisimIcerik));

        //3. adim soft assert objesiye yaptigi assertionlari raporlamasini soyleyelim

        softAssert.assertAll();

        Driver.quitDriver();

    }
}
