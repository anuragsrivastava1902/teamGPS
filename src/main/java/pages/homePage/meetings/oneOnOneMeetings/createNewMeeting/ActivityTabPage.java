package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityTabPage {

    WebDriver driver;
    WebDriverWait wait;

    public ActivityTabPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locator for the "Shoutouts Given" card
    By shoutoutsGivenCard = By.xpath("//div[contains(@class, 'card-title') and text()='Shoutouts Given ']");

    // Locator for the "Shoutouts Received" card
    By shoutoutsReceivedCard = By.xpath("//div[contains(@class, 'card-title') and text()='Shoutouts Received ']");

    // Locator for the "CSAT Responses" card
    By csatResponsesCard = By.xpath("//div[contains(@class, 'card-title') and text()='CSAT Responses']");

    // Locator for the "No Data Found" message inside card details
    By noDataFoundMessage = By.xpath("//div[contains(@class, 'noDataFound')]//p[text()='No Data Found!']");

    // Locator for the Date Range Dropdown
    By dateRangeDropdown = By.xpath("//ng-select[contains(@class, 'date-range-filter')]");

    // Locator for the options within the Date Range Dropdown (dynamic)
    By dateRangeOption(String optionText) {
        return By.xpath("//ng-dropdown-panel//span[text()='" + optionText + "']");
    }

    // Method to get locator for Shoutouts Given Card
    public By getShoutoutsGivenCard() {
        return shoutoutsGivenCard;
    }

    // Method to get locator for Shoutouts Received Card
    public By getShoutoutsReceivedCard() {
        return shoutoutsReceivedCard;
    }

    // Method to get locator for CSAT Responses Card
    public By getCsatResponsesCard() {
        return csatResponsesCard;
    }

    // Method to get locator for "No Data Found" message
    public By getNoDataFoundMessage() {
        return noDataFoundMessage;
    }

    // Method to get locator for Date Range Dropdown
    public By getDateRangeDropdown() {
        return dateRangeDropdown;
    }

    // Method to get dynamic locator for a specific Date Range option
    public By getDateRangeOption(String optionText) {
        return dateRangeOption(optionText);
    }
}
