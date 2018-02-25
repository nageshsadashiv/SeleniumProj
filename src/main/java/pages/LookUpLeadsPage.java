package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wdMethods.ProjectMethods;

public class LookUpLeadsPage extends ProjectMethods{
	public static String firstLeadid;
	
	public LookUpLeadsPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(how=How.NAME, using ="lastName")
	WebElement lastName;
	public LookUpLeadsPage enterLastName(String lName) {
		switchToWindow(1);
		type(lastName, lName);
		return this;
	}
	

	@FindBy(how=How.XPATH, using="//button[text()='Find Leads']")
	WebElement findLeadsWindowBtn;
	public LookUpLeadsPage clickFindLeadsWindowBtn() throws InterruptedException {
		clickWithNoSnap(findLeadsWindowBtn);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(firstResult)));
		//Thread.sleep(2000);
		return this;
	}

	
	@FindBy(how=How.XPATH, using="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement firstResult;
	public MergeLeadsPage clickFirstResult() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(firstResult)));
		firstLeadid = getText(firstResult);
		clickWithNoSnap(firstResult);
		//Thread.sleep(2000);
		return new MergeLeadsPage();
	}
	@FindBy(how=How.XPATH, using="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")
	WebElement secondResult;
	public MergeLeadsPage clickSecondResult() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(secondResult)));
		clickWithNoSnap(secondResult);
	
		//Thread.sleep(2000);
		return new MergeLeadsPage();
	}


}
