package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MeetingSurveyTabPage {
    WebDriver driver;
    WebDriverWait wait;

    public MeetingSurveyTabPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By assignSurveyButton = By.xpath("//button[normalize-space()='Assign survey']");
    By surveyTemplateSearch = By.xpath("//input[@placeholder='Search']");
    By surveyTemplateCard = By.xpath("(//div[@class='card'])[2]");
    By meetingPreviewButton = By.xpath("//div[@class='container scrollClass']//div[2]//div[1]//div[1]//div[2]//div[1]//button[1]");
    By useTemplateButton = By.xpath("(//button[contains(text(),'Use Template')])[2]");

    public void clickOnAssignSurveyButton(){
        wait.until(ExpectedConditions.elementToBeClickable(assignSurveyButton)).click();
        driver.switchTo().activeElement();
    }

    public void clickOnMeetingTemplatePreview(){
        //wait.until(ExpectedConditions.elementToBeClickable(assignSurveyButton)).click();
        //driver.switchTo().activeElement();
        WebElement card = wait.until(ExpectedConditions.elementToBeClickable(surveyTemplateCard));
        Actions actions = new Actions(driver);
        actions.moveToElement(card).perform();
        wait.until(ExpectedConditions.elementToBeClickable(meetingPreviewButton)).click();
        driver.switchTo().activeElement();
    }

    public void clickOnSurveyTemplateSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(assignSurveyButton)).click();
        driver.switchTo().activeElement();

    }

    public void clickOnUseTemplate(){
        wait.until(ExpectedConditions.elementToBeClickable(assignSurveyButton)).click();
        driver.switchTo().activeElement();
        WebElement card = wait.until(ExpectedConditions.elementToBeClickable(surveyTemplateCard));
        Actions actions = new Actions(driver);
        actions.moveToElement(card).perform();
        wait.until(ExpectedConditions.elementToBeClickable(useTemplateButton)).click();
    }
}
