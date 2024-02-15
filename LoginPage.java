package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver lDriver;
	public LoginPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement email;
	
	@FindBy (id ="Password")
	@CacheLookup
	WebElement password;
	
	@FindBy (xpath ="//input[@value='Log in']")
	@CacheLookup
	WebElement loginBtn;
	
	public void enterEmail(String emailAddress) 
	{
	email.clear();
	email.sendKeys(emailAddress);	
	}
	public void enterPassword(String pwd) 
	{
	password.clear();
	password.sendKeys(pwd);	
	}
	public void clickonLoginBtn() 
	{
	loginBtn.click();	
	}
	@FindBy (linkText = "Logout")
	WebElement logout;
	public void clickonLogoutBtn() 
	{
	logout.click();	
	}
}
