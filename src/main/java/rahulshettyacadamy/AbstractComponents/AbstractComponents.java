package rahulshettyacadamy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacadamy.pageobjects.CartPage;
import rahulshettyacadamy.pageobjects.OrderPage;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;

	@FindBy(xpath="//*[contains(text(),'ORDERS')]")
	WebElement ordersButton;
	
	
	public void waitUntilVisibilityOfElement(By findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitUntilInvisibilityOfElement(By findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.invisibilityOfElementLocated(findBy));

		// w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner.ng-tns-c11-0")));
	}
	
	
	public void waitUntilVisibilityOfElements(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(element));
	}


	public CartPage goToMyCartPage() {

		cartButton.click();
		CartPage  cartPage = new CartPage(driver);
		return  cartPage;

	}

	
	public OrderPage goToMyOrdersPage() {
		
		ordersButton.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		
	}
	
}	

