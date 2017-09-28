package by.htp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPage extends Page {

	@FindBy(xpath = "//b[text()='Личные данные']")
	WebElement personalData;

	@FindBy(xpath = "//input[@name='personalForm.name']")
	WebElement formName;

	@FindBy(xpath = "//input[@name='personalForm.surname']")
	WebElement formSurName;

	@FindBy(xpath = "//input[@name='personalForm.birthyear']")
	WebElement formbirthYear;

	@FindBy(xpath = "//input[@name='personalForm.site']")
	WebElement formSite;

	@FindBy(xpath = "//input[@name='personalForm.company']")
	WebElement formCompany;

	@FindBy(xpath = "//select[@name='personalForm.countryId']")
	WebElement select;

	@FindBy(xpath = "//select[@name='personalForm.zone']")
	WebElement selectTimeZone;

	@FindBy(xpath = "//textarea[@name='personalForm.about']")
	WebElement aboutYourSelf;

	@FindBy(xpath = "//*[@name='personalForm.save']")
	WebElement save;

	@FindBy(xpath = "//b[text()='Уведомления']")
	WebElement notifications;

	@FindBy(xpath = "//input[@name='notificationsForm.notificationsEnabled']")
	WebElement radiobuttonSwitchOnNotification;

	@FindBy(xpath = "//input[@name='notificationsForm.deliveryEnabled']")
	WebElement radiobuttonGettingNesLetters;

	@FindBy(xpath = "//input[@name='notificationsForm.save']")
	WebElement saveNotifications;

	@FindBy(xpath = "//b[text()='Конфиденциальность']")
	WebElement privacy;

	@FindBy(xpath = "//input[@value='closed']")
	WebElement onlyI;

	@FindBy(name ="privacyForm.save")
	WebElement savePrivacy;

	@FindBy(xpath = "//input[@name='personalForm.avatar']")
	WebElement inputTypeFile;

	public EditPage(WebDriver driver) {
		super(driver);
	}

	public void startEditPersonalData() {
		personalData.click();
	}

	public ProfilePage fillFormPersonalData(String name, String surname, String birthYear, String site, String company,
			String country, String aboutYours) {

		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(formName));

		formName.clear();
		formName.sendKeys(name);

		formSurName.clear();
		formSurName.sendKeys(surname);

		formbirthYear.clear();
		formbirthYear.sendKeys(birthYear);

		formSite.clear();
		formSite.sendKeys(site);

		formCompany.clear();
		formCompany.sendKeys(company);

		findOption(select, country);
		findOption(selectTimeZone, "Белоруссия/Минск(GMT+3)");

		aboutYourSelf.clear();
		aboutYourSelf.sendKeys(aboutYours);
		save.click();
		return new ProfilePage(driver);
	}

	private void findOption(WebElement element, String optionStr) {
		List<WebElement> options = element.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (optionStr.equals(option.getText())) {
				option.click();
			}
		}
	}

	public void startEditSettingNotifications() {
		notifications.click();
	}

	public ProfilePage changeSettingsNotifications() {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(radiobuttonSwitchOnNotification));

		if (radiobuttonSwitchOnNotification.isSelected()) {
			radiobuttonSwitchOnNotification.click();
		}
		if (radiobuttonGettingNesLetters.isSelected()) {
			radiobuttonGettingNesLetters.click();
		}
		saveNotifications.click();
		return new ProfilePage(driver);
	}

	public void startEditPrivacy() {
		privacy.click();
	}

	public ProfilePage changeRadiobuttonOnlyI() {		
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(onlyI));
		onlyI.click();		
		savePrivacy.click();
		return new ProfilePage(driver);
	}

	public void loadPhoto() {
		// File file = new File("D:\\ECLIPSE\\QuizFull\\src\\resources", "picture.jpg");

		// String filePath =
		// "D:"+File.separator+"ECLIPSE"+File.separator+"QuizFull"+File.separator
		// +"src"+File.separator+"resources"+File.separator+"picture.jpg";

		String filePath = System.getProperty("user.dir") + "\\src\\resources\\picture.jpg";

		new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(inputTypeFile));
		inputTypeFile.sendKeys(filePath);
		save.click();
	}

}
