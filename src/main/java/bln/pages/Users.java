package bln.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import bln.util.Driver;
import bln.variables.Variables;

public class Users extends BasePage{
	

	public Users(Driver driver) {
		super(driver);
	} 
	//Select the Borrower Harika Testing 
	public void select_Borrower() throws InterruptedException {
		//Select the lender
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Broker).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//select borrower
		super.locateElement(Variables.SelectBorrower).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	// Select the Borrower Harika Testing
	public void select_intakeLender() throws InterruptedException {
		// Select the lender
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locateElement(Variables.SelectLender).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// select borrower
		locateElement(Variables.IntakeLender_employee).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
			
	public Lender select_RCNLender() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.SelectLender).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// select borrower
		super.locateElement(Variables.RcnCapital_lender).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Return CustomerSearch page
				return new Lender(driver);
	}
	
	public Lender select_LoanProcessor() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.SelectLender).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// select borrower
		super.locateElement(Variables.RcnCapital_LP).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Return CustomerSearch page
				return new Lender(driver);
	}
	public Lender select_Lender() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.SelectLender).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// select borrower
		super.locateElement(Variables.Lender).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Return CustomerSearch page
				return new Lender(driver);
	}
	public void select_Broker() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Broker).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// select borrower
		super.locateElement(Variables.Broker_emp).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	public Lender select_Legal() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.SelectLender).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// select borrower
		super.locateElement(Variables.Legal).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Return CustomerSearch page
		return new Lender(driver);
		
	}
}
