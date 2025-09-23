package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.externalUser.sidebar.UserAddressPO;
import pageObjects.nopCommerce.externalUser.sidebar.UserCustomerInfoPO;
import pageObjects.nopCommerce.externalUser.sidebar.UserOrderPageObject;
import pageObjects.nopCommerce.externalUser.sidebar.UserRewardPointPO;
import pageUIs.jquery.HomePageUI;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.nopCommerce.externalUser.UserSidebarPageUI;
import pageUIs.orangehrm.BasePUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    // Map Driver
//    private WebDriver driver;
//    public BasePage(WebDriver driver) {
//        this.driver;
//    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Encapsulation
    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String URL) {
        driver.get(URL);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

// Alert section
    public Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String key) {
        waitAlertPresence(driver).sendKeys(key);
    }

    // Window section
    public Set<String> getWindowHandles(WebDriver driver) {
        return driver.getWindowHandles();
    }

    public void switchWindowByID(WebDriver driver, String parentID) {
        for (String id : getWindowHandles(driver)) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchWindowByTitle(WebDriver driver, String expectedPageTitle) {
        for (String id : getWindowHandles(driver)) {
            driver.switchTo().window(id);

            String pageTitlle = driver.getTitle();

            if (pageTitlle.equals(expectedPageTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String expectedWindow) {
        for (String id : getWindowHandles(driver)) {
            if (!id.equals(expectedWindow)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    // Web Element Function
    private By getByXpath(String locator) {
        return By.xpath(locator);
    }


    private String castParameter(String locator, String... restParameter) {
        return String.format(locator, (Object[]) restParameter);
    }

    private By getByLocator(String prefixLocator) {
        By by = null;
        if (prefixLocator.toUpperCase().startsWith("ID")) {
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.toUpperCase().startsWith("CLASS")) {
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.toUpperCase().startsWith("NAME")) {
            by = By.name(prefixLocator.substring(5));
        } else if (prefixLocator.toUpperCase().startsWith("TAGNAME")) {
            by = By.tagName(prefixLocator.substring(8));
        } else if (prefixLocator.toUpperCase().startsWith("CSS")) {
            by = By.cssSelector(prefixLocator.substring(4));
        } else if (prefixLocator.toUpperCase().startsWith("XPATH")) {
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not support!");
        }
        return by;
    }

    protected WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    protected List<WebElement> getListElements(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    protected List<WebElement> getListElements(WebDriver driver, String locator, String... restParameter) {
        return driver.findElements(getByLocator(castParameter(locator, restParameter)));
    }

    public Set<Cookie> getALlCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies){
            driver.manage().addCookie(cookie);
        }
        sleepInSeconds(3);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String key) {
        getElement(driver, locator).sendKeys(key);
    }

    public void sendkeyToElement(WebDriver driver, String locator, String key, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).sendKeys(key);
    }

    public void selectItemInDropdown(WebDriver driver, String dropdownLocator, String expectedItem) {
        new Select(getElement(driver, dropdownLocator))
                .selectByVisibleText(expectedItem);
    }

    public void selectItemInDropdown(WebDriver driver, String dropdownLocator, String expectedItem, String... restParameter) {
        new Select(getElement(driver, castParameter(dropdownLocator, restParameter)))
                .selectByVisibleText(expectedItem);
    }

    public String getSelectedItemInDropdown(WebDriver driver, String dropdownLocator) {
        return new Select(getElement(driver, dropdownLocator))
                .getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple (WebDriver driver, String dropdownLocator) {
        return new Select(getElement(driver, dropdownLocator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getAttribute(attributeName);
    }

    public Dimension getElementSize(WebDriver driver, String locator) {
        return getElement(driver, locator).getSize();
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getText();
    }


    public String getCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListNumberOfElements(WebDriver driver, String locator) {
        return getListElements(driver, locator).size();
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        if(!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator, String... restParameter) {
        if(!getElement(driver, castParameter(locator, restParameter)).isSelected()) {
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }

    public void unheckTheCheckbox(WebDriver driver, String locator) {
        if(getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void unheckTheCheckbox(WebDriver driver, String locator, String... restParameter) {
        if(getElement(driver, castParameter(locator, restParameter)).isSelected()) {
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeInSecond) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSecond));
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).isDisplayed();
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getListElements(driver, locator);
        overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);

        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver,castParameter(locator, restParameter)).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    // Actions Section
    public void switchToDefaultPage(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void clickToElementByAction(WebDriver driver, String locator) {
        new Actions(driver).click(getElement(driver, locator)).perform();
    }

    public void clickAndHoldElementByAction(WebDriver driver, String locator) {
        new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
    }

    public void releaseLeftMouseByAction(WebDriver driver) {
        new Actions(driver).release().perform();
    }

    public void rightClick(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();;
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    public void pressKeyboardToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
    }

    public void pressKeyboardToElement(WebDriver driver, String locator, Keys key, String... restParameter) {
        new Actions(driver).sendKeys(getElement(driver, castParameter(locator, restParameter)), key).perform();
    }

    // Upload File(s) Section
    public void uploadSingleFile(WebDriver driver, String inputLocator, String filePath) {
        getElement(driver,inputLocator).sendKeys(filePath);
    }

    public void uploadMultipleFiles(WebDriver driver, String inputLocator, String[] filesPath) {
        int numberOfFiles = filesPath.length;
        String filePath = "";
        for (int i = 0; i <= numberOfFiles; i++) {
            if(i == 0  || i == numberOfFiles) {
                filePath = filesPath[i];
            } else {
                filePath = filesPath[i];
            }
        }
        getElement(driver,inputLocator).sendKeys();
    }

    // Javascript Executor Section
    public void executeJavascriptToBrowser(WebDriver driver, String jsScript) {
        ((JavascriptExecutor) driver).executeScript(jsScript);
    }

    public void executeJavascriptToElement(WebDriver driver, String locator, String jsScript) {
        ((JavascriptExecutor) driver).executeScript(jsScript, getElement(driver, locator));
    }

    public void clickToElementTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", getElement(driver, locator));
    }

    public void clickToElementTopByJS(WebDriver driver, String locator, String... restParameter) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", getElement(driver, castParameter(locator, restParameter)));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollToElementTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", getElement(driver, locator));
    }

    public void scrollToElementBottomByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false)", getElement(driver, locator));
    }

    public void hightlightElementByJS(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript ("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments [1])", element, originalStyle);
    }

    public void setAttributeinDOMByJS(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('"
                + attributeName + "', '" + attributeValue + "' )", getElement(driver, locator));
    }

    public String getAttributeinDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }
    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + value + "');", getElement(driver, locator));
    }

    public void removeAttributeinDOMByJS(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('"
                + attributeName + "', '" + attributeValue + "' )", getElement(driver, locator));
    }

    public boolean checkImageLoadedByJS(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    public void verifyTextInInnerTectByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public Object getElementValidationMessageByJS(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].validationMessage", getElement(driver, locator));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator, restParameter))));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public void waitForElementAttribute(WebDriver driver, String attributeName, String attributeValue, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.attributeToBe(getByLocator(locator), attributeName, attributeValue));
    }

    public void waitForElementAttribute(WebDriver driver, String attributeName, String attributeValue, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions
                .attributeToBe(getByLocator(castParameter(locator, restParameter)), attributeName, attributeValue));
    }

    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator, restParameter))));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator, restParameter))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public boolean waitForListElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions
                .invisibilityOfAllElements(getListElements(driver, locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForListElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public void waitForAlertPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    /* Only use for Level_07 */
    public UserRewardPointPO openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserAddressPO openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserOrderPageObject openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(driver, HomePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }

    public void enterToTextboxByID(WebDriver driver, String textboxId, String value) {
        waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_ID, textboxId);
        sendkeyToElement(driver, BasePageUI.TEXTBOX_BY_ID, value, textboxId);
    }

    public void clickToButtonByText(WebDriver driver, String buttonText) {
        waitForElementClickable(driver, BasePageUI.BUTTON_BY_TEXT, buttonText);
        clickToElement(driver, BasePageUI.BUTTON_BY_TEXT, buttonText);
    }

    public void clickToRadioByID(WebDriver driver, String radioID) {
        waitForElementClickable(driver, BasePageUI.RADIO_BUTTON_BY_ID, radioID);
        checkTheCheckboxOrRadio(driver, BasePageUI.RADIO_BUTTON_BY_ID, radioID);
    }

    public void clickToCheckboxByID(WebDriver driver, String checkboxID) {
        waitForElementClickable(driver, BasePageUI.CHECKBOX_BY_ID, checkboxID);
        checkTheCheckboxOrRadio(driver, BasePageUI.CHECKBOX_BY_ID, checkboxID);
    }

    public String getTextboxValueByID(WebDriver driver, String textboxId) {
//        waitForElementAttribute(driver, "AttributeName", "AttributeValue", BasePageUI.TEXTBOX_BY_ID, textboxId);
        waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_ID, textboxId);
        return getAttributeValue(driver, BasePageUI.TEXTBOX_BY_ID, "value", textboxId);
    }

    public boolean isRaditoSelectedByID(WebDriver driver, String radioId) {
        waitForElementSelected(driver, BasePageUI.RADIO_BUTTON_BY_ID, radioId);
        return isElementSelected(driver, BasePageUI.RADIO_BUTTON_BY_ID, radioId);
    }

    public boolean isCheckboxSelectedByID(WebDriver driver, String checkboxId) {
        waitForElementSelected(driver, BasePageUI.RADIO_BUTTON_BY_ID, checkboxId);
        return isElementSelected(driver, BasePageUI.RADIO_BUTTON_BY_ID, checkboxId);
    }

    /* Only using for OragneHRM Porject */
    public boolean waitAllLoadingIconInvisible(WebDriver driver) {
        return waitForListElementInvisible(driver, BasePUI.LOADING_ICON);
    }

    public boolean isSuccessMessageDisplayed(WebDriver driver) {
        waitForElementVisible(driver, BasePUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver, BasePUI.SUCCESS_MESSAGE);
    }
}
