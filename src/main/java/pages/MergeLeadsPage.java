package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wdMethods.ProjectMethods;

public class MergeLeadsPage extends ProjectMethods{

	public MergeLeadsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//img[@src='/images/fieldlookup.gif'])[1]")
	WebElement fromLead;
	public LookUpLeadsPage clickFromLead() {
		clickWithNoSnap(fromLead);
		return new LookUpLeadsPage();
	}
	
	@FindBy(xpath="(//img[@src='/images/fieldlookup.gif'])[2]")
	WebElement toLead;
	public LookUpLeadsPage clickToLead() {
		switchToWindow(0);
		clickWithNoSnap(toLead);
		return new LookUpLeadsPage();
	}
	
	@FindBy(how=How.LINK_TEXT,using="Merge") WebElement mergeBtn;
		public ViewLeadPage clickMergeLeadBtn() throws InterruptedException {
		switchToWindow(0);
		clickWithNoSnap(mergeBtn);
		acceptAlert();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[text()='View Lead']")));
		//Thread.sleep(2000);
		return new ViewLeadPage();
	}
	
	
}
