package tests.day17_dataProvider_crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.TestBaseCross;

public class C01_CrossBrowserArama extends TestBaseCross {
    /*


    .xml dosyasindan parametre olarak gonderilen
    calisacagimizBrowseri buradan yakalayacagimiz bir sistem kuralim

    1-.xml calisacak browseri parametre olarak yollar
    2- her classta ugrasmamak icin olusturdugumuz TestBaseCross calisacakBrowser parametresini yakalar
    calisacak browsera uygun webDriver objesi olusturmasi icin DriverCrossu calistirir.
    3-DriverCross kendisine parametre olarak gonderilen calisacakBrowsera uygun WebDriveri olusturup
    TestBaseCrossa dondurur
    4-TestBaseCross DriverCrosstan gelen WebDriveri
    'driver' objesine atama yapar.
    5-Test classinda driver objesini kullanarak testlerimizi yazacagiz.

    ONEMLI NOT:

    Page classlarinda Driver.getDriver() tanimli oldugundan crossBrowser testler icin varolan
    Page classlarini kullanamayiz
    */

    @Test
    public void aramaTesti(){
        //testotomasyonu anasayfaya gidin
        driver.get(ConfigurationReader.getProperty("toUrl"));

        //belirlenen aranacakkelime icin arama yapin
        WebElement aramaKutusu= driver.findElement(By.id("\"global-search\""));
        aramaKutusu.sendKeys(ConfigurationReader.getProperty("toAranacakKelime"));


        //arama sonucunda urun bulunabildigini test edin
        String unExpectedSonucYazisi="0 Products Found";
        WebElement sonucYazisiElementi=driver.findElement(By.className("product-count-text"));
        String actualSonucYazisi=sonucYazisiElementi.getText();

        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);


        //sayfayi kapatin
        //TestBAse crossta After method sayfayi kapatir

    }
}
