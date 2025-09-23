package com.orangehrm.pim;

import commons.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_02_Employee extends BaseTest {
    String firstName, lastName, day, month, year, emailAddress, companyName, password;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {

        driver = getBrowserDriver(browserName, url);

    }

    @Test
    public void Employee_07_Edit_View_Job() {

    }

    @Test
    public void Employee_08_Edit_View_Salary() {

    }

    @Test
    public void Employee_09_Edit_View_Tax() {

    }

    @Test
    public void Employee_10_Qualifications() {

    }

    @Test
    public void Employee_11_Search_Employee() {

    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
