package pageObjects.orangehrm.pim.employee.detailsTab;

import org.openqa.selenium.WebDriver;

public class ContactDetailsPO extends EmployeeDetailsTabs{
    private WebDriver driver;

    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
