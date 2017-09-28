package by.htp.pagestest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.pages.AutorizedPage;
import by.htp.pages.EditPage;
import by.htp.pages.LoginPage;
import by.htp.pages.ProfilePage;
import by.htp.pages.StartPage;

public class EditPageNotificationTest {

	private WebDriver driver;
	private EditPage edit;
	private ProfilePage profile;

	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[@class='spacer']")
	WebElement gettingNews;

	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[9]")
	WebElement notifications;
	
	@FindBy(xpath = "//a[text()='выйти']")
	WebElement logout;

	@BeforeClass
	public void beforeClassInit() {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);

		StartPage mainPage = new StartPage(driver);
		mainPage.open();

		LoginPage loginPage = mainPage.clickLogin();
		AutorizedPage autorizPage = loginPage.fillInput("antiylia");
		profile = autorizPage.folowProfile();
	}

	@BeforeMethod
	public void beforeMethodInit() {
		edit = profile.folowLinkEditProfile();
	}

	@Test
	public void ifsetSettingsNotificationsIsCorrect() {
		edit.startEditSettingNotifications();
		edit.changeSettingsNotifications();

		assertEquals(gettingNews.getText().trim(), "нет");
		assertEquals(notifications.getText().trim(), "выключены");		
	}
	
	@AfterClass
	public void logout() {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(logout));
		logout.click();
		driver.close();
	}

}
