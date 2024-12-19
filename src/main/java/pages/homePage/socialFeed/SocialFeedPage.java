package pages.homePage.socialFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SocialFeedPage {
    WebDriver driver;
    WebDriverWait wait;

    public SocialFeedPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By giveShoutOutInputField = By.xpath("//textarea[@id='createFeedDiv']");
    By shoutoutCardsLocator = By.xpath("//div[contains(@class, 'feed-list-card') and contains(@class, 'ng-star-inserted') and contains(@class, 'feedListDiv4363')]");

    //Action methods

    public void clickShoutInputField() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(giveShoutOutInputField)).sendKeys("hellooooooo");

    }

    public void filterShoutOutCardsByUser() throws InterruptedException {
        Thread.sleep(10000);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200);");
        //List<WebElement> shoutOutCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(shoutoutCardsLocator));
        WebElement shoutoutcard = wait.until(ExpectedConditions.elementToBeClickable(shoutoutCardsLocator));
        System.out.println("in here");
        //for (WebElement shoutoutcard : shoutOutCards){
            System.out.println(shoutoutcard.getText());
        //}
    }
}
