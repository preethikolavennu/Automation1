package bln.test.automation.closingcoordinators;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bln.pages.Brokerages;
import bln.pages.ClosingCoordinator;
import bln.pages.HomePage;
import bln.pages.Lender;
import bln.pages.LoanFee;
import bln.pages.LoanInside;
import bln.pages.LoanRequest;
import bln.pages.MyProfile;
import bln.pages.Users;
import bln.test.BaseTest;

public class ClosingCoordinatorsTestScripts extends BaseTest {
	
	@BeforeMethod(alwaysRun = true)
	public void initializeDriver(ITestContext context, Method m) throws MalformedURLException {
		super.initializeDriver(context, m);
	}
	@Test(groups = {"Regression", "CC"})
	public void updateProfile() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();

		// Navigating to MyProfile Tab
		MyProfile MyProfile1 = homePage.navigateToMyProfile();
		// Updating Phone Number
		MyProfile1.updatePhoneNumber();
		MyProfile MyProfile2 =homePage.navigateToMyProfile();
		MyProfile2.verifyUpdatedPhoneNumber();
	}

	/**
	 * Verify that Notes section is editable.
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "CC"})
	public void CC_NoteSection_editable() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		Brokerages Brokerages1 =homePage.navigateToBrokerages();
		Brokerages1.NotesSections_Brokerages();
	}
	
	/**
	 * Verify that new coordinator is getting added 
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "CC"})
	public void CC_New_Add() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		ClosingCoordinator ClosingCoordinator1  =homePage.navigateToCC();
		ClosingCoordinator1.add_CC();
		
	}
	
	/**
	 *Delete the Closing coordinator
	 * @throws InterruptedException
	 
	@Test(groups = {"Regression", "CC"})
	public void CC_Deleteclosingcoordinator() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		ClosingCoordinator ClosingCoordinator1 =homePage.navigateToCC();
		ClosingCoordinator1.delete_CC();
		
	} */
	
	/**
	 *Loan fee Verify the Edit filter
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "CC"})
	public void CC_LoanFee_Edit() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		LoanFee LoanFee1 =homePage.navigateToLoanFee();
		LoanFee1.Filters_Edit_CC();
	}
	
	/**
	 * Verify Make lender name editable for CC users on lender profile
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "CC"})
	public void lenderNameEditable() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		Lender Lender1 = homePage.navigateToLender();
		Lender1.lenderName();
	}
	/**
	 *Copy URL the filter
	 * @throws InterruptedException
	
	@Test(groups = {"Regression", "CC"})	
	public void CC_LoanFee_Copy_Direct_Payment_URL() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		LoanFee LoanFee1 =homePage.navigateToLoanFee();
		LoanFee1.Filters_CopyURL();
		//Need to update code for loan amount assertions
	} */
	
	/**
	 *Delete the filter
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "CC"})
	public void CC_LoanFee_Delete() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		LoanFee LoanFee1 =homePage.navigateToLoanFee();
		LoanFee1.Filters_delete();
	}
	
	/**
	 *Loan Request,View Stagnant Loans
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "CC"})
	public void CC_LoanRequest_StagnantLoans() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		LoanRequest LoanRequest1 =homePage.navigateToLoanRequest();
		LoanRequest1.stagnantLoans();
	}
	
	/**
	 *Loan Request,Reset Search 
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "CC"})
	public void CC_LoanRequest_ResetSearch() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		LoanRequest LoanRequest1 =homePage.navigateToLoanRequest();
		LoanRequest1.resetSearch();
	}
	
	/**
	 *Loan Request,Reset Search 
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "CC"})	
	public void CC_Lender_changeProgramType() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		Lender Lender1 =homePage.navigateToLender();
		Lender1.programType();
	}
	
	/**
	 *loan request columns formatte
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "CC"})	
	public void CC_LoanRequestFormatte() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		LoanRequest LoanRequest1 =homePage.navigateToLoanRequest();
		LoanRequest1.loanFormatte();
	}

}
