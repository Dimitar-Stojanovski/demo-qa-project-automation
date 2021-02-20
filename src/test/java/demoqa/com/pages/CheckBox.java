package demoqa.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBox {
    WebDriver driver;
    WebDriverWait wait;

    By checkBoxMenu = By.xpath("//*[@id=\"item-1\"]");
    By home = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label");
    By homeDropButton = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button");
    By desktopDropButton = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button");
    By desktop = By.xpath("//*[@id='tree-node']/ol/li/ol/li/ol/li");


    public CheckBox(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }

    public void clickCheckBoxMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxMenu)).click();

    }

    public void selectHome(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(home)).click();
    }

    public void selectHomeDropButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeDropButton)).click();
    }

    public void selectDesktopDropButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(desktopDropButton)).click();
    }

    public void selectDesktop(int index){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(desktop)).get(index).click();

    }
}


