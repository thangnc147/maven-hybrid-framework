package orangehrmData.pim;

import commons.GlobalConstants;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.databind.DeserializationFeature;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.File;

public class EmployeeInfo {

    public static EmployeeInfo getEmployeeInfo() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "employeeData.json"), EmployeeInfo.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("driverLicense")
    private String driverLicense;

    @JsonProperty("licenseExpiryDate")
    private String licenseExpiryDate;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("maritalStatus")
    private String maritalStatus;

    @JsonProperty("dateOfBirth")
    private String dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public String getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public String getNationality() {
        return nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
