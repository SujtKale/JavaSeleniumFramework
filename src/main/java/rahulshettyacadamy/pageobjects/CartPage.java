package rahulshettyacadamy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacadamy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {

		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}



	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	WebElement orderPage;
	
	@FindBy(xpath="//*[text()='Checkout']")
	WebElement checkoutButton;
	

	
	public CheckOutPage clickOnCheckOut() {
		checkoutButton.click();
		CheckOutPage checkOutPage =new CheckOutPage(driver);
		return checkOutPage;

	}


	public boolean validationOfProductNameOnMyCartPage(String productName) {
		boolean isCorrectProduct =orderPage.getText().equalsIgnoreCase(productName);
		System.out.println("The given product is:" + isCorrectProduct );
		 return isCorrectProduct;
		
	}
	

	
}
