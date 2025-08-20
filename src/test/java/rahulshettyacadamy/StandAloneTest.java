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

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("sujitkale3767@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Test@123");
		driver.findElement(By.cssSelector("input.login-btn")).click();
		String productName = "ZARA COAT 3";
		driver.manage().window().maximize();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector("div.mb-3"));
		System.out.println(products.size());

		/*
		 * WebElement prod = products.stream().filter(product ->
		 * product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).
		 * findFirst().orElse(null);
		 * prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 */

		for (WebElement product : products) {

			if (product.getText().contains(productName)) {
				driver.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
			}
		}

		// div.toast-success

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.toast-success")));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner.ng-tns-c11-0")));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		boolean match = driver.findElement(By.xpath("//div[@class='cartSection']/h3")).getText().equals(productName);

		Assert.assertTrue(match);
		driver.findElement(By.xpath("//*[text()='Checkout']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 50)");
		/*
		 * driver.findElement(By.xpath("//input[@placeholder='Select Country']")).
		 * sendKeys("ind"); driver.findElement(
		 * By.xpath("//*[text()=' India']")).click();
		 */

		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		WebElement listOfCountry = driver
				.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']"));
		w.until(ExpectedConditions.visibilityOf(listOfCountry));
		WebElement country = driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[2]"));
		country.click();
		driver.findElement(By.cssSelector("a.action__submit")).click();

		String confirmationMessage = driver.findElement(By.cssSelector("h1.hero-primary")).getText();
		System.out.println(confirmationMessage);

		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}
}
