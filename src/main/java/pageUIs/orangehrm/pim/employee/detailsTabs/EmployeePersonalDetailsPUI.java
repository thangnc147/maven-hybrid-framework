package pageUIs.orangehrm.pim.employee.detailsTabs;

public class EmployeePersonalDetailsPUI {
    public static final String PAGE_TITLE = "XPath=//div[@class='orangehrm-edit-employee-content']/div/h6";

    // Personal Detail Container
    public static final String FIRST_NAME_TEXTBOX = "name=firstName";
    public static final String MIDDLE_NAME_TEXTBOX = "name=middleName";
    public static final String LAST_NAME_TEXTBOX = "name=lastName";
    public static final String EMPLOYEE_ID_TEXTBOX = "Xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String DRIVER_LICENSE_TEXTBOX = "Xpath=//label[contains(text(), 'License Number')]/parent::div/following-sibling::div//input";
    public static final String LICENSE_EXPIRY_DATE_INPUT = "Xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
    public static final String NATIONALITY_FIELD = "Xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String NATIONALITY_ITEMS = "Xpath=//label[text()='Nationality']/parent::div/following-sibling::div//span";
    public static final String MARITAL_STATUS_FIELD = "Xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String MARITAL_STATUS_ITEMS = "Xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//span";
    public static final String DATE_OF_BIRTH_INPUT = "Xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String GENDER_MALE_SELECTED = "Xpath=//label[text()='Gender']/parent::div/following-sibling::div//label[text()='Male']/input";
    public static final String MALE_RADIO_BUTTON = "Xpath=//label[text()='Male']/span[contains(@Class, 'oxd-radio-input')]";
    public static final String SAVE_BUTTON_AT_PERSONAL_DETAILS_CONTAINER = "Xpath=//h6[text()='Personal Details']/parent::div/form//button[contains(string(), ' Save ')]";

    // Profile Picture Container
    public static final String EMPLOYEE_PROFILE_IMAGE = "Xpath=//div[@class='orangehrm-edit-employee-image']//img[@alt='profile picture']";
    public static final String SAVE_BUTTON_AT_CHANGE_PROFILE_PICTURE_CONTAINER = "Xpath=//h6[text()='Change Profile Picture']/parent::div/form//button[contains(string(), ' Save ')]";
}
