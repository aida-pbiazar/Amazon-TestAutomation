package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import amazon.Models.Objects.AmazonUser;
import amazon.Utils.DriverUtil;
import amazon.Utils.OTPHandle;

public class AccountPage extends DriverUtil {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	private By giftCardLink = By.xpath("//div[contains(@class, 'a-column') and contains(.//h2, 'Gift cards')]");

	public GiftCardPage goToGiftCardPage() throws Exception {
		findElement(giftCardLink).click();
		return new GiftCardPage(driver);
	}
}
