package teamGps.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectTemplatePage {

	WebDriver driver;
	
	public SelectTemplatePage(WebDriver driver){
		this.driver = driver;
	}
	
	By fromScratchBtn = By.xpath("//img[@src='/assets/itbd-img/add-icon.svg']");
	By defaultTemplatebtn = By.xpath("//h5[normalize-space()='Default Template']");
	
	By previousBtn = By.xpath("//button[normalize-space()='Previous']");
	By saveAndNextBtn = By.xpath("//button[normalize-space()='Save & Next']");
	
	By createEventBtn = By.xpath("(//div[@class='meet-label labelcomplete'])[1]");
	
	
	
	//action methods
	
	public void clickDefaultTemplate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(defaultTemplatebtn)));
		driver.findElement(defaultTemplatebtn).click();
	}
	
	public void clickSaveAndNextButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(saveAndNextBtn)));
		driver.findElement(saveAndNextBtn).click();
	}
}
