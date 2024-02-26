package WebstaurantStore.CarmensMavenProject;

import java.time.Duration;
import java.util.List;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Cart;
import pages.GlobalSiteHeader;
import pages.ProductResultsPage;

public class WssTest {

	@Test
	public static void main(String[] args) {

		//Creating Chrome WebDriver instance
/*		 
		//Uncomment this section for WebDriverManager use
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
*/
		WebDriver driver = new ChromeDriver();


		//Creating object of Global Site Header page
		GlobalSiteHeader header = new GlobalSiteHeader(driver);
			
		//Creating object of Product Search Results page
		ProductResultsPage searchResults = new ProductResultsPage(driver);
				
		//Creating object of Cart page
		Cart cart = new Cart(driver);
				
		SoftAssert softAssert = new SoftAssert();
				

		//Navigate to WebstaurantStore.com
		driver.get("https://www.webstaurantstore.com/");
		
		//Maximize browser window
		driver.manage().window().maximize();
			    	
		//Perform keyword search
		header.enterSearchTerm("stainless work table");
		header.submitSearch();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
		// Gather Product search results and Validate search term text is included in Title
		String searchTerm = "Table";// <-- Change to any value not in the search result Product text and assertion will fail
	
		List<WebElement> results = driver.findElements(By.id("ProductBoxContainer"));
		
	    	try {
			for (int i = 0; i < results.size(); i++) {
		 	       softAssert.assertTrue(results.get(i).getText().contains(searchTerm), searchTerm + " text does NOT exist in Title for Product.");
		    		}
			} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			throw e;
		}

	    
		//Add Last Product of search results to Cart
	    	searchResults.selectLastProduct();
	    
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		//View Cart
		header.viewCart();
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    
		//Empty Cart and Confirm
		cart.emptyCart();
		cart.emptyCartConfirm();
	    
		//Close browser session
		driver.quit();
		
		softAssert.assertAll();
		
		}

}
