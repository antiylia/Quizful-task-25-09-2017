package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends Page {

	
	@FindBy(xpath = "//a[text()='редактировать']")
	WebElement editLink;

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public EditPage folowLinkEditProfile() {
		editLink.click();
		return new EditPage (driver);
	}

}
