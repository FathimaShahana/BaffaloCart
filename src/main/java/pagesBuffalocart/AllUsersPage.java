package pagesBuffalocart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllUsersPage {
	WebDriver driver;
	public AllUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tr[starts-with(@id,'table_')]//td[3][contains(text(),'ob')]")
	public List<WebElement> UserListContainUserNameOb;

	@FindBy(xpath = "//a[contains(text(),'demo')]")
	public WebElement Dispalydemo;

	public List<String> getUserListContainUserNameOb() {
		
		List<String> userList = new ArrayList<String>();
		
		for(WebElement userElement: UserListContainUserNameOb)
		{
			userList.add(userElement.getText());
		}
		
		return userList;
	}

	public String getDemoText() {
		return Dispalydemo.getText();
	}

}
