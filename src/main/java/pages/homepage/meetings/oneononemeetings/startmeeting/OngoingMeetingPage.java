package pages.homepage.meetings.oneononemeetings.startmeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OngoingMeetingPage {

	WebDriver driver;
	WebDriverWait wait;
		
		public OngoingMeetingPage(WebDriver driver){
			this.driver = driver;
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
		
		//Locators
		
		By completeMeetingButton = By.xpath("//button[normalize-space()='Complete 1:1']");
		
		//Action Methods to interact with the element on the ongoing 1:1 meeting page
		
		public void clickOnCompleteMeetingbutton() {
			wait.until(ExpectedConditions.elementToBeClickable(completeMeetingButton)).click();
			clickOnCompleteMeetingPopup();
		}
		
		public void clickOnCompleteMeetingPopup() {
			WebElement popup = driver.switchTo().activeElement();
			popup.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		}
}
