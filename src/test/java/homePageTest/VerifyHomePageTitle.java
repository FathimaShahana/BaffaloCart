package homePageTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesBuffalocart.HomePage;
import pagesBuffalocart.LoginPage;

public class VerifyHomePageTitle extends HomePageBaseTest{

	@Test
	public void verifyPageTitle() {
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.GetTitle().equalsIgnoreCase("codecarrots"));
	}

}
