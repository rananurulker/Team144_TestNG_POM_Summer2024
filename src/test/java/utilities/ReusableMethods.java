package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getStringList(List<WebElement> kaynakList) {

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement : kaynakList
        ) {

            stringList.add(eachElement.getText());

        }


        return stringList;
    }

    public static void SwitchWindowbyURL(WebDriver driver, String hedefURl) {
        Set<String> acikWindowlarinWHDSeti = driver.getWindowHandles();
        for (String eachWHD : acikWindowlarinWHDSeti) {
            //once eachWHD nin getirdigi WHD ile bir windowa gecis yapalim
            driver.switchTo().window(eachWHD);
            String gecilenSyafaURL = driver.getCurrentUrl();

            if (gecilenSyafaURL.equals(hedefURl)) {
                break;
            }

        }
    }

    public static void SwitchWindowByTitle(WebDriver driver, String hedefTitle) {
        Set<String> acikWindowlarinWHDSeti = driver.getWindowHandles();
        for (String eachWHD : acikWindowlarinWHDSeti) {
            //once eachWHD nin getirdigi WHD ile bir windowa gecis yapalim
            driver.switchTo().window(eachWHD);
            String gecilenSyafaTitle = driver.getCurrentUrl();

            if (gecilenSyafaTitle.equals(hedefTitle)) {
                break;
            }


        }

    }
    public static void getFullScreenshot(WebDriver driver, String ScreenshotIsmi){
        // 1.adim screenshot objesi olusturmak ve deger olarak driver'imizi atamak
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2.adim screenshot'i kaydedecegimiz File'i olusturun
        File tumSayfaSS = new File("target/ekranGoruntuleri/"+ScreenshotIsmi+".png");
        // 3.adim screenshot'i alip gecici bir dosyaya kopyalayalim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        // 4.adim gecici dosyayi, asil kaydetmek istedigimiz dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getFullScreenshot(WebDriver driver){
        //dosya isimlerine tarih etiketi ekleyelim
        //....240829114023 gibi bir etiket eklemek dosya ismini benzersiz yapar

        LocalDateTime zaman=LocalDateTime.now();//2024.08.29T12:42:23
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi= zaman.format(dateTimeFormatter);//240829114023

        // 1.adim screenshot objesi olusturmak ve deger olarak driver'imizi atamak
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2.adim screenshot'i kaydedecegimiz File'i olusturun
        File tumSayfaSS = new File("target/ekranGoruntuleri/TumSayfaSS"+tarihEtiketi+".png");
        // 3.adim screenshot'i alip gecici bir dosyaya kopyalayalim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        // 4.adim gecici dosyayi, asil kaydetmek istedigimiz dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void getWebelementScreenshot(WebElement istenenWebElement){
        //tarih etiketi olusturalim

        LocalDateTime zaman=LocalDateTime.now();//2024.08.29T12:42:23
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi= zaman.format(dateTimeFormatter);//240829114023


        //1.adim webelementi locate et

        //2.adim kaydedeceginiz doyayi olusturun
        File webElementSS=new File("target/ekrangoruntuleri/webElementSS_"+tarihEtiketi+".png");

        //3.adim webelementi kullanarak ss  alip gecici dosya olarak kaydedin
        File geciciDosya=istenenWebElement.getScreenshotAs(OutputType.FILE);

        //4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,webElementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void getWebelementScreenshot(WebElement istenenWebElement, String reimIsmi){
        //tarih etiketi olusturalim

        LocalDateTime zaman=LocalDateTime.now();//2024.08.29T12:42:23
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi= zaman.format(dateTimeFormatter);//240829114023


        //1.adim webelementi locate et

        //2.adim kaydedeceginiz doyayi olusturun
        File webElementSS=new File("target/ekrangoruntuleri/"+reimIsmi+"_"+tarihEtiketi+".png");

        //3.adim webelementi kullanarak ss  alip gecici dosya olarak kaydedin
        File geciciDosya=istenenWebElement.getScreenshotAs(OutputType.FILE);

        //4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,webElementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }
