import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagesBuffalocart.AllUsersPage;
import pagesBuffalocart.LoginPage;

public class AllUsersPageTest {
	WebDriver driver;

	@BeforeClass
	public void initializeDriver() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\webdrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();// create object of browser, like a= this is assigned to a
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://erp.buffalocart.com/login");// browsergets open now login so need username element
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("admin", "123456");
		driver.navigate().to("https://erp.buffalocart.com/admin/user/user_list");

	}

	// public void xpathIdentification()
	// {
	// driver.navigate().to("https://erp.buffalocart.com/admin/user/user_list");
	//
	// Assert.assertEquals(driver.getTitle(), "User List");
	// System.out.println( driver.getTitle());
	@Test
	public void verifyUserListContainOb() {
		AllUsersPage alluserspage = new AllUsersPage(driver);

		List<String> usersList = alluserspage.getUserListContainUserNameOb();

		int actualTest = usersList.size();
		
		int expectedSize = 3;
		
		Assert.assertEquals(actualTest, expectedSize);
	}

	@Test
	public void verifyDemo() {
		AllUsersPage alluserspage = new AllUsersPage(driver);
		Assert.assertTrue(alluserspage.Dispalydemo.isDisplayed());

	}
	// List<WebElement>UserListContainOb =
	// driver.findElements(By.xpath("//td[contains(text(),'ob')][1]]"));
	// System.out.println(UserListContainOb);

	// verify userlist contains username ob
	// public void verifyUserNameContainOb()
	// {
	// AllUsersPage alluserspage= new AllUsersPage(driver);
	//
	//
	// List<WebElement> UserListContainOb =
	// driver.findElements(By.xpath("//tr[starts-with(@id,'table_')]//td[3][contains(text(),'ob')]"));
	// //driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
	// System.out.println(UserListContainOb.size());
	//
	// for (WebElement i: UserListContainOb)//for(int i:)
	// {
	// System.out.println(i.getText());
	// }
	// }

	// verify demo
	// List<WebElement> UserTypewebElement
	// =driver.findElements(By.xpath("//a[contains(text(),'demo')]"));
	//
	// System.out.println(UserTypewebElement.size());
	// for (WebElement ele: UserTypewebElement)//for(int i:)
	// {
	// System.out.println(ele.getText());
	// }
	@AfterClass
	public void quit() {
		driver.quit();
	}
}