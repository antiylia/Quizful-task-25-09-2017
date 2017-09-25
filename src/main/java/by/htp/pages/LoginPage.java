package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

	@FindBy(id ="login")
	WebElement loginInput;
	
	@FindBy(xpath = "//input[@name='loginForm.password']")
	WebElement passwordInput;
		
	@FindBy(xpath = "//input[@class ='btn btn-primary']")
	WebElement ok;
		
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public AutorizedPage fillInput (String u_login, String u_password) {
		loginInput.click();
		loginInput.sendKeys(u_login);
		passwordInput.click();
		passwordInput.sendKeys(u_password);	
		ok.click();
		return new AutorizedPage (driver);
	}		
	

}
