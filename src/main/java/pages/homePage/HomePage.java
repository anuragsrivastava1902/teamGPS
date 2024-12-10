package pages.homePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	//Locators
	
	By meetingModule = By.xpath("//span[normalize-space()='Meetings']");
	//By meetingModule = By.xpath("//li[@class='sidenav-item hover-link']//a[@class='sidenav-link userguide_Meet']");
	By groupMeetingModule = By.xpath("//ul[@class='sidenav level-2 collapse show']//li[2]//a[1]//span[1]");
	//By oneOnOneMeeting = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/div[1]/app-admin-nav[1]/div[2]/ul[1]/li[3]/ul[1]/li[1]/a[1]/span[1]");
	By oneOnOneMeetingModule = By.xpath("//span[normalize-space()='1:1 Meetings']");
	//Actions
	
	public void clickOnMeetings() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(meetingModule));
		WebElement meetingElement = driver.findElement(meetingModule);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", meetingElement);
	}
	
	public void clickOnOneOnOneMeetings() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(oneOnOneMeetingModule));
		WebElement oneOnOneMeetingElement = driver.findElement(oneOnOneMeetingModule);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", oneOnOneMeetingElement);

	}
	
	public void clickOnGroupMeetings() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(groupMeetingModule));
		driver.findElement(groupMeetingModule).click();
	}
}
