package pageObjects.orangehrm.pim.employee.detailsTab;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.pim.employee.detailsTabs.EmployeePersonalDetailsPUI;

public class EmployeePersonalDetailsPO extends EmployeeDetailsTabs {
    private WebDriver driver;

    public EmployeePersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Get page title of the Employee Detail")
    public String getPageTitle() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.PAGE_TITLE);
        return getElementText(driver, EmployeePersonalDetailsPUI.PAGE_TITLE);
    }

    @Step("Get value of the First Name textbox")
    public String getFirstNameText() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.FIRST_NAME_TEXTBOX);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.FIRST_NAME_TEXTBOX, "value");
    }

    @Step("Get value of the Middle Name textbox")
    public String getMiddleNameText() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.MIDDLE_NAME_TEXTBOX);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.MIDDLE_NAME_TEXTBOX, "value");
    }

    @Step("Get value of the Last Name textbox")
    public String getLastNameText() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.LAST_NAME_TEXTBOX);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.LAST_NAME_TEXTBOX, "value");
    }

    @Step("Get value of the Emplopyee ID textbox")
    public String getEmployeeId() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    @Step("Get value of the Driver's License Number textbox")
    public String getToDriverLicenseValue() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    @Step("Get value of the License Expiry Date textbox")
    public String getToLicenseExpiryDateValue() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.LICENSE_EXPIRY_DATE_INPUT);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.LICENSE_EXPIRY_DATE_INPUT, "value");
    }

    @Step("Get value of the Nationality dropdown")
    public String getToNationalitySelectedItem() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.NATIONALITY_FIELD);
        return getElementText(driver, EmployeePersonalDetailsPUI.NATIONALITY_FIELD);
    }

    @Step("Get value of the Marital Status dropdown")
    public String getToMaritalStatusSelectedItem() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.MARITAL_STATUS_FIELD);
        return getElementText(driver, EmployeePersonalDetailsPUI.MARITAL_STATUS_FIELD);
    }

    @Step("Get value of the Date Of Birth textbox")
    public String getToDateOfBirthValue() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.DATE_OF_BIRTH_INPUT);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.DATE_OF_BIRTH_INPUT, "value");
    }

    @Step("Verify Male Gender is selected")
    public boolean isGenderMaleRadioSelected() {
        waitForElementPresence(driver, EmployeePersonalDetailsPUI.GENDER_MALE_SELECTED);
        return isElementSelected(driver, EmployeePersonalDetailsPUI.GENDER_MALE_SELECTED);
    }

    @Step("Enter to First Name textbox with value: {0}")
    public void enterToFirstNameTextbox(String value) {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, EmployeePersonalDetailsPUI.FIRST_NAME_TEXTBOX, value);
    }

    @Step("Enter to Middle Name textbox with value: {0}")
    public void enterToMiddleNameTextbox(String value) {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.MIDDLE_NAME_TEXTBOX);
        sendkeyToElement(driver, EmployeePersonalDetailsPUI.MIDDLE_NAME_TEXTBOX, value);
    }

    @Step("Enter to Last Name textbox with value: {0}")
    public void enterToLastNameTextbox(String value) {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, EmployeePersonalDetailsPUI.LAST_NAME_TEXTBOX, value);
    }

    @Step("Enter to Driver License textbox with value: {0}")
    public void enterToDriverLicenseTextbox(String value) {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        sendkeyToElement(driver, EmployeePersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, value);
    }

    @Step("Select License Expiry Date with value: {0}")
    public void enterToLicenseExpiryDateTextbox(String value) {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.LICENSE_EXPIRY_DATE_INPUT);
        sendkeyToElement(driver, EmployeePersonalDetailsPUI.LICENSE_EXPIRY_DATE_INPUT, value);
    }

    @Step("Select Nationality with value: {0}")
    public void selectToNationalityDropdown(String nationName) {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.NATIONALITY_FIELD);
        selectItemInCustomDropdown(driver, EmployeePersonalDetailsPUI.NATIONALITY_FIELD,
                EmployeePersonalDetailsPUI.NATIONALITY_ITEMS,
                nationName);
    }

    @Step("Select Marital Status with value: {0}")
    public void selectToMaritalStatusDropdown(String maritalStatus) {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.MARITAL_STATUS_FIELD);
        selectItemInCustomDropdown(driver, EmployeePersonalDetailsPUI.MARITAL_STATUS_FIELD,
                EmployeePersonalDetailsPUI.MARITAL_STATUS_ITEMS,
                maritalStatus);
    }

    @Step("Select Date Of Birth with value: {0}")
    public void enterToDateOfBirthTextbox(String value) {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.DATE_OF_BIRTH_INPUT);
        sendkeyToElement(driver, EmployeePersonalDetailsPUI.DATE_OF_BIRTH_INPUT, value);
    }

    @Step("Select Gender Male Radio Button")
    public void selectGenderMaleRadioButton() {
        waitForElementClickable(driver, EmployeePersonalDetailsPUI.MALE_RADIO_BUTTON);
        clickToElement(driver, EmployeePersonalDetailsPUI.MALE_RADIO_BUTTON);
    }

    @Step("Click to Save Button at  Personal Detail tab")
    public void clickToSaveButtonAtPersonalDetailContainer() {
        waitForElementClickable(driver, EmployeePersonalDetailsPUI.SAVE_BUTTON_AT_PERSONAL_DETAILS_CONTAINER);
        clickToElement(driver, EmployeePersonalDetailsPUI.SAVE_BUTTON_AT_PERSONAL_DETAILS_CONTAINER);
    }

    // Handle Avatar
    @Step("Click to Employee Avatar Image")
    public void clickToEmployeeAvatarImage() {
        waitForElementClickable(driver, EmployeePersonalDetailsPUI.EMPLOYEE_PROFILE_IMAGE);
        clickToElement(driver, EmployeePersonalDetailsPUI.EMPLOYEE_PROFILE_IMAGE);
    }

    @Step("Upload new Avatar Image with filename: {0}")
    public void loadAvatarImage(String filename) {
        uploadMultipleFiles(driver, filename);
    }

    @Step("Click Save button to save new Avatar")
    public void clickToSaveButtonAtChangeProfilePicture() {
        waitForElementClickable(driver, EmployeePersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_PICTURE_CONTAINER);
        clickToElement(driver, EmployeePersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_PICTURE_CONTAINER);
    }

    public Dimension getAvatarSize() {
        return getElementSize(driver, EmployeePersonalDetailsPUI.EMPLOYEE_PROFILE_IMAGE);
    }

    @Step("Verify Avatar is updated successfuly.")
    public boolean isProfileAvatarUpdatedSuccess(Dimension beforeUpload) {
        Dimension afterUpload = getAvatarSize();
        return !(beforeUpload.equals(afterUpload));
    }
}
