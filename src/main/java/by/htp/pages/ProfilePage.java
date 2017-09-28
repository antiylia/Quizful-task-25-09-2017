package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends Page {

	
	@FindBy(xpath = "//a[text()='редактировать']")
	WebElement editLink;

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public EditPage folowLinkEditProfile() {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(editLink));
		editLink.click();
		return new EditPage (driver);
	}

}
