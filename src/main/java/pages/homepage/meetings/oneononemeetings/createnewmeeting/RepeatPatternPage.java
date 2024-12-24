package pages.homepage.meetings.oneononemeetings.createnewmeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepeatPatternPage {

    WebDriver driver;
    WebDriverWait wait;
    WebElement modalWindow;


    public RepeatPatternPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        modalWindow = wait.until(ExpectedConditions.elementToBeClickable(repeatPatternModalWindow));
    }

    //Locators for the pop-up window for making the 1:1 meeting recurring:
    By repeatPatternModalWindow = By.xpath("/html/body/ngb-modal-window/div/div");
    By startDateInputField = By.xpath("(//input[@id='meetdate'])[2]");
    By endDateInputField = By.xpath("(//input[@id='end_date'])[2]");
    By startTimeInputField = By.xpath("(//input[@placeholder='Enter start time'])[2]");
    By endTimeInputField = By.xpath("(//input[@placeholder='Enter end time'])[2]");
    By meetingDurationDropdown = By.xpath("//ng-select[@placeholder='Duration']//div[@class='ng-value-container']");

    // -- Locators for the "Recurrence Pattern" section in the repeat pattern pop-up window
    By dailyRecurrenceRadioButton = By.xpath("//label[normalize-space()='Daily']");
    By weeklyRecurrenceRadioButton = By.xpath("//label[normalize-space()='Weekly']");
    By monthlyRecurrenceRadioButton = By.xpath("//label[normalize-space()='Monthly']");
    By repeatCustomDaysRadioButton = By.xpath("//label[normalize-space()='Every']");
    By repeatEverydayRadioButton = By.xpath("//label[normalize-space()='Every weekday']");

    // -- Locators for the "Range of recurrence" section in the repeat pattern pop-up window
    By recurrenceRangeStartDatePicker = By.xpath("//input[@id='recurrence_range_start_time']");
    By noEndDateRadioButton = By.xpath("//label[normalize-space()='No end date']");
    By endByRadioButton = By.xpath("//label[normalize-space()='End by :']");
    By recurrenceRangeEndDatePicker = By.xpath("//input[@id='recurrence_range_end_time']");
    By endAfterRadioButton = By.xpath("//label[normalize-space()='End after :']");

    By okButton = By.xpath("(//button[@type='submit'][normalize-space()='OK'])[1]");

    //-- Action methods for interacting with the pop-up window
//    WebElement modal = wait.until(ExpectedConditions.elementToBeClickable(repeatPatternModalWindow));;


   /* public void switchToRecurringModal() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(modal.findElement(startDateInputField))).click();
        setStartDate();
        wait.until(ExpectedConditions.elementToBeClickable(modal.findElement(endDateInputField))).click();
        setEndDate();
        //Thread.sleep(5000);
    }*/

    public void setStartDate() {
        wait.until(ExpectedConditions.elementToBeClickable(modalWindow.findElement(startDateInputField))).click();
        WebElement selectYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select year']")));
        Select select = new Select(selectYear);
        select.selectByVisibleText("2025");
        WebElement selectMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select month']")));
        Select select2 = new Select(selectMonth);
        select2.selectByVisibleText("Jan");
        WebElement selectDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'16')]")));
        selectDay.click();
    }

    public void setEndDate() {
        wait.until(ExpectedConditions.elementToBeClickable(modalWindow.findElement(endDateInputField))).click();
        WebElement selectYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select year']")));
        Select select = new Select(selectYear);
        select.selectByVisibleText("2025");
        WebElement selectMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select month']")));
        Select select2 = new Select(selectMonth);
        select2.selectByVisibleText("Jan");
        WebElement selectDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'16')]")));
        selectDay.click();
    }

    public void setStartTime(String time) {
        driver.findElement(startTimeInputField).sendKeys(time);
    }

    public void setEndTime(String time) {
        driver.findElement(endTimeInputField).sendKeys(time);
    }

    public void selectRecurrencePattern(String pattern) {
        switch (pattern.toLowerCase()) {
            case "daily":
                wait.until(ExpectedConditions.elementToBeClickable(modalWindow.findElement(dailyRecurrenceRadioButton))).click();
                System.out.println("clicked on the radio buttons");
                break;
            case "weekly":
                wait.until(ExpectedConditions.elementToBeClickable(modalWindow.findElement(weeklyRecurrenceRadioButton))).click();
                break;
            case "monthly":
                wait.until(ExpectedConditions.elementToBeClickable(modalWindow.findElement(monthlyRecurrenceRadioButton))).click();
                break;
        }
        System.out.println("clicked on the radio buttons");
    }

    public void clickOnOkButton() {
        wait.until(ExpectedConditions.elementToBeClickable(modalWindow.findElement(okButton))).click();
        System.out.println("ok button clicked");
    }

}

