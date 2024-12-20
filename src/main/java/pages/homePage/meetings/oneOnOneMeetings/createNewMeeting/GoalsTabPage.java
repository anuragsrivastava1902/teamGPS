

package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class GoalsTabPage {

    WebDriver driver;
    WebDriverWait wait;

    public GoalsTabPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    By goalsCard = By.cssSelector(".list-group-item.ng-star-inserted");
    By goalsCardSmall = By.cssSelector(".overflow-wrapper");
    By goalTypeDropdown = By.cssSelector("ng-select[placeholder='Type : All'] span[class='ng-arrow-wrapper']");
    By goalType = By.cssSelector("ng-select[placeholder='Focus Area : All'] span[class='ng-arrow-wrapper']");
    By getGoalStatusDropdown = By.cssSelector("ng-select[placeholder='Status : All'] span[class='ng-arrow-wrapper']");

    By goalDueDate = By.xpath("//input[@id='enddate']");


    public void setGoalTypeDropdown() throws InterruptedException {
        for(int i=0;i<5;i++) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".backdrop.full-screen")));
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(goalTypeDropdown));
            dropdown.click();
            List<WebElement> goalRangeList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ng-option-label.ng-star-inserted")));
            goalRangeList.get(i).click();
            Thread.sleep(2000);
        }
    }

    public void ClickOnAGoal() {
        List<WebElement> goalsCardList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(goalsCardSmall));
        if(!goalsCardList.isEmpty()){
            System.out.println("list not empty");
            for(WebElement goal : goalsCardList){
                System.out.println(goal.getText());
                if(goal.getText().contains("department")){
                    //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".btn.btn-outline-primary.mr-3.px-3.w-100.ng-star-inserted")));
                    goal.click();
                }
            }
        }
    }

    public void setGoalType(){
        for(int i=0;i<6;i++) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".backdrop.full-screen")));
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(goalType));
            dropdown.click();
            List<WebElement> Range = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ng-option-label.ng-star-inserted")));
            Range.get(i).click();
        }
    }
    public void setGoalStatusDropdown(){
//        for(int i=0;i<3;i++) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".backdrop.full-screen")));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(getGoalStatusDropdown));
        dropdown.click();
        List<WebElement> RangeL = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ng-option.ng-option")));
        RangeL.get(2).click();
        RangeL.get(3).click();

//        }

    }
    public void clickOnTaskDueDate(){
        wait.until(ExpectedConditions.elementToBeClickable(goalDueDate)).click();
        WebElement selectMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select month']")));
        Select select = new Select(selectMonth);
        select.selectByVisibleText("Nov");
        WebElement selectYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select year']")));
        Select select2 = new Select(selectYear);
        select2.selectByVisibleText("2026");
        WebElement selectDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'16')]")));
        selectDay.click();
    }
}
