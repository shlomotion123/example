package models;

import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class BasePage {
    protected Page page;
    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
   

    public void initialize(final Page page) {
        this.page = page;
    }
    public void clickLinkText(String text)
	  {
		  this.page.click("a:has-text(\"" + text + "\")");
	  }
    
   
    public Browser launchPlaywright(String browserName, String headless) {
        playwright = Playwright.create();
        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("msedge")
                || browserName.equalsIgnoreCase("chromium")) {
            browserType = playwright.chromium();
        } else if (browserName.equalsIgnoreCase("webkit")) {
            browserType = playwright.webkit();
        }
        if (headless.equalsIgnoreCase("true")) {
            browser =  browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        } else {
        	//playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        }
        return browser;
        
     
      
    }

//    public void captureScreenshot(final Path fileName) {
//        page.screenshot(
//                new Page.ScreenshotOptions().setPath(
//                		fileName
//                       
//                        )
//                ).setFullPage(true)
//        
//    }
}
