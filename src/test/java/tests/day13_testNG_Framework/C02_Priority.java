package tests.day13_testNG_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {
    /*
    1- TestNG test methodlari oncelik belirtmez isek harf sirasina uygun olarak calistirir.
    2- Eger test methodlarinin calismasini isim sirasi disindaki bir sirayla yapmak istersek
     methodlara kucukten buyuge dogru priority verebiliriz
     3-priorty degeri belirtmezsek degeri 0 gelir
     4-priorty degeri ayni olursa harf onceligine gore calistirir
     5-hangisi en kucukse once onu calistirir
     */
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    //3 farkli test methodu olusturup asagidaki testleri yapin

    //1-testotomasyonu anasayfaya gidip, logo gorundugunu test edin
    //2-wisequarter.com anasayfaya gidip, title in wise icerdigini test edin
    //3- youtube ana sayfaya gidip, url in youtube icerdigini test edin
    @Test (priority = 1)
    public void testOtomasyonuTesti(){
        driver.get("https://www.testotomasyonu.com");

        WebElement logoElementi= driver.findElement(By.xpath("(//*[@alt='Logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
    @Test(priority = 2)
    public void wiseQuarterTest(){
        driver.get("https://www.wisequarter.com");
        String expectedTitleIcerik="Wise";
        String actualTitleIcerik=driver.getTitle();

        Assert.assertTrue(actualTitleIcerik.contains(expectedTitleIcerik));
    }

    @Test(priority = 3)
    public void youtubeAnasayfaURL(){
        driver.get("https://www.youtube.com");
        String expectedUrl="youtube";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

}
