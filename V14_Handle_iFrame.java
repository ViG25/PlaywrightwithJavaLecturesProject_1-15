package gettingstarted;

import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V14_Handle_iFrame {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page = browser.newPage();
		page.navigate("https://www.redbus.in/");
		page.locator("//span[text()='Account']").click();
		page.locator("#user_sign_in_sign_up").click();
		
		List <Frame> allIframes = page.frames();
		System.out.println("Total Number of Frames "+allIframes.size());
		
		// 1st way to code create object  (Here FrameLocater will be imported above)
//		FrameLocator iframe1 = page.frameLocator("//iframe[@class='modalIframe']");
//		iframe1.locator("#mobileNoInp").fill("8881212");
		
		// 2nd way to code without object - shortcut
//		page.frameLocator("//iframe[@class='modalIframe']").locator("#mobileNoInp").fill("8881212");
		
		// 3rd way to code first identify Frame and next its pattern
		Frame iframe1 = page.frameByUrl(Pattern.compile(".*login.*"));
		iframe1.locator("#mobileNoInp").fill("8881212");
			
		
		 
		page.close();
		browser.close();

	}

}
