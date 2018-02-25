package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import wdMethods.ProjectMethods;

public class HomePage extends ProjectMethods{

	public HomePage() {
		PageFactory.initElements(driver,this);
	}	

	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	private WebElement eleLogOut;

	public LoginPage clickLogOut() {
		//WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogOut);
		return new LoginPage();		
	}

	@FindBy(how=How.XPATH,using="//h2[text()[contains(.,'Demo Sales Manager')]]")
	private WebElement eleLoggedName;

	public HomePage verifyLoggedName(String data) {
		verifyPartialText(eleLoggedName, data);
		return this;		
	}

	@FindBy(how = How.LINK_TEXT,using="CRM/SFA")
	WebElement clickCRMSFA;
	public MyHomePage clickCRMSFA() {
		click(clickCRMSFA);
		return new MyHomePage();
	}



}
