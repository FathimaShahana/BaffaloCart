package pagesBuffalocart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	// locators
	@FindBy(xpath = "//input[@name='user_name']") // findelementsbyname//
	public WebElement userNameInputField;

	@FindBy(name = "password")
	public WebElement passwordInputField;

	@FindBy(xpath = "//button[@class='btn btn-primary  btn-flat']")
	public WebElement SigninButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;// driver mthd contstr variabledriver,thidriver this class
		PageFactory.initElements(driver, this);// instead of driver.findelement,instead of calling driver. give object.
	}// sendkeys click occure in driver,object of this class contain
		// signinbtton,userpage with xpathy.so loading

	// tc
	public void login(String userName, String password) {
		enterUserName(userName);//
		enterPassword(password);
		enterSignin();
	}

	// operations
	private void enterSignin() 
	{
		SigninButton.click(); // webelem
	}

	private void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}

	private void enterUserName(String userName) {
		userNameInputField.sendKeys(userName);
	}
}
