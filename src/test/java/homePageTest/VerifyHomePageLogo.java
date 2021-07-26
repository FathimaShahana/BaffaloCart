package homePageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagesBuffalocart.HomePage;
import pagesBuffalocart.LoginPage;

public class VerifyHomePageLogo extends HomePageBaseTest {
	
	//WebDriver driver;

	
	@Test
	public void verifyAussieTimeSheetsimg() {
		HomePage homepage = new HomePage(driver);
	
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(homepage.logoImage));
		//WebDriverWait wait1 = new WebDriverWait(driver,60);
		//wait1.until(ExpectedConditions.)
		
		boolean isImageDisplayed = homepage.logoImage.isDisplayed();
		
		Assert.assertTrue(isImageDisplayed);
	}

}
