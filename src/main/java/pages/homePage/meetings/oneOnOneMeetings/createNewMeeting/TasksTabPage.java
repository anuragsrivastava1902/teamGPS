package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TasksTabPage {


    WebDriver driver;
    WebDriverWait wait;

    public TasksTabPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By searchTaskNameInputField = By.xpath("//input[@placeholder='Search Task Name']");
    By createTaskButton = By.xpath("//button[normalize-space()='+Create Task']");
    By taskSourceDropdown = By.xpath("//ng-select[@placeholder='Task Source: All']//div[@class='ng-value-container']");
    By taskStatusDropdown = By.xpath("//ng-select[@placeholder='Status : Open']//span[@class='ng-arrow-wrapper']");
    By taskDueDateDropdown = By.xpath("//div[@class='ng-select-container']//span[@class='ng-arrow-wrapper']");

    public void searchTaskName(String name){
        wait.until(ExpectedConditions.elementToBeClickable(searchTaskNameInputField)).sendKeys(name);
    }

    public void clickOnCrateTaskButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(createTaskButton));
        wait.until(ExpectedConditions.elementToBeClickable(createTaskButton)).click();
//        js.executeScript("window.scrollBy(0, -300);");
//        driver.switchTo().activeElement();
    }

    public void clickOnTaskSourceDropdown(){
        wait.until(ExpectedConditions.elementToBeClickable(taskSourceDropdown)).click();
    }

    public void clickOnTaskStatusDropdown(){
        wait.until(ExpectedConditions.elementToBeClickable(taskStatusDropdown)).click();
    }

    public void clickOnTaskDueDateDropdown(){
        wait.until(ExpectedConditions.elementToBeClickable(taskDueDateDropdown)).click();
    }


}
