package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genricLibraries.WebDriverUtility;

public class BlogPage {
	
	@FindBy(xpath = "//h2[text()='Subscribe to our newsletter']")private WebElement pageHeader;
	@FindBy(name ="email") private WebElement emailTF;
	@FindBy(name ="submit")private WebElement subscribe;
	
	
	public BlogPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement pageHeader() {
		return pageHeader;
	}
	public void scrollTillEmailTF(WebDriverUtility web)
	{
		web.scrollToElement(emailTF);
	}
	public void enterEmail(String data)
	{
		emailTF.sendKeys(data);
	}
	public void clickOnSuscribeButton()
	{
		subscribe.click();
	}
	

}
