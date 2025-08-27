package rahulshettyacadamy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacadamy.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryTextBox;
	
	@FindBy(xpath="(//span[@class='ng-star-inserted'])[2]")
	WebElement country;
	
	By countryList = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	
	
	@FindBy(css="a.action__submit")
    WebElement submitButton;
	
	
	public void selectCountry(String countryName) {
		
		Actions act = new Actions(driver);
		act.sendKeys(countryTextBox, countryName).build().perform();
		waitUntilVisibilityOfElement(countryList);
		country.click();
	}
	
	
	public ConfirmationPage placeOrderClick() {
		
		submitButton.click();
		
		ConfirmationPage confirmationPage =	new ConfirmationPage(driver);
		return confirmationPage;
		
	}

}
