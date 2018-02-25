package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class CreateLeadPage extends ProjectMethods{

	public CreateLeadPage() {
		PageFactory.initElements(driver,this);
	}	

	
	@FindBy(id="createLeadForm_companyName")
	WebElement compName;
	
	public CreateLeadPage enterCompName(String cName) {
		type(compName,cName);
		return this;
	}

	@FindBy(how = How.ID,using="createLeadForm_firstName")
	WebElement firstName;
	
	public CreateLeadPage enterfirstName(String fName) {
		type(firstName, fName);
		return this;
	}
	
	@FindBy(how = How.ID,using="createLeadForm_lastName")
	WebElement lastName;
	
	public CreateLeadPage enterLastName(String lName) {
		type(lastName,lName);
		return this;
	}

	@FindBy(how = How.ID,using="createLeadForm_primaryEmail")
	WebElement emailId;
	
	public CreateLeadPage enterEmailId(String emailId1) {
		type(emailId,emailId1);
		return this;
	}
	
	@FindBy(how = How.ID,using="createLeadForm_primaryPhoneNumber")
	WebElement phoneNum;
	
	public CreateLeadPage enterPhoneName(String phNum) {
		type(phoneNum,phNum );
		return this;
	}
	
	
	@FindBy(how = How.NAME, using="submitButton")
	WebElement submitBtn;
	
	public ViewLeadPage clickCreateLead() {
		click(submitBtn);
		return new ViewLeadPage();
	}

}
