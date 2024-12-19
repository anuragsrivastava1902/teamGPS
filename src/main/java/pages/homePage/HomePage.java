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
	WebDriverWait wait;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	//Locators inside the homepage in the left menu
	By meetingModule = By.xpath("//span[normalize-space()='Meetings']");
	By groupMeetingModule = By.xpath("//span[normalize-space()='Group Meetings']");
	By oneOnOneMeetingModule = By.xpath("//span[normalize-space()='1:1 Meetings']");
	By SocialFeedModule = By.xpath("//span[normalize-space()='Social Feed']");

	//Action methods
	public void clickOnMeetings() {
		WebElement meetingElement = wait.until(ExpectedConditions.elementToBeClickable(meetingModule));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", meetingElement);
	}
	
	public void clickOnOneOnOneMeetings() {
		WebElement oneOnOneMeetingElement = wait.until(ExpectedConditions.elementToBeClickable(oneOnOneMeetingModule));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", oneOnOneMeetingElement);
	}
	
	public void clickOnGroupMeetings() {
		wait.until(ExpectedConditions.elementToBeClickable(groupMeetingModule)).click();
	}

	public void clickOnSocialFeed() throws InterruptedException {
		WebElement socialFeedElement = wait.until(ExpectedConditions.elementToBeClickable(SocialFeedModule));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", socialFeedElement);
		System.out.println("clicked social feed");
	}

}
