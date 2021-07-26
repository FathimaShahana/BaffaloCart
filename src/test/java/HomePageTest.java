import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pagesBuffalocart.HomePage;
import pagesBuffalocart.LoginPage;

public class HomePageTest {
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void initializeDriver() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\webdrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();// create object of browser, like a= this is assigned to a
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@BeforeMethod(alwaysRun = true) 
	public void SigintoBrowser() {
		driver.get("https://erp.buffalocart.com/login");// browsergets open now login so need username element
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("admin", "123456");
	}

	@Test(priority=0,groups = { "Homepagegroup1", "Homepagegroup2" })
	public void verifyPageTitle() {
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.GetTitle().equalsIgnoreCase("codecarrots"));
	}

	@Test(priority=1,groups= {"Homepagegroup1"})
	public void verifyAussieTimeSheetsimg() {
		HomePage homepage = new HomePage(driver);// 2window not possible when static varble use so use it/mutilpletest
													// not possible in static
		boolean isImageDisplayed = homepage.logoImage.isDisplayed();
		
		Assert.assertTrue(isImageDisplayed);
	}

	@Test(priority=2,groups= {"Homepagegroup1"})
	public void verifyUsersMenuAvailable() {

		HomePage homepage = new HomePage(driver);
		homepage.verifySearchUserInMenu();
		Assert.assertTrue(homepage.SearchResultUser.isDisplayed());
	}

	@Test(priority=3,groups= {"Homepagegroup1"})
	public void verifyLanguagesLinkIsAvailable() {
		HomePage homepage = new HomePage(driver);
		boolean isLangaugeLinkAvailable = (homepage.LanguageLink != null);

		Assert.assertTrue(homepage.LanguageLink.isDisplayed());
	}

	@Test(priority=4,groups= {"Homepagegroup2"})
	public void verifyTodaysDate() { 		// Verifying currentdate and system's date is same

		HomePage homepage = new HomePage(driver);
		
		Date actualDate = homepage.getDateShownOnTheScreen();
//		
//		Date tempDate = new Date("Sunday 18th July - 2021");
//		Date dateFromScreen = new Date(dateStringFromScreen);
//		DateFormat dateFormat = new SimpleDateFormat("dd");
		
		// get current date time with Date()
		Date currentDate = new Date();

		// Now format the date
//		String expectedDateValue = dateFormat.format(currentDate);
//		String actualDateValue = dateFormat.format(dateFromScreen);

		Assert.assertEquals(actualDate.getDate(), currentDate.getDate());
		Assert.assertEquals(actualDate.getMonth(), currentDate.getMonth());
		Assert.assertEquals(actualDate.getYear(), currentDate.getYear());
	}
	
	
	@AfterMethod	
	public void signOut()
	{
		HomePage homepage = new HomePage(driver);
		homepage.doLogOut();
		
	}
	
	@AfterClass
	public void windowQuit()
	{
		driver.quit();
	}
	
}
