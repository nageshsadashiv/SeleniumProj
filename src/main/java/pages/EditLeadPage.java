package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class EditLeadPage extends ProjectMethods{

	
	public EditLeadPage() {
		PageFactory.initElements(driver,this);
	}	

	@FindBy(id="updateLeadForm_companyName") WebElement compName;
	public EditLeadPage editCompName(String editCompany) {
		type(compName, editCompany);
		return this;
	}

	@FindBy(name="submitButton") WebElement submitBtn;
public ViewLeadPage clickUpdateBtn() {
	click(submitBtn);
	return new ViewLeadPage();
}
}
