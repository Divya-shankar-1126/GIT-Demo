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

public class CartPage extends AbstractCompo {
	WebDriver driver;

	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);  // Initializes elements @FindBy
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']") 
	WebElement cart;
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartList;
	
	@FindBy(css = "li button[class='btn btn-primary']:last-of-type")
	WebElement checkout;
	
	
	public void clickcart() throws InterruptedException
	{
		Thread.sleep(2000);
		cart.click();
	}
	
	public Boolean matchToOriginal(String Productname)
	{
		Boolean match = cartList.stream().anyMatch(c->c.getText().contains(Productname));
		return match;
	}
	
	public CheckoutPage checkoutButton()
	{
		checkout.click();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		return checkoutpage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
