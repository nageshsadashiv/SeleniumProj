package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC002_CreateLead extends ProjectMethods{
	
	@BeforeTest
		public void setData() {
			testCaseName="TC002_CreateLead";
			testDescription="Create a New Lead";
			testNodes="Leads";
			category="Smoke";
			authors="Nagesh";
			browserName="chrome";
			dataSheetName="TC002";
		}
		
		
		@Test(dataProvider="fetchData")
		public void CreateLead(String uName,String pwd,String vName,
				String cName, String fName, String lName, String emailId,String phNum) {		
			new LoginPage()
			.enterUserName(uName)
			.enterPassword(pwd)
			.clickLogIn()
			.verifyLoggedName(vName)
			.clickCRMSFA()
			.clickLeadLink()
			.clickCreateLead()
			.enterCompName(cName)
			.enterfirstName(fName)
			.enterLastName(lName)
			.enterEmailId(emailId)
			.enterPhoneName(phNum)
			.clickCreateLead()
			.verifyLeadId(cName);
				
		}
		
}
