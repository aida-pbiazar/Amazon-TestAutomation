package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import amazon.Utils.DriverUtil;

public class LoggedInHomePage extends DriverUtil {
	public LoggedInHomePage(WebDriver driver) throws Exception {
		super(driver);
	}

	private By yourAccountLink = By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]/span");
	private By account = By.id("nav-link-accountList");

	public AccountPage goToAccountPage() throws Exception {
		elementVisible(account, 5);
		hoverOverAndClick(account, yourAccountLink);
		return new AccountPage(driver);
	}
}
