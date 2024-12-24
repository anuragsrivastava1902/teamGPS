package pages.homepage.socialFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomRewardRedemptionPage {
    WebDriver driver;
    WebDriverWait wait;

    public CustomRewardRedemptionPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By rewardNameSearchBox = By.xpath("//input[@placeholder='Search reward name']");
    By searchButton = By.xpath("//button[normalize-space()='Search']");
    By customRewardsRedeemButton = By.xpath("//div[contains(@class,'reward-box')]//button");


    public void enterRewardNameToSearch(String rewardName) {
        wait.until(ExpectedConditions.elementToBeClickable(rewardNameSearchBox)).sendKeys(rewardName);
    }

    public void clickOnSearchButton() throws InterruptedException {
        //click on the search button to search the custom reward
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        try {
            Thread.sleep(3000);
            //scroll down the window by 300px down so that the custom reward is completely in the viewport
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
            WebElement noRewardFound = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".text-center")));
            if (noRewardFound.isDisplayed()) {
                System.out.println("NO reward found");
            } else System.out.println("YES. reward found with this name");
        } catch (Exception e) {
            System.out.println("reward found, hence this exception is thrown");
            clickOnCustomRewardRedeemButton();
        }
    }

    private void clickOnCustomRewardRedeemButton() throws InterruptedException {
        WebElement redeemButtonElement = wait.until(ExpectedConditions.elementToBeClickable(customRewardsRedeemButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",redeemButtonElement);
        System.out.println(redeemButtonElement.getLocation());
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",redeemButtonElement);
        System.out.println("redeem button clicked");
        By redeemButtonInConfirmationPopup = By.xpath("//ngb-modal-window//button[contains(text(),'Redeem')]");
        wait.until(ExpectedConditions.elementToBeClickable(redeemButtonInConfirmationPopup)).click();
        Thread.sleep(5000);
    }
}
