package by.htp.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import by.htp.pages.AutorizedPage;
import by.htp.pages.EditPage;
import by.htp.pages.LoginPage;
import by.htp.pages.ProfilePage;
import by.htp.pages.StartPage;

public class Runner {

	public static void main(String[] args) {

		// System.setProperty("webdriver.gecko.driver", "D:\\geckoDriver\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		StartPage mainPage = new StartPage(driver);
		mainPage.open();

		LoginPage loginPage = mainPage.clickLogin();
		AutorizedPage autorizPage = loginPage.fillInput("antiylia");
		ProfilePage profile = autorizPage.folowProfile();

		EditPage edit = profile.folowLinkEditProfile();
		edit.startEditPersonalData();
		profile = edit.fillFormPersonalData("Ylia", "Antipirovich", "1993", "htp.by", "It-academy", "Studing Java");
		edit = profile.folowLinkEditProfile();

		edit.startEditSettingNotifications();
		profile = edit.changeSettingsNotifications();

		edit = profile.folowLinkEditProfile();
		edit.startEditPrivacy();
		profile = edit.changeRadiobuttonOnlyI();

		edit = profile.folowLinkEditProfile();

		edit.startEditPersonalData();
		edit.loadPhoto();
	}
}