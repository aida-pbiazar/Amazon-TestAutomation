package amazon.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import amazon.Utils.DriverUtil;

public class CurrencyPage extends DriverUtil {

	public CurrencyPage(WebDriver driver) throws Exception {
		super(driver);
	}

	private By giftCardBalance = By.id("gc-ui-balance-gc-balance-value");

	private By currencyDropDown = By.xpath("//span[contains(@data-action, 'a-dropdown-button')]");
	private By currencyLinks = By.className("a-dropdown-link");
	private By currecnySaveBtn = By.xpath("//*[@id=\"icp-btn-save\"]/span/input");

	public String getGiftCardBalance() {
		return findElement(giftCardBalance).getText();
	}

	public HomePage chooseCurrency(String currency) throws Exception {
		scrollDown();
		elementVisible(currencyDropDown, 10);
		findElement(currencyDropDown).click();
		List<WebElement> currencies = findElements(currencyLinks);
		for (WebElement currencyElement : currencies) {
			if (currencyElement.getText().contains(currency)) {
				currencyElement.click();
				break;
			}
		}
		findElement(currecnySaveBtn).click();
		return new HomePage(driver);
	}
}
