package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genricLibraries.WebDriverUtility;

public class HomePage {

	@FindBy(xpath = "//a[@class=\"myntraweb-sprite desktop-logo sprites-headerLogo\"]")
	private WebElement logo;
	@FindBy(xpath = "//input[@class=\"desktop-searchBar\"]")
	private WebElement searchTF;
	@FindBy(xpath = "//a[@class=\"desktop-submit\"]")
	private WebElement searchButton;
	@FindBy(xpath = "//ul[@class=\"gender-list\"]/child::li/child::label[text()='Men']")
	private WebElement selectMen;
	@FindBy(xpath = "//h4[.='Men Cotton Pure Cotton T-shirt']")
	private WebElement tshirt;
	@FindBy(xpath = "//a[@data-group='women']")
	private WebElement womenTab;
	@FindBy(xpath = "//a[text()='Sunglasses & Frames' and contains(@href,'women-sunglasses')]")
	private WebElement sunglass;
	@FindBy(xpath ="//a[text()='Blog']") private WebElement blog;
	@FindBy(xpath ="//img[@class=\"img-responsive\" and @alt=\"Huetrap Men Beige & Black Typography Printed Sustainable T-shirt\"]")
	private WebElement tshirtlogo;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogo() {
		return logo;
	}

	public void SearchFor(String data) {
		searchTF.sendKeys(data);
		searchButton.click();
	}

	public void selectGender() {
		selectMen.click();
	}

	public void clickOnSelectedTshirt() {
		tshirt.click();
	}

	public void mouseHoverTowomenTab(WebDriverUtility web) {
		web.mouseHover(womenTab);
	}

	public void clickSunglassAndFrames() {
		sunglass.click();
	}
	public void scrollTillBlog(WebDriverUtility web) {
		web.scrollToElement(blog);
	}
	public void clickOnBlog() {
		blog.click();
	}
	

}
