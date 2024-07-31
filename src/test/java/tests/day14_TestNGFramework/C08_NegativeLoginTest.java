package tests.day14_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C08_NegativeLoginTest {
    @Test
    public void negativeLoginTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki
                .click();

        //3- gecerli email, gecersiz password yazin
        testOtomasyonuPage.loginEmailkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.loginPasswordkutusu
                .sendKeys(ConfigurationReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSignInButonu
                .click();
        //5- Basarili olarak giris yapilamadigini test edin
        //   giris yapamadigimizi test etmek icin
        //   Email kutusunun hala gorundugunu test edebiliriz
        Assert.assertTrue(testOtomasyonuPage.loginEmailkutusu.isDisplayed());
    }
}
