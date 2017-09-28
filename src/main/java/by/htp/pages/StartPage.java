package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends Page {
	private static final String URL = "http://www.quizful.net/test";

	@FindBy(xpath = "//ul[@id='user-panel']//a[text()='войти']")
	WebElement buttonLogIn;

	public StartPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open(URL);
	}

	public LoginPage clickLogin() {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(buttonLogIn));

		buttonLogIn.click();
		return new LoginPage(driver);
	}

}
