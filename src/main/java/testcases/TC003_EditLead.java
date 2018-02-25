package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC003_EditLead extends ProjectMethods{
	
	@BeforeTest
		public void setData() {
			testCaseName="TC003_EditLead";
			testDescription="Edit Company Name in existing Lead";
			testNodes="Leads";
			category="Smoke";
			authors="Nagesh";
			browserName="chrome";
			dataSheetName="TC003";
		}
		
		
		@Test(dataProvider="fetchData")
		
		public void editLead(String uName, String pwd,String fName, String updateCompName) throws InterruptedException {
			new LoginPage()
			.enterUserName(uName)
			.enterPassword(pwd)
			.clickLogIn()
				.clickCRMSFA()
				.clickLeadLink()
				.clickfindLeads()
				.enterfName(fName)
				.clickFindLeadsBtn()
				.clickFirstLink()
				.clickEditBtn()
				.editCompName(updateCompName)
				.clickUpdateBtn()
				.verifyEdit(updateCompName);
				;
		}
		
}
