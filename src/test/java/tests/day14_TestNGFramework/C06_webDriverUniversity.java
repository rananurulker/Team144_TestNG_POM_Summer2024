package tests.day14_TestNGFramework;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebDriverUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_webDriverUniversity {
    @Test
    public void webDriverUniversity(){
        //1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        WebDriverUniversityPage webDriverUniversityPage=new WebDriverUniversityPage();
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",webDriverUniversityPage.loginButonu);
        //3."Login Portal" a tiklayin
        webDriverUniversityPage.loginButonu.click();

        //4.Diger window'a gecin
        ReusableMethods.SwitchWindowByTitle(Driver.getDriver(),"WebDriver | Login Portal");

        //5."username" ve "password" kutularina deger yazdirin
        Faker faker=new Faker();
        webDriverUniversityPage.userNameKutusu.sendKeys(faker.name().username());
        webDriverUniversityPage.passwordKutusu.sendKeys(faker.internet().password());

        //6."login" butonuna basin
        webDriverUniversityPage.loginKutusu.click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedAlertYazisi="validation failed";
        String actualAlertYazisi=Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);

        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver().switchTo().alert().accept();

        //9.Ilk windowa geri donun
        ReusableMethods.SwitchWindowbyURL(Driver.getDriver() , "https://webdriveruniversity.com/");

        //10.Ilk windowa donuldugunu test edin
        String expectedTitle = "WebDriverUniversity.com";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        ReusableMethods.bekle(3);
        Driver.quitDriver();

    }
}
