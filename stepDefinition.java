package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import pageObjects.LoginPage;
import io.cucumber.java.en.*;


public class stepDefinition {
	
	public WebDriver driver;
	public LoginPage loginPG;
    public EdgeOptions option = new EdgeOptions();
	@Given("User launch edge browser")
	public void user_launch_edge_browser() {
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//Drivers/msedgedriver.exe");
		
	    option.addArguments("--remote-allow-origins=*");
	    WebDriver driver = new EdgeDriver(option);
	
	   loginPG = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	   driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pass) {
	 loginPG.enterEmail(email);
	 loginPG.enterPassword(pass);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	   loginPG.clickonLoginBtn();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	   String actualTitle=driver.getTitle();
	   if (expectedTitle.equals(actualTitle)) {
		   Assert.assertTrue(true);
	   }
	   else {
		   Assert.assertTrue(false);
	   }
	}

	@When("User clicks on Logout button")
	public void user_clicks_on_logout_button() throws InterruptedException {
	   loginPG.clickonLogoutBtn();
	   Thread.sleep(3000);
	}

	@Then("Close the browser")
	public void close_the_browser() {
	driver.close();
	driver.quit();
	}

}
