package BLNProject.Automation;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bln.pages.HomePage;
import bln.test.BaseTest;




public class NewLoanRequest extends BaseTest {
	
	@BeforeMethod(alwaysRun = true)
	public void initializeDriver(ITestContext context, Method m) throws MalformedURLException {
		super.initializeDriver(context, m);
	}
	


	/**
	 * Creating an order with existing payment type
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	@Test(groups = {"Regression", "Smoke"})
	public void LoginBLN() throws InterruptedException  {
		//Login to the BLN with provided credentials
  		HomePage homePage = new HomePage(d);
  		// Login to BLN Application
  		homePage.logIntoBLN();
}
	
	@Test(groups = {"Regression", "Smoke"})
	 public void CreateSoftCreditPull() throws InterruptedException  {
			//Login to the BLN with provided credentials
	  		HomePage homePage = new HomePage(d);
	  		// Login to BLN Application
	  		homePage.logIntoBLN();
	  		homePage.SoftCreditPull();
	  		
	}
	@Test(groups = {"Regression", "Smoke"})
	 public void LoanRequestGrid() throws InterruptedException
	 {
		//Login to the BLN with provided credentials
	  		HomePage homePage = new HomePage(d);
	  		// Login to BLN Application
	  		homePage.logIntoBLN();
	  		homePage.LRGColumns();
	  		//checking
	 }
	 
	 
}