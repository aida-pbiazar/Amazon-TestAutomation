package amazon.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import amazon.Models.Objects.AmazonUser;
import amazon.Utils.DriverUtil;
import amazon.Utils.OTPHandle;

public class HomePage extends DriverUtil {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By account = By.id("nav-link-accountList");
	private By startHere = By.xpath("(//a[contains(@class,'nav-a') and text() = 'Start here.'])[1]");
	private By phoneNumber = By.id("ap_phone_number");
	private By nameField = By.id("ap_customer_name");
	private By emailField = By.id("ap_email");
	private By passWordField = By.id("ap_password");
	private By createAccountBtn = By.id("continue");
	private By countryDropDown = By.id("auth-country-picker-container");
	private By usCountryDropDown = By.xpath("//ul[@role ='application']//li//a[contains(text(), 'United States +1')]");
	private By otpField = By.cssSelector(".a-input-text.a-span12");
	private By createAccount = By.cssSelector(".a-button.a-button-span12.a-button-primary");
	private By signInBtn = By.id("signInSubmit");
	private By currecnyLink = By.xpath("//*[@id='icp-touch-link-cop']");
	private By hamburgerMenu = By.id("nav-hamburger-menu");
	private By smartPhone = By.xpath("//a[contains(@class, 'hmenu-item') and contains(.//div, 'Smart Home')]");
	private By televisions = By.xpath("//*[@id=\"hmenu-content\"]/ul[8]/li[11]/a");
	private By sort = By.id("sort");
	private By searchResultProduct = By.xpath("//span[contains(@cel_widget_id , 'SEARCH_RESULTS')]");
	private By sortDropDown = By.xpath("//*[@id=\"sort\"]/option[2]");
	private By currencyDropDownSymbol = By.xpath("//*[@id='icp-touch-link-cop']/span[1]");
	private By firstProductResult = By.id("result_0");
	private By searchResults = By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small");

	public LoggedInHomePage createAccount(AmazonUser amazonUser) throws Exception {
		elementVisible(account, 5);
		hoverOverAndClick(account, startHere);
		findElement(nameField).sendKeys(amazonUser.getUserName());
		findElement(countryDropDown).click();
		findElement(usCountryDropDown).click();
		findElement(phoneNumber).sendKeys("6672205141");
		findElement(passWordField).sendKeys(amazonUser.getUserPassword());
		findElement(createAccountBtn).click();
		String smsBody = OTPHandle.getMessage();
		String OTPNumber = smsBody.replaceAll("[^-?0-9]+", "");
		findElement(otpField).sendKeys(OTPNumber);
		findElement(createAccount).click();
		return new LoggedInHomePage(driver);
	}

	public LoggedInHomePage login(String userPhoneNumber,String userPassword) throws Exception {
		elementVisible(account, 5);
		findElement(account).click();
		findElement(emailField).sendKeys(userPhoneNumber);
		findElement(createAccountBtn).click();
		findElement(passWordField).sendKeys(userPassword);
		findElement(signInBtn).click();
		return new LoggedInHomePage(driver);
	}

	public boolean verifyNumberofTelevisionSerachResults() throws Exception {
		elementVisible(account, 5);
		findElement(hamburgerMenu).click();
		findElement(smartPhone).click();
		findElement(televisions).click();
		String searchResult = findElements(searchResults)
				.get(0).getText();
		scrollDown();
		elementVisible(sort, 5);
		findElement(sort).click();
		findElement(sortDropDown).click();
		List<WebElement> products = findElements(searchResultProduct);
		int size = products.size();
		boolean comparision = false;
		if (searchResult.replaceAll("[^0-9]", "").substring(1, 3).equalsIgnoreCase(String.valueOf(size))) {
			comparision = true;

		}
		return comparision;
	}

	public CurrencyPage openCurrencySetting() throws Exception {
		scrollDown();
		elementVisible(currecnyLink, 5);
		findElement(currecnyLink).click();
		return new CurrencyPage(driver);
	}

	public String getCurrencySymbolText() throws Exception {
		scrollDown();
		elementVisible(currencyDropDownSymbol, 5);
		return findElement(currencyDropDownSymbol).getText();
	}

	public String getProductCurrencyValue() throws Exception {
		hoverOverAndClick(hamburgerMenu, hamburgerMenu);
		findElement(smartPhone).click();
		findElement(televisions).click();
		scrollDown();
		elementVisible(firstProductResult, 10);
		return findElement(firstProductResult).getText();
	}
}
