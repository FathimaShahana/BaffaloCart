package homePageTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pagesBuffalocart.HomePage;

public class verifyShoppingCartIcon extends HomePageBaseTest{
	@Test
	public void verifyShoppingCartIconisAvailable() 
	{
		HomePage homepage = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(homepage.ShoppingCartIcon));
		
		boolean IsDisplayed=homepage.shoppingCartIconIsDisplayed();
		//Assert.assertEquals(true, IsDisplayed);
		Assert.assertTrue(IsDisplayed);
	}

}
