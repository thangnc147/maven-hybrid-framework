package pageObjects.orangehrm;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.LoginPUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to Username textbox with value: {0}")
    public void enterToUsernameTextbox(String usernsame) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver,  LoginPUI.USERNAME_TEXTBOX, usernsame);
    }

    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,  LoginPUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Login Button")
    public DashboardPO clickToLoginButton() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);

        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDashboardPage(driver);
    }
}
