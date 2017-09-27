package by.htp.pages;


import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement save;
		
	@FindBy(xpath = "//b[text()='Уведомления']")
	WebElement news;
	
	@FindBy(xpath = "//input[@name='notificationsForm.notificationsEnabled']")
	WebElement radiobutton1;
	
	@FindBy(xpath = "//input[@name='notificationsForm.deliveryEnabled']")
	WebElement radiobutton2;
	
	@FindBy(xpath = "//input[@name='notificationsForm.save']")
	WebElement saveNews;
	
	@FindBy(xpath = "//b[text()='Конфиденциальность']")
	WebElement privacy;
		
	@FindBy(xpath = "//input[@value='closed']")
	WebElement onlyI;
	
	@FindBy(xpath = "//input[@name='privacyForm.save']")
	WebElement savePrivacy;
	
	@FindBy(xpath = "//input[@name='personalForm.avatar']")
	WebElement inputTypeFile;
	
	
	public EditPage (WebDriver driver) {
		super(driver);
	}
	
	/*
	 * в разделе «Личные данные» заполнить поля: имя, фамилия, год рождения, сайт,
	 * компания.
	 * Выбрать страну, город, верный часовой пояс. 
	 *  Заполнить поле «О cебе». - в разделе «Уведомления» убрать отметку для полей «Включить
	 * уведомления» и «Получать рассылку».
	 */
	
	public void startEditPersonalData() {
		personalData.click();
	}
	
	public ProfilePage fillFormPersonalData (String name, String surname, String birthYear, String site, String company, String aboutYours) {
		formName.sendKeys(name);
		formSurName.sendKeys(surname);
		formbirthYear.sendKeys(birthYear);
		formSite.sendKeys(site);
		formCompany.sendKeys(company);
		findOption(select, "Беларусь");
		findOption(selectTimeZone, "Белоруссия/Минск(GMT+3)");
		aboutYourSelf.sendKeys(aboutYours);      
		save.click();	
		return new ProfilePage(driver);
	}
	
	private void findOption (WebElement element, String optionStr) {
		List<WebElement> options = element.findElements(By.tagName("option"));
		for (WebElement option : options) {
		    if (optionStr.equals(option.getText())) {
		        option.click(); 		
	      }
       }
	}
	
	public void startEditSettingNews () {
		news.click();
	}
	
	
	public ProfilePage changeRadioButton () {
		if (radiobutton1.isSelected() ) {
			radiobutton1.click();			
		}
		if (radiobutton2.isSelected() ) {
			radiobutton2.click();			
		}
		saveNews.click();
		return new ProfilePage(driver);
	}
	
	public void startEditPrivacy () {
		privacy.click();
	}
	
	
	public ProfilePage changeRadiobuttonOnlyI() {
		onlyI.click();
		savePrivacy.click();
		return new ProfilePage(driver);
	}	
	/*
	public static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(stringSelection, null);
	}
	*/
	
	// public static final String FILE = System.getProperty("user.dir") + "\\src\\resources\\picture.jpg";

	public void loadPhoto() {
		
	//	File file = new File ("D:\\ECLIPSE\\QuizFull\\src\\resources\\picture.jpg");
		
	// File file = new File("D:\\ECLIPSE\\QuizFull\\src\\resources", "picture.jpg");
		
	// String filePath = "D:"+File.separator+"ECLIPSE"+File.separator+"QuizFull"+File.separator
	//                                       	+"src"+File.separator+"resources"+File.separator+"picture.jpg";
	/*	
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		 String filePath = System.getProperty("user.dir") + "\\src\\resources\\picture.jpg";
		  inputTypeFile.sendKeys(filePath); 
		
		  
		  //driver.findElement(By.xpath("//input[@type='file']")).sendKeys(file.getAbsolutePath());
			
	}
		
}
