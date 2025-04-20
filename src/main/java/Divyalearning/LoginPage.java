package Divyalearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethod.AbstractCompo;

public class LoginPage extends AbstractCompo {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")  // Locate email input field
    WebElement username;

    @FindBy(id = "userPassword") // Locate password input field
    WebElement password;

    @FindBy(id = "login") // Locate login button
    WebElement submit;

    public ProductCatalogue value(String name, String pass) {
        username.sendKeys(name);  // Enter email
        password.sendKeys(pass);  // Enter password
        submit.click();  // Click login button

        return new ProductCatalogue(driver); // Navigate to ProductCatalogue page
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client"); // Open login page
    }
}
