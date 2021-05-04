package bln.test.automation.lender;

import java.awt.AWTException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bln.pages.Application;
import bln.pages.Brokerages;
import bln.pages.CrossVersionDev;
import bln.pages.HomePage;
import bln.pages.Lender;
import bln.pages.LoanFee;
import bln.pages.LoanInside;
import bln.pages.LoanRequest;
import bln.pages.MyProfile;
import bln.pages.Users;
import bln.test.BaseTest;
import bln.variables.Variables;

public class LenderTestScripts extends BaseTest {
	
	@BeforeMethod(alwaysRun = true)
	public void initializeDriver(ITestContext context, Method m) throws MalformedURLException {
		super.initializeDriver(context, m);
	}
	/**
	 *Lenders should not be able to request invoices for themselves
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lender_Norequestinvoices() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.Norequestinvoices();
	}
	/**dfgdf**/
	/**
	 *LO _if an loan is after loan processing stage collateral screen should be read only mode
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lo_ReadOnlyModeCollateral() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectApprovedLoan();
		LoanRequest1.checkMultiUnit();
		
	}
	/**
	 *LP _if an loan is after loan processing stage collateral screen should be read only mode
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lP_ReadOnlyModeCollateral() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_LoanProcessor();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectApprovedLoan();
		LoanRequest1.checkTaxTab();
		
	}
	
	/**
	 *LO _if an loan is after loan processing stage collateral screen should be read only mode
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lo_EditOnlyModeCollateral() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanInside LoanInside1 = LoanRequest1.navigateToLoanInside();
		LoanRequest1.checkMultiUnitEdit();
		
		
	}
	/**
	 *LP _if an loan is after loan processing stage collateral screen should be read only mode
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lP_EditOnlyModeCollateral() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_LoanProcessor();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanInside LoanInside1 = LoanRequest1.navigateToLoanInside();
		LoanRequest1.checkTaxTabEdit();
		
	}
	
	/**
	 * Verify that Purchase price is updated 
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void purchasePrice_Collateral() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanInside LoanInside1 = LoanRequest1.navigateToLoanInside();
		LoanInside1.updatePurchasePrice();
		LoanInside1.verifyPurchasePrice();
	}
	

	
	/**
	 * Verify that Profile is updated.
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lenderMyProfile() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		MyProfile MyProfile1 = homePage.navigateToMyProfile();
		//LoanInside LoanInside1 = LoanRequest1.navigateToLoanInside();
		MyProfile1.updateintakePhoneNumber();
		MyProfile1.verifyUpdatedPhoneNumber();
	}
	
	/**
	 * Verify the Loan fee section
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lenderLoanFee() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		// Navigating to MyProfile Tab
		LoanFee LoanFee1 = homePage.navigateToLoanFee();
		LoanFee1.Filters_Edit_CC();
		
	}
	
	/**
	 * Verify the lenderSoftCreditPull
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lenderSoftCreditPull() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.SoftCreditPull();
		LoanRequest1.createRequest();
		LoanRequest1.lenderLoanFetch();
	}
	
	/**
	 * Verify the CreateLoan Request
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lenderCreateLoanRequest() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		Application Application1 = homePage.createLoanRequest();
		Application1.createLoan_Lender();
	}
	/**
	 *Loan Request,Reset Search 
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lender_LoanRequest_ResetSearch() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.borrower_resetSearch();
	}

	/**
	 *Add Log need to work 
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lender_AddLog() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.Lender_addLog();
	}
	

	/**
	 *Insurance Tab on collateral in edit mode for LO
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lp_InsuranceTab() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_LoanProcessor();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectApprovedLoan();
		LoanRequest1.checkInsurance();
		
	}
	
	/**
	 *Add Message
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lender_AddMessages() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.addMessage_Lender();
	}
	/**
	 * Verify the cloneloan from loanRequest 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void lender_CloneLoan() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanInside LoanInside1 = LoanRequest1.navigateToLoanInside();
		LoanInside1.cloneLoan();
		
	}
	/**
	 * Verify Soft Credit Pull from loan request
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void softCreditPullfromLoanRequest() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.SoftCreditPull();
	}
	/**
	 * Verify Credit Authroziation
	 *  pending 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void creditAuthroziation() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanInside LoanInside1 = LoanRequest1.navigateToLoanInside();
		LoanInside1.creditAuth();
		
	}
	/**
	 * Verify with draw status is not displayed in killed filter 
	 *   
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void withdrawShowKilled() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectKilled();
		LoanRequest1.verifyStatusWithDraw();
	}
	/**
	 * Verify each state is saved in lending states -fine 
	 *   
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void stateSavedLending() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1=Users1.select_RCNLender();
		Lender1.RCN_lendingStates();
	}
	/**
	 * Verify closing schedule checkbox 
	 *   
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void closingScheduleCheckBox() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1=Users1.select_Legal();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanRequest1.legal_ClosingSchedule();
	}
	/**
	 * Verify closing schedule checkbox _Action
	 *   
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void closingScheduleCheckBox_Action() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1=Users1.select_Legal();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanRequest1.actions_SetClosingLoan();	
	}
	/**
	 * Verify closing schedule checkbox _Loan Inside
	 *   
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void closingScheduleCheckBox_LoanInside() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1=Users1.select_Legal();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanInside LoanInside1 = LoanRequest1.navigateToLoanInside();	
		LoanInside1.closingSummary();
	}
	/**
	 * Points interest Rebate tweak
	 *   
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void interestRebate() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanInside LoanInside1 = LoanRequest1.navigateToLoanInside();
		LoanInside1.interestRebate();
	}
	/**
	  * Verify the closingSummary miss
	 *   
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void closingSummary() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1=Users1.select_Legal();
		// Navigating to MyProfile Tab
		//Lender1.rcn_editEmployee();
	}
	/**
	 * Add Employee fine
	 *   
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void addEmployee() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1=Users1.select_RCNLender();
		// Navigating to MyProfile Tab
		Lender1.rcn_addEmployee();
	}
	/**
	 * Edit Employee -fine
	 *   
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void editEmployee() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1=Users1.select_RCNLender();
		// Navigating to MyProfile Tab
		Lender1.rcn_editEmployee();
	}
	/**
	 * Verify that Property type -fine 
	 *   
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "LenderPortal"})
	public void propertyType() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1=Users1.select_RCNLender();
		Lender1.RCN_PropertyType();
	}

	/**
	 * Verify the Loan type
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "Regression", "LenderPortal" })
	public void loanType() throws InterruptedException, AWTException {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1 = Users1.select_RCNLender();
		Lender1.RCN_LoanType();
	}
	
	/**
	 * Verify the loan program in loan settings 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "Regression", "LenderPortal" })
	public void lp_loanSetting() throws InterruptedException, AWTException {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1 = Users1.select_LoanProcessor();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.RCN_LoanProgram();
		
	}
	/**
	 * Verify the collateral screen in LP
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "Regression", "LenderPortal" })
	public void lP_Collateral() throws InterruptedException, AWTException {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1 = Users1.select_LoanProcessor();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectActive1();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.RCN_newCollateral();
		
	}

	/**
	 * Verify the Payment calculation typo
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	
	@Test(groups = { "Regression", "LenderPortal" })
	public void payment_calculations() throws InterruptedException, AWTException {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1 = Users1.select_Legal();
		Lender1.typo();
	} */

	/**
	 * Verify the add columns to apprisal grid
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "Regression", "LenderPortal" })
	public void add_columns_to_apprisal_grid() throws InterruptedException, AWTException {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Lender Lender1 = Users1.select_Lender();
		Lender1.add_columns_to_apprisal_grid();
	}

	/**
	 * Verify the add columns to apprisal grid
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "Regression", "LenderPortal" })
	public void lender_CheckPLLinDeneyRequestGrid() throws InterruptedException, AWTException {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Lender();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		LoanRequest1.selectDenyRequest();
	}
}
