package testScripts;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genricLibraries.BaseClass;

public class Script1 extends BaseClass {
	
	@Test
	public void firstTest()
	{
		web.handleNotification();
	    SoftAssert soft = new SoftAssert();
	    soft.assertTrue(home.getLogo().isDisplayed());
	  
	    List<String> data = excel.fetchDataFromExcel("Sheet1");
		home.SearchFor(data.get(0));
		
	  
	    home.selectGender();
	    home.clickOnSelectedTshirt();
	    web.handleChildBrowser();
	    tshirt.selectSize();
	    tshirt.addToBag();
	    tshirt.goToBag();
	    soft.assertTrue(cart.pageHeader().isDisplayed());
	    soft.assertAll();
	}

}
