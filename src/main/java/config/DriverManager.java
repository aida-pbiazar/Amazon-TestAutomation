package config;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	public static ChromeDriver driver;

	public WebDriver getDriver() {
		return (WebDriver) driver;
	}

	public MutableCapabilities capabilities;

	public DriverManager() {
	}

	public WebDriver setupDriver() {

		try {

			String exePath = "src//test//resources//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return driver;

	}
}
