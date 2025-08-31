package rahulshettyacadamy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacadamy.AbstractComponents.AbstractComponents;

public class ProductCatalouge extends AbstractComponents {

	WebDriver driver;

	public ProductCatalouge(WebDriver driver) {

		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

		// When we create object of class then first constructor will execute

		// List<WebElement> products = driver.findElements(By.cssSelector("div.mb-3"));
	}

	@FindBy(css = "div.mb-3")
	List<WebElement> products;

	By products1 = By.cssSelector("div.mb-3");
	By addToCart = By.xpath(".//button[@class='btn w-10 rounded']");
	By toastMessage = By.cssSelector("div.toast-success");
	By spinner = By.cssSelector("ngx-spinner.ng-tns-c11-0");

	public List<WebElement> getProductList() {

		waitUntilVisibilityOfElement(products1);
		return products;

	}

	public void addToCart(String productName) {
		for (WebElement product : products) {

			if (product.getText().contains(productName)) {
				product.findElement(addToCart).click();
				waitUntilVisibilityOfElement(toastMessage);
				waitUntilInvisibilityOfElement(spinner);

			}

		}

	}

}
