package pages.homepage.socialfeed;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RedemptionHistoryPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public RedemptionHistoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }


    By filterIcon = By.xpath("//img[@alt='filter']");
    By datePicker = By.cssSelector("#startdate");
    By pointsRedeemedFilter = By.xpath("(//input[@type='text'])[3]");
    By amountFilter = By.cssSelector("(//input[@type='text'])[4]");
    By pointBalanceFilter = By.xpath("(//input[@type='text'])[5]");
    By deductionTypeDropdown = By.xpath("(//select[contains(@class,'form-control')])[1]");
    By redemptionStatusDropdown = By.xpath("(//select[contains(@class,'form-control')])[2]");
    By resendMailLink = By.xpath("(//a[normalize-space()='Resend Mail'])[1]");


    public void clickOnFilterIcon(){
        WebElement filterIconElement = wait.until(ExpectedConditions.elementToBeClickable(filterIcon));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",filterIconElement);
    }

    public void selectRedemptionDate(){
        wait.until(ExpectedConditions.elementToBeClickable(datePicker)).click();
        WebElement selectMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select month']")));
        Select select = new Select(selectMonth);
        select.selectByVisibleText("Nov");
        WebElement selectYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select year']")));
        Select select2 = new Select(selectYear);
        select2.selectByVisibleText("2026");
        WebElement selectDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'16')]")));
        selectDay.click();
    }

    public void clickOnPointsRedeemedFilter(){
        wait.until(ExpectedConditions.elementToBeClickable(pointsRedeemedFilter)).sendKeys("800");
        actions.sendKeys(Keys.RETURN).perform();
    }

    public void clickOnAmountFilter(){
        wait.until(ExpectedConditions.elementToBeClickable(amountFilter)).sendKeys("800");
        actions.sendKeys(Keys.RETURN).perform();
    }

    public void clickOnPointBalanceFilter(){
        wait.until(ExpectedConditions.elementToBeClickable(pointBalanceFilter)).sendKeys("800");
        actions.sendKeys(Keys.RETURN).perform();
    }

    public void clickOnDeductionTypeDropdown(int index){
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(deductionTypeDropdown));
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
        System.out.println("clicked on the dropdown");
    }

    public void clickOnRedemptionStatusDropdown(){
        WebElement dropdownElement  = wait.until(ExpectedConditions.elementToBeClickable(redemptionStatusDropdown));
        //((JavascriptExecutor)driver).executeScript("arguments[0].click()",dropdownElement);
        Select select = new Select(dropdownElement);
        select.selectByIndex(2);
    }

    public void clickOnResendMailButton(){
        wait.until(ExpectedConditions.elementToBeClickable(resendMailLink)).click();
        //click on the popup window to confirm the action of resending email.
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes'][contains(@class,'btn btn-primary px-4')]"))).click();

    }

}