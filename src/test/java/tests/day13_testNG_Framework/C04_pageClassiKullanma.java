package tests.day13_testNG_Framework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

import java.util.Locale;

public class C04_pageClassiKullanma {
    @Test(groups = {"smoke","E2E 1","regression"})
    public void test01(){
        //testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        //testNG POMde pages classlari altindaki locate edilmis
        //WEBElementleri kullanmak icin ilgili classdan obje olustururuz.

        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();

        // phone icin arama yapin
        testOtomasyonuPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        //ilk urune tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList.
                get(0).
                click();

        //acilan sayfadaki urun isminde case sensitive olmadan phone bulndugunu test edin
        String expectedUrunicerik="phone";
        String actualUrunIcerik= testOtomasyonuPage
                .ilkUrunSayfasiIsimElementi
                .getText()
                .toLowerCase(Locale.ROOT);
        Assert.assertTrue(actualUrunIcerik.contains(expectedUrunicerik));

    }
}
