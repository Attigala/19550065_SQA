package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	WebDriver driver;
	
	By username = By.id("username");
	By password = By.name("pwd");
	By LoginBtn = By.id("loginButton");
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void typeUsername(String username) {
		driver.findElement(this.username).sendKeys(username);
	}
	
	public void typePassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(LoginBtn).click();
		
	}

}
