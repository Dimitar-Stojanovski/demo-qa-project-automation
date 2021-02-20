package demoqa.com.Tests;

import demoqa.com.pages.DropDowns;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    @DataProvider(name = "Personal info")
    public Object[][] infodata() {
        return new Object[][]{
                {"John", "Doe", "john.doe@gmail.com", 0, "1234567890", "29 Jun 1991", "Subject 1", 0, "Random Address num 1", "NCR", "Delhi"},
                {"Zoey", "Barnes", "zoey.barnes@yahoo.com", 1, "1122334455", "18 Aug 1991 ", "Subject 2", 1, "Random Address num 2", "Haryana", "Karnal"},
                {"Edward", "Jones", "edward.jones@hotmail.com", 2, "1112223334", "07 Jul 1991 ", "Subject 3", 2, "Random Address num 3", "Rajasthan", "Jaipur"}
        };
    }


    @Test
    public void TextBoxMenu() {

        textBox.clickTextBoxMenu();
        textBox.enterFullName("John Doe");
        textBox.enterEmail("john.doe@gmail.com");
        textBox.enterCurrentAddress("Address 1");
        textBox.enterPermanentAddress("Address 2");
        sleep(1000);
        textBox.clickSubmit();
        textBox.scrollToTheVerifications();

        //Assertions
        Assert.assertEquals(textBox.getFullName(), "Name:John Doe");
        Assert.assertEquals(textBox.getEmail(), "Email:john.doe@gmail.com");
        Assert.assertEquals(textBox.getCurrentAddress(), "Current Address :Address 1");
        Assert.assertEquals(textBox.getPerrmanentAddress(), "Permananet Address :Address 2");


        sleep(1000);
    }

    @Test
    public void CheckBoxTests() {
        checkBox.clickCheckBoxMenu();
        //checkBox.selectHome();
        checkBox.selectHomeDropButton();
        checkBox.selectDesktopDropButton();
        checkBox.selectDesktop(1);

        sleep(1000);


    }


    @Test
    public void radioButtonsTest() {
        radioButtons.clickRadioButtonMenu();
        radioButtons.clickRadioButton(2);
        Assert.assertEquals(radioButtons.getResult(), "You have selected Impressive");
        sleep(2000);


    }


    @Test
    public void buttonsTest() {
        buttons.selectButtonMenu();
        buttons.clickDoubleClickButton();
        buttons.clickRightClick();
        buttons.singleClick();

        Assert.assertEquals(buttons.getdoubleClickMessage(), "You have done a double click");
        Assert.assertEquals(buttons.getRihtClickMessage(), "You have done a right click");
        Assert.assertEquals(buttons.getSingleClickMessage(), "You have done a dynamic click");


    }


    @Test
    public void uploadsAndDownLoads() {
        uploadsAndDownloads.clickUploadMenu();
        uploadsAndDownloads.clickUpload("C:\\Users\\Dimitar\\Desktop\\GithubPic.jpg");
        uploadsAndDownloads.clickDownload();
        sleep(2000);

    }

    public String[] genderVerification = {"Male", "Female", "Other"};
    public String[] hobbiesVerification = {"Sports", "Reading", "Music"};

    @Test(dataProvider = "Personal info")
    public void practiseForm(String name, String lastName, String email, int gender, String number, String date,
                             String subject, int hobbies, String address, String state, String city) {
        practiseForm.clickFormsMenu();
        sleep(1000);
        practiseForm.clickPractiseForm();
        practiseForm.enterFirstName(name);
        practiseForm.enterLastName(lastName);
        practiseForm.enterEmail(email);
        practiseForm.selectGender(gender);
        practiseForm.enterMobileNumber(number);
        practiseForm.enterDate(date);
        practiseForm.enterSubject(subject);
        practiseForm.selectHobbie(hobbies);
        practiseForm.enterCurrentAddress(address);
        practiseForm.selectState(state);
        practiseForm.selectCity(city);
        practiseForm.clickSubmit();
        Assert.assertEquals(practiseForm.getName(), name + ' ' + lastName);
        Assert.assertEquals(practiseForm.getMail(), email);
        Assert.assertEquals(practiseForm.getGender(), genderVerification[gender]);
        Assert.assertEquals(practiseForm.getMobileNumber(), number);
        Assert.assertEquals(practiseForm.getHobbies(), hobbiesVerification[hobbies]);
        Assert.assertEquals(practiseForm.getAddress(), address);
        Assert.assertEquals(practiseForm.getStateCity(), state + ' ' + city);


        sleep(1000);

    }


    @Test
    public void testAlertsAndWindows() {
        alertsAndWindows.clickAlertMenu();
        alertsAndWindows.selectAlertMenuList(0);
        alertsAndWindows.clickNewTabButton();
        sleep(1000);
        alertsAndWindows.switchNewTab();
        sleep(1000);
        alertsAndWindows.clickNewWindowButton();

        alertsAndWindows.switchToNewWindowTab();
        alertsAndWindows.clickNewWindowMessageBtn();
        alertsAndWindows.switchToNewWindowsMessage();
        sleep(1000);
        alertsAndWindows.selectAlertMenuList(1);
        alertsAndWindows.clickAlert();
        alertsAndWindows.clickTimeAlert();
        alertsAndWindows.clickConfrimAlert();
        alertsAndWindows.clickPromptAlert("John Doe");
        sleep(2000);
    }


    @Test
    public void testWidgets(){
        dropDowns.clickWidgetMenu();
        dropDowns.clickWidgetDropdown(8);
        dropDowns.enterSelectValueDropdown("Group 2, option 1");
        dropDowns.enterSingleValueDropDown("Other");
        dropDowns.enterOldSyleSelectMenu("1", 3, "White");
        
        sleep(2000);
    }


    private void sleep(long m) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
