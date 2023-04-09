package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(xpath = "//div[text()='100% SECURE']")
	private WebElement pageHeader;
	@FindBy(xpath = "//a[text()='Men Beige & Black Typography Printed Sustainable T-shirt']")
	private WebElement product;
	
	
    public CartPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public WebElement pageHeader()
    {
    	return pageHeader;
    }
    
    public WebElement getProduct()
    {
    	return product;
    }

}
