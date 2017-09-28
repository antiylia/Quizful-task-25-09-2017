package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutorizedPage  extends Page {

	
	@FindBy(xpath = "//a[text()='Профиль']")
	WebElement profileLink;
		
	public AutorizedPage(WebDriver driver) {
		super(driver);		
	}

    public ProfilePage folowProfile () {
    	new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(profileLink));
    	profileLink.click();
    	return new ProfilePage(driver);
    }
	
}
