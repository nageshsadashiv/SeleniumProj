package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wdMethods.ProjectMethods;

public class FindLeadsPage extends ProjectMethods{
	public static String firstLeadnum;
	
	public FindLeadsPage() {
		PageFactory.initElements(driver,this);
	}	

	@FindBy(how=How.XPATH, using ="(//input[@name='firstName'])[3]")
	WebElement firstName;

	public FindLeadsPage enterfName(String data) {
		type(firstName, data);
		return this;
	}

	@FindBy(xpath="//button[text()='Find Leads']") WebElement findLeadsBtn;
	public FindLeadsPage clickFindLeadsBtn() throws InterruptedException {
		click(findLeadsBtn);
		WebDriverWait wait = new WebDriverWait(driver,20);
	//	wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(firstLink)));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='x-panel-body xedit-grid']"))));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='x-panel-body xedit-grid']")));
		//Thread.sleep(2000);
		return this;
	}

	@FindBy(how=How.XPATH, using = "(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/div/a")
	WebElement firstLink;

	public ViewLeadPage clickFirstLink() {
		click(firstLink);
		System.out.println("firstlinkCompName " +firstlinkCompName);
		return new ViewLeadPage();
	}

	@FindBy(how=How.XPATH,using="(//div[@class='x-grid3-cell-inner x-grid3-col-companyName'])[1]/a")
	WebElement firstlinkCompName;
	public String getFirstlinkCompName() {
		return getText(firstlinkCompName);
	}

	@FindBy(how=How.XPATH, using="//span[text()='Email']")
	WebElement emailTab;
	public FindLeadsPage switchToEmailTab() {
		clickWithNoSnap(emailTab);
		return this;
	}

	@FindBy(how=How.NAME,using="emailAddress")
	WebElement emailId;
	public FindLeadsPage enterEmail(String emailAddress) {
		type(emailId, emailAddress);
		return this;
	}
	
	@FindBy(xpath="(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/div/a")
	WebElement firstLeadID;
	public String getLeadId() {
	 firstLeadnum = getText(firstLeadID);
	 System.out.println("Lead ID which is getting deleted " +firstLeadnum);
	 return firstLeadnum;
	}

	@FindBy(how=How.XPATH, using="//span[text()='Phone']")
	WebElement phoneTab;
	public FindLeadsPage switchToPhoneTab( ) {
		clickWithNoSnap(phoneTab);
		return this;
	}
	
	@FindBy(how=How.NAME, using ="id")
	WebElement leadId;
	public FindLeadsPage enterLeadById() {
		System.out.println("Entering Deleted Lead ID "+firstLeadnum);
		type(leadId, firstLeadnum);
		return this;
	}
	
	public FindLeadsPage enterFromLeadID() {
		new LookUpLeadsPage();
		String leadID1 = LookUpLeadsPage.firstLeadid;
		System.out.println("Entering From Merge Lead ID "+leadID1);
		type(leadId, leadID1);
		return this;
	}
	
	@FindBy(how=How.CLASS_NAME, using="x-paging-info")
	WebElement searchResults;
	public FindLeadsPage verifyDeleteLead() {
	verifyExactText(searchResults, "No records to display");
	return this;
	}
	

}
