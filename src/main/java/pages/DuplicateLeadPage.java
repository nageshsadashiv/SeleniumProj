package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import wdMethods.ProjectMethods;

public class DuplicateLeadPage extends ProjectMethods{

	public DuplicateLeadPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how= How.ID, using="sectionHeaderTitle_leads")
	WebElement DuplicateLeadTitle;
	public void verifyPageTitle() { 
		verifyExactText(DuplicateLeadTitle, "Duplicate Lead");
	}

	@FindBy(how=How.NAME, using="submitButton")
	WebElement CreateDupLeadBtn;
	public ViewLeadPage clickCreateDupLead() {
		clickWithNoSnap(CreateDupLeadBtn);
		return new ViewLeadPage();
	}
	
	
}
