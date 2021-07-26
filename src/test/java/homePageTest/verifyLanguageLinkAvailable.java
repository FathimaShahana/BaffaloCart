package homePageTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pagesBuffalocart.HomePage;



public class verifyLanguageLinkAvailable extends HomePageBaseTest {
	@Test
	public void verifyLanguagesLinkIsAvailable() {
		HomePage homepage = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(homepage.LanguageLink));
		
		boolean isLangaugeLinkAvailable = (homepage.LanguageLink != null);

		Assert.assertTrue(homepage.LanguageLink.isDisplayed());
	}

}
