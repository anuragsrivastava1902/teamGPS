package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;
import org.openqa.selenium.By;
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
        By meetingsMenu = By.xpath("//a[contains(text(),'Meetings')]");
        By oneOnOneMenu = By.xpath("//a[contains(text(),'1:1 Meetings')]");
        By scorecardTab = By.xpath("//a[text()='Scorecard']");
        By dateRangeDropdown = By.cssSelector("ng-select[formcontrolname='date_range'] .ng-select-container");
        By tabLink = By.xpath("//a[text()='%s']"); // Placeholder for dynamic tab names

        // Navigate to the 1:1 meeting and click the Scorecard tab
        public void navigateToScorecardTab() {
            clickElement(meetingsMenu);
            clickElement(oneOnOneMenu);
            clickElement(scorecardTab);
        }

        // Select an option from the dropdown (e.g., "Last 15 Weeks")
        public void selectDateRange(String dateRange) {
            clickElement(dateRangeDropdown);
            // Use a dynamic XPath to locate the date range option
            By option = By.xpath("//div[@title='" + dateRange + "']");
            clickElement(option);
        }

        // Navigate to a specific tab (Daily, Weekly, Monthly, Quarterly)
        public void navigateToTab(String tabName) {
            // Use String.format to properly insert tab name into XPath
            By tab = By.xpath(String.format("//a[text()='%s']", tabName));
            clickElement(tab);

            // Wait for the tab to be visible after clicking
            wait.until(ExpectedConditions.visibilityOfElementLocated(tab));
        }

        // Helper method to click on an element and wait for it to be clickable
        private void clickElement(By locator) {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }

        // Automate the full flow
        public void automateScorecardTab() {
            // Step 1: Navigate to the 1:1 meeting and Scorecard tab
            navigateToScorecardTab();

            // Step 2: Select "Last 15 Weeks" in the dropdown
            selectDateRange("Last 15 Weeks");

            // Step 3: Iterate through the tabs dynamically
            String[] tabs = {"Daily", "Weekly", "Monthly", "Quarterly"};
            for (String tab : tabs) {
                navigateToTab(tab);
                System.out.println("Switched to the " + tab + " tab.");
            }
            System.out.println("Scorecard automation completed successfully!");
        }
}