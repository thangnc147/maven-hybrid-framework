package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.configurations.*;
import pageObjects.orangehrm.pim.employee.*;
import pageObjects.orangehrm.pim.employee.detailsTab.ContactDetailsPO;
import pageObjects.orangehrm.pim.employee.detailsTab.EmergencyContactsPO;
import pageObjects.orangehrm.pim.employee.detailsTab.EmployeePersonalDetailsPO;
import pageObjects.orangehrm.pim.reports.AddReportPO;
import pageObjects.orangehrm.pim.reports.ReportListPO;

public class PageGenerator {
    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage(WebDriver driver) {
        return new DashboardPO(driver);
    }

    public static AddEmployeePO getAddEmployeePage(WebDriver driver) {
        return new AddEmployeePO(driver);
    }

    public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
        return new EmployeeListPO(driver);
    }

    public static EmployeePersonalDetailsPO getEmployeePersonalDetailsPage(WebDriver driver) {
        return new EmployeePersonalDetailsPO(driver);
    }

    public static ContactDetailsPO getContactDetailsPage(WebDriver driver) {
        return new ContactDetailsPO(driver);
    }

    public static EmergencyContactsPO getEmergencyContactsPage(WebDriver driver) {
        return new EmergencyContactsPO(driver);
    }

    public static AddReportPO getAddReportPage(WebDriver driver) {
        return new AddReportPO(driver);
    }

    public static ReportListPO getReportListPage(WebDriver driver) {
        return new ReportListPO(driver);
    }

    public static CustomFieldsPO getReportCustomFieldsPage(WebDriver driver) {
        return new CustomFieldsPO(driver);
    }

    public static DataImportPO getReportDataImportPage(WebDriver driver) {
        return new DataImportPO(driver);
    }

    public static OptionalFieldsPO getReportOptionalFieldsPage(WebDriver driver) {
        return new OptionalFieldsPO(driver);
    }

    public static ReportingMethodPO getReportReportingMethodPage(WebDriver driver) {
        return new ReportingMethodPO(driver);
    }

    public static TerminationReasonsPO getReportTerminationReasonsPage(WebDriver driver) {
        return new TerminationReasonsPO(driver);
    }
}
