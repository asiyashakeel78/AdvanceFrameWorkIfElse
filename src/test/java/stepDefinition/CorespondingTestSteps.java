package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basePage.BasePage;
import factory.LoginPageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilites.Screenshot;


public class CorespondingTestSteps {
	public WebDriver driver;
	private LoginPageFactory loginPage;
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws InterruptedException {
		driver = BasePage.getDriver("chrome");
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		
		loginPage = new LoginPageFactory(driver); 
		
	}
	

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() throws InterruptedException {		
		loginPage.enterUsername("student");
		loginPage.enterpassword("Password123");	
		Thread.sleep(3000);
	}
	

	@When("user clicks the submit button")
	public void user_clicks_the_submit_button() {
		loginPage.clicksubmit();		    
	}
	

	@Then("user is navigated to the dashboard page")
	public void user_is_navigated_to_the_dashboard_page() throws InterruptedException {
		String actualURL = loginPage.getCurrentURL();
		String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
		
		 try {
	            Assert.assertEquals(actualURL, expectedURL, "User is not on the expected login page URL.");
	        } catch (AssertionError e) {
	            Screenshot.takeScreenshot(driver, "screenshots/failure-screenshot.png");
	            throw e;  // Rethrow to allow Cucumber to handle the failure
	        } finally {
	          
	           Thread.sleep(3000);
	           driver.quit();
	        }
	    }  	
	    
	    
	}


