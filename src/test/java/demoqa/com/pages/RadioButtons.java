package demoqa.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtons {
    WebDriverWait wait;
    WebDriver driver;

    By radioButtomMenu = By.xpath("//*[@id=\"item-2\"]");
    By radioButtons = By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div[1]/div");
    By getText =By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/p");


    public RadioButtons(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }

    public void clickRadioButtonMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(radioButtomMenu)).click();
    }

    public void clickRadioButton(int index){

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(radioButtons)).get(index).click();

    }

    public String getResult(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getText)).getText();
    }





}
