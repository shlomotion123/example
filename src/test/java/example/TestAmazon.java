package example;

import models.AmazonHomePage;
import com.microsoft.playwright.*;

import static org.junit.Assert.*;
import java.util.Collection;


import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAmazon {

	@DataProvider(name = "data-provider")
	public static Object[][] dataProviderMethod() {
		return new Object[][] {{"TV, Appliances, Electronics",
			"Television", 
			"Samsung", 
			"Price: High to Low",
			"About this item"}};
	}
	@Test(dataProvider = "data-provider")

	public void test(String data[]) {


		AmazonHomePage homePage = new AmazonHomePage("Chrome", "Headed");
		homePage.navigate();
		Assert.assertTrue(homePage.searchForAnItem(data));

		//}
	}
}


