package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {

	WebDriver driver;
	
	public Cart(WebDriver driver) {
		this.driver=driver;
	}
	
	//Empty Cart Button Locator
	By emptyCart = By.cssSelector(".emptyCartButton");
	
	//Empty Cart Confirm Button Locator	    
	By emptyCartConfirm = By.cssSelector(".text-shadow-black-60");
	
	//Select Empty Cart Method
	public void emptyCart() {
	driver.findElement(emptyCart).click();
	}
	
	//Select Confirm Empty Cart Method
	public void emptyCartConfirm() {
	driver.findElement(emptyCartConfirm).click();
	}
    
}
