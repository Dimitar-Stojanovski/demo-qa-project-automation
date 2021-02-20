package demoqa.com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PractiseForm {
    WebDriver driver;
    WebDriverWait wait;

    By formsMenu = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/span/div");
    By practiseForm = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/div/ul");
    By firstName = By.xpath("//*[@id=\"firstName\"]");
    By last_name = By.xpath("//*[@id=\"lastName\"]");
    By e_mail = By.xpath("//*[@id=\"userEmail\"]");
    By gender = By.xpath("//*[@id='genterWrapper']/div[2]/div");
    By mobile = By.xpath("//*[@id=\"userNumber\"]");
    By dateOfBirth = By.xpath("//*[@id=\"dateOfBirthInput\"]");
    By subject_placeholder = By.xpath("//*[@id=\"subjectsInput\"]");
    By hobbies = By.xpath("//*[@id='hobbiesWrapper']/div[2]/div");
    By currentAddress = By.xpath("//*[@id=\"currentAddress\"]");
    By stateLocator = By.xpath("//*[@id=\"react-select-3-input\"]");
    By cityLocator = By.xpath("//*[@id=\"react-select-4-input\"]");
    By submitButton = By.xpath("//*[@id=\"submit\"]");
    By getFirstName = By.xpath("//*[contains(@class, 'modal-content')]/div[2]/div/table/tbody/tr/td[2]");
    By getE_mail = By.xpath("//*[contains(@class, 'modal-content')]/div[2]/div/table/tbody/tr[2]/td[2]");
    By getGender = By.xpath("//*[contains(@class, 'modal-content')]/div[2]/div/table/tbody/tr[3]/td[2]");
    By getNumber = By.xpath("//*[contains(@class, 'modal-content')]/div[2]/div/table/tbody/tr[4]/td[2]");
    By getHobbies = By.xpath("//*[contains(@class, 'modal-content')]/div[2]/div/table/tbody/tr[7]/td[2]");
    By getCurrentAddress = By.xpath("//*[contains(@class, 'modal-content')]/div[2]/div/table/tbody/tr[9]/td[2]");
    By getStateAndCity = By.xpath("//*[contains(@class, 'modal-content')]/div[2]/div/table/tbody/tr[10]/td[2]");
    public PractiseForm(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }

    public void clickFormsMenu(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(formsMenu)).click();
    }

    public void clickPractiseForm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(practiseForm)).click();
    }

    public void enterFirstName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(name);

    }

    public void enterLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(last_name)).sendKeys(lastName);

    }

    public void enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(e_mail)).sendKeys(email);

    }

    public void selectGender(int index){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(gender)).get(index).click();

    }

    public void enterMobileNumber(String number){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobile)).sendKeys(number);

    }

    public void enterDate(String date){

        wait.until(ExpectedConditions.visibilityOfElementLocated(dateOfBirth)).sendKeys(date);
        sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateOfBirth)).sendKeys(Keys.ENTER);


    }

    public void enterSubject(String subject){
        wait.until(ExpectedConditions.visibilityOfElementLocated(subject_placeholder)).sendKeys(subject);

    }

    public void selectHobbie(int index){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(hobbies)).get(index).click();

    }

    public void enterCurrentAddress(String address){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentAddress)).sendKeys(address);
    }

    public void selectState(String state){
        wait.until(ExpectedConditions.visibilityOfElementLocated(stateLocator)).sendKeys(state);
        sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(stateLocator)).sendKeys(Keys.ENTER);
    }

    public void selectCity(String city){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityLocator)).sendKeys(city);
        sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityLocator)).sendKeys(Keys.ENTER);
    }

    public void clickSubmit(){
        Actions actions = new Actions(driver);
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton))).click().perform();
    }

    public String getName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstName)).getText();
    }

    public String getMail(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(getE_mail)).getText();
    }

    public String getGender(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getGender)).getText();
    }

    public String getMobileNumber(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getNumber)).getText();
    }

    public String getHobbies(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getHobbies)).getText();
    }

    public String getAddress(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getCurrentAddress)).getText();
    }

    public String getStateCity(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getStateAndCity)).getText();
    }







    private void sleep(long m){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
