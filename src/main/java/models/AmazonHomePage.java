package models;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AmazonHomePage extends BasePage {
	private final Page page;

	private final String locator_hamburger = "[aria-label=\"Open Menu\"]";

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

	public boolean searchForAnItem(String text[]) {

		// page.click("[aria-label=\"Open Menu\"]");
		this.clickHamburger();

		this.clickLinkText(text[0]);

		page.click("text=" + text[1]);

		page.waitForNavigation(() -> {

			page.click("xpath=//span[@class='a-size-base a-color-base'][normalize-space()='" + text[2] + "']");
		});

		page.click("text=Sort by:Featured");

		page.waitForNavigation(() -> {
			this.clickLinkText(text[3]);

		});

		Page page1 = page.waitForPopup(() -> {
			page.click(
					"(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[2]");
		});
		Locator locator = page.locator(text[4]);
		if (locator != null)
			return true;
		return false;

	}
}