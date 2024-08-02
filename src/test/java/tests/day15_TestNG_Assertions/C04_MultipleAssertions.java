package tests.day15_TestNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Locale;

public class C04_MultipleAssertions {
    /*
    TEstNGdeki assert classindan kullanilan
    assertion methodlari JUnitdeki assertions gibidir.
    ilk failed ola assertionda kodun calismasini durdurur.
    kodun geriye kalaninda hata olup olmadigini bilemeyiz.

    kodun geriye kalanini kontrol etmedigi icin bulunan hata
    duzeltildikten sonra test methodu calistirildiginda testin passed olacagini garanti edemeyiz
     */
    @Test
    public void aramaTesti(){

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        // url'in "testotomasyonu" icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigurationReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // bulunan urun sayisinin 3'den fazla oldugunu test edin

        int expectedMinUrunSayisi = 3;
        int actualBulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList
                .size();

        Assert.assertTrue(actualBulunanUrunSayisi > expectedMinUrunSayisi);

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

        Assert.assertTrue(actualUrunIsmi.contains("Ali"));

        Driver.quitDriver();
    }
}
