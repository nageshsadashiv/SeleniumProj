package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import wdMethods.ProjectMethods;

public class MyLeadsPage extends ProjectMethods{

	public MyLeadsPage() {
		PageFactory.initElements(driver,this);
	}	

	@FindBy(how = How.LINK_TEXT,using="Create Lead")
	WebElement createLead;
	
	public CreateLeadPage clickCreateLead() {
		click(createLead);
		return new CreateLeadPage();
	}

	@FindBy(how=How.LINK_TEXT, using="Find Leads")
	WebElement findLeadslink;

	public FindLeadsPage clickfindLeads() {
		click(findLeadslink);
		return new FindLeadsPage();
	}

	@FindBy(how=How.LINK_TEXT, using="Merge Leads")
	WebElement mergeLeadslink;
	public MergeLeadsPage clickMergeLeads() {
		clickWithNoSnap(mergeLeadslink);
		return new MergeLeadsPage();
	}
}
