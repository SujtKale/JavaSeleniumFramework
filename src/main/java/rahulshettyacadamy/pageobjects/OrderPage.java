package rahulshettyacadamy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacadamy.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {

	WebDriver driver;

	public OrderPage(WebDriver driver) {

		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> orderNames;

	public boolean validationOfProductNameOnMyOrderPage(String productName) {
		for (WebElement orderName : orderNames) {

			boolean isCorrectOrderName = orderName.getText().equalsIgnoreCase(productName);
			System.out.println("The given product is present on Orderpage:" + isCorrectOrderName);
			return isCorrectOrderName;
		}
		return false;

	}

}
