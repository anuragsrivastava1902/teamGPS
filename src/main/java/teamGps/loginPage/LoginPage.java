package teamGps.loginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	//locators
	By emailInputField = By.xpath("//input[@id='email']");
	By nextButton = By.xpath("//button[normalize-space()='Next']");
	By passwordInputField = By.xpath("//input[@placeholder='Password']");
	By loginButton = By.xpath("//button[normalize-space()='Log In']");
	By forgotPasswordLink = By.xpath("//a[normalize-space()='Forgot Password?']");
	
	
	//Actions on 1:1 meetings page
	
	
	public LoginPage enterUsername(String email) {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputField)).sendKeys(email);
		driver.findElement(emailInputField).sendKeys(email);
		return this;
	}
	
	public LoginPage clickNextButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton)).click();
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputField)).sendKeys(password);
		return this;
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void clickForgotPassword() {
		 wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink)).click();
	}
	

}
