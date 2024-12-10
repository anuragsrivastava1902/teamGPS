package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.OneOnOneMeetingsPage;
import pages.loginPage.LoginPage;

public class EditMeetingCheck {

	public static void main(String args[]) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://itbd-stage-frontend.team-gps.net/login");
	driver.manage().window().maximize();

	LoginPage login = new LoginPage(driver);
	login.enterUsername("ralph.sharma@yopmail.com");
	login.clickNextButton();
	login.enterPassword("John@123");
	login.clickLoginButton();
	
	//Thread.sleep(10000);
	
	HomePage mp = new HomePage(driver);
	mp.clickOnMeetings();
	mp.clickOnOneOnOneMeetings();
	
	OneOnOneMeetingsPage one = new OneOnOneMeetingsPage(driver);
	Thread.sleep(6000);
	one.clickEditMeeting(1);
	}
}