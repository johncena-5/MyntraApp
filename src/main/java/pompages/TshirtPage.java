package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TshirtPage {

	@FindBy(xpath = "//h1[text()='Huetrap']")
	private WebElement pageHeader;
	@FindBy(xpath = "//button[contains(@class,'size-buttons-size-button')]/child::p[text()='M']")
	private WebElement sizeM;
	@FindBy(xpath = "//div[text()='ADD TO BAG']")
	private WebElement addToBag;
	@FindBy(xpath = "//span[text()='GO TO BAG']")
	private WebElement goToBag;

	public TshirtPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement pageHeader()
	{
		return pageHeader;
	}
	public void selectSize()
	{
		sizeM.click();
	}
	public void addToBag()
	{
		addToBag.click();
	}
	public void goToBag()
	{
		goToBag.click();
	}

}
