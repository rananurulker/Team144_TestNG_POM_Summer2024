package tests.day14_TestNGFramework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PageClassDUzenlemeJava {

    @Test
    public void aramaTesti(){

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        ReusableMethods.bekle(3);
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(3);
        // arama sonucunda urun bulunabildigini test edin
        int actualSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualSonucSayisi > 0);

        // sayfayi kapatin
        Driver.quitDriver();
}}
