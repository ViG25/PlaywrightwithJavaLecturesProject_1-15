package gettingstarted;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class V11_ClickFor_JS_Prompt {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page = browser.newPage();
		
		page.navigate("https://practice.expandtesting.com/js-dialogs?utm_source=chatgpt.com");
		
		page.onDialog(dialog -> 
		{
			String jsPromptMsg = dialog.message();
			System.out.println("Prmpt dialog message is - "+jsPromptMsg);
			Assert.assertTrue(jsPromptMsg.contains("I am a Js prompt"));
			dialog.accept("Vinod Katekar");
		});
		
		page.locator("#js-prompt").click();
		
		String innerTextSaved = page.locator("#dialog-response").innerText();
		System.out.println(innerTextSaved);
		page.close();
		
	}

}
