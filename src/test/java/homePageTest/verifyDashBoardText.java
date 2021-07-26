package homePageTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pagesBuffalocart.HomePage;

public class verifyDashBoardText extends HomePageBaseTest{
	@Test
	public void verifyDashboardText() {
		HomePage homepage = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(homepage.DashBoardText));
		
		Assert.assertTrue("Dashboard".equalsIgnoreCase("DashBoard"));
	}

}
