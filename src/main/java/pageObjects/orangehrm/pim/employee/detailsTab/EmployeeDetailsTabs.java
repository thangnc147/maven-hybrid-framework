package pageObjects.orangehrm.pim.employee.detailsTab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.detailsTabs.EmployeeDetailsTabsPUI;

public class EmployeeDetailsTabs extends BasePage {

    private WebDriver driver;

    public EmployeeDetailsTabs(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeePersonalDetailsPO openPersonalDetailsTab() {
        waitForElementClickable(driver, EmployeeDetailsTabsPUI.PERSONAL_DETAIL_TAB);
        clickToElement(driver, EmployeeDetailsTabsPUI.PERSONAL_DETAIL_TAB);

        return PageGenerator.getEmployeePersonalDetailsPage(driver);
    }

    public ContactDetailsPO openContactDetailsTab() {
        waitForElementClickable(driver, EmployeeDetailsTabsPUI.CONTACT_DETAIL_TAB);
        clickToElement(driver, EmployeeDetailsTabsPUI.CONTACT_DETAIL_TAB);

        return PageGenerator.getContactDetailsPage(driver);
    }

    public EmergencyContactsPO openEmergencyContactDTab() {
        waitForElementClickable(driver, EmployeeDetailsTabsPUI.EMERGENCY_CONTACT_TAB);
        clickToElement(driver, EmployeeDetailsTabsPUI.EMERGENCY_CONTACT_TAB);

        return PageGenerator.getEmergencyContactsPage(driver);
    }
}
