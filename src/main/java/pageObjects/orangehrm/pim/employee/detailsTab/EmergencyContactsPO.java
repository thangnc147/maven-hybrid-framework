package pageObjects.orangehrm.pim.employee.detailsTab;

import org.openqa.selenium.WebDriver;

public class EmergencyContactsPO extends EmployeeDetailsTabs{
    private WebDriver driver;

    public EmergencyContactsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
