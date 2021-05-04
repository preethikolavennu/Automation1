package bln.test.automation.lender;

import java.awt.AWTException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bln.pages.Application;
import bln.pages.Clients;
import bln.pages.HomePage;
import bln.pages.Lender;
import bln.pages.LoanInside;
import bln.pages.LoanRequest;
import bln.pages.MyProfile;
import bln.pages.Users;
import bln.test.BaseTest;

public class IntakeLender extends BaseTest {
	
	@BeforeMethod(alwaysRun = true)
	public void initializeDriver(ITestContext context, Method m) throws MalformedURLException {
		super.initializeDriver(context, m);
	}
	

	/**
	 * Verify that Profile is updated.
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "IntakeLender"})
	public void IntakelenderMyProfile() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_intakeLender();
		MyProfile MyProfile1 = homePage.navigateToMyProfile();
		//LoanInside LoanInside1 = LoanRequest1.navigateToLoanInside();
		MyProfile1.updateintakePhoneNumber();
		MyProfile1.verifyUpdatedPhoneNumber();
	}
	/**
	 * Remove Loan Tasks and Loan Fees from main navigation -My Profile 
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "IntakeLender"})
	public void RemoveLoanTaskfee_MyProfile() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_intakeLender();
		MyProfile MyProfile1 = homePage.navigateToMyProfile();
		MyProfile1.validateHeaderNav();
		
		
	}
	/**
	 * Remove Loan Tasks and Loan Fees from main navigation -clients
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "IntakeLender"})	
	public void RemoveLoanTaskfee_clients() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_intakeLender();
		Clients Clients1 = homePage.navigateToClients();
		Clients1.validateHeaderNav();
		
	}
	/**
	 * Remove Loan Tasks and Loan Fees from main navigation -Loan Request
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "IntakeLender"})
	public void RemoveLoanTaskfee_LoanRequest() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_intakeLender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.validateHeaderNav();
	}
	
	/**
	 *  Remove "revert to lender" option for intake lender employee-Heeader menu 
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "IntakeLender"})
	public void RevertToLender_HeaderMenu() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_intakeLender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanRequest1.navigateToLoanInside();
		LoanRequest1.revertToLender();
		
	}
	
	/**
	 *  Remove "revert to lender" option for intake lender employee-Loan Req grid
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "IntakeLender"})
	public void RevertToLender_LoanReqGrid() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_intakeLender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanRequest1.revertToLender_LoanGrid();
	}
	/**
	 *  Remove "Add to Queue","Title Request Email" option for intake lender employee-Loan View
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "IntakeLender"})
	public void RemoveActions_HeaderMenu() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_intakeLender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanRequest1.navigateToLoanInside();
		LoanRequest1.actions();
		
	}
	
	/**
	 *  Remove "Add to Queue","Title Request Email" option for intake lender employee-Loan Req grid
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "IntakeLender"})
	public void RemoveActions_LoanReqGrid() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_intakeLender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanRequest1.actions_LoanGrid();
	}
	/**
	 *  Remove Loan Settings,Financial,Special Items
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "IntakeLender"})	
	public void RemoveoldTabs() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_intakeLender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanRequest1.navigateToLoanInside();
		LoanRequest1.oldTabs();
	}
	
	/**
	 *  Verify LO Assignment mandatory in Lender Intake
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "IntakeLender"})	
	public void LoAssignment() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1=Users1.select_RCNLender();
		Lender1.RCN_loanOfficers();
		// Navigating to MyProfile Tab
		Users Users2 = homePage.navigateToUsers();
		Users2.select_intakeLender();
		Application Application1 = homePage.createLoanRequest();
		Application1.LoanOfficer();
		Application1.LoanOfficerTest(Users1.sortedList1,Users2.sortedList1);
		
	}
	

} 
