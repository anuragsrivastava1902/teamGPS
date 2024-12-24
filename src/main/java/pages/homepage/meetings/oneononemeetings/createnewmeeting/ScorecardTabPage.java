package pages.homepage.meetings.oneononemeetings.createnewmeeting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ScorecardTabPage {

    WebDriver driver;
    WebDriverWait wait;

    public ScorecardTabPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set explicit wait timeout
    }

    // Locators for elements on the Scorecard tab page

    By scorecardTab = By.xpath("//a[text()='Scorecard']");

    // Tabs
    By dailyTab = By.xpath("//a[contains(text(), 'Daily')]");
    By weeklyTab = By.xpath("//a[contains(text(), 'Weekly')]");
    By monthlyTab = By.xpath("//a[contains(text(), 'Monthly')]");
    By quarterlyTab = By.xpath("//a[contains(text(), 'Quarterly')]");
    By dateRangeDropdown = By.cssSelector("ng-select[formcontrolname='date_range'] .ng-select-container");
    By selectYearDropdown = By.cssSelector("ng-select[placeholder='Select Year'] div[class='ng-select-container ng-has-value']");
    By selectMonthDropdown = By.cssSelector("div[class='ng-select-container']");
    By clickOnApply = By.xpath("//button[normalize-space()='Apply']");
    By dropdownInputField = By.xpath("//div[@role='combobox' and @aria-expanded='false']//input");
    By expandedDropdown = By.xpath("//div[@aria-expanded='true']");
    By dropdownOption = By.xpath("//div[@class='hover' and @title='Last 15 Weeks']");
    By tabLink = By.xpath("//a[text()='%s']"); // Placeholder for dynamic tab names

    public void clickOnScorecardTab() {
        wait.until(ExpectedConditions.elementToBeClickable(scorecardTab)).click();
        System.out.println("Clicked on Scorecard Tab.");
    }

    public void clickOnDailyTab() {
        wait.until(ExpectedConditions.elementToBeClickable(dailyTab)).click();
        System.out.println("Clicked on Daily Tab.");
    }

    public void clickOnWeeklyTab() {
        wait.until(ExpectedConditions.elementToBeClickable(weeklyTab)).click();
        System.out.println("Clicked on Weekly Tab.");
    }

    public void clickOnMonthlyTab() {
        wait.until(ExpectedConditions.elementToBeClickable(monthlyTab)).click();
        System.out.println("Clicked on Monthly Tab.");
    }

    public void clickOnQuarterlyTab() {
        wait.until(ExpectedConditions.elementToBeClickable(quarterlyTab)).click();
        System.out.println("Clicked on Quarterly Tab.");
    }

    public void clickOndateRangeDropdown(String optionText) {
        //wait.until(ExpectedConditions.elementToBeClickable(dateRangeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dateRangeDropdown)).click();
        // Wait for the dropdown to expand
        WebElement expandedDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-expanded='true']")));
    }

    public void selectDateRangeDropdownOption(String optionText) {
        try {
            // Click on the dropdown to open it
            wait.until(ExpectedConditions.elementToBeClickable(dateRangeDropdown)).click();
            System.out.println("Clicked on Date Range Dropdown to expand it.");

            // Select option based on the text provided
            By optionByText = By.xpath("//div[contains(@title, '" + optionText + "')]");
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionByText));

            // Click the option using JavaScript (to avoid any click interception)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
            System.out.println("Successfully selected option: " + optionText);

        } catch (Exception e) {
            System.err.println("Error selecting dropdown option: " + optionText);
            e.printStackTrace();
        }
    }
    public void setSelectMonthDropdown(String month){
        wait.until(ExpectedConditions.elementToBeClickable(selectMonthDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[title='" + month + "']"))).click();
    }
    public void setSelectYearDropdown(String year){
        wait.until(ExpectedConditions.elementToBeClickable(selectYearDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[title='" + year + "']"))).click();
    }
    public void setClickOnApply(){
        wait.until(ExpectedConditions.elementToBeClickable(clickOnApply)).click();
    }
}

