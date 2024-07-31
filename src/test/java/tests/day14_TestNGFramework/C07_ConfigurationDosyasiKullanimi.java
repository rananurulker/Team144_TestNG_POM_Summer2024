package tests.day14_TestNGFramework;

import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_ConfigurationDosyasiKullanimi {
    @Test
    public void positiveLoginTesti(){
        /*
        Artik test methodlarinda dinamik olmayan hicbir data istemiyoruz.
        tum locate, url, kullanici adi vb datalar
        proje kapsamindaki belirlenmis yerlerde olmali
        test methodunda ihtiyacimiz oldugunda ilgili yerden
        kolayca ulasabilmeli ve alabilmeliyiz

        Locate ettigimiz webelementler Pages claslarinda
        configuration.properties dosyasinda da test datalarimiz olacak url, kullanci adi, sifre, aranacak kelime

         */
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();

        // 3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.loginEmailkutusu.sendKeys(ConfigurationReader.getProperty("toGecerliEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.loginPasswordkutusu.sendKeys(ConfigurationReader.getProperty("toGecerliPassword"));
        // 5- Login butonuna basarak login olun
        testOtomasyonuPage.loginSignInButonu.click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutButonu.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}
