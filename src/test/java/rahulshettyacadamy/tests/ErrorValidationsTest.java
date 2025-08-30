package rahulshettyacadamy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacadamy.TestComponents.BaseTest;
import rahulshettyacadamy.pageobjects.CartPage;
import rahulshettyacadamy.pageobjects.ProductCatalouge;

public class ErrorValidationsTest extends BaseTest {

	@Test
	public void loginErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";
		ProductCatalouge productCatalouge=landingPage.loginApplication("sujitkale3767@gmail.com", "Wrong@123");
		Assert.assertEquals(" Incorrect email or password. ", landingPage.getErrorMessage());

	}

	@Test
	public void productErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";
		ProductCatalouge productCatalouge = landingPage.loginApplication("sujitkale3767@gmail.com", "Test@123");

		List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addToCart(productName);

		CartPage cartPage = productCatalouge.goToMyCartPage();

		boolean match = cartPage.validationOfProductNameOnMyCartPage("zara coat 22");
		Assert.assertFalse(match);

	}

}
