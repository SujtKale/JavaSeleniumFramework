package rahulshettyacadamy.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
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
import org.testng.annotations.Test;

import rahulshettyacadamy.TestComponents.BaseTest;
import rahulshettyacadamy.pageobjects.CartPage;
import rahulshettyacadamy.pageobjects.CheckOutPage;
import rahulshettyacadamy.pageobjects.ConfirmationPage;
import rahulshettyacadamy.pageobjects.LandingPage;
import rahulshettyacadamy.pageobjects.ProductCatalouge;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException {

		String productName = "ZARA COAT 3";
		String countryName = "India";

		LandingPage landingPage = LaunchingApp();

		ProductCatalouge productCatalouge = landingPage.loginApplication("sujitkale3767@gmail.com", "Test@123");

		List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addToCart(productName);

		CartPage cartPage = productCatalouge.goToMyCartPage();

		boolean match = cartPage.validationOfProductNameOnMyCartPage(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.clickOnCheckOut();
		checkOutPage.scrollPage();
		checkOutPage.selectCountry(countryName);

		ConfirmationPage confirmationPage = checkOutPage.placeOrderClick();
		String message = confirmationPage.verifyConfrimationMessage();

		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}

}
