package genricLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	private WebDriver driver;

	public WebDriver openApplication(String browser, String url, long time) {

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return driver;
	}

	public void mouseHover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	public void dragAndDrop(WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}

	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	public void dropDown(WebElement element, int intex) {
		Select s = new Select(element);
		s.selectByIndex(intex);
	}

	public void dropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void dropDown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void switchFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchBackToFrame() {
		driver.switchTo().defaultContent();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
		;
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public void getText() {
		driver.switchTo().alert().getText();
	}

	public void switchToParentBrowser() {
		driver.switchTo().window(driver.getWindowHandle());
	}

	public void handleChildBrowser() {
		Set<String> child = driver.getWindowHandles();
		for (String string : child) {
			driver.switchTo().window(string);
		}
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void takeScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screen/shot.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void explicitlyWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void handleNotification() {
		HashMap<String, Integer> contentSettings = new HashMap();
		contentSettings.put("notifications", 2);

		HashMap<String, Object> profile = new HashMap();
		profile.put("managed_default_content_settings", contentSettings);

		HashMap<String, Object> preference = new HashMap();
		preference.put("profile", profile);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preference);
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void closeCurrentBrowser() {
		driver.close();
	}
}
