package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.EmployeeListPUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Add Employee button from PIM Nav bar")
    public AddEmployeePO clickToAddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPUI.ADD_EMPLOYEE_NAV_BUTTON);
        clickToElement(driver, EmployeeListPUI.ADD_EMPLOYEE_NAV_BUTTON);

        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddEmployeePage(driver);
    }
}
