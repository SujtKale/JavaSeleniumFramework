package rahulshettyacadamy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacadamy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;

	
	public LandingPage(WebDriver driver) {
		//Initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		//When we create object of class then first constructor will execute
		
		//WebElement userEmails=driver.findElement(By.xpath("//input[@id='userEmail']"));
	}
	
	@FindBy(id="userEmail")
	WebElement userEmails;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(css="input.login-btn")
	WebElement submit;
	
	public ProductCatalouge loginApplication(String email, String password) {
		userEmails.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();		
		ProductCatalouge productCatalouge = new ProductCatalouge (driver) ;
		return productCatalouge;
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}

}
