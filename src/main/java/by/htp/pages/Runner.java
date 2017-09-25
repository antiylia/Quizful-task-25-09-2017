package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Runner {
	
	public static void main (String [] args) {
	
	System.setProperty("webdriver.gecko.driver", "D:\\geckoDriver\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();

	StartPage mainPage = new StartPage (driver);
	mainPage.open();
	
	LoginPage loginPage = mainPage.clickLogin();
	
	AutorizedPage autorizPage = loginPage.fillInput("antiylia", "1.61803398875");
	ProfilePage profile = autorizPage.folowProfile();
	
	EditPage edit = profile.folowLinkEditProfile();
	edit.startEditPersonalData();
	
	profile = edit.fillFormPersonalData ("Ylia", "Antipirovich", "1993", "htp.by", "It-academy", "Studing Java");
	edit = profile.folowLinkEditProfile();

	edit.startEditSettingNews();
	profile = edit.changeRadioButton ();
		
	edit = profile.folowLinkEditProfile();
	edit.startEditPrivacy();
	profile = edit.changeRadiobuttonOnlyI();
	
	edit = profile.folowLinkEditProfile();	
	edit.startEditPersonalData();
	
	
}
}