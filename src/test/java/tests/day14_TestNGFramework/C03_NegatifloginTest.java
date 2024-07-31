package tests.day14_TestNGFramework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_NegatifloginTest {
    @Test
    public void negatifLoginTesti(){

        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        //2- Cookies cikiyorsa kabul edin
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookiesKabulButonu.click();

        //3- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        //4- Faker class’ini kullanarak
        //   email ve sifre degerlerini yazdirip, giris butonuna basin

        Faker faker = new Faker();

        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        facebookPage.loginButonu.click();

        //5- Basarili giris yapilamadigini test edin

        // giris yapamadigimizi, hala email kutusunun gorundugu ile test edebiliriz

        Assert.assertTrue(facebookPage.emailKutusu.isDisplayed());

        // sayfayi kapatin
        Driver.quitDriver();
    }

    }

