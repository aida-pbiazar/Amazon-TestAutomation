package amazon.Base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeMethod;

import config.DriverManager;

/**
 * The class has all methods needed for test initialization
 * @author aida
 */
public class BaseTest {

	protected amazon.Utils.DriverUtil driverUtil;
	protected WebDriver driver;
	private static final Properties properties = new Properties();

	public DriverManager driverManager = new DriverManager();

	public WebDriver getDriver() {
		driverManager.setupDriver();
		return driverManager.getDriver();
	}

	@BeforeMethod
	public void setUp() {
		driver = getDriver();
		driver.get("https://www.amazon.ae/");
	}

	public void initProperties(String language) {
		if (language.contains("ae")) {
			loadProperties("uae.properties");
		} else {
			loadProperties("us.properties");
		}
	}

	/**
	 * the method loads the property files under source folder of the project for
	 * verifying texts in tests
	 */

	private void loadProperties(String filePropertyName) {
		try (InputStream input = ClassLoader.getSystemResourceAsStream(filePropertyName)) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
