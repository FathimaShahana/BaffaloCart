package homePageTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pagesBuffalocart.HomePage;
import pagesBuffalocart.LoginPage;

public class HomePageBaseTest {
	WebDriver driver;
	@BeforeClass
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\webdrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();// create object of browser, like a= this is assigned to a
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void SigintoBrowser() {
		driver.get("https://erp.buffalocart.com/login");// browsergets open now login so need username element
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("admin", "123456");
	}
	
	@AfterMethod	
	public void signOut()
	{
		HomePage homepage = new HomePage(driver);
		homepage.doLogOut();
		
	}
	
	@AfterClass
	public void closeDriver()
	{
		driver.quit();
	}

}
