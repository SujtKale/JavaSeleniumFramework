package rahulshettyacadamy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshettyacadamy.pageobjects.CartPage;
import rahulshettyacadamy.pageobjects.CheckOutPage;
import rahulshettyacadamy.pageobjects.ConfirmationPage;
import rahulshettyacadamy.pageobjects.LandingPage;
import rahulshettyacadamy.pageobjects.ProductCatalouge;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		String productName = "ZARA COAT 3";
		String countryName = "India";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();

		ProductCatalouge productCatalouge = landingPage.loginApplication("sujitkale3767@gmail.com", "Test@123");

		List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addToCart(productName);
		CartPage cartPage = productCatalouge.goToMyCartPage();

		boolean match = cartPage.validationOfProductNameOnMyCartPage(productName);
		Assert.assertTrue(match);
		cartPage.clickOnCheckOut();
		cartPage.scrollPage();

		CheckOutPage checkOutPage = new CheckOutPage(driver);
		checkOutPage.selectCountry(countryName);
		checkOutPage.placeOrderClick();

		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		String message = confirmationPage.verifyConfrimationMessage();

		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));

	}
}
