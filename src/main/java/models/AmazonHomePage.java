package models;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AmazonHomePage extends BasePage {
	private final Page page;

	private final String locator_hamburger = "[aria-label=\"Open Menu\"]";
	private final String itemFromList = "a-size-base-plus a-color-base a-text-normal";
	                                     
	public AmazonHomePage(String browserName, String mode) {
		// Page page = context.newPage();
		Browser browser = this.launchPlaywright(browserName, mode);
		BrowserContext context = browser.newContext();

		this.page = context.newPage();

		this.initialize(page);

	}

	public void navigate() {
		page.navigate("https://amazon.in");
	}

	public void clickHamburger() {
		this.page.click(locator_hamburger);
	}

	public Page searchForAnItem(String testData[]) {
		this.clickHamburger();

		this.clickLinkText(testData[0]);

		page.click("text=" + testData[1]);

		page.waitForNavigation(() -> {

			page.click("xpath=//span[@class='a-size-base a-color-base'][normalize-space()='" + testData[2] + "']");
		});

		page.click("text=Sort by:Featured");

		page.waitForNavigation(() -> {
			this.clickLinkText(testData[3]);

		});
		

//		Page page1 = page.waitForPopup(() -> {
//			page.click(
//					 this.itemFromList + "[" + testData[4] +  "]");
//		});
		return page;
		

	}
}