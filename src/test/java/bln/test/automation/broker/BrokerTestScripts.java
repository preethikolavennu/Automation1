package bln.test.automation.broker;

import java.awt.AWTException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import bln.pages.Settings;
import bln.pages.Users;
import bln.test.BaseTest;

public class BrokerTestScripts extends BaseTest {
	
	@BeforeMethod(alwaysRun = true)
	public void initializeDriver(ITestContext context, Method m) throws MalformedURLException {
		super.initializeDriver(context, m);
	}
	

	/**
	 * Verify that Profile is updated.
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerResetSearch() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBroker();
		LoanRequest1.borrower_resetSearch();
		
	}
	/**
	 * Apply hold on loan
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerHoldLoan() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBroker();
		LoanRequest1.selectActive();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.holdLoan();
		LoanRequest LoanRequest2 = homePage.navigateToLoanRequestBroker();
		LoanRequest2.selectAll();
		
	}
	/**
	 * Remove Hold on loan
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Broker"},dependsOnMethods= {"brokerHoldLoan"})
	public void brokerHoldLoan_Remove() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBroker();
		LoanRequest1.selectAll();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.removeholdLoan();
		
	}
	/**
	 * Kill the Loan
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerKillLoan() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBroker();
		LoanRequest1.selectActive();
		LoanInside LoanInside1=LoanRequest1.navigateToLoanInside();
		LoanInside1.killLoan();
		homePage.navigateToLoanRequest();
		/*LoanRequest1.selectDenied();
		LoanInside LoanInside2=LoanRequest1.navigateToLoanInside();
		LoanInside2.validateDeniedLoan(LoanInside1.getOrderNumber());*/
		
	}
	/**
	 * Broker Soft Credit Pull and create request
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerSoftCreditPull() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBroker();
		LoanRequest1.SoftCreditPull();
		LoanRequest1.createRequest();
		LoanRequest1.brokerLoanFetch();
	}
	/**
	 * Broker Soft Credit Pull, Reject Request
	 * @throws InterruptedException
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerSoftCreditPull_RejectRequest() throws InterruptedException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBroker(); 
		LoanRequest1.SoftCreditPull();
		LoanRequest1.rejectRequest();
	}
	/**
	 * Broker Soft Credit Pull, Reject Request
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerCreateLoan() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBroker();
		Application Application1 = LoanRequest1.navigateToApplication();
		Application1.applicationFillup1();
	}
	/**
	 * Updated broker phone number
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerUpdatePhoneNumber() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		Settings Settings1 = homePage.navigateToSettings();
		Settings1.updatePhoneNumber();
	}
	/**
	 * Show Denied Loans and verify status
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerShowDenied() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBroker();
		LoanRequest1.selectDenied();
		LoanRequest1.verifyStatusDenied();
	}
	/**
	 * Add Lender to Broker 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerAddLender() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		Settings Settings1 = homePage.navigateToSettings();
		Settings1.lenderAssignment();
		Settings1.Add_Lender();
	}
	/** Pending
	 * Broker feature access
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerFeatureAccess() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		Settings Settings1 = homePage.navigateToSettings();
		Settings1.featureAccess();
	}
	/** Pending
	 *Hard Credit Report 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerHardReport() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		Settings Settings1 = homePage.navigateToSettings();
		Settings1.featureAccess();
		Settings1.hardCreditReport();
	}
	/** Pending
	 *Apply Auto Fee to Loan 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerAutoFeetoLoan() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		Settings Settings1 = homePage.navigateToSettings();
		Settings1.fee_AddAutoFee();
	}
	/**
	 *Remove Auto Fee to Loan 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	@Test(groups = {"Regression", "Broker"})
	public void brokerRemoveAutoFeetoLoan() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		// Navigating to MyProfile Tab
		Settings Settings1 = homePage.navigateToSettings();
		Settings1.fee_RemoveAutoFee();
	}
	/**
	 * navigateTofilter_option
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = {"Regression", "Broker"})
	public void navigateTofilter_option() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		
		// Navigating to documents
		homePage.navigateTofilter_option();

		
	}
	
	/**
	 * PLL_Change "Refer to BLN" to "Refer to PLL" in LRG 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = {"Regression", "Broker"})
	public void verifyRefertoPLL() throws InterruptedException, AWTException  {
		// Login to the BLN with provided credentials
		HomePage homePage = new HomePage(d);
		// Login to BLN Application
		homePage.logIntoBLN();
		
		// Navigating to MyProfile Tab
		Users Users1 = homePage.navigateToUsers();
		Users1.select_Broker();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequestBroker();
		// Navigating to documents
		LoanRequest1.referToPll();

		
	}
	
	
	
}
