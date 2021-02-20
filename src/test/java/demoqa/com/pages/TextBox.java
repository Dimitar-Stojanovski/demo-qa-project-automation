package demoqa.com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBox {
    WebDriverWait wait;
    WebDriver driver;

    By TextBoxmenuList = By.xpath("//*[@id=\"item-0\"]");
    By fullName = By.xpath("//*[@id=\"userName\"]");
    By email = By.xpath("//*[@id=\"userEmail\"]");
    By currentAddress = By.xpath("//*[@id=\"currentAddress\"]");
    By permanentAddress = By.xpath("//*[@id=\"permanentAddress\"]");
    By submitButton = By.xpath("//*[@id=\"submit\"]");
    By getFullName = By.xpath("//*[@id=\"name\"]");
    By getEmail = By.xpath("//*[@id=\"email\"]");
    By getCurrentAddress = By.xpath("//*[@id=\"output\"]/div/p[3]");
    By getPermanentAddress = By.xpath("//*[@id=\"output\"]/div/p[4]");

    public TextBox(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }

    public void clickTextBoxMenu(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(TextBoxmenuList)).click();


    }

    public void enterFullName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullName)).sendKeys(name);

    }

    public void enterEmail(String mail){
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(mail);

    }

    public void enterCurrentAddress(String address){
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentAddress)).sendKeys(address);

    }

    public void enterPermanentAddress(String address){
        wait.until(ExpectedConditions.visibilityOfElementLocated(permanentAddress)).sendKeys(address);

    }

    public void clickSubmit(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
    }

    public void scrollToTheVerifications(){
        WebElement nameVerify = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", nameVerify);

    }

    public String getFullName(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getFullName)).getText();
    }

    public String getEmail(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getEmail)).getText();
    }

    public String getCurrentAddress(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getCurrentAddress)).getText();
    }

    public String getPerrmanentAddress(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getPermanentAddress)).getText();
    }









}
