package pages.homePage.meetings.oneOnOneMeetings;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.loginPage.LoginPage;

public class OneOnOneMeetingsTest {

	//public static void main(String[] args) 
	
		WebDriver driver;
		@BeforeClass
		void setup(){
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://itbd-qa-frontend.team-gps.net/login");
			driver.manage().window().maximize();
		}
		
		@Test
		void LoginTest() {
			LoginPage login = new LoginPage(driver);
			login.enterUsername("ralph.sharma@yopmail.com");
			login.clickNextButton();
			login.enterPassword("John@123");
			login.clickLoginButton();
		}
		
	
}


