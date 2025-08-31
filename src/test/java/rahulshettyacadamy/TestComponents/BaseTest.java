package rahulshettyacadamy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulshettyacadamy.pageobjects.LandingPage;

public class BaseTest {
	
	
	public WebDriver driver;
	
	public LandingPage landingPage;
	
	
	public WebDriver InitializeBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacdamy\\resources\\GlobalData.properties");
	prop.load(fis);
	String browserName  =prop.getProperty("browser");
	
	
	
	if (browserName.equalsIgnoreCase("chrome")) {

		//Properties class
		driver = new ChromeDriver();
		
	}
	
	else if (browserName.equalsIgnoreCase("Edge")) {
		 driver = new EdgeDriver();
	}
	
	else if(browserName.equalsIgnoreCase("Firefox")) {
		 driver = new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	return driver;
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage LaunchingApp() throws IOException {
		driver=InitializeBrowser();
		 landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}
	
	
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.close();
		}
	
	
	
}
	

