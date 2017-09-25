package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutorizedPage  extends Page {

	
	@FindBy(xpath = "//a[text()='Профиль']")
	WebElement profileLink;
		
	public AutorizedPage(WebDriver driver) {
		super(driver);		
	}

    public ProfilePage folowProfile () {
    	profileLink.click();
    	return new ProfilePage(driver);
    }
	
}
