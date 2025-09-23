package pageObjects.orangehrm;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageUIs.orangehrm.DashboardPUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to PIM from Main Menu Bar")
    public EmployeeListPO clickToPIMButton() {
        waitForElementClickable(driver, DashboardPUI.PIM_BUTTON_ON_MENU);
        clickToElement(driver, DashboardPUI.PIM_BUTTON_ON_MENU);

        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmployeeListPage(driver);
    }
}
