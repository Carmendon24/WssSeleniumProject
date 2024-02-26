package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GlobalSiteHeader {

	WebDriver driver;
		
	public GlobalSiteHeader(WebDriver driver) {
		this.driver=driver;
	}
	    
	//Global Search Field Locator
	By searchField = By.id("searchval");
		
	//View Cart Button Locator
	By cartButton = By.linkText("View Cart");
		

	//Enter Keyword Search Term Method
	public void enterSearchTerm(String search) {
		driver.findElement(searchField).sendKeys(search);
	}

	//Submit Keyword Search Method
	public void submitSearch() {
		driver.findElement(searchField).submit();
	}
	   
	//Select View Cart Method
	public void viewCart() {
	    	driver.findElement(cartButton).click();
	}

}

