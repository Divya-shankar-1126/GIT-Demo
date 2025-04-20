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

public class CheckoutPage extends AbstractCompo {
	WebDriver driver;

	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);  // Initializes elements @FindBy
	}

	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement cvv;
	
	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement name;
	
	@FindBy(css = "[placeholder='Select Country']") 
	WebElement selectCountry;
	
	@FindBy(css = ".ta-item:nth-of-type(2)") 
	WebElement countryoption;
	
	@FindBy(css = ".action__submit") 
	WebElement submit;
	
	By sec = By.cssSelector("section.ta-results");
	
	
	public void cardDetails(String cv, String nam)
	{
		cvv.sendKeys(cv);
		name.sendKeys(nam);
	}
	public ConfirmationPage mouse(String country)
	{
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry, country).build().perform();
		ElementToAppear(sec);
		countryoption.click();
		submit.click();
		ConfirmationPage confirmpage = new ConfirmationPage(driver);
		return confirmpage;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
