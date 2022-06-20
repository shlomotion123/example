package models;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ItemsPage extends BasePage {
	
	
	 protected Page page;
	 protected Page page1;
	
	 Playwright playwright;
	
	 private final String itemFromList = "a-size-base-plus a-color-base a-text-normal";
	
	
	public ItemsPage(Page page) {
		this.page = page;
	}

	public void clickOnSelectedItem(String itemNumber)
	{

		 this.page1 = page.waitForPopup(() -> {
			 
				page.locator("img[data-image-index=\"" + itemNumber + "\"]").click();
	        });
	
	}
	public boolean verifyTextOnAPage(String text)
	{
		
		this.page1.waitForSelector("text=" + text);
		Locator locator = this.page1.locator("text=" + text);
		System.out.println(locator.count());
		if (locator.count() > 0)
			return true;
		
		return false;
		
	}
	
}
	
	

