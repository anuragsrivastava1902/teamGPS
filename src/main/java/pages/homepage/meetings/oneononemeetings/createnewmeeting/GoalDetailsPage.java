package pages.homepage.meetings.oneononemeetings.createnewmeeting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoalDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    public GoalDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //locators


    //action methods
}
