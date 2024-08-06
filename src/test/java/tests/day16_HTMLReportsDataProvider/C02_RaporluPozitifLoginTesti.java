package tests.day16_HTMLReportsDataProvider;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.lang.module.Configuration;

public class C02_RaporluPozitifLoginTesti extends TestBaseRapor {
    /*
    TestNGde calisan bir test methodunu raporlu hale getirmek istedigimizde
    1-classi TestBaseRapor'a extend edin
    2- her methodda extentTest objesine deger atayip
    raporda info cikmasini istedigimiz satirlara extendTest.info()
    assertion olan satirlara ise extendTest.pass()
    methodlari ile aciklama ekleyin.
     */
    @Test
    public void pozitifLoginTesti(){
        extentTest=extentReports.createTest("Pozitif login testi",
                "kullanici gecerli bilgilerle sisteme giris yapabilmeli");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        extentTest.info("kullanici https://www.testotomasyonu.com/ anasayfaya gider");
        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.loginEmailkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecerliEmail"));
        extentTest.info("email olarak gecerli email girer");
        //4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.loginPasswordkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecerliPassword"));
        extentTest.info("gecerli password girer");

        //5- Login butonuna basarak login olun
        testOtomasyonuPage.loginSignInButonu
                .click();
        extentTest.info("login butonuna basarak login olur");

        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("basarili giris yapabildigini test eder");

    }
}
