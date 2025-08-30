package rahulshettyacadamy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacadamy.TestComponents.BaseTest;
import rahulshettyacadamy.pageobjects.CartPage;
import rahulshettyacadamy.pageobjects.CheckOutPage;
import rahulshettyacadamy.pageobjects.ConfirmationPage;
import rahulshettyacadamy.pageobjects.OrderPage;
import rahulshettyacadamy.pageobjects.ProductCatalouge;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException {

		String productName = "ZARA COAT 3";
		String countryName = "India";

		

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
		
	}
	
	//To verify that "ZARA COAT 3" is present on Orders Page
	
	
	@Test (dependsOnMethods ={"submitOrder"})
	public void orderHistoryTest() {
		String productName = "ZARA COAT 3";
		ProductCatalouge productCatalouge = landingPage.loginApplication("sujitkale3767@gmail.com", "Test@123");
		OrderPage orderPage =productCatalouge.goToMyOrdersPage();
	boolean match =	orderPage.validationOfProductNameOnMyOrderPage(productName);
	
	Assert.assertTrue(match);
		
	}

}
