package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectTemplatePage {

	WebDriver driver;
	WebDriverWait wait;
	
	public SelectTemplatePage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	By fromScratchButton = By.xpath("//img[@src='/assets/itbd-img/add-icon.svg']");
	By defaultTemplateButton = By.xpath("//h5[normalize-space()='Default Template']");
	
	By previousButton = By.xpath("//button[normalize-space()='Previous']");
	By saveAndNextButton = By.xpath("//button[normalize-space()='Save & Next']");
	
	By createEventButton = By.xpath("(//div[@class='meet-label labelcomplete'])[1]");
	
	
	
	//Action methods for interacting with select template page which comes in second step while creating an One-on-One meeting
	
	public void clickDefaultTemplate() {
		wait.until(ExpectedConditions.elementToBeClickable(defaultTemplateButton)).click();
	}
	
	public void clickSaveAndNextButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveAndNextButton)).click();
	}
}
