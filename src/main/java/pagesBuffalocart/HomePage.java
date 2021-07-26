package pagesBuffalocart;

import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='brand-logo']")
	public WebElement logoImage;

	@FindBy(xpath = "//input[@id='s-menu']")
	public WebElement SearchField;
	
	@FindBy(xpath = "//span[contains(text(),'User')]")
	public WebElement SearchResultUser;

	@FindBy(xpath = "//li[@class='dropdown']//a[@class='dropdown-toggle']")
	public WebElement LanguageLink;
	
	@FindBy(xpath = "//div[@class='pull-right']//small[@class='text-sm']")
	public WebElement DateDisplay;
	
	@FindBy(xpath = "//li[@class='dropdown user user-menu']")
	public WebElement TextDemoicon;

	@FindBy(xpath = "//button[@type=\"submit\"][text()=\"Log Out\"]")
	public WebElement LogOutButton;
	
	@FindBy(xpath = "//a[@class='text-muted']")
	public WebElement DashBoardText;
	
	

	@FindBy(xpath = "//a[@class='text-muted']")
	public WebElement ShoppingCartIcon;
	
	
	public String GetTitle()// image(findelementsby xpath)
	{
		return driver.getTitle();
		
	}

	
	public String verifyImageDisplay() {
		System.out.println("displayed image");
		return logoImage.getText();
	}

	public void verifySearchUserInMenu()// String Text)
	{
		SearchField.click();// enterText(SearchField.Text);
		SearchField.sendKeys("user");
		SearchField.sendKeys(Keys.ENTER);
	}

	public String getLanguageLinkAvailable() {
	return LanguageLink.getText();
	}

	public Date getDateShownOnTheScreen() {		
		String dateTimeString = DateDisplay.getText(); //Sunday 18th July - 2021,  Time  12:47:29
		String dateString = dateTimeString.split(",")[0].trim();  //Sunday 18th July - 2021
		
		String date = dateString.split(" ")[1].substring(0, 2); //18
		String month = dateString.split(" ")[2]; // July
		String year = dateString.split(" ")[4]; // 2021
		
		return new Date(date + " " + month + " " + year);
	}
	
	private void clickOnDemoicon()// image(findelementsby xpath)
	{
		TextDemoicon.click();
	}
	
	private void clickOnLogOut()// image(findelementsby xpath)
	{
		LogOutButton.click();
	}
	
	public void doLogOut()
	{
		clickOnDemoicon();
		clickOnLogOut();
	}
	public String DashBoardTextDisplayed()
	{
	return	DashBoardText.getText();
	}
	
	public boolean shoppingCartIconIsDisplayed()
	{
	return	ShoppingCartIcon.isDisplayed();
	}
	
	

}
