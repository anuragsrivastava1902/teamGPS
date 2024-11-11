package teamGps.homePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	By groupMeeting = By.xpath("//ul[@class='sidenav level-2 collapse show']//li[2]//a[1]//span[1]");
	//By oneOnOneMeeting = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/div[1]/app-admin-nav[1]/div[2]/ul[1]/li[3]/ul[1]/li[1]/a[1]/span[1]");
	By oneOnOneMeeting = By.xpath("//span[normalize-space()='1:1 Meetings']");
	//Actions
	
	public void selectMeeting() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(meetingModule));
		wait.until(ExpectedConditions.elementToBeClickable(meetingModule));
		driver.findElement(meetingModule).click();
	}
	
	public void selectOneonOneMeeting() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(oneOnOneMeeting));
		driver.findElement(oneOnOneMeeting).click();
	}
	
	public void selectGroupMeeting() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(groupMeeting));
		driver.findElement(groupMeeting).click();
	}
}
