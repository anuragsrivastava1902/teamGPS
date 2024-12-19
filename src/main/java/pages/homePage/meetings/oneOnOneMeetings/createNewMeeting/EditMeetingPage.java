package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditMeetingPage {

    WebDriver driver;
    WebDriverWait wait;

    public EditMeetingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    // We have to take considerations of the scenario, where the meeting being
    // created is not between the employee and his manager
    By meetingTitle = By.xpath("//input[@class='ng-pristine ng-valid ng-touched']");

    //Locators for different tabs that are shown inside the meeting
    By agendaTab = By.xpath("//a[contains('Agenda')]");
    By meetingSurveyTab = By.xpath("(//a[normalize-space()='Meeting Survey'])[1]");
    By scorecardTab = By.xpath("//a[contains(text(),'Scorecard') and contains(@class,'nav-link')]");
    By tasksTab = By.xpath("//a[contains(text(), 'Tasks') and contains(@class, 'nav-link') and contains(@class, 'nav-item') and contains(@class, 'ng-star-inserted')]");
    By activityTab = By.xpath("//a[contains(text(),'Activity') and contains(@class,'nav-link')]");
    By goalsTab = By.xpath("//a[contains(text(),'Goals') and contains(@class,'nav-link')]");

    //Locator for the "create task" button that is accessible from every tab inside the 1:1 meeting
    By createTaskButton = By.xpath("//span[normalize-space()='Create Task']");

    //Locator for the "meeting time and date element" which is located on the top right position inside the meeitng
    By repeatPatternButton = By.cssSelector(".timeDiv.pointer");

    By saveAndSendUpdateButton = By.xpath("//button[normalize-space()='Save & Send Update']");
    By addToCalendarSkipbutton = By.xpath("//button[normalize-space()='Skip']");
    By addToCalendarButton = By.xpath("//button[normalize-space()='Add to Calendar']");

    // Action methods

    public void clickOnAgendaTab() {
        wait.until(ExpectedConditions.elementToBeClickable(agendaTab));
        driver.findElement(agendaTab).click();
    }

    public void clickOnMeetingSurveyTab() {
        wait.until(ExpectedConditions.elementToBeClickable(meetingSurveyTab)).click();
    }

    public void clickOnTasksTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tasksTab));
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(tasksTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tab);

    }

    public void clickOnScorecardTab() {
        wait.until(ExpectedConditions.elementToBeClickable(scorecardTab)).click();
    }

    public void clickOnActivityTab() {
        wait.until(ExpectedConditions.elementToBeClickable(activityTab)).click();
    }

    public void clickOnRepeatPatternButton() {
        wait.until(ExpectedConditions.elementToBeClickable(repeatPatternButton)).click();
    }

    public void clickOnGoalsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(goalsTab)).click();
    }

    public void clickOnCreateTaskButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(createTaskButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }


    public void clickSaveAndSendUpdateButton() {
        try {
            WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(saveAndSendUpdateButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        } catch (NoSuchElementException e) {
            System.out.println("Save and Send Update Button not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void clickAddToCalendarButton() {
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
        // Locate the "Add to Calendar" button within the modal
        WebElement addButton = modal.findElement(addToCalendarButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);
    }

    public void clickSkipCalendarButton() {
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
        // Locate the "skip" button within the modal
        WebElement skipButton = modal.findElement(addToCalendarSkipbutton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", skipButton);
    }

}
