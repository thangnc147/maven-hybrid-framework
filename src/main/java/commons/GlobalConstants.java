package commons;

public class GlobalConstants {
    // System Info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String JAVA_VERSION = System.getProperty("java.version");

    // App Info: User
    public static final String DEV_USER_URL = "http://localhost/";
    public static final String STAGING_USER_URL = "https://user-staging.nopcommerce.com/";
    public static final String LIVE_USER_URL = "https://user-live.nopcommerce.com/";

    // App Info: Admin
    public static final String DEV_ADMIN_URL = "http://localhost/admin";
    public static final String STAGING_ADMIN_URL = "https://admin-staging.nopcommerce.com/";
    public static final String LIVE_ADMIN_URL = "https://admin-live.nopcommerce.com/";
    public static final String ADMIN_USERNAME = "";
    public static final String ADMIN_PASSWORD = "";

    // Wait Info
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;

    // Download-Upload file
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    // Retry Case Failed
    public static final int RETRY_NUMBER = 3;

    // Browser Logs/ Extention
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENTION_PATH = PROJECT_PATH + SEPARATOR + "browserExtentions" + SEPARATOR;

    // HTML Report Folder
    public static final String REPORTING_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    // Data Test/ Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "dataTest" + SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "environmentConfig" + SEPARATOR;

    // Jira Configuration
    public static final String JIRA_SITE_URL = "https://thangnguyen1407.atlassian.net/";
    public static final String JIRA_USERNAME = "thangnguyen.tsp@gmail.com";
    public static final String JIRA_API_KEY = "";
    public static final String JIRA_PROJECT_KEY = "";
}
