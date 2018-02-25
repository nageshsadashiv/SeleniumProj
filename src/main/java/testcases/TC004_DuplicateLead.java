package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FindLeadsPage;
import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC004_DuplicateLead extends ProjectMethods{

	@BeforeTest
	public void setData() {
		testCaseName="TC004_DuplicateLead";
		testDescription="Edit Company Name in existing Lead";
		testNodes="Leads";
		category="Smoke";
		authors="Nagesh";
		browserName="chrome";
		dataSheetName="TC004";
	}

	@Test(dataProvider="fetchData")

	public void editLead(String uName, String pwd,String userLoggedin, String fName) throws InterruptedException {		
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogIn()
		.verifyLoggedName(userLoggedin)
		.clickCRMSFA()
		.clickLeadLink()
		.clickfindLeads()
		.enterfName(fName)
		.clickFindLeadsBtn();
		String CompName =new  FindLeadsPage().getFirstlinkCompName();
		new FindLeadsPage()
		.clickFirstLink()
		.clickDuplicateLead()
		.clickCreateDupLead()
		.verifyEdit(CompName)


		//.clickEditBtn()
		//.editCompName(updateCompName)
		//.clickUpdateBtn()
		//.verifyEdit(updateCompName);
		;
	}

}
