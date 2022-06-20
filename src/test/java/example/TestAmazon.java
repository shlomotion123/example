package example;

import models.AmazonHomePage;
import models.ItemsPage;

import com.microsoft.playwright.*;

import java.util.Collection;

import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestAmazon {

	@DataProvider(name = "data-provider")
	public static Object[][] dataProviderMethod() {
		// Parameters. Main Category, Sub category, sort order, nth item on list, text to assert
		return new Object[][] {{"TV, Appliances, Electronics",
			"Television", 
			"Samsung", 
			"Price: High to Low",
			"2",
			// text to assert
		"About this item"}};
	}
	@Test(dataProvider = "data-provider")

	public void test(String data[]) {

		AmazonHomePage homePage = new AmazonHomePage("Chrome", "Headed");
		homePage.navigate();
		Page page = homePage.searchForAnItem(data);
		ItemsPage items = new ItemsPage(page);
		items.clickOnSelectedItem(data[4]); 
		Assert.assertTrue(items.verifyTextOnAPage (data[5]));
		homePage.closeBrowser();

	}
}


