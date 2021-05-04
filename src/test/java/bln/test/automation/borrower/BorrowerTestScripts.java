package bln.test.automation.borrower;

import java.awt.AWTException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bln.pages.Application;
import bln.pages.CrossVersionDev;
import bln.pages.HomePage;
import bln.pages.LoanFee;
import bln.pages.LoanInside;
import bln.pages.LoanRequest;
import bln.pages.MyProfile;
import bln.pages.Users;
import bln.test.BaseTest;

public class BorrowerTestScripts extends BaseTest {
	
	@BeforeMethod(alwaysRun = true)
	public void initializeDriver(ITestContext context, Method m) throws MalformedURLException {
		super.initializeDriver(context, m);
	}
	

	/**
	 * Verify that Profile is updated.
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Borrower"})
	public void borrowerMyProfile() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		MyProfile MyProfile1 = homePage.navigateToMyProfileBorrower();
		MyProfile1.updateEmailId();
		
	}
	
	
	/**
	 * Verify the Loan fee section
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Borrower"})
	public void borrowerLoanFee() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanFee LoanFee1 = homePage.navigateToLoanFeeBorrower();
		LoanFee1.Filters_Edit_CC();
		
	}
	
	/**
	 * Verify the CreateLoan Request
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Borrower"})
	public void borrowerCreateLoanRequest() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		Application Application1 = homePage.createLoanRequest();
		Application1.applicationFillup();	
	}
	/**
	 *Loan Request,Reset Search 
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Borrower"})
	public void Borrower_LoanRequest_ResetSearch() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		LoanRequest1.borrower_resetSearch();
	}
	
	/**
	 *Add Log need to work 
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Borrower"})
	public void Borrower_AddLog() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
	
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.addLog();
	}
	/**
	 *Add Message
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Borrower"})
	public void Borrower_AddMessages() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
	
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.addMessage();
	}
	/**
	 * Verify the CreateLoan from loanRequest 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Borrower"})
	public void borrowerCreateLoanRequestfromLoanRequest() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		Application Application1 = LoanRequest1.navigateToApplication();
		Application1.applicationFillup();
		
	}
	/* Verify comments are updated to the loan 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Borrower"})
	public void borrowerCommentsUpdated() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.addcomments();
		
	}
	/* Verify Make payment button 
	 * @throws InterruptedException
	 * @throws AWTException 
	 
	@Test(groups = {"Regression", "Borrower"})
	public void borrowerMakePayment() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.makePayment();
		
	}*/
	/* Verify broker added 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Borrower"})	
	public void borrowerAddBroker() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.addBroker();
		
	}
	/* Verify experience
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Borrower"})	
	public void borrowerExperience() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.expereince();
		
	}
	/* Verify budjet with 0 are hidden 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Borrower"})	
	public void borrowerbudjet() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.budgethidden();
	}
	/* Update collateral info 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Borrower"})	
	public void collateralinfoUpdate() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.infoUpdate();
	}
	/* export rehab budget 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Borrower"})	
	public void exportRehabBudget() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.infoUpdate();
	}
	/* Navigate from Lead to loan info 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Borrower"})	
	public void navigatefromleadtoloaninfo() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.leadtoloaninfo();
	}
	/* Navigate from loan info to contacts
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Borrower"})
	public void navigatefromloaninfotocontacts() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Borrower();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBorrower();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.loaninfotocontact();
	}



}
