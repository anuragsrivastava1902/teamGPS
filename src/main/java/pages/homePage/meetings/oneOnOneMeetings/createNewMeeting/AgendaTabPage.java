package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.tools.JavaCompiler;


public class AgendaTabPage {
	
WebDriver driver;
WebDriverWait wait;
	
	public AgendaTabPage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//locators
	private int agendaNumber;
	By editAgendaItem = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-add-agenda[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[4]/span[1]");
	By deleteAgendaItems = By.xpath("//*[@id=\"cdk-drop-list-0\"]/div[1]/div/div[5]/span[2]/img");
	By addNotesToAgendaItem = By.xpath("//*[@id=\"cdk-drop-list-0\"]/div[1]/div/div[5]/span[1]/img");
	By addNotesInputField = By.xpath("//div[@data-placeholder='Write your notes...']");
	
	By addNewAgendaItem = By.cssSelector(".form-row.addItem.mb-4.ng-star-inserted");
	By showPrivateNotes = By.xpath("//div[@class='d-flex justify-content-end']//span[1]");
	By hidePrivateNotes = By.className("ml-2.btn-primary.addNote.ng-star-inserted");
	
	public void clickOnEditAgendaItem(int num) throws InterruptedException {
		agendaNumber = num;
		wait.until(ExpectedConditions.elementToBeClickable(editAgendaItem)).click();
		//driver.switchTo().activeElement();
		Thread.sleep(4000);
		WebElement agendaItemField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"updateInput0\"]")));
		((JavascriptExecutor)driver).executeScript("arguments[0].value = '';", agendaItemField);
		agendaItemField.sendKeys("this is the agenda item created by automation");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cdk-drop-list-0\"]/div[1]/div/div[4]/div[2]/button\n"))).click();
	}

	public void clickOnDeletAgendaItem(){
		wait.until(ExpectedConditions.elementToBeClickable(deleteAgendaItems)).click();
	}

	public void clickOnAddNotesToAgendaItems(){
		wait.until(ExpectedConditions.elementToBeClickable(addNotesToAgendaItem)).click();
		driver.switchTo().activeElement();
		WebElement NotesInputField = wait.until(ExpectedConditions.elementToBeClickable(addNotesInputField));
		NotesInputField.sendKeys("hello");
		driver.switchTo().defaultContent();
	}

	//one issue though -- new agenda items are not saving -- last line of this method is not executing
	public void clickOnAddAgendaItemButton(String agendaName, int n){
		for(int i=0; i<n; i++) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addNewAgendaItem));
			//js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].click()", element);
			WebElement addAgendaItemInputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='input0']")));
			addAgendaItemInputField.sendKeys(agendaName);
			//		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Save']")));
			//		js.executeScript("arguments[0].click()", saveButton);
			Actions actions = new Actions(driver);
			WebElement bodyElement = driver.findElement(By.tagName("body"));
			actions.moveToElement(bodyElement).click().perform();
		}
	}

	public void clickOnShowNotes(){

	}
}
