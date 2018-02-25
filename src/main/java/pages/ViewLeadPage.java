package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wdMethods.ProjectMethods;

public class ViewLeadPage extends ProjectMethods{

	public ViewLeadPage() {
		PageFactory.initElements(driver,this);
	}	

	@FindBy(how=How.ID, using="viewLead_companyName_sp")
	WebElement chkLeadid;
	public ViewLeadPage verifyLeadId(String cName) {
		verifyPartialText(chkLeadid, cName);
		return this;
	}
	
	@FindBy(linkText="Edit")
	WebElement editButton;
	public EditLeadPage clickEditBtn() {
		click(editButton);
		return new EditLeadPage();
	}
	
	@FindBy(id="viewLead_companyName_sp") WebElement ele;
	public void verifyEdit(String editCompany) {
		verifyPartialText(ele, editCompany);
	}
	
	@FindBy(how=How.LINK_TEXT, using="Duplicate Lead")
	WebElement duplicateLeadBtn;
	public DuplicateLeadPage clickDuplicateLead() {
	click(duplicateLeadBtn);	
	return new DuplicateLeadPage();
	}
	
	@FindBy(how=How.LINK_TEXT,using="Delete") WebElement deleteBtn;
	@FindBy(how=How.XPATH, using ="//div[text()='My Leads']") WebElement myLeadTitle;
	public MyLeadsPage clickDeleteLeadBtn() throws InterruptedException {
		clickWithNoSnap(deleteBtn);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(myLeadTitle));
		wait.until(ExpectedConditions.visibilityOf(myLeadTitle));
		return new MyLeadsPage();
	}
	
	@FindBy(how=How.XPATH, using = "//a[text()='Find Leads']") WebElement findLeadsLink;
	public FindLeadsPage clickFindLeadsLink() {
		clickWithNoSnap(findLeadsLink);
		return new FindLeadsPage();
	}
}
