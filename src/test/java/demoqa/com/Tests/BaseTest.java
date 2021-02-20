package demoqa.com.Tests;

import demoqa.com.framework.Browser;
import demoqa.com.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    Browser browser = new Browser();
    public String chromeBrs = "chrome";
    public String geckoBrs = "gecko";
    public static final String url = "https://demoqa.com/";
    By elementsCard = By.xpath("//*[contains(@class, 'home-content')]/div[2]/div[1]/div");
    TextBox textBox;
    CheckBox checkBox;
    RadioButtons radioButtons;
    Buttons buttons;
    UploadsAndDownloads uploadsAndDownloads;
    PractiseForm practiseForm;
    AlertsAndWindows alertsAndWindows;
    DropDowns dropDowns;


    @BeforeMethod
    public void startUp(){
    driver = browser.setUp(this.chromeBrs);
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 20);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    textBox = new TextBox(driver, wait);
    checkBox = new CheckBox(driver, wait);
    radioButtons = new RadioButtons(driver, wait);
    buttons = new Buttons(driver,wait);
    uploadsAndDownloads = new UploadsAndDownloads(driver, wait);
    practiseForm = new PractiseForm(driver,wait);
    alertsAndWindows = new AlertsAndWindows(driver, wait);
    dropDowns = new DropDowns(driver, wait);


    driver.navigate().to(url);
    clickElementCard();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    private void clickElementCard(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementsCard)).click();

    }

}
