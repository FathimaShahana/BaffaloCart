import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagesBuffalocart.HomePage;
import pagesBuffalocart.LoginPage;
import pagesBuffalocart.NewUserPage;

public class NewUserPageTest {

	WebDriver driver;

	@BeforeClass

	public void initializeDriver() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\webdrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();// create object of browser, like a= this is assigned to a
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// }
		//
		// @BeforeMethod
		// public void SigintoBrowser() {
		driver.get("https://erp.buffalocart.com/login");// browsergets open now login so need username element
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("admin", "123456");
		driver.navigate().to("https://erp.buffalocart.com/admin/user/user_list");// navigate to this URL
	}

	@Test
	public void verifyUserDetails() {
		NewUserPage newuserpage = new NewUserPage(driver);

		// driver.navigate().to("https://erp.buffalocart.com/admin/user/user_list");//navigate
		// to this URL
		Assert.assertEquals(driver.getTitle(), "User List");
		// Assert.assertTrue(newuserpage.SelectNewUserListPage.isDisplayed());

	}

	@Test
	public void verifySelectUserTypeDropDown() {
		NewUserPage newuserpage = new NewUserPage(driver);
		newuserpage.selectNewUserpage();
		newuserpage.enterFullname();
		newuserpage.enterUserName();
		newuserpage.enterEmployeeId();
		newuserpage.enterPassword();
		// Assert.assertEquals(newuserpage.SelectDropdownUserType,"");
		Assert.assertTrue(newuserpage.SelectDropdownUserType.isDisplayed());

	}

	/// dropdown verification

	/*
	 * / WebElement UserLocalwebElement
	 * =driver.findElement(By.className("select2-search__field")); Select
	 * UserLocalDropdown =new Select(UserLocalwebElement);
	 * UserLocalDropdown.selectByIndex(0);//index 0 contain admin,1 is staff& 3 is
	 * client
	 * 
	 * WebElement UserLanguagewebElement
	 * =driver.findElement(By.className("select2-selection__rendered")); Select
	 * UserLanguageDropdown =new Select(UserLanguageDropdown);
	 * UserLanguageDropdown.selectByIndex(0);
	 */
	// cnt use select bcz it tag is /aso use xpath

	// DIFFERENCE METHODS OF DRPDOWN SELECTION
	// public void userTypeSelection()
	// {
	// UserPage userpage= new UserPage(driver);
	// Select UserTypeselect =new Select(UserTypeselect);//use select class
	// @AfterClass
	/// public void quit()
	// {
	// driver.close();
	// driver.quit();
	// }
}
