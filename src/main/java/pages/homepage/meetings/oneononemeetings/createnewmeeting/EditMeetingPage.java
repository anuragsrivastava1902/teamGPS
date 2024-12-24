package pages.homepage.meetings.oneononemeetings.createnewmeeting;

import java.time.Duration;
import java.util.List;

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
    // We have to also take considerations of the scenario, where the meeting being
    // created is not between the employee and his manager
    By meetingTitle = By.xpath("//input[@class='ng-pristine ng-valid ng-touched']");

    //Locators for different tabs that are shown inside the meeting
    By agendaTab = By.xpath("//a[contains('Agenda')]");
    By meetingSurveyTab = By.xpath("(//a[normalize-space()='Meeting Survey'])[1]");
    By scorecardTab = By.xpath("//a[contains(text(),'Scorecard') and contains(@class,'nav-link')]");
    By tasksTab = By.xpath("//a[contains(text(), 'Tasks') and contains(@class, 'nav-link') and contains(@class, 'nav-item') and contains(@class, 'ng-star-inserted')]");
    By activityTab = By.xpath("//a[contains(text(),'Activity') and contains(@class,'nav-link')]");
    By goalsTab = By.xpath("//a[contains(text(),'Goals') and contains(@class,'nav-link')]");

    //Locator for notes
    By showNotesButton = By.xpath("//div[@class='d-flex justify-content-end']//span[contains(.,'Show Notes')]");
    By privateNotesButton = By.xpath("//button[@data-target='#collapseOne']");
    By privateNotesInputField = By.xpath("//div[@data-placeholder='Enter text here...']");

    //Locator for the "create task" button that is accessible from every tab inside the 1:1 meeting
    By createTaskButton = By.xpath("//span[normalize-space()='Create Task']");

    //Locator for the "meeting time and date element" which is located on the top right position inside the meeitng
    By repeatPatternButton = By.cssSelector(".timeDiv.pointer");

    By saveAndSendUpdateButton = By.xpath("//button[normalize-space()='Save & Send Update']");
    By saveButton = By.xpath("//div[@class='meet-button ng-star-inserted']//button[contains(text(),'Save')]");
    By calendarSkipButton = By.xpath("//div[@class='modal-content']//button[contains(text(),'Skip')]");
    By addToCalendarButton = By.xpath("//div[@class='modal-content']//button[contains(text(),'Add to Calendar')]");

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
        WebElement scorecardTabElement = wait.until(ExpectedConditions.elementToBeClickable(scorecardTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scorecardTabElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", scorecardTabElement);
    }

    public void clickOnActivityTab() {
        WebElement activityTabElement = wait.until(ExpectedConditions.elementToBeClickable(activityTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activityTabElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", activityTabElement);
    }

    public void clickOnRepeatPatternButton() {
        wait.until(ExpectedConditions.elementToBeClickable(repeatPatternButton)).click();
    }

    public void clickOnGoalsTab() {
        WebElement goalsTabElement = wait.until(ExpectedConditions.elementToBeClickable(goalsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", goalsTabElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", goalsTabElement);
    }

    public void clickOnCreateTaskButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(createTaskButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }


    public void clickSaveAndSendUpdateButton() {
        try {
            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveAndSendUpdateButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        } catch (NoSuchElementException e) {
            System.out.println("Save and Send Update Button not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void clickOnSaveButton() {
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-body")));
            WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButtonElement);
            //saveButtonElement.click();
            System.out.println("save button clicked");
    }

    public void clickAddToCalendarButton() {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(addToCalendarButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);
    }

    public void clickSkipCalendarButton() {
        //WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
        // Locate the "skip" button within the modal
        WebElement skipButton = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarSkipButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", skipButton);
    }

    public void showPreviousMeetings() throws InterruptedException {
        WebElement previousMeetings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Previous Meetings')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",previousMeetings);
        Thread.sleep(5000);
        //Extra steps (need to move to some other method)
        List<WebElement> previousMeetingList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'accordion-toggle')]")));
        for (WebElement meet : previousMeetingList) {
            System.out.println(meet.getText());
        }
    }

    public void createPrivateNotes(){
        WebElement showNotesButtonElement = wait.until(ExpectedConditions.elementToBeClickable(showNotesButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",showNotesButtonElement);
        wait.until(ExpectedConditions.elementToBeClickable(privateNotesButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(privateNotesInputField)).sendKeys("this is the private note");
        wait.until(ExpectedConditions.elementToBeClickable(privateNotesButton)).click();
    }

}
