package tests.day16_HTMLReportsDataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.TestBaseRapor.extentReports;

public class C01_RaporluAramaTesti extends TestBaseRapor {
    @Test
    public void aramaTesti() {

      extentTest=extentReports.createTest("arama testi",
              "kullanici belirlenen kelimeyi aratip sonucu bulabilmelidir");

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        extentTest.info("kullanici testotomasyonu anasayfaya gider");

        // url'in "testotomasyonu" icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        extentTest.pass("urlnin test otomasyonu icerdigini test eder");

        // belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigurationReader.getProperty("toAranacakKelime") + Keys.ENTER);
        extentTest.info("kullanici arama yapar");

        // bulunan urun sayisinin 3'den fazla oldugunu test edin

        int expectedMinUrunSayisi = 3;
        int actualBulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList
                .size();

        Assert.assertTrue(actualBulunanUrunSayisi > expectedMinUrunSayisi);
        extentTest.pass("bulunan urunun 3 ten fazla oldugunu test eder");
        //ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList
                .get(0)
                .click();
        extentTest.info("kilk urune tiklar");
        // acilan sayfada urun isminde case sensitive olmadan
        // aranacak kelimenin bulundugunu test edin

        String actualUrunIsmi = testOtomasyonuPage.ilkUrunSayfasiIsimElementi
                .getText()
                .toLowerCase();
        String expectedisimIcerik = ConfigurationReader.getProperty("toAranacakKelime");

        Assert.assertTrue(actualUrunIsmi.contains("Ali"));
        extentTest.pass("acilan sayfada urun isminde case sensitive olmadan aranacak kelimenin bulundugunu test eder");

    }
}
