package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC006_MergeLeads extends ProjectMethods{

	@BeforeTest
	public void setData() {
		testCaseName="TC006_MergeLeads";
		testDescription="Merge 2 leads";
		testNodes="Leads";
		category="Smoke";
		authors="Nagesh";
		browserName="chrome";
		dataSheetName="TC006";
	}

	@Test(dataProvider="fetchData")

	public void MergeLeads(String uName, String pwd, String userLoggedIn,String lastName) throws InterruptedException {		
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogIn()
		.verifyLoggedName(userLoggedIn)
		.clickCRMSFA()
		.clickLeadLink()
		.clickMergeLeads()
		.clickFromLead()
		.enterLastName(lastName)
		.clickFindLeadsWindowBtn()
		.clickFirstResult()
		.clickToLead()
		.enterLastName(lastName)
		.clickFindLeadsWindowBtn()
		.clickSecondResult()
		.clickMergeLeadBtn()
		.clickFindLeadsLink()
		.enterFromLeadID()
		.clickFindLeadsBtn()
		.verifyDeleteLead()
		;
	}

}
