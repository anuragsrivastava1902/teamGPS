package pages.homepage.meetings.oneononemeetings.createnewmeeting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ActivityTabPage {

    WebDriver driver;
    WebDriverWait wait;

    public ActivityTabPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    By shoutoutsGivenCard = By.xpath("//div[contains(@class, 'card-title') and normalize-space(text())='Shoutouts Given']");
    By shoutoutsReceivedCard = By.xpath("//div[contains(@class, 'card-title') and normalize-space(text())='Shoutouts Received']");
    By csatResponsesCard = By.xpath("//div[contains(@class, 'card-title') and normalize-space(text())='CSAT Responses']");

    By dateRangeDropdown = By.cssSelector("ng-select[placeholder='Select Date Range']");

    // Method to get locator for Shoutouts Given Card
    public void getShoutoutsGivenCard() {
        wait.until(ExpectedConditions.elementToBeClickable(shoutoutsGivenCard)).click();
    }

    // Method to get locator for Shoutouts Received Card
    public void getShoutoutsReceivedCard() {
        wait.until(ExpectedConditions.elementToBeClickable(shoutoutsReceivedCard)).click();
    }

    // Method to get locator for CSAT Responses Card
    public void getCsatResponsesCard() {
        wait.until(ExpectedConditions.elementToBeClickable(csatResponsesCard)).click();
    }

    public void getDateRangeDropdown() {
        // Wait until the dropdown is clickable and open it
        wait.until(ExpectedConditions.elementToBeClickable(dateRangeDropdown)).click();

        // Wait for the dropdown options to be visible
        By dropdownOptions = By.xpath("//div[@aria-expanded='true']//span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownOptions));

        // Find all the options inside the dropdown
        List<WebElement> options = driver.findElements(dropdownOptions);

        // Iterate through each option and click on them sequentially
        for (WebElement option : options) {
            // Click on the option
            option.click();

            // Optionally, you can perform a verification step here, e.g., check the selected value
            WebElement selectedValue = driver.findElement(By.cssSelector(".ng-value-container span"));
            System.out.println("Selected Option: " + selectedValue.getText());

            // Re-open the dropdown for the next iteration if necessary
            wait.until(ExpectedConditions.elementToBeClickable(dateRangeDropdown)).click();
        }
    }
}