package rahulshettyacadamy.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacadamy.TestComponents.BaseTest;
import rahulshettyacadamy.pageobjects.CartPage;
import rahulshettyacadamy.pageobjects.CheckOutPage;
import rahulshettyacadamy.pageobjects.ConfirmationPage;
import rahulshettyacadamy.pageobjects.OrderPage;
import rahulshettyacadamy.pageobjects.ProductCatalouge;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData", groups = { "PurchaseOrder" })
	
	
	public void submitOrder(HashMap <String,String> input) throws IOException {
		 //String productName ="IPHONE 13 PRO";
		
		String countryName = "India";

		ProductCatalouge productCatalouge = landingPage.loginApplication(input.get("email"), input.get("password") );

		List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addToCart(input.get("productName"));

		CartPage cartPage = productCatalouge.goToMyCartPage();

		boolean match = cartPage.validationOfProductNameOnMyCartPage(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.clickOnCheckOut();
		checkOutPage.scrollPage();
		checkOutPage.selectCountry(countryName);

		ConfirmationPage confirmationPage = checkOutPage.placeOrderClick();
		String message = confirmationPage.verifyConfrimationMessage();

		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));

	}

	// To verify that "ZARA COAT 3" is present on Orders Page

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistoryTest() {
		String productName = "ZARA COAT 3";
		ProductCatalouge productCatalouge = landingPage.loginApplication("sujitkale3767@gmail.com", "Test@123");
		OrderPage orderPage = productCatalouge.goToMyOrdersPage();
		boolean match = orderPage.validationOfProductNameOnMyOrderPage(productName);

		Assert.assertTrue(match);

	}

	/*@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "sujitkale3767@gmail.com", "Test@123", "ZARA COAT 3" },
				{ "sujitkale3767@gmail.com", "Test@123", "IPHONE 13 PRO" }

		};
	}*/
	
	@DataProvider 
	
	public Object getData() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "sujitkale3767@gmail.com");
		map.put("password", "Test@123");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "sujitkale3767@gmail.com");
		map1.put("password", "Test@123");
		map1.put("productName", "IPHONE 13 PRO");
		
		
		return new Object [][] {{map},{map1}};
	}
	

}
