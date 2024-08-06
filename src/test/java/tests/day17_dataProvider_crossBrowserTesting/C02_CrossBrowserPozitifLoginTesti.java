package tests.day17_dataProvider_crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.TestBaseCross;

public class C02_CrossBrowserPozitifLoginTesti extends TestBaseCross {
    @Test
    public void pozitifLoginTesti(){
        //testotomasyonu anasayfaya gidin
        driver.get(ConfigurationReader.getProperty("toUrl"));
        // Account linkine basin
        driver.findElement(By.xpath("(//*[text()='Account'])[1])")).click();

        // email olarak gecerliEmail
        driver.findElement(By.id("email"))
                .sendKeys(ConfigurationReader.getProperty("toGecerliEmail"));
        // password olarak gecerliPassword degerlerini girin
        driver.findElement(By.id("password"))
                .sendKeys(ConfigurationReader.getProperty("toGecerliPassword"));

        // signIn butonuna basarak sisteme giris yapin
        driver.findElement(By.id("submitlogin")).click();

        // sisteme giris yapabildiginizi test edin
        WebElement logoutButonu=driver.findElement(By.xpath("(//*[text()='Logout'])[2]"));


    }
}
