package demoqa.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadsAndDownloads {
    WebDriver driver;
    WebDriverWait wait;

    By uploadAndDownloadMenu = By.xpath("//*[@id=\"item-7\"]");
    By uppload = By.xpath("//*[@id=\"uploadFile\"]");
    By download = By.xpath("//*[@id=\"downloadButton\"]");

    public UploadsAndDownloads(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickUploadMenu(){

       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,250)");
       wait.until(ExpectedConditions.visibilityOfElementLocated(uploadAndDownloadMenu)).click();
    }

    public void clickUpload(String fileDirectory){
        wait.until(ExpectedConditions.visibilityOfElementLocated(uppload)).sendKeys(fileDirectory);

    }

    public void clickDownload(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(download)).click();
    }

}
