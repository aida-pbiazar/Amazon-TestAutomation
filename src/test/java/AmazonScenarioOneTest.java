
import org.testng.Assert;
import org.testng.annotations.Test;
import amazon.Base.BaseTest;
import amazon.Pages.AccountPage;
import amazon.Pages.GiftCardPage;
import amazon.Pages.HomePage;
import amazon.Pages.LoggedInHomePage;

/**
 * @author aida
 */

public class AmazonScenarioOneTest extends BaseTest {

	@Test(testName = "Check your gift card's balance is $0.00")
	public void newUserCreated_shouldLeadTo_ZeroGiftCardBalance() throws Exception {
		HomePage homePage = new HomePage(driver);
		LoggedInHomePage loggedInHomePage = homePage.login();
		AccountPage accountPage = loggedInHomePage.goToAccountPage();
		GiftCardPage giftCardPage = accountPage.goToGiftCardPage();
		Assert.assertTrue(giftCardPage.getGiftCardBalance().equalsIgnoreCase("AED 0.00"));
	}
}