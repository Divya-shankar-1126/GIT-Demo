package Divyalearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ReusableMethod.AbstractCompo;

public class ProductCatalogue extends AbstractCompo {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);  // Initializes elements @FindBy
	}
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = "li button[class='btn btn-primary']:last-of-type")
	WebElement checkout;
	
	By productsby = By.cssSelector(".mb-3");
	By addtocart = By.xpath("//button[@class='btn w-10 rounded']");
	By toastMsg = By.cssSelector("#toast-container");
	
	public List<WebElement> listingproducts()
	{
		//ElementToAppear(productsby);
		return products;
	}
	
	public WebElement getProductByName(String productname)
	{
		WebElement prod = listingproducts().stream().filter(p -> p.getText().contains(productname)).findFirst().orElse(null);
		return prod;
		
	}
	
	public CartPage addToCart(String productname)
	{
		WebElement prod = getProductByName(productname);
		prod.findElement(addtocart).click();
		ElementToAppear(toastMsg);
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
