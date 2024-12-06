package teamGps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import teamGps.homePage.HomePage;
import teamGps.homePage.meetings.oneOnOneMeetings.OneOnOneMeetingsPage;
import teamGps.loginPage.LoginPage;

public class EditMeetingCheck {

	public static void main(String args[]) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://itbd-qa-frontend.team-gps.net/login");
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