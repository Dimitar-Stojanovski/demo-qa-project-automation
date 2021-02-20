package demoqa.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buttons {
    WebDriverWait wait;
    WebDriver driver;

    By buttonMenu = By.xpath("//*[@id=\"item-4\"]");
    By doubleClick = By.xpath("//*[@id=\"doubleClickBtn\"]");
    By getDoubleClickMessage = By.xpath("//*[@id=\"doubleClickMessage\"]");
    By rightClick = By.xpath("//*[@id=\"rightClickBtn\"]");
    By click = By.xpath("//*[contains(@class, 'col-12 mt-4 col-md-6')]/div/div[3]/button");
    By getRightClickMessage = By.xpath("//*[@id=\"rightClickMessage\"]");
    By getSingleClickMessage = By.xpath("//*[@id=\"dynamicClickMessage\"]");

    public Buttons(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }

    public void selectButtonMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonMenu)).click();
    }


    public void clickDoubleClickButton(){
        Actions action = new Actions(driver);
        WebElement doubleClickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(doubleClick));
        action.moveToElement(doubleClickBtn).doubleClick().perform();

    }

    public String getdoubleClickMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getDoubleClickMessage)).getText();
    }

    public void clickRightClick(){
        Actions action = new Actions(driver);
        WebElement rightClickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(rightClick));
        action.moveToElement(rightClickBtn).contextClick().perform();
    }

    public void singleClick(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(click)).click();
    }

    public String getRihtClickMessage(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(getRightClickMessage)).getText();
    }

    public String getSingleClickMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getSingleClickMessage)).getText();
    }


}
