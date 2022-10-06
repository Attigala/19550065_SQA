package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testing.pages.Login;
import testing.pages.NewUser;

public class TestNewUser extends TestBase {

	NewUser newUser;
	Login login;
	private static final String TITLE = "actiTIME - Enter Time-Track";
	
	
	public void testNewUser() {
		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		capabilities.setCapability("marionette", true);
		driver = new EdgeDriver(capabilities);
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
		login = new Login(driver);
		login.typeUsername("admin");
		login.typePassword("manager");
		login.clickLoginButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(titleIsEqualTo(TITLE));
		newUser = new NewUser(driver);
		newUser.clickNewUserTab();
		wait.until(titleIsEqualTo("actiTIME - User List"));
		newUser.clickNewUserButton();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		newUser.typeFirstName("Devni");
		newUser.typeLastName("Attigala");
		newUser.typeEmail("devniattigala@gmail.com");
	}
	
	private ExpectedCondition<Boolean> titleIsEqualTo(final String searchString) {
	    return driver -> driver.getTitle().toLowerCase().equals(searchString.toLowerCase());
	}
}
