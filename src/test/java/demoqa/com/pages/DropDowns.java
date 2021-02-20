package demoqa.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDowns {
    WebDriver driver;
    WebDriverWait wait;

    By widgets = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]/span/div");
    By widgetList = By.xpath("//div[@class = 'element-list collapse show']/ul/li");
    By selectValueDropdown = By.xpath("//*[@id=\"react-select-2-input\"]");
    By selectOneDropdown = By.xpath("//*[@id=\"react-select-3-input\"]");
    By selectOldStyleDropDown = By.xpath("//*[@id=\"oldSelectMenu\"]");


    public DropDowns(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }


    public void clickWidgetMenu(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(widgets)).click();
    }

    public void clickWidgetDropdown(int index){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(widgetList)).get(index).click();

    }

    public void enterSelectValueDropdown(String option){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectValueDropdown)).sendKeys(option);
        sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectValueDropdown)).sendKeys(Keys.ENTER);

    }

    public void enterSingleValueDropDown(String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectOneDropdown)).sendKeys(value);
        sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectOneDropdown)).sendKeys(Keys.ENTER);
    }

    public void enterOldSyleSelectMenu(String value, int index, String text){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(selectOldStyleDropDown)));
        select.selectByValue(value);
        sleep(1000);
        select.selectByIndex(index);
        select.selectByVisibleText(text);

    }










    private void sleep(long m){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


