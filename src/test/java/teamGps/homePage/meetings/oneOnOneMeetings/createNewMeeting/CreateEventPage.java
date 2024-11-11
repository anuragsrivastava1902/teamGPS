package teamGps.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEventPage {
	
	WebDriver driver;
	
	public CreateEventPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	
	//Locators -
	By addRecipientDropdown = By.xpath("//div[@class='ng-select-container']//div[@class='ng-value-container']");
	By eventTitleInput = By.xpath("//input[@placeholder='Enter Title']");
	By startTimeDateInput = By.xpath("//input[@id='meetdate']");
	By startTimeTimeInput = By.xpath("//input[@placeholder='Enter start time']");
	By startTimezoneInput = By.xpath("//ng-select[@class='ng-select ng-select-single ng-select-searchable ng-select-clearable ng-untouched ng-pristine ng-valid ng-select-focused ng-select-opened ng-select-bottom']//div[@class='ng-value-container']");
	By cancelButton = By.xpath("//button[normalize-space()='Cancel']");
	By createButton = By.xpath("//button[@type='submit']");
	

	//Action methods
	public void addRecipient(String option){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addRecipientDropdown));
		driver.findElement(addRecipientDropdown).click();
	    By optionLocator = By.xpath("(//span[contains(text(),'" + option + "')])");
	    // Wait until the desired option is clickable and then click it
	    WebElement addRecipientSelected = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
	    addRecipientSelected.click();
	}
	
	public void setEventTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventTitleInput));
		
		driver.findElement(eventTitleInput).click();
		driver.findElement(eventTitleInput).clear();
		driver.findElement(eventTitleInput).sendKeys(title);
	}
	
	public void clickOnCreateButton() {
		driver.findElement(createButton).click();
	}
	
}
