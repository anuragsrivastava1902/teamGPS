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
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(taskSourceDropdown));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",dropdownElement);
        //Thread.sleep(100000);
        System.out.println("dropdown clicked");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.=\"Shri's Task\"]"))).click();
            System.out.println("second option clicked");
        } catch (Exception e) {
            throw new RuntimeException("task source not visible yet. " + e);
        }
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
