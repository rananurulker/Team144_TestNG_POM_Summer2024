package tests.day14_TestNGFramework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ToFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.channels.SeekableByteChannel;

public class C05_formDoldurma {
    @Test
    public void formDoldurma(){
        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");


        //2- Sirt Agrisi ve Carpinti checkbox’larini secin
        ToFormPage toFormPage = new ToFormPage();

        //eger webelementler sayfada goruhmuyorsa scrool yapmamiz gerek
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",toFormPage.sirtAgrisiCheckboxElementi);
        toFormPage.sirtAgrisiCheckboxElementi.click();
        toFormPage.carpintiCheckboxElementi.click();

        //3- Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assert.assertTrue(toFormPage.carpintiCheckboxElementi.isSelected());
        Assert.assertTrue(toFormPage.sirtAgrisiCheckboxElementi.isSelected());

        //4- Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",toFormPage.sekerCheckboxElementi);
        ReusableMethods.bekle(1);
        Assert.assertFalse(toFormPage.sekerCheckboxElementi.isSelected());
        Assert.assertFalse(toFormPage.epilepsiCheckboxElementi.isSelected());


        //5- sayfayi kapatin
        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}
