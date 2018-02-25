package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class LoginPage extends ProjectMethods{
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.ID,using="username")
	private WebElement eleUserName;
	
	public LoginPage enterUserName(String data) {
		//WebElement eleUserName = locateElement("usernama");
		type(eleUserName, data);
		return this;
	}
	
	
	@FindBy(how=How.ID,using="password")
	private WebElement elePassword;
	
	public LoginPage enterPassword(String data) {
		//WebElement elePassword = locateElement("password");
		type(elePassword, data);
		return this;
	}
	
	
	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	private WebElement eleLogin;
	
	public HomePage clickLogIn() {
		//WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		/*HomePage hp = new HomePage();
		return hp;*/
		return new HomePage();
		
	}
	
	public LoginPage clickLogInForFailer() {
		click(eleLogin);
		return this;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
