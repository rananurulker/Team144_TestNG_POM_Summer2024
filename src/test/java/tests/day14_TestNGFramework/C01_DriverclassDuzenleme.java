package tests.day14_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverclassDuzenleme {
    @Test(groups = {"regression", "E2E 1"})

    public void test01(){
        /*
        Driver klasina bir duzeltme yapmamiz gerekiyor
         */
        //testotomasyonu sayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        //urlnin testotomasyonu test edin

        String expectedURL="testotomasyonu";
        String actualURL=Driver.getDriver().getCurrentUrl();
        String actualtitle=Driver.getDriver().getTitle();

        Assert.assertTrue(actualURL.contains(expectedURL));

        //windowu kapatin
        Driver.quitDriver();
    }
}
