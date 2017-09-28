package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

	@FindBy(id = "login")
	WebElement loginInput;

	@FindBy(xpath = "//input[@name='loginForm.password']")
	WebElement passwordInput;

	@FindBy(xpath = "//input[@class ='btn btn-primary']")
	WebElement ok;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public AutorizedPage fillInput(String u_login) {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(loginInput));
		loginInput.click();
		loginInput.sendKeys(u_login);
		passwordInput.click();
		passwordInput.sendKeys("1.61803398875");
		ok.click();
		return new AutorizedPage(driver);
	}

}
