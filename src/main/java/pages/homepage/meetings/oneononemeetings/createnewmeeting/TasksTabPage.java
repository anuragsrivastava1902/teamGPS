package pages.homepage.meetings.oneononemeetings.createnewmeeting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TasksTabPage {


    WebDriver driver;
    WebDriverWait wait;

    public TasksTabPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By searchTaskNameInputField = By.xpath("//input[@placeholder='Search Task Name']");
    By createTaskButton = By.xpath("//button[normalize-space()='+Create Task']");
    By taskSourceDropdown = By.xpath("//ng-select[@placeholder='Task Source: All']//span[@class='ng-arrow-wrapper']");
    By taskStatusDropdown = By.xpath("//ng-select[@placeholder='Status : Open']//span[@class='ng-arrow-wrapper']");
    By taskDueDateDropdown = By.xpath("//div[@class='ng-select-container']//span[@class='ng-arrow-wrapper']");

    public void searchTaskName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(searchTaskNameInputField)).sendKeys(name);
    }

    public void clickOnCrateTaskButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(createTaskButton));
        wait.until(ExpectedConditions.elementToBeClickable(createTaskButton)).click();
//        js.executeScript("window.scrollBy(0, -300);");
        driver.switchTo().activeElement();
    }

    public void clickOnTaskSourceDropdown() throws InterruptedException {
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(taskSourceDropdown)).click();
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",taskDropdownElement);
        //Thread.sleep(5000);
        //((JavascriptExecutor) driver).executeScript("arguments[0].click()",taskDropdownElement);
        //taskDropdownElement.click();
        WebElement taskSourceList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'ng-option') and contains(text(),'Shri')]")));
        taskSourceList.click();
        System.out.println("second option clicked");
    }

    public void clickOnTaskStatusDropdown(String status) {
        wait.until(ExpectedConditions.elementToBeClickable(taskStatusDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+status+"') and contains(@class,'ng-option-label')]"))).click();
    }

    public void clickOnTaskDueDateDropdown() throws InterruptedException {
        WebElement taskDueDateDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(taskDueDateDropdown));
        taskDueDateDropdownElement.click();
        List<WebElement> dueDateList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ng-option.ng-star-inserted")));
        dueDateList.get(2).click();
        Thread.sleep(3000);
    }
}
