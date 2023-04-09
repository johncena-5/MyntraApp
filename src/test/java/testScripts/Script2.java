package testScripts;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genricLibraries.BaseClass;

public class Script2 extends BaseClass{
	
	@Test
	public void secondTest()
	{
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(home.getLogo().isDisplayed());
		home.mouseHoverTowomenTab(web);
		home.clickSunglassAndFrames();
		home.scrollTillBlog(web);
		home.clickOnBlog();
		soft.assertTrue(blog.pageHeader().isDisplayed());
		blog.scrollTillEmailTF(web);
		List<String> data = excel.fetchDataFromExcel("Sheet1");
		blog.enterEmail(data.get(1));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		blog.clickOnSuscribeButton();
		soft.assertAll();
	}

}
