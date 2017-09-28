package by.htp.pagestest;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class EditPagePrivacyTest {

	private WebDriver driver;
	private EditPage edit;
	private ProfilePage profile;
	
	static final Logger userLogger = LogManager.getLogger(EditPage.class.getSimpleName());
	static final Logger rootLogger = LogManager.getRootLogger();

	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[10]")
	WebElement privacy;

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
	public void ifsetEditPrivacyIsCorrect() {
		userLogger.info("ifsetEditPrivacyIsCorrect() running");
		edit.startEditPrivacy();

		edit.changeRadiobuttonOnlyI();

		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(privacy));
		assertEquals(privacy.getText().trim(), "только мне");
	}

	@AfterClass
	public void logout() {
		rootLogger.info("Test1 is about compliting");
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(logout));
		logout.click();
		userLogger.info("Log out is done");
		driver.close();
	}

}
