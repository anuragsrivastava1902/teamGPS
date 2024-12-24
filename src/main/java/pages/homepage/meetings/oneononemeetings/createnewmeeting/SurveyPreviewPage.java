package pages.homepage.meetings.oneononemeetings.createnewmeeting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SurveyPreviewPage {

    WebDriver driver;
    WebDriverWait wait;

    public SurveyPreviewPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By closeButton = By.xpath("//span[@class='close']");
    By useTemplateButton = By.xpath("//button[normalize-space()='Use Template']");
    By cancelButton = By.xpath("//button[normalize-space()='Cancel']");

    public void clickOnCloseButton() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }

    public void clickOnUseTemplateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(useTemplateButton)).click();
    }

    public void clickOnCancelButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }
}
