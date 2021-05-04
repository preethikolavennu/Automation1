package bln.pages;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import bln.util.Driver;
import bln.variables.Variables;
import bln.variables.VariablesAPI;


public class API extends BasePage{
	
	public API(Driver driver) {
		super(driver);
	} 
	public void createLoan_Broker() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		selectFromDropdown(VariablesAPI.API_PropertyState, VariablesAPI.API_PropertyStateOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		selectFromDropdown(VariablesAPI.API_CollateralType, VariablesAPI.API_CollateralTypeOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_PropertyStatus));
		
		//super.locateElement(VariablesAPI.API_PropertyStatus).click();
		//pageScrollDown();
		super.scrollUntilElementToDisplay(VariablesAPI.API_Next);
		//super.locateElement(VariablesAPI.API_Next).click();
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_Next));
		//driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//pageScrollDown();
		// Store new email address
		String newEmail = super.generateEmail();

		// Enter new email id
		super.type(VariablesAPI.API_EmailAddress, newEmail);
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_Submit));
		//super.locateElement(VariablesAPI.API_Submit).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//doubleClickUsingAction(locateElement(VariablesAPI.API_FirstName));
		//super.locateElement(VariablesAPI.API_FirstName).sendKeys("Harika");
		super.type(VariablesAPI.API_FirstName, "Harika");
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_LastName));
		//super.locateElement(VariablesAPI.API_LastName).click();
		super.locateElement(VariablesAPI.API_LastName).sendKeys("Vegesna");
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_PhoneNumber));
		//super.locateElement(VariablesAPI.API_PhoneNumber).click();
		super.locateElement(VariablesAPI.API_PhoneNumber).sendKeys("7896541230");
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_NavigateNext));
		//super.locateElement(VariablesAPI.API_NavigateNext).click();
		super.scrollUntilElementToDisplay(VariablesAPI.API_ZipCode);
		super.type(VariablesAPI.API_ZipCode, "10019");
		super.type(VariablesAPI.API_Address, "720 fifth avenue");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(VariablesAPI.API_CollateralType1, VariablesAPI.API_CollateralTypeOptions1);
		//super.locateElement(VariablesAPI.API_PurchaseRefinance).click();
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_PurchaseRefinance));
		super.locateElement(VariablesAPI.API_PurchasePrice).sendKeys("4000");
		super.locateElement(VariablesAPI.API_RehabCost).sendKeys("2000");
		super.locateElement(VariablesAPI.API_AfterRepair).sendKeys("8000");
		super.locateElement(VariablesAPI.API_AsisValue).sendKeys("4500");
		super.locateElement(VariablesAPI.API_AmountRequested).sendKeys("4500");
		super.scrollUntilElementToDisplay(VariablesAPI.API_desired_terms);
		selectFromDropdown(VariablesAPI.API_desired_terms, VariablesAPI.API_desired_termsOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.scrollUntilElementToDisplay(VariablesAPI.API_loan_purpose);
		selectFromDropdown(VariablesAPI.API_loan_purpose, VariablesAPI.API_loan_purposeOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		selectFromDropdown(VariablesAPI.API_exit_strategy, VariablesAPI.API_exit_strategyOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_TermAgreement));
		//super.locateElement(VariablesAPI.API_TermAgreement).click();
		//super.locateElement(VariablesAPI.API_Recaptcha).click();	
		if (isAlertPresent()) {
			Alert alert = driver.getDriver().switchTo().alert();
			// alert.accept();
			alert.dismiss();
		}
		//super.locateElement(VariablesAPI.API_SubmitRequest).click();	
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_SubmitRequest));
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.type(VariablesAPI.API_Password, "BLN!@#bln123");
		super.type(VariablesAPI.API_PasswordCheck, "BLN!@#bln123");
		super.scrollUntilElementToDisplay(VariablesAPI.API_sign);
		//super.locateElement(VariablesAPI.API_sign).click();
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_sign));
		driver.getDriver().manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		//super.scrollUntilElementToDisplay(VariablesAPI.API_LoanNumber);
		String LoanDeatils  =super.locateElement(VariablesAPI.API_LoanNumber).getText();
		System.out.println("Loan Number:" +LoanDeatils);
	}
	public void createLoan_Lender() throws InterruptedException {
		
		selectFromDropdown(VariablesAPI.API_PropertyState, VariablesAPI.API_PropertyStateOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		selectFromDropdown(VariablesAPI.API_CollateralType, VariablesAPI.API_CollateralTypeOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_PropertyStatus));
		//pageScrollDown();
		super.scrollUntilElementToDisplay(VariablesAPI.API_Next);
		//super.locateElement(VariablesAPI.API_Next).click();
		super.clickOnElementUsingJavaScript(locateElement(VariablesAPI.API_Next));
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//super.locateElement(VariablesAPI.API_AreYou).click();
		super.clickOnElementUsingJavaScript(VariablesAPI.API_AreYou);
		//super.locateElement(VariablesAPI.API_Next).click();
		super.clickOnElementUsingJavaScript(VariablesAPI.API_Next);
		//pageScrollDown();
		// Store new email address
		String newEmail = super.generateEmail();

		// Enter new email id
		super.type(VariablesAPI.API_EmailAddress, newEmail);
		//super.locateElement(VariablesAPI.API_Submit).click();
		super.clickOnElementUsingJavaScript(VariablesAPI.API_Submit);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//doubleClickUsingAction(locateElement(VariablesAPI.API_FirstName));
		//super.locateElement(VariablesAPI.API_FirstName).sendKeys("Harika");
		super.type(VariablesAPI.API_FirstName, "Harika");
		//super.locateElement(VariablesAPI.API_LastName).click();
		super.clickOnElementUsingJavaScript(VariablesAPI.API_LastName);
		super.locateElement(VariablesAPI.API_LastName).sendKeys("Vegesna");
		//super.locateElement(VariablesAPI.API_PhoneNumber).click();
		super.clickOnElementUsingJavaScript(VariablesAPI.API_PhoneNumber);
		super.locateElement(VariablesAPI.API_PhoneNumber).sendKeys("7896541230");
		//super.locateElement(VariablesAPI.API_NavigateNext).click();
		super.clickOnElementUsingJavaScript(VariablesAPI.API_NavigateNext);
		super.scrollUntilElementToDisplay(VariablesAPI.API_ZipCode);
		super.type(VariablesAPI.API_ZipCode, "10019");
		super.type(VariablesAPI.API_Address, "720 fifth avenue");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(VariablesAPI.API_CollateralType1, VariablesAPI.API_CollateralTypeOptions1);
		//super.locateElement(VariablesAPI.API_PurchaseRefinance).click();
		super.clickOnElementUsingJavaScript(VariablesAPI.API_PurchaseRefinance);
		super.locateElement(VariablesAPI.API_PurchasePrice).sendKeys("4000");
		super.locateElement(VariablesAPI.API_RehabCost).sendKeys("2000");
		super.locateElement(VariablesAPI.API_AfterRepair).sendKeys("8000");
		super.locateElement(VariablesAPI.API_AsisValue).sendKeys("4500");
		super.locateElement(VariablesAPI.API_AmountRequested).sendKeys("4500");
		selectFromDropdown(VariablesAPI.API_desired_terms, VariablesAPI.API_desired_termsOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.scrollUntilElementToDisplay(VariablesAPI.API_loan_purpose);
		selectFromDropdown(VariablesAPI.API_loan_purpose, VariablesAPI.API_loan_purposeOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		selectFromDropdown(VariablesAPI.API_exit_strategy, VariablesAPI.API_exit_strategyOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//super.locateElement(VariablesAPI.API_TermAgreement).click();
		super.clickOnElementUsingJavaScript(VariablesAPI.API_TermAgreement);
		//super.locateElement(VariablesAPI.API_Recaptcha).click();	
		if (isAlertPresent()) {
			Alert alert = driver.getDriver().switchTo().alert();
			// alert.accept();
			alert.dismiss();
		}
		//super.locateElement(VariablesAPI.API_SubmitRequest).click();
		super.clickOnElementUsingJavaScript(VariablesAPI.API_SubmitRequest);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.type(VariablesAPI.API_Password, "BLN!@#bln123");
		super.type(VariablesAPI.API_PasswordCheck, "BLN!@#bln123");
		super.scrollUntilElementToDisplay(VariablesAPI.API_sign);
		//super.locateElement(VariablesAPI.API_sign).click();
		super.clickOnElementUsingJavaScript(VariablesAPI.API_sign);
		driver.getDriver().manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		//super.scrollUntilElementToDisplay(VariablesAPI.API_LoanNumber);
		String LoanDeatils  =super.locateElement(VariablesAPI.API_LoanNumber).getText();
		System.out.println("Loan Number:" +LoanDeatils);
	}
	public void createLoan_Lender_Broker() throws InterruptedException {
		
		selectFromDropdown(VariablesAPI.API_PropertyState, VariablesAPI.API_PropertyStateOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		selectFromDropdown(VariablesAPI.API_CollateralType, VariablesAPI.API_CollateralTypeOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		super.locateElement(VariablesAPI.API_PropertyStatus).click();
		//pageScrollDown();
		super.scrollUntilElementToDisplay(VariablesAPI.API_Next);
		super.locateElement(VariablesAPI.API_Next).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		super.locateElement(VariablesAPI.API_Broker).click();
		super.locateElement(VariablesAPI.API_Next).click();
		super.locateElement(VariablesAPI.API_Company).sendKeys("Testing");
		//pageScrollDown();
		// Store new email address
		String newEmail = super.generateEmail();

		// Enter new email id
		super.type(VariablesAPI.API_EmailAddress, newEmail);
		super.locateElement(VariablesAPI.API_Submit).click();
		driver.getDriver().manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		//doubleClickUsingAction(locateElement(VariablesAPI.API_FirstName));
		//super.locateElement(VariablesAPI.API_FirstName).sendKeys("Harika");
		super.type(VariablesAPI.API_FirstName, "Selenium");
		super.locateElement(VariablesAPI.API_LastName).click();
		super.locateElement(VariablesAPI.API_LastName).sendKeys("Broker");
		super.locateElement(VariablesAPI.API_PhoneNumber).click();
		super.locateElement(VariablesAPI.API_PhoneNumber).sendKeys("7896541230");
		super.locateElement(VariablesAPI.API_NavigateNext).click();
		super.type(VariablesAPI.API_FirstName_Guarantor, "Loan");
		super.type(VariablesAPI.API_LastName_Guarantor, "Testing");
		String newEmail1 = super.generateEmail1();
		super.type(VariablesAPI.API_email_Guarantor, newEmail1);
		
		super.scrollUntilElementToDisplay(VariablesAPI.API_ZipCode);
		super.type(VariablesAPI.API_ZipCode, "10019");
		super.type(VariablesAPI.API_Address, "720 fifth avenue");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(VariablesAPI.API_CollateralType1, VariablesAPI.API_CollateralTypeOptions1);
		super.locateElement(VariablesAPI.API_PurchaseRefinance).click();
		super.locateElement(VariablesAPI.API_PurchasePrice).sendKeys("4000");
		super.locateElement(VariablesAPI.API_RehabCost).sendKeys("2000");
		super.locateElement(VariablesAPI.API_AfterRepair).sendKeys("8000");
		super.locateElement(VariablesAPI.API_AsisValue).sendKeys("4500");
		super.locateElement(VariablesAPI.API_AmountRequested).sendKeys("4500");
		selectFromDropdown(VariablesAPI.API_desired_terms, VariablesAPI.API_desired_termsOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.scrollUntilElementToDisplay(VariablesAPI.API_loan_purpose);
		selectFromDropdown(VariablesAPI.API_loan_purpose, VariablesAPI.API_loan_purposeOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		selectFromDropdown(VariablesAPI.API_exit_strategy, VariablesAPI.API_exit_strategyOptions);
		driver.getDriver().manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		super.locateElement(VariablesAPI.API_TermAgreement).click();
		//super.locateElement(VariablesAPI.API_Recaptcha).click();	
		if (isAlertPresent()) {
			Alert alert = driver.getDriver().switchTo().alert();
			// alert.accept();
			alert.dismiss();
		}
		super.locateElement(VariablesAPI.API_SubmitRequest).click();	
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.type(VariablesAPI.API_Password, "BLN!@#bln123");
		super.type(VariablesAPI.API_PasswordCheck, "BLN!@#bln123");
		super.scrollUntilElementToDisplay(VariablesAPI.API_sign);
		super.locateElement(VariablesAPI.API_sign).click();
		driver.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//super.scrollUntilElementToDisplay(VariablesAPI.API_LoanNumber);
		
	}
	public void calenderDate() throws InterruptedException {
		
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		 System.out.println(date1);
	
	}
	public void LoanNumber() throws InterruptedException {
		
		String LoanDeatils  =super.locateElement(VariablesAPI.API_LoanNumber).getText();
		System.out.println("Loan Number:" +LoanDeatils);
	
	}
	
	
}
