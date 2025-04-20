	package Divyalearning.tests;
	
	import java.time.Duration;
	import java.util.List;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
	
	
	public class StandAlonetest2 {
	
		public static void main(String[] args) throws InterruptedException {
			String Productname = "ZARA COAT 3";
			WebDriverManager.chromedriver().setup(); //latest form instead of system .set
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://rahulshettyacademy.com/client");
			driver.findElement(By.id("userEmail")).sendKeys("divyarun@gmail.com");
			driver.findElement(By.id("userPassword")).sendKeys("Arun@2611");
			driver.findElement(By.id("login")).click();
			
			//Explicit Wait		
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
			List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
			WebElement prod = products.stream().filter(p->p.getText().contains(Productname)).findFirst().orElse(null);
			prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));//waiting untill toast msg displyed
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating"))); //wait untill loading invisible
			
			driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
			List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));
			Boolean match = cart.stream().anyMatch(c->c.getText().contains(Productname));
			Assert.assertTrue(match);
			
			driver.findElement(By.cssSelector("li button[class='btn btn-primary']:last-of-type")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("443");
			driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Divya");
			Actions a = new Actions(driver);
			a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "Ind").build().perform();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("section.ta-results")));
			driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
			driver.findElement(By.cssSelector(".action__submit")).click();
			String t = driver.findElement(By.cssSelector(".hero-primary")).getText();
			Assert.assertTrue(t.equalsIgnoreCase("Thankyou for the order."));
			
			driver.close();
		}
	
	}
