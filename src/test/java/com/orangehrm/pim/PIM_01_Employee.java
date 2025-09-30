package com.orangehrm.pim;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import orangehrmData.pim.EmployeeInfo;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGenerator;
import pageObjects.orangehrm.pim.employee.*;
import pageObjects.orangehrm.pim.employee.detailsTab.ContactDetailsPO;
import pageObjects.orangehrm.pim.employee.detailsTab.EmergencyContactsPO;
import pageObjects.orangehrm.pim.employee.detailsTab.EmployeePersonalDetailsPO;

@Feature("Employee Management")
public class PIM_01_Employee extends BaseTest {
    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);

        loginPage = PageGenerator.getLoginPage(driver);

        employeeInfo = EmployeeInfo.getEmployeeInfo();

        usernsame = "thangnguyen";
        password = "jBg0xOKLJJNdjnn^Ej";

        firstName = employeeInfo.getFirstName();
        middleName = employeeInfo.getMiddleName() + generateRandomNumber();
        lastName = employeeInfo.getLastName();

        avatarImageName = "Image02.png";

        editFirstName = "NEW";
        editMiddleName = "NEW";
        editLastName = "NEW";
        driverLicense = employeeInfo.getDriverLicense();
        licenseExpiryDate = employeeInfo.getLicenseExpiryDate();
        nationality = employeeInfo.getNationality();
        maritalStatus = employeeInfo.getMaritalStatus();
        dateOfBirth = employeeInfo.getDateOfBirth();

        loginPage.enterToUsernameTextbox(usernsame);
        loginPage.enterToPasswordTextbox(password);
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Description("Add a new Employee record")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void Employee_01_Add_New() {
        // Wait all loading is done
        employeeListPage = dashboardPage.clickToPIMButton();

        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addEmployeePage.enterToFirstNameTextbox(firstName);
        addEmployeePage.enterToMiddleNameTextbox(middleName);
        addEmployeePage.enterToLastNameTextbox(lastName);
        employeeId = addEmployeePage.getEmployeeId();

        personalDetailsPage = addEmployeePage.clickToSaveButtonAtEmployeeCreation();

        verifyEquals(personalDetailsPage.getPageTitle(), "Personal Details");

        // Wait for second Loading Icon After create
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        // Verify Data after created
        verifyEquals(personalDetailsPage.getFirstNameText(), firstName);
        verifyEquals(personalDetailsPage.getMiddleNameText(), middleName);
        verifyEquals(personalDetailsPage.getLastNameText(), lastName);
        verifyEquals(personalDetailsPage.getEmployeeId(), employeeId);
    }

    @Description("Upload Avatar for Employee record")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_02_Upload_Avatar() {
        personalDetailsPage.clickToEmployeeAvatarImage();

        // Get height/width of current avatar (Before Upload)
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();

        personalDetailsPage.loadAvatarImage(avatarImageName);

        personalDetailsPage.clickToSaveButtonAtChangeProfilePicture();

        // Verify Success Message showing
        personalDetailsPage.isSuccessMessageDisplayed(driver);

        // Verify system done loading
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        // Verify new avatar show up (Avatar Size Before Upload and After Upload)
        verifyFalse(personalDetailsPage.isProfileAvatarUpdatedSuccess(beforeUpload));
    }

    @Test
    public void Employee_03_Personal_Details() {
        personalDetailsPage.openPersonalDetailsTab();

        sleepInSeconds(2);
        personalDetailsPage.enterToFirstNameTextbox(editFirstName);
        personalDetailsPage.enterToMiddleNameTextbox(editMiddleName);
        personalDetailsPage.enterToLastNameTextbox(editLastName);
        personalDetailsPage.enterToDriverLicenseTextbox(driverLicense);
        personalDetailsPage.enterToLicenseExpiryDateTextbox(licenseExpiryDate);
        personalDetailsPage.selectToNationalityDropdown(nationality);
        personalDetailsPage.selectToMaritalStatusDropdown(maritalStatus);
        personalDetailsPage.enterToDateOfBirthTextbox(dateOfBirth);
        personalDetailsPage.selectGenderMaleRadioButton();

        personalDetailsPage.clickToSaveButtonAtPersonalDetailContainer();

        // Verify Success Message showing
        personalDetailsPage.isSuccessMessageDisplayed(driver);
        // Verify system done loading
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        // Verify Updated Data
        verifyEquals(personalDetailsPage.getFirstNameText(), firstName + editFirstName);
        verifyEquals(personalDetailsPage.getMiddleNameText(), middleName + editMiddleName);
        verifyEquals(personalDetailsPage.getLastNameText(), lastName + editLastName);
        verifyEquals(personalDetailsPage.getEmployeeId(), employeeId);

        verifyEquals(personalDetailsPage.getToDriverLicenseValue(), driverLicense);
        verifyEquals( personalDetailsPage.getToLicenseExpiryDateValue(), licenseExpiryDate);
        verifyEquals(personalDetailsPage.getToNationalitySelectedItem(), nationality);
        verifyEquals(personalDetailsPage.getToMaritalStatusSelectedItem(), maritalStatus);
        verifyEquals(personalDetailsPage.getToDateOfBirthValue(), dateOfBirth);
        verifyTrue(personalDetailsPage.isGenderMaleRadioSelected());
    }

//    @Test
//    public void Employee_04_Contact_Details() {
//
//    }

//    @Test
//    public void Employee_05_Emergency_Details() {
//
//    }

//    @Test
//    public void Employee_06_Assigned_Dependents() {
//
//    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private AddEmployeePO addEmployeePage;
    private EmployeeListPO employeeListPage;
    private EmployeePersonalDetailsPO personalDetailsPage;
    private EmergencyContactsPO emergencyContactsPage;
    private ContactDetailsPO contactDetailsPage;
    private EmployeeInfo employeeInfo;
    private String usernsame, password;
    private String firstName, middleName, lastName, employeeId;
    private String editFirstName, editMiddleName, editLastName, driverLicense, licenseExpiryDate, nationality, maritalStatus, dateOfBirth;
    private String avatarImageName;

}
