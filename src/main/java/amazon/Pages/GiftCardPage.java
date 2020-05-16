package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import amazon.Utils.DriverUtil;

public class GiftCardPage extends DriverUtil {

	public GiftCardPage(WebDriver driver) throws Exception {
		super(driver);
	}

	private By giftCardBalance = By.id("gc-ui-balance-gc-balance-value");

	public String getGiftCardBalance() {
		return findElement(giftCardBalance).getText();
	}
}
