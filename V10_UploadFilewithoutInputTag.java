package gettingstarted;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class V10_UploadFilewithoutInputTag {

	public static void main(String[] args) {

		Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000)).newPage();

	      page.navigate("https://app.iriscarbon.com/#/login");
	      page.getByPlaceholder("abc@example.com").click();
	      page.getByPlaceholder("abc@example.com").fill("vinod.katekar@irisbusiness.com");
	      page.getByPlaceholder("●●●●●●●●").click();
	      page.getByPlaceholder("●●●●●●●●").fill("Vinod@12345");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("")).first().click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Edit")).click();
	      page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("")).click();
	      
	      // ()-> call back function
	      FileChooser filechooser = page.waitForFileChooser(()->page.locator("#file-dropzone2").click());
	      	      
	      // Single file upload following way
	      // filechooser.setFiles(Paths.get("D:\\Playwright_Feb_2025\\MavenFeb25\\Files\\MainDocument.htm"));
	      
	      // Multiple file upload following way
	      // 1st need to create path array
	      Path [] multipleFilesUpload = 
	    	  {
	    		  Paths.get("D:\\Playwright_Feb_2025\\MavenFeb25\\Files\\EXHIBIT311.htm"),
	    		  Paths.get("D:\\Playwright_Feb_2025\\MavenFeb25\\Files\\EXHIBIT312.htm"),
	    		  Paths.get("D:\\Playwright_Feb_2025\\MavenFeb25\\Files\\EXHIBIT32.htm")	    		  
	    	  };	      
	      filechooser.setFiles(multipleFilesUpload);
	      
	      // page.locator("#btnSkipDesc").click();
	      page.locator("#userLogo").click();
	      page.getByTitle("Sign Out").click();
	           
	}

}
