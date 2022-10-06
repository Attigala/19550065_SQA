package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUser {
	
	WebDriver driver;
	
	By usersTab = By.id("container_users");
	By addUserButton = By.className("withPlusIcon");
	
	By firstName = By.xpath("//*[@id=\"createUserPanel_firstNameField\"]");
	By lastName = By.className("lastNameField");
	By email = By.className("emailField");
	By saveBtn = By.className("submitBtn");
	@FindBy(css = "input#userDataLightBox_firstNameField")
	private WebElement firstNameTextField;
	
	
	public NewUser(WebDriver driver) {
		this.driver = driver;
	}
	
	public void typeFirstName(String firstName) {
		driver.findElement(this.firstName).sendKeys(firstName);
	}
	
	public void typeLastName(String lastName) {
		driver.findElement(this.lastName).sendKeys(lastName);
	}
	
	public void typeEmail(String email) {
		driver.findElement(this.email).sendKeys(email);
	}
	
	public void ClickSaveButton() {
		driver.findElement(saveBtn).click();
		
	}
	
	public void clickNewUserTab() {
		driver.findElement(usersTab).click();
	}
	
	public void clickNewUserButton() {
		driver.findElement(addUserButton).click();
	}

}
