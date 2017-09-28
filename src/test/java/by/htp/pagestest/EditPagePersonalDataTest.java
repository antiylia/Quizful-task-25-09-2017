package by.htp.pagestest;

import org.testng.annotations.Test;

import by.htp.pages.AutorizedPage;
import by.htp.pages.EditPage;
import by.htp.pages.LoginPage;
import by.htp.pages.ProfilePage;
import by.htp.pages.StartPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPagePersonalDataTest {

	private WebDriver driver;
	private EditPage edit;
	private ProfilePage profile;

	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[2]")
	WebElement fullNameUser;

	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[3]")
	WebElement cityCountry;

	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[4]")
	WebElement yearBirth;

	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[5]/a[text()='http://htp.by']")
	WebElement setSite;

	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[7]")
	WebElement setAboutYourSelf;

	@FindBy(xpath = "//a[text()='выйти']")
	WebElement logout;

	@BeforeClass
	public void beforeClassInit() {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
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
	public void ifsetDataIsCorrect() {
		edit.startEditPersonalData();
		String name = "Ylia";
		String surname = "Antipirovich";
		String year = "1993";
		String country = "Беларусь";
		String site = "htp.by";
		String aboutYourself = "Studing Java";

		profile = edit.fillFormPersonalData(name, surname, year, site, "It-academy", country, aboutYourself);

		assertEquals(fullNameUser.getText().trim(), name + " " + surname);
		assertTrue(cityCountry.getText().contains(country));
		assertEquals(yearBirth.getText().trim(), year);
		assertTrue(setSite.getText().contains(site));
		assertEquals(setAboutYourSelf.getText().trim(), aboutYourself);
	}

	@AfterClass
	public void logout() {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(logout));
		logout.click();
		driver.close();
	}
}
