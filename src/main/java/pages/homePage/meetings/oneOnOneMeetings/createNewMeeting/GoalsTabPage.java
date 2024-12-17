package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoalsTabPage {

    WebDriver driver;
    WebDriverWait wait;

    public GoalsTabPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    // Dynamic locators for elements on the Goal tab

    // Goal Tab [already defined in the edit meeting class]
    //By goalTab = By.xpath("//a[contains(@class, 'nav-link') and contains(text(), 'Goals')]");

    // Search Box [where is the search box inside the goals tab?]
    By searchIcon = By.xpath("//div[contains(@class, 'goalSearch')]//img[@alt='search']");
    By searchInputField = By.xpath("//input[contains(@placeholder, 'Search Goal Name')]");

    // Goal Source Dropdown [12dec-- made changes to the name of the locators as they were pointing to different elements]
    By goalTypeDropdown = By.xpath("//ng-select[@formcontrolname='goal_type']");
    //By goalSourceSelectedValue = By.xpath("//ng-select[@formcontrolname='goal_type']//span[@class='ng-value-label']");
    //By goalSourcePlaceholder = By.xpath("//ng-select[@formcontrolname='goal_type']//div[contains(@class, 'ng-placeholder')]");

    // Status Dropdown
    By goalStatusDropdown = By.xpath("//ng-select[@placeholder='Status']//div[@class='ng-select-container ng-has-value']");
    //By statusSelectedValue = By.xpath("//ng-select[@formcontrolname='status']//span[@class='ng-value-label']");
    //By statusPlaceholder = By.xpath("//ng-select[@formcontrolname='status']//div[contains(@class, 'ng-placeholder')]");

    // Due Date Filter
    By calendarIcon = By.xpath("//span[contains(@class, 'calendarIcon')]//img[contains(@src, 'calendar.svg')]");
    By dueDateDropdown = By.xpath("//ng-select[contains(@placeholder, 'Due Date')]");
    By dueDatePlaceholder = By.xpath("//ng-select[contains(@placeholder, 'Due Date')]//div[contains(@class, 'ng-placeholder')]");

    By goalStartDateDatePicker = By.xpath("//div[@class='input-container']//input[@id='startdate']");
    By goaleEndDateDatePicker = By.xpath("//div[@class='input-container']//input[@id='enddate']");

    // Create Goal Button
    By createGoalButton = By.xpath("//button[contains(@class, 'createGoal') and contains(text(), 'Create Goal')]");

    // Action methods for interacting with elements

    // Click on the search icon
    public void clickSearchIcon() {
        driver.findElement(searchIcon).click();
    }

    // Enter a search term in the search input field
    public void enterSearchTerm(String searchTerm) {
        driver.findElement(searchInputField).sendKeys(searchTerm);
    }

    // Select a value from the Goal Source dropdown
    /*public void selectGoalSource(String goalSource) {
        driver.findElement(goalSourceDropdown).sendKeys(goalSource);
    }*/

    // Get selected value from the Goal Source dropdown
    /*public String getSelectedGoalSource() {
        return driver.findElement(goalSourceSelectedValue).getText();
    }*/

    // Get the placeholder value of the Goal Source dropdown
    /*public String getGoalSourcePlaceholder() {
        return driver.findElement(goalSourcePlaceholder).getText();
    }*/

    // Select a value from the Status dropdown
    /*public void selectStatus(String status) {
        driver.findElement(statusDropdown).sendKeys(status);
    }*/

    // Get selected value from the Status dropdown
    /*public String getSelectedStatus() {
        return driver.findElement(statusSelectedValue).getText();
    }*/

    // Get the placeholder value of the Status dropdown
    /*public String getStatusPlaceholder() {
        return driver.findElement(statusPlaceholder).getText();
    }*/

    // Click on the calendar icon for Due Date filter
    public void clickCalendarIcon() {
        driver.findElement(calendarIcon).click();
    }

    // Select a due date from the Due Date dropdown
    public void selectDueDate(String dueDate) {
        driver.findElement(dueDateDropdown).sendKeys(dueDate);
    }

    // Get the placeholder value of the Due Date dropdown
    public String getDueDatePlaceholder() {
        return driver.findElement(dueDatePlaceholder).getText();
    }

    // Click the Create Goal button
    public void clickCreateGoalButton() {
        driver.findElement(createGoalButton).click();
    }
}