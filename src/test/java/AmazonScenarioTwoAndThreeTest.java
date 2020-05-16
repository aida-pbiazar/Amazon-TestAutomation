

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.Base.AmazonUSBaseTest;
import amazon.Base.BaseTest;
import amazon.Models.Objects.AmazonUser;
import amazon.Models.Objects.RandomAmazonUserGenerator;
import amazon.Pages.AccountPage;
import amazon.Pages.CurrencyPage;
import amazon.Pages.GiftCardPage;
import amazon.Pages.HomePage;
import amazon.Pages.LoggedInHomePage;
import static utilities.Currencies.*;

/**
 * @author aida
 */

public class AmazonScenarioTwoAndThreeTest extends AmazonUSBaseTest {

	
	@Test(testName = "Check the total displayed number of results for category Smart Home | Televisions")
	public void searchTVCategory_shouldLeadTo_CorrectNumberOfResultsShown() throws Exception {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyNumberofTelevisionSerachResults());
		
	}
	
	@Test(testName = "Check the selected currency displayed for the products price")
	public void changeCurrencyInSetting_shouldLeadTo_NewCurrencyValueShown() throws Exception {
		HomePage homePage = new HomePage(driver);
		CurrencyPage currencyPage = homePage.openCurrencySetting();
		homePage = currencyPage.chooseCurrency(AED_CURRENCY_COUNTRY);
		Assert.assertTrue(homePage.	getCurrencySymbolText().equalsIgnoreCase(AED_CURRECNY_SYMBOL));
		Assert.assertTrue(homePage.getProductCurrencyValue().contains(AED_CURRECNY_SYMBOL));	
	}
}
