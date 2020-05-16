package amazon.Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The class has all common methods which are used in all different pages
 * 
 * @author aida
 */
public class DriverUtil {

	protected WebDriver driver;

	public DriverUtil(WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void maximizeBrowser() throws Exception {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw e;
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	protected WebElement findElement(By locator) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		return wait.until(d -> d.findElement(locator));
	}

	protected List<WebElement> findElements(By locator) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		return wait.until(d -> d.findElements(locator));
	}

	protected boolean elementVisible(By locator, int timeOut) {
		boolean flag;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			flag = true;
		} catch (Exception ex) {
			flag = false;
		}
		return flag;
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void hoverOverAndClick(By locator, By target) {
		Actions action = new Actions(driver);
		WebElement filter = driver.findElement(locator);
		action.moveToElement(filter).perform();
		driver.findElement(target).click();
	}
}
