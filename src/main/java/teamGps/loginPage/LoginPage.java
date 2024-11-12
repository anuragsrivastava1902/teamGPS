package teamGps.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}

	//locators
	By emailField = By.xpath("//input[@id='email']");
	By nextBtn = By.xpath("//button[normalize-space()='Next']");
	By passField = By.xpath("//input[@placeholder='Password']");
	By loginBtn = By.xpath("//button[normalize-space()='Log In']");
	By forgotPasswordLink = By.xpath("//a[normalize-space()='Forgot Password?']");
	
	
	//Actions on 1:1 meetings page
	
	public LoginPage enterUsername(String email) {
		driver.findElement(emailField).sendKeys(email);
		return this;
	}
	
	public LoginPage clickNext() {
		driver.findElement(nextBtn).click();
		return this;
	}
	
	public LoginPage enterPassword(String pass) {
		driver.findElement(passField).sendKeys(pass);
		return this;
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public void clickForgotPassword() {
		driver.findElement(forgotPasswordLink).click();
	}
	

}
