package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageObjects.orangehrm.pim.employee.detailsTab.EmployeePersonalDetailsPO;
import pageUIs.orangehrm.pim.employee.AddEmployeePUI;

public class AddEmployeePO extends BasePage {
    private WebDriver driver;

    public AddEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to First Name textbox with value: {0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddEmployeePUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter to Middle Name textbox with value: {0}")
    public void enterToMiddleNameTextbox(String middleName) {
        waitForElementVisible(driver, AddEmployeePUI.MIDDLE_NAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePUI.MIDDLE_NAME_TEXTBOX, middleName);
    }

    @Step("Enter to Last Name textbox with value: {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddEmployeePUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePUI.LAST_NAME_TEXTBOX, lastName);
    }

    @Step("Get value from Employee ID textbox")
    public String getEmployeeId() {
        waitForElementVisible(driver, AddEmployeePUI.EMPLOEE_ID_TEXTBOX);
        return getAttributeValue(driver, AddEmployeePUI.EMPLOEE_ID_TEXTBOX, "value");
    }

    @Step("Click to Save button to create new Employee record")
    public EmployeePersonalDetailsPO clickToSaveButtonAtEmployeeCreation() {
        waitForElementClickable(driver, AddEmployeePUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver, AddEmployeePUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);

        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmployeePersonalDetailsPage(driver);
    }
}
