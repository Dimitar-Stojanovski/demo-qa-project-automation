package demoqa.com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class AlertsAndWindows {
    WebDriver driver;
    WebDriverWait wait;

    By alertsMenuTab = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/span/div/div[1]");
    By alertsMenuList = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li");
    By newTab = By.xpath("//*[@id=\"tabButton\"]");
    By getPageTitle = By.xpath("//*[@id=\"sampleHeading\"]");
    By newWindow = By.xpath("//*[@id=\"windowButton\"]");
    By newWindowMessage = By.xpath("//*[@id=\"messageWindowButton\"]");
    By getNewWindowMessageTitle = By.xpath("/html/body/text()");
    By alertBtn = By.xpath("//*[@id=\"alertButton\"]");
    By timeAlert = By.xpath("//*[@id=\"timerAlertButton\"]");
    By confirmAlert = By.xpath("//*[@id=\"confirmButton\"]");
    By promptAlert = By.xpath("//*[@id=\"promtButton\"]");

    public AlertsAndWindows(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }

    public void clickAlertMenu(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(alertsMenuTab)).click();
    }

    public void selectAlertMenuList(int index){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(alertsMenuList)).get(index).click();

    }

    public void switchNewTab(){
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String child: allWindowHandles){
            if (!parentWindow.equalsIgnoreCase(child)){
                driver.switchTo().window(child);
                WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(getPageTitle));
                Assert.assertEquals(pageTitle.getText(), "This is a sample page");
                driver.switchTo().window(parentWindow);
            }
        }
    }

    public void clickNewTabButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(newTab))).click().perform();

    }

    public void clickNewWindowButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(newWindow)).click();
    }

    public void switchToNewWindowTab(){
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String childWindow:allWindows){
            if (!parentWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(getPageTitle));
                Assert.assertEquals(pageTitle.getText(), "This is a sample page");
                driver.switchTo().window(parentWindow);
            }
        }

    }

    public void clickNewWindowMessageBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(newWindowMessage)).click();
    }

    public void switchToNewWindowsMessage(){
        String parent = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String child: allWindows){
            if (!parent.equalsIgnoreCase(child)){
                driver.switchTo().window(child);
                driver.switchTo().window(parent);
            }
        }
    }

    //This is the alerts menu

    public void clickAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertBtn)).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickTimeAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(timeAlert)).click();
       wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickConfrimAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmAlert)).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void clickPromptAlert(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(promptAlert)).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();
    }
















    private void sleep(long m){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
