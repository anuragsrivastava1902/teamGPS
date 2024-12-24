package pages.homepage.meetings.oneononemeetings.createnewmeeting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateTasksFlyoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CreateTasksFlyoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By taskName = By.xpath("//div[2]/app-create-task/div/form/div[2]/input");
    By taskAssignee = By.xpath("//div[@class='slide-out position_CT']//div[@class='ng-value-container']");
    By taskDueDate = By.xpath("//div[@class='slide-out position_CT']//input[@id='startdate']");
    By taskDescription = By.xpath("//div[@class='slide-out position_CT']//div[@data-placeholder='Write description(optional)']");
    By saveButton = By.xpath("//div[@class='slide-out position_CT']//button[normalize-space()='Save']");

    public void enterTaskName(String nameOfTask) {
        //WebElement flyoutFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='slide-out position_CT']")));
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(taskName)).sendKeys(nameOfTask);
    }

    public void enterTaskAssignee(String assignee) {
        wait.until(ExpectedConditions.elementToBeClickable(taskAssignee)).click(); //div[contains(text(),'Shri')]
        WebElement assigneeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slide-out position_CT']//div[contains(text(),'" + assignee + "')]")));
        assigneeOption.click();
    }

    public void enterTaskDescription() {
        wait.until(ExpectedConditions.elementToBeClickable(taskDescription)).sendKeys("this is the task description to validate the sendkeys method");
    }

    public void clickOnSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public void clickOnTaskDueDate() {
        wait.until(ExpectedConditions.elementToBeClickable(taskDueDate)).click();
        WebElement selectMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select month']")));
        Select select = new Select(selectMonth);
        select.selectByVisibleText("Nov");
        WebElement selectYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select year']")));
        Select select2 = new Select(selectYear);
        select2.selectByVisibleText("2026");
        WebElement selectDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'16')]")));
        selectDay.click();
    }
}


