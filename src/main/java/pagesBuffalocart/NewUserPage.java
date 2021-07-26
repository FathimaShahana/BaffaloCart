package pagesBuffalocart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUserPage {
	WebDriver driver;

	public NewUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='New User']")
	public WebElement SelectionOfNewUserPage;


	// driver.findElement(By.xpath("//a[text()='New User']")).click();
	@FindBy(xpath = "//input[@name='fullname']")
	public WebElement FullNameInputField;

	@FindBy(xpath = "//input[@id='check_employment_id']")
	public WebElement EmployeeIdInputField;

	@FindBy(xpath = "//input[@id='check_username']")
	public WebElement UserNameInputField;

	@FindBy(xpath = "//input[@id='new_password']")
	public WebElement PasswordInputField;

	@FindBy(xpath = "//input[@name='confirm_password']")
	public WebElement ConfirmPasswordInputField;

	@FindBy(xpath = "//input[@name='confirm_password']")
	public WebElement EmailIdField;

	@FindBy(xpath = "//select[@id='user_type']")
	public WebElement SelectDropdownUserType;

	public void selectNewUserpage() {
		SelectionOfNewUserPage.click();
	}

	public void enterFullname() {
		// boolean display = verifyNewUserPage.isDisplayed();
		FullNameInputField.sendKeys("User1");
	}

	public void enterEmployeeId() {
		EmployeeIdInputField.sendKeys("EId12345");
	}

	public void enterUserName() {
		UserNameInputField.sendKeys("User1UserName");
	}

	public void enterPassword() {
		PasswordInputField.sendKeys("Password123");
	}

	public void enterConfirmPassword() {
		ConfirmPasswordInputField.sendKeys("Password123");
	}

	public void enterEmailId() {
		EmailIdField.sendKeys("abcd@gmailcom");
	}

	public void verifySelectUserTypeDropDown() {

		SelectDropdownUserType.getText();
		SelectDropdownUserType.click();

	}
}
