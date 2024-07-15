package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	private WebDriver driver;
	
	@FindBy(id="username")
	private WebElement usernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(id="submit")
	private WebElement submitbuttonField;
	
	//constructor
	
	
	public LoginPageFactory (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	public void enterpassword(String pw) {
		passwordField.sendKeys(pw);
	}
	public void clicksubmit() {
		submitbuttonField.click();
	}
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}	
	
}
