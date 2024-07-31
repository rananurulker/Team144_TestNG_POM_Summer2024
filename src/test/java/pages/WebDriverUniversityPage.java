package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebDriverUniversityPage {
    public WebDriverUniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
@FindBy(xpath = "//*[text()='LOGIN PORTAL']")
    public WebElement loginButonu;

    @FindBy(id = "text")
    public WebElement userNameKutusu;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id = "login-button")
    public WebElement loginKutusu;

}
