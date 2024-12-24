package pages.homepage.socialFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//using this page class we can switch between the rewards tab and redemption history tab
//also we can select between the gift card radio buttons and the custom reward radio buttons using this page class
public class RewardsAndRedemptionHistoryPage {

    WebDriver driver;
    WebDriverWait wait;

    public RewardsAndRedemptionHistoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set explicit wait timeout
    }

    By rewardsTab = By.xpath("//button[contains(@class,'nav-link') and contains(text(),'Rewards')]");
    By redemptionHistoryTab = By.xpath("//button[contains(@class,'nav-link') and contains(text(),'Redemption')]");
    By customRewardsRadioButton = By.xpath("//label[normalize-space()='Custom Rewards']");
    By giftCardRadioButton = By.xpath("//label[normalize-space()='Gift Card']");

    //click on the rewards tab that appears after "social feed --> redeem points"
    public void clickOnRewardsTab(){
        WebElement rewardsTabElement = wait.until(ExpectedConditions.elementToBeClickable(rewardsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",rewardsTabElement);
    }

    //click on the redemption history tab that appears after "social feed --> redeem points"
    public void clickOnRedemptionHistoryTab(){
        WebElement redemptionHistoryTabElement = wait.until(ExpectedConditions.elementToBeClickable(redemptionHistoryTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",redemptionHistoryTabElement);
    }

    //select the custom reward radio button inside the "social feed --> redeem points --> rewards tab"
    public void selectCustomRewardRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(customRewardsRadioButton)).click();
    }

    //select the gift card radio button inside the "social feed --> redeem points --> rewards tab"
    public void selectGiftCardRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(giftCardRadioButton)).click();
    }
}
