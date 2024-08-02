package tests.day15_TestNG_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_NegativeLoginTesti {

    // 1- https://www.testotomasyonu.com/ anasayfasina gidin
    // 2- account linkine basin
    // 3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin



    @Test
    public void gecersizPasswordTesti(){
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //	- gecerli email, gecersiz password girin
        testOtomasyonuPage.loginEmailkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.loginPasswordkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecersizPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSignInButonu
                .click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginEmailkutusu.isDisplayed());
        Driver.quitDriver();
    }

    @Test
    public void gecersizEmailTesti(){
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //	- gecersiz email, gecerli password girin
        testOtomasyonuPage.loginEmailkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.loginPasswordkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecerliPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSignInButonu
                .click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginEmailkutusu.isDisplayed());
        Driver.quitDriver();

    }


    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //	- gecersiz email, gecersiz password girin
        testOtomasyonuPage.loginEmailkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.loginPasswordkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecersizPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSignInButonu
                .click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginEmailkutusu.isDisplayed());
        Driver.quitDriver();
    }
}