package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEventPage {

    WebDriver driver;
    WebDriverWait wait;

    public CreateEventPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }


    //Locators -
    By addRecipientDropdown = By.cssSelector(".ng-value-container");
    By eventTitleInput = By.xpath("//input[@placeholder='Enter Title']");

    //--Start time section
    By startDateInputField = By.xpath("//input[@id='meetdate']");
    By startTimeInputField = By.xpath("//input[@placeholder='Enter start time']");
    By startTimezoneInput = By.xpath("//ng-select[@class='ng-select ng-select-single ng-select-searchable ng-select-clearable ng-untouched ng-pristine ng-valid ng-select-focused ng-select-opened ng-select-bottom']//div[@class='ng-value-container']");

    //-- End time section
    By endDateInputField = By.xpath("//input[@id='end_date']");
    By endTimeInputField = By.xpath("//input[@placeholder='Enter end time']");
    By endTimezoneInput = By.xpath("//div[@aria-expanded='true']//input[@type='text']");

    By makeMeetingRecurringLink = By.xpath("//img[@alt='Refresh Icon']");

    By cancelButton = By.xpath("//button[normalize-space()='Cancel']");
    By createButton = By.xpath("//button[@type='submit']");


    //Action methods

    //?? there is one issue here, the dropdown is not automatically getting clicked.
    //..and we need it to click manually for option to be selected -- [[issue solved]]
    public void addRecipient(String option) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".backdrop.full-screen")));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(addRecipientDropdown));
        //((JavascriptExecutor)driver).executeScript("arguments[0].click();", dropdown);
        dropdown.click();
        //click on the name of user passed
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + option + "')]")));
        optionElement.click();
    }

    public void setEventTitle(String title) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(eventTitleInput));
        driver.findElement(eventTitleInput).click();
        driver.findElement(eventTitleInput).clear();
        driver.findElement(eventTitleInput).sendKeys(title);
    }

    public void clickOnCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }

    public void clickOnCancelButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }

    public void clickOnRecurringMeetingLink() {
        WebElement recurringLink = wait.until(ExpectedConditions.elementToBeClickable(makeMeetingRecurringLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", recurringLink);
    }

    public void clickOnMeetingStartDate() {
        wait.until(ExpectedConditions.elementToBeClickable(startDateInputField)).click();
        WebElement selectYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select year']")));
        Select select = new Select(selectYear);
        select.selectByVisibleText("2025");
        WebElement selectMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select month']")));
        Select select2 = new Select(selectMonth);
        select2.selectByVisibleText("Jan");
        WebElement selectDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'16')]")));
        selectDay.click();
    }

    public void clickOnMeetingEndDate() {
        wait.until(ExpectedConditions.elementToBeClickable(endDateInputField)).click();
        WebElement selectYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select year']")));
        Select select = new Select(selectYear);
        select.selectByVisibleText("2025");
        WebElement selectMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select month']")));
        Select select2 = new Select(selectMonth);
        select2.selectByVisibleText("Jan");
        WebElement selectDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'16')]")));
        selectDay.click();
    }

}
