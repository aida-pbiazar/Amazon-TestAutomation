package amazon.Base;

import org.testng.annotations.BeforeMethod;

import amazon.Base.BaseTest;

public class AmazonUSBaseTest extends BaseTest {

	@BeforeMethod
	public void setUp() {
		driver = getDriver();
		driver.get("https://www.amazon.com/");
	}
}
