package tests.day16_HTMLReportsDataProvider;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluNegatifLoginTesti extends TestBaseRapor {

    @Test
    public void gecersizPasswordTesti() {
        extentTest = extentReports.createTest("Gecersiz password testi",
                "kullanici gecersiz password ile sisteme giris yapamaz");
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        extentTest.info("kullanici testoromasyonu.coma gider");

        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("kullanici account linkine basar");
        //	- gecerli email, gecersiz password girin
        testOtomasyonuPage.loginEmailkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.loginPasswordkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecersizPassword"));
        extentTest.info("gecerli email girer");
        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSignInButonu
                .click();
        extentTest.info("login butonuna basar");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginEmailkutusu.isDisplayed());
        extentTest.pass("basarili olarak giris yapilamadigini test eder");
    }

    @Test
    public void gecersizEmailTesti() {
        extentTest = extentReports.createTest("Gecersiz email testi",
                "kullanici gecersiz email ile sisteme giris yapamaz");
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        extentTest.info("kullanici testoromasyonu.coma gider");

        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("kullanici account linkine basar");
        //	- gecersiz email, gecerli password girin
        testOtomasyonuPage.loginEmailkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.loginPasswordkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecerliPassword"));
        extentTest.info("gecersiz email girer");
        extentTest.info("gecersiz email girer");
        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSignInButonu
                .click();
        extentTest.info("login butonuna basar");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginEmailkutusu.isDisplayed());
        extentTest.pass("basarili olarak giris yapilamadigini test eder");


    }

}