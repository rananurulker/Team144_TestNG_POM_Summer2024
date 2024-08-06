package tests.day17_dataProvider;

import org.openqa.selenium.devtools.v125.input.model.DragDataItem;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_CokluNegatifLoginTesti {
    @DataProvider
    public static Object[][] testDatalariGonder() {
        String[][] kullaniciDatalariArr = {

                {"banu@gmail.com","898989"},
                {"sedat@yahoo.com","989887"},
                {"orkong@tmail.com","122334"},
                {"fatih@hotmail.com","454545"},
                {"arzu@senmail.com","676767"},
                {"mehmet@mynet.com","878987"}

        };
        return kullaniciDatalariArr;
    }

    @Test(dataProvider = "testDatalariGonder")
    public void CokluNegaticeLoginTesti(String email, String password) {
        //1. testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));

        // 2. Account linkine tiklayin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();

        // 3. Asagida verilen kullanici adi ve sifreleri ile giris yapilamadigini test edin
        testOtomasyonuPage.loginEmailkutusu
                .sendKeys(email);
        testOtomasyonuPage.loginPasswordkutusu
                .sendKeys(password);

        //giris yapilamadigini test edin
        //email kutusunun hala gorunur oldugunu test edin

        Assert.assertTrue(testOtomasyonuPage.loginEmailkutusu.isDisplayed());

        // 4. banu@gmail.com    898989
        // sedat@yahoo.com   989887
        // orkong@tmail.com  122334
        // fatih@hotmail.com 454545
        // arzu@senmail.com  676767
        // mehmet@mynet.com  878987

    }
}
