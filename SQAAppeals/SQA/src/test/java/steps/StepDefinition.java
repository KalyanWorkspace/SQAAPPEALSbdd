package steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LoginPage;
import pageObjects.YourServicesPage;
import resources.TestBase;


public class StepDefinition extends TestBase {
	
	@Given("^the user has access to SQA Portal$")
    public void the_user_has_access_to_sqa_portal() throws IOException {
		driver= initializeDriver();
		driver.get(OR.getProperty("URL"));
    }

    @When("^the user enters his valid credentials$")
    public void the_user_enters_his_valid_credentials() {
    	LoginPage lp = new LoginPage(driver);
    	lp.getEmail().sendKeys(OR.getProperty("email"));		
		lp.getPassword().sendKeys(OR.getProperty("password"));		
		lp.submitButton().click();		
    }

    
    @When("^the user enters his Invalid credentials$")
    public void the_user_enters_his_invalid_credentials() {
    	LoginPage lp = new LoginPage(driver);
    	lp.getEmail().sendKeys(OR.getProperty("email"));		
		lp.getPassword().sendKeys(OR.getProperty("password1"));		
		lp.submitButton().click();
    }
    @Then("^the user can view the services$")
    public void the_user_can_view_the_services() {
    	YourServicesPage ys = new YourServicesPage(driver);
    	assertEquals("Your services", ys.yourServices().getText());
    	driver.close();
		driver.quit();
    }

    @Then("^the user cannot login to the site$")
    public void the_user_cannot_login_to_the_site() {   }
    }
