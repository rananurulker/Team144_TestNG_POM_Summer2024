package tests.day15_TestNG_Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebAppPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C06_SoftAssertion {
    @Test
    public void test01(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("webAppUrl"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        WebAppPage webAppPage=new WebAppPage();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(webAppPage.zeroBankLogo.isDisplayed(),"Zerobank logosu gorunmuyor");

        // 3. Sign in butonuna basin
        webAppPage.signinButonu
                .click();

        // 4. Login kutusuna “username” yazin
        webAppPage.loginKutusu.sendKeys(ConfigurationReader.getProperty("webAppGecerliUsername"));


        // 5. Password kutusuna “password” yazin
        webAppPage.passwordKutusu.sendKeys(ConfigurationReader.getProperty("webAppGecerliPassword"));

        // 6. Sign in tusuna basin
        webAppPage.submitButonu
                .click();
        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(webAppPage.girisYapilanKullanici.isDisplayed()
                ,"Sayfaya girisyapilamadi");


        // 9. Online banking menusunu tiklayin
        webAppPage.onlineBlakingButonu.click();

        //10. Pay Bills sayfasina gidin
        webAppPage.payBillLinki.click();

        //11. “Purchase Foreign Currency” tusuna basin
        webAppPage.foreignCurrencySekmesi.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(webAppPage.dropDown.isEnabled(),"PC Currency dropdown erisilemiyor");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select=new Select(webAppPage.dropDown);
        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedSecilenOption="Eurozone (euro)";
        String actualSecilenOption=select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSecilenOption,expectedSecilenOption,"dropdown secilen option Eurozone degil");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        int expectedOptionSayisi=16;
        int actualOptionSayisi= select.getOptions().size();

        softAssert.assertEquals(actualOptionSayisi,expectedOptionSayisi,"option sayisi esit degil");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        String expectedOptionsIcerik="Canada (dollar)";
        List<WebElement> optionsElementList=select.getOptions();
        List<String> optionsYaziList= ReusableMethods.getStringList(optionsElementList);

        softAssert.assertTrue(optionsYaziList.contains(expectedOptionsIcerik));

        //17. Sayfayi kapatin
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
