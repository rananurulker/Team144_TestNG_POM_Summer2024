package tests.day16_HTMLReportsDataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C05_DataProvider {
    @DataProvider
    public static Object[][] kelimeleriGonderenDataProvider() {
        String[][] aranacakKelimelerArrayi = {{"java"}, {"phone"}, {"apple"}, {"samsung"}, {"nutella"}, {"cokoprens"}, {"dress"}};
        return new Object[][]{};
    }
    //testNgnin bize bir alternatif olarak sundugu data provider
    //test edecegimiz kelimeleri disaridan teker tekere bize yllar

    //1- dataproviderin gonderdigi kelimeleri test methodunda kullanmak icin bir parametre olusturalim
    //parametre ile gelen tek bir kelimeyi aratacak sekilde testimizi yazalim

    //2-@test notasyonu oldugu satira data provider=kelimeleriGonderenDataProvider yaziyoruz

    //3-uzerine yaklastigimizda bize bir obje olusturmasini sagliyoruz

    //4- data providerin bize gonderecegi datalari
    //iki katli bir array olarak hazirliyoruz.

    @Test(dataProvider = "kelimeleriGonderenDataProvider")
    public void dataProviderIleCokluAramaTesti(String aranacakKelime){
        //testotomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("toUrl"));
        //arama kutusuna parametre olarak gelen aranacak kelimeyi yazip aratin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);

        String unexpectedSonucYazisi="0 Products Found";
        String actualSonucYazisi= testOtomasyonuPage.aramaSonucuElementi.getText();
        Assert.assertNotEquals(actualSonucYazisi,unexpectedSonucYazisi);
        Driver.quitDriver();

    }
}
