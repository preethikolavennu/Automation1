package bln.test.automation.wordpressAPI;

import java.awt.AWTException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bln.pages.API;
import bln.pages.Application;
import bln.pages.CrossVersionDev;
import bln.pages.HomePage;
import bln.pages.LoanFee;
import bln.pages.LoanInside;
import bln.pages.LoanRequest;
import bln.pages.MyProfile;
import bln.pages.Users;
import bln.test.BaseTest;

public class WordPressAPITestScripts extends BaseTest {
	
	@BeforeMethod(alwaysRun = true)
	public void initializeDriver(ITestContext context, Method m) throws MalformedURLException {
		super.initializeDriver(context, m);
	}
	

	/**
	 * Verify that Profile is updated.
	 * @throws InterruptedException
	 */
	//@Test(groups = {"WordPressAPI"})
	@Test (priority=1)	
	public void brokerAPIV2_createLoan() throws InterruptedException  {
		// Login to API Application
		HomePage homePage = new HomePage(d);
		// Navigating to MyProfile Tab
		API API1 = homePage.logIntoBrokerwpv2API();
		API1.createLoan_Broker();
	}
	/**
	 * Verify that Profile is updated.
	 * @throws InterruptedException
	 */
	//@Test(groups = {"WordPressAPI"})
	@Test (priority=2)	
	public void brokerAPIV3_createLoan() throws InterruptedException  {
		// Login to API Application
		HomePage homePage = new HomePage(d);
		// Navigating to MyProfile Tab
		API API1 = homePage.logIntoBrokerwpv3API();
		API1.createLoan_Broker();
	}
	
	/**
	 * Verify that Profile is updated.
	 * @throws InterruptedException
	 */
	//@Test(groups = {"WordPressAPI"})
	@Test (priority=3)	
	public void lenderAPIV2_createLoan_RealEstateInvestor() throws InterruptedException  {
		// Login to API Application
		HomePage homePage = new HomePage(d);
		// Navigating to MyProfile Tab
		API API1 = homePage.logIntoLenderwpv2API();
		API1.createLoan_Lender();
	}
	/**
	 * Verify that Profile is updated.
	 * @throws InterruptedException
	 */
	//@Test(groups = {"WordPressAPI"})
	@Test (priority=4)	
	public void lenderAPIV3_createLoan_RealEstateInvestor() throws InterruptedException  {
		// Login to API Application
		HomePage homePage = new HomePage(d);
		// Navigating to MyProfile Tab
		API API1 = homePage.logIntoLenderwpv3API();
		API1.createLoan_Lender();
	}

	// @Test(groups = {"WordPressAPI"})
	//@Test(priority = 5)
	@Test (enabled = false)
	public void lenderAPIV2_createLoan_Broker() throws InterruptedException {
		// Login to API Application
		HomePage homePage = new HomePage(d);
		// Navigating to MyProfile Tab
		API API1 = homePage.logIntoLenderwpv2API();
		API1.createLoan_Lender_Broker();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		API1.calenderDate();
	}

	/**
	 * Verify that Profile is updated.
	 * 
	 * @throws InterruptedExceptionT
	 */
	// @Test(groups = {"WordPressAPI"})
	//@Test(priority = 6)
	@Test (enabled = false)
	public void lenderAPIV3_createLoan_Broker() throws InterruptedException {
		// Login to API Application
		HomePage homePage = new HomePage(d);
		// Navigating to MyProfile Tab
		API API1 = homePage.logIntoLenderwpv3API();
		API1.createLoan_Lender_Broker();
		LoanRequest LoanRequest1 = homePage.navigateToLoanRequest();
		API1.calenderDate();
	}

	/**
	 * Verify that Profile is updated.
	 * 
	 * @throws InterruptedException
	 */
	// @Test(groups = {"WordPressAPI"})
	@Test (enabled = false)
	//@Test (priority=5)	
	public void lenderAPI_createLoan() throws InterruptedException  {
		// Login to API Application
		HomePage homePage = new HomePage(d);
		// Navigating to MyProfile Tab
		API API1 = homePage.logIntoLenderAPI();
		API1.createLoan_Lender();
	}
	/**
	 * Verify that Profile is updated.
	 * @throws InterruptedException
	 */
	//@Test(groups = {"WordPressAPI"})
	@Test (enabled = false)	
	//@Test (priority=6)	
	public void brokerAPIV_createLoan() throws InterruptedException  {
		// Login to API Application
		HomePage homePage = new HomePage(d);
		// Navigating to MyProfile Tab
		API API1 = homePage.logIntoBrokerAPI();
		API1.createLoan_Broker();
	}
	
	


}
