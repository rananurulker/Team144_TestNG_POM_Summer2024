package tests.day13_testNG_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class C03_DependsOnMethod {
    /*
    Eger test methodlari birbine bagli ise
    yani islerm basarili olmadiginda sonraki methodlarin calismasina gerek kalmiyorsa
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
    //3 farkli test methodu olusturup asagidaki gorevleri yapin
    //1-testotomasyonu ana sayfaya gidin urlin testotomasyonu icerdigini test edin
    //2-phone icin arama yapip, arama sonucunda urun bulunabildigini test edin
    //3-ilk urunu tiklayip acilan urun sayfasindaki isimde case sensitive olmadan phone bulundugunu test edin

    @Test
    public void anaSayfaTesti(){
        driver.get("https://www.testotomasyonu.com");
        String expectedUrl="testotomasyonu";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test(dependsOnMethods ="anaSayfaTesti")
    public void phoneArama(){
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        String unexpectedSonucYazisi="0 Products Found";
        String actualSonucYazisi=driver.findElement(By.className("product-count-text")).getText();

        Assert.assertNotEquals(actualSonucYazisi,unexpectedSonucYazisi);
    }
    @Test(priority = 5, dependsOnMethods = "phoneArama")
    public void ilkUrunIsimTest(){
        //3-ilk urunu tiklayip acilan urun sayfasindaki isimde
        // case sensitive olmadan phone bulundugunu test edin
        driver.findElement(By.xpath("(//*[@class='mx-2 mb-3 mt-4'])[1]")).click();
        String expectedIsimIcerik="phone";
        String urunBilgiDetayi=driver.findElement(By.className("prod-detail"))
                .getText()
                .toLowerCase(Locale.ROOT);
        Assert.assertTrue(urunBilgiDetayi.contains(expectedIsimIcerik));




    }
}
