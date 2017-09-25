package by.htp.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
	
	protected final WebDriver driver;

	protected Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	protected void open(String url) {
		getDriver().get(url);
	}
	/*
	protected WebDriver waitSpecifiedElement () {		
		Wait<WebDriver> wait = new WebDriverWait(driver, 20L, 1000L).withMessage("Element was not found");
	    wait.until(ExpectedConditions.visibilityOf(element.getWebElement()));
		return driver;
	}
	*/

}
