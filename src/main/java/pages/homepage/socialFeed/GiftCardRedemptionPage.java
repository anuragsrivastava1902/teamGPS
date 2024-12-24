package pages.homepage.socialFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GiftCardRedemptionPage {
    WebDriver driver;
    WebDriverWait wait;

    public GiftCardRedemptionPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    By selectPointsDropdown = By.xpath("//span[@class='ng-arrow-wrapper']");
    By giftCardRedeemButton = By.xpath("//button[normalize-space()='Redeem']");


    public void clickOnPointsToRedeemDropdown(String pointsToRedeem) {
        wait.until(ExpectedConditions.elementToBeClickable(selectPointsDropdown)).click();
        try {
            //select the option from the dropdown based on the value provided
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'("+pointsToRedeem+" points)')]"))).click();
        } catch (Exception e) {
            System.out.println("not enough points in the points to redeem");
        }
    }

    public void clickOnGiftCardRedeemButton(){
        wait.until(ExpectedConditions.elementToBeClickable(giftCardRedeemButton)).click();
        //click on the confirmation popup window
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn-primary px-4') and contains(text(),'Redeem')]"))).click();
        System.out.println("confirm redeem button clicked");
    }

}
