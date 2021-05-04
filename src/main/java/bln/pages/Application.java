package bln.pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import bln.util.Driver;
import bln.variables.Variables;


public class Application extends BasePage{
	
	public Application(Driver driver) {
		super(driver);
	} 
	public ArrayList<String> LoanOfficer() throws InterruptedException, AWTException {
		locateElement(Variables.RcnCapital_LoanOfficer_List).click();
		
	 /*List<WebElement> loan_list1 = driver.getDriver().findElements(By.cssSelector("li[id^='select2-loan_officer']"));
	 for(int i=0;i<=loan_list1.size();i++)
	 {
	    test=loan_list1.get(i).getText();
	    System.out.println(test);
	 }*/

	 ArrayList<String> obtainedList = new ArrayList<>(); 
	 List<WebElement> elementList= driver.getDriver().findElements(By.cssSelector("li[id^='select2-loan_officer']"));
	 for(WebElement we:elementList){
	    obtainedList.add(we.getText());
	 }
	 ArrayList<String> sortedList = new ArrayList<>();   
	 for(String s:obtainedList){
	 sortedList.add(s);
	 }
	 Collections.sort(sortedList);
	 
	 return(sortedList);
	 	
	}
	public void createLoan_Lender() throws InterruptedException {
		
		super.locateElement(Variables.BrokerInfo).click();
		super.locateElement(Variables.BrokerInfo).sendKeys("Regression");
		super.locateElement(Variables.Search).click();
		selectFromDropdown(Variables.Brokerage_dropdown, Variables.Brokerage_dropdown_Option);
		selectFromDropdown(Variables.Emp_dropdown, Variables.Emp_dropdown_Option);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.GuarantorInfo).click();
		super.locateElement(Variables.GuarantorInfo).sendKeys("sam");
		super.locateElement(Variables.GuarantorSearch).click();
		selectFromDropdown(Variables.Guarantor_dropdown, Variables.Guarantor_dropdown_Option);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		super.locateElement(Variables.Lender_Addresszip).sendKeys("10019");
		super.locateElement(Variables.Lender_Addressaddress).sendKeys("720 fifth avenue");
		super.locateElement(Variables.Lender_Addresscity).sendKeys("New York");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(Variables.Lender_Collateral_Dropdown, Variables.Lender_Collateral_Dropdown_Option);
		// Select Purchase or Refinance
		List<WebElement> purchaseref = listOfVisibleElements(Variables.Lender_PurchaseRef);
		randomElementSelection(purchaseref).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Lender_PurchaseOriginal).sendKeys("40000");
		super.locateElement(Variables.Lender_PurchaseRehabCost).sendKeys("20000");
		super.locateElement(Variables.Lender_PurchaseARV).sendKeys("90000");
		super.locateElement(Variables.Lender_PurchaseAsisValue).sendKeys("50000");
		super.locateElement(Variables.Lender_AmountRequested).sendKeys("25000");
		selectFromDropdown(Variables.Lender_DesiredTerm, Variables.Lender_DesiredTerm_Option);
		selectFromDropdown(Variables.Lender_UseOfFunds, Variables.Lender_UseOfFunds_Option);
		selectFromDropdown(Variables.Lender_ExitStrategy, Variables.Lender_ExitStrategy_Option);
		selectFromDropdown(Variables.Lender_LoanOfficer, Variables.Lender_LoanOfficer_Option);
		selectFromDropdown(Variables.Lender_LoanProgram, Variables.Lender_LoanProgram_Option);
		super.locateElement(Variables.Lender_SubmitRequest).click();
	}
	public void applicationFillup() throws InterruptedException, AWTException {
		//Select Purchase or Refinance
		List<WebElement> purchaseref = listOfVisibleElements(Variables.Borrower_Application_Purchase);
		randomElementSelection(purchaseref).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Select Use of Funds
		List<WebElement> UseFunds = listOfVisibleElements(Variables.Borrower_Application_UseofFunds);
		randomElementSelection(UseFunds).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Select ExitStrategy
		List<WebElement> ExitStrategy = listOfVisibleElements(Variables.Borrower_Application_ExitStrategy);
		randomElementSelection(ExitStrategy).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_AmountRequested).sendKeys("50000");
		
		WebElement myLink =super.locateElement(Variables.Borrower_PurchasePrice);
		if (myLink.isDisplayed())
		{
		   myLink.sendKeys("65,000");
		}
		WebElement myLink1 =super.locateElement(Variables.Borrower_RehabCost);
		if (myLink1.isDisplayed())
		{
		   myLink1.sendKeys("40,000");
		}
		WebElement myLink2 =super.locateElement(Variables.Borrower_borrowercontribution);
		if (myLink2.isDisplayed())
		{
		   myLink2.sendKeys("10,000");
		}
		
		//Select from drop down
		selectFromDropdown(Variables.Borrower_DesiredTerm, Variables.Borrower_DesiredTerm_Dropdown);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_NextButton1).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		/**
		 * Property Details
		 */
		super.locateElement(Variables.Borrower_Address).sendKeys(Keys.ENTER);
		WebElement fromDropDwon2 = locateElement(Variables.Borrower_Address1);
		fromDropDwon2.click();
		super.locateElement(Variables.Borrower_Addresszip).sendKeys("10019");
		super.locateElement(Variables.Borrower_Addressaddress).sendKeys("720 fifth avenue");
		super.locateElement(Variables.Borrower_Addresscity).sendKeys("New York");
		 /*if (locateElement(Variables.Borrower_AddressStatearrow).isDisplayed()) {
			selectFromDropdown(Variables.Borrower_AddressStatearrow, Variables.Borrower_AddressStateValue);
		 }*/
		super.locateElement(Variables.Borrower_AddressOkButton).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Property Type
		List<WebElement> PropertyType = listOfVisibleElements(Variables.Borrower_PropertyType);
		randomElementSelection(PropertyType).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Occupancy
		List<WebElement> Occupancy = listOfVisibleElements(Variables.Borrower_Occupancy);
		randomElementSelection(Occupancy).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//living
		super.locateElement(Variables.Borrower_plan_on_living).click();
		// Purchasesale
		List<WebElement> Purchasesale = listOfVisibleElements(Variables.Borrower_purchasesale);
		randomElementSelection(Purchasesale).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		super.locateElement(Variables.Borrower_AsisValue).sendKeys("70000");
		
		WebElement myLink4 =super.locateElement(Variables.Borrower_RepairValue);
		if (myLink4.isDisplayed())
		{
			super.locateElement(Variables.Borrower_RepairValue).sendKeys("150000");
		}
		
		WebElement myLink3 =super.locateElement(Variables.Borrower_collateralType);
		if (myLink3.isDisplayed())
		{
			//Select from drop down
			selectFromDropdown(Variables.Borrower_collateralType, Variables.Borrower_collateralType_Value);
		}
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_NextButton2).click();
		
		/**
		 * Personal Details
		 */
		super.locateElement(Variables.Borrower_PhoneNumber).sendKeys("9676874990");
		
		//super.locateElement(Variables.Borrower_Lookupaddress).sendKeys("Borrower_Lookupaddress");
		WebElement fromDropDwon3 = locateElement(Variables.Borrower_Address2);
		fromDropDwon3.click();
		super.locateElement(Variables.Borrower_Addresszip2).sendKeys("10019");
		super.locateElement(Variables.Borrower_Addressaddress2).sendKeys("720 fifth avenue");
		super.locateElement(Variables.Borrower_Addresscity2).sendKeys("New York");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//selectFromDropdown(Variables.Borrower_AddressStatearrow2, Variables.Borrower_AddressStateValue2);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_AddressOkButton2).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_dob).sendKeys("16/05/1994");
		// How many investment properties have you sold?
		super.locateElement(Variables.Borrower_flipped_properties).sendKeys("2");
		// How many rental properties do you own?
		super.locateElement(Variables.Borrower_num_rental_properties).sendKeys("4");
		WebElement CreditScore = super.locateElement(Variables.Borrower_credit_score);
		// Enter Phone number
		CreditScore.clear();
		// Credit Score:
		CreditScore.sendKeys("750");
		// Agreement check
		super.locateElement(Variables.Borrower_agreement).click();
		// SubmitRequest
		super.locateElement(Variables.SubmitRequest).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables. Borrower_SSN).sendKeys("666225801");
		super.locateElement(Variables.Borrower_SSN_Submit).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		String LoanDeatils  =locateElement(Variables.LOanDeatils).getText();
		System.out.println("Loan Number:" +LoanDeatils);
	}
	public void applicationFillup1() throws InterruptedException, AWTException {
		//Select Purchase or Refinance
		List<WebElement> purchaseref = listOfVisibleElements(Variables.Borrower_Application_Purchase);
		randomElementSelection(purchaseref).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Select Use of Funds
		List<WebElement> UseFunds = listOfVisibleElements(Variables.Borrower_Application_UseofFunds);
		randomElementSelection(UseFunds).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Select ExitStrategy
		List<WebElement> ExitStrategy = listOfVisibleElements(Variables.Borrower_Application_ExitStrategy);
		randomElementSelection(ExitStrategy).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_AmountRequested).sendKeys("50000");
		
		WebElement myLink =super.locateElement(Variables.Borrower_PurchasePrice);
		if (myLink.isDisplayed())
		{
		   myLink.sendKeys("65,000");
		}
		WebElement myLink1 =super.locateElement(Variables.Borrower_RehabCost);
		if (myLink1.isDisplayed())
		{
		   myLink1.sendKeys("40,000");
		}
		WebElement myLink2 =super.locateElement(Variables.Borrower_borrowercontribution);
		if (myLink2.isDisplayed())
		{
		   myLink2.sendKeys("10,000");
		}
		
		
		//Select from drop down
		selectFromDropdown(Variables.Borrower_DesiredTerm, Variables.Borrower_DesiredTerm_Dropdown);
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clickUsingActions(locateElement(Variables.Borrower_NextButton1));
		//super.locateElement(Variables.Borrower_NextButton1).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/**
		 * Property Details
		 */
		super.locateElement(Variables.Borrower_Address).sendKeys(Keys.ENTER);
		WebElement fromDropDwon2 = locateElement(Variables.Borrower_Address1);
		fromDropDwon2.click();
		super.locateElement(Variables.Borrower_Addresszip).sendKeys("10019");
		super.locateElement(Variables.Borrower_Addressaddress).sendKeys("720 fifth avenue");
		super.locateElement(Variables.Borrower_Addresscity).sendKeys("New York");
		 if (locateElement(Variables.Borrower_AddressStatearrow).isDisplayed()) {
			selectFromDropdown(Variables.Borrower_AddressStatearrow, Variables.Borrower_AddressStateValue);
		 }
		super.locateElement(Variables.Borrower_AddressOkButton).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Property Type
		List<WebElement> PropertyType = listOfVisibleElements(Variables.Borrower_PropertyType);
		randomElementSelection(PropertyType).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Occupancy
		List<WebElement> Occupancy = listOfVisibleElements(Variables.Borrower_Occupancy);
		randomElementSelection(Occupancy).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//living
		super.locateElement(Variables.Borrower_plan_on_living).click();
		// Purchasesale
		List<WebElement> Purchasesale = listOfVisibleElements(Variables.Borrower_purchasesale);
		randomElementSelection(Purchasesale).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		super.locateElement(Variables.Borrower_AsisValue).sendKeys("70000");
		
		WebElement myLink4 =super.locateElement(Variables.Borrower_RepairValue);
		if (myLink4.isDisplayed())
		{
			super.locateElement(Variables.Borrower_RepairValue).sendKeys("150000");
		}
		
		WebElement myLink3 =super.locateElement(Variables.Borrower_collateralType);
		if (myLink3.isDisplayed())
		{
			//Select from drop down
			selectFromDropdown(Variables.Borrower_collateralType, Variables.Borrower_collateralType_Value);
		}
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_NextButton2).click();
		super.locateElement(Variables.Guarantor_Name).sendKeys("Harika");
		super.locateElement(Variables.Guarantor_Search).click();
		super.locateElement(Variables.Guarantor_Properties).sendKeys("2");
		super.locateElement(Variables.Guarantor_rentalProperties).sendKeys("2");
		super.locateElement(Variables.Guarantor_accept).click();
		super.locateElement(Variables.SubmitRequest).click();
	}
	
}
