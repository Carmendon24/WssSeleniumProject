package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductResultsPage {

	WebDriver driver;
	
	public ProductResultsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Last Product Search Result Locator
	By addLastToCart = By.xpath("//div[@id='ProductBoxContainer'][last()]//input[@name='addToCartButton']");
	
    
	//Select Last Product Search Result Method
	public void selectLastProduct() {
    		driver.findElement(addLastToCart).click();
	}
 
}
