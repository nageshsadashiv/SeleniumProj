package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FindLeadsPage;
import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC005_DeleteLead extends ProjectMethods{

	@BeforeTest
	public void setData() {
		testCaseName="TC005_DeleteLead";
		testDescription="Delete a lead";
		testNodes="Leads";
		category="Smoke";
		authors="Nagesh";
		browserName="chrome";
		dataSheetName="TC005";
	}

	@Test(dataProvider="fetchData")

	public void deleteLead(String uName, String pwd, String userLoggedIn,String emailAdd) throws InterruptedException {		
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogIn()
		.clickCRMSFA()
		.clickLeadLink()
		.clickfindLeads()
		.switchToEmailTab()
		.enterEmail(emailAdd)
		.clickFindLeadsBtn()
		.getLeadId();
		new FindLeadsPage()
		.clickFirstLink()
		.clickDeleteLeadBtn()
		.clickfindLeads()
		.enterLeadById()
		.clickFindLeadsBtn()
		.verifyDeleteLead();
	}

}
