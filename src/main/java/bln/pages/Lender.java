package bln.pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import bln.util.Driver;
import bln.variables.Variables;
import bln.variables.VariablesAPI;



public class Lender extends BasePage{
	private String Message;

	public Lender(Driver driver) {
		super(driver);
	}
	public void programType() throws InterruptedException {
		super.locateElement(Variables.CC_Lender_ProgramType_Space).sendKeys(Keys.SPACE);
		super.locateElement(Variables.CC_Lender_ProgramType_Space).sendKeys(Keys.ENTER);
		// Store visible sizes and click on random size
		List<WebElement> sizeList = listOfVisibleElements(Variables.CC_Lender_ProgramType);
		randomElementSelection(sizeList).click();
		driver.getDriver().navigate().refresh();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	public void lenderName() throws InterruptedException {
		super.locateElement(Variables.CC_Lender_Search).sendKeys("Lend some");
		super.locateElement(Variables.CC_Lender_Select).click();
		selectFromDropdown(Variables.CC_Lender_SelectAction, Variables.CC_Lender_ActionValue);
		//super.locateElement(Variables.CC_Lender_Name).sendKeys("Lend some Money Test");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement Name = super.locateElement(Variables.CC_Lender_Name);

		// Enter Name
		Name.clear();
		Name.sendKeys(Variables.Lender_Name);
		
		super.locateElement(Variables.CC_Lender_Save).click();
		
		waitForVisibilityOfAnElement(Variables.CC_UpdateMessage, 120);
		
		Message = super.locateElement(Variables.CC_UpdateMessage).getText().trim();
		
		// Validate amount after adding line
		Assert.assertTrue(Message.equalsIgnoreCase("Your changes were saved."));
		super.locateElement(Variables.MyProfile_Cont_Btn).click();
	
		
	}
	public ArrayList<String> RCN_loanOfficers() throws InterruptedException {
		RCNEmp = locateElement(Variables.RcnCapital_Employee);
		Officer = locateElement(Variables.RcnCapital_Officer);
		hoverOverElement(RCNEmp,Officer);
		//List<WebElement> sizeList = listOfVisibleElements(Variables.RcnCapital_LoanOfficer);
		/*List<WebElement> sizeList=driver.getDriver().findElements(By.xpath("//i[starts-with(@class, 'jstree-icon')and contains(@class, 'glyphicon-eye-open')]//parent::a"));
		for(int i=0;i<sizeList.size();i++)
		{
			OfficerList = sizeList.get(i).getText();
			System.out.println(OfficerList);
		}*/
		ArrayList<String> obtainedList = new ArrayList<>(); 
		 List<WebElement> elementList= driver.getDriver().findElements(By.xpath("//i[starts-with(@class, 'jstree-icon')and contains(@class, 'glyphicon-eye-open')]//parent::a"));
		 for(WebElement we:elementList){
		    obtainedList.add(we.getText());
		 }
		 ArrayList<String> sortedList1 = new ArrayList<>();   
		 for(String s:obtainedList){
		 sortedList1.add(s);
		 }
		 Collections.sort(sortedList1);
		locateElement(Variables.Stop_Impersonation).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return(sortedList1);
	}

	public void RCN_lendingStates()  {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locateElement(Variables.Lending_States).click();
		clickUsingActions(locateElement(Variables.Lendingstates_all));
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		locateElement(Variables.Lendingstates_dakota).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locateElement(Variables.Lendingstates_save).click();
		waitForVisibilityOfAnElement(Variables.MyProfile_UpdateMessage, 120);
		
		Message = super.locateElement(Variables.MyProfile_UpdateMessage).getText().trim();
		
		// Validate amount after adding line
		Assert.assertTrue(Message.equalsIgnoreCase("Your changes were saved."));
		super.locateElement(Variables.MyProfile_Cont_Btn).click();
	}
	public void RCN_PropertyType()  {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locateElement(Variables.Property_Type).click();
		clickUsingActions(locateElement(Variables.PropertyType_Select));
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locateElement(Variables.PropertyType_save).click();
		waitForVisibilityOfAnElement(Variables.MyProfile_UpdateMessage, 120);
		
		Message = super.locateElement(Variables.MyProfile_UpdateMessage).getText().trim();
		
		// Validate amount after adding line
		Assert.assertTrue(Message.equalsIgnoreCase("Your changes were saved."));
		super.locateElement(Variables.MyProfile_Cont_Btn).click();
	}
	public void RCN_LoanType()  {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locateElement(Variables.Loan_Type).click();
		clickUsingActions(locateElement(Variables.PropertyType_Select));
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locateElement(Variables.LoanType_save).click();
		waitForVisibilityOfAnElement(Variables.MyProfile_UpdateMessage, 120);
		
		Message = super.locateElement(Variables.MyProfile_UpdateMessage).getText().trim();
		
		// Validate amount after adding line
		Assert.assertTrue(Message.equalsIgnoreCase("Your changes were saved."));
		super.locateElement(Variables.MyProfile_Cont_Btn).click();
	}
	
	
	
	public void rcn_addEmployee()  {
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		locateElement(Variables.Employee_Detail).click();
		locateElement(Variables.add_employes).click();
		driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		locateElement(Variables.first_name).sendKeys("Harika");
		locateElement(Variables.last_name).sendKeys("Test");
		locateElement(Variables.phone_no).sendKeys("7896541203");
		// Store new email address
		String newEmail = super.generateEmail();
		// Enter new email id
		super.type(Variables.email_id, newEmail);
		locateElement(Variables.add_employee).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.type(Variables.Email_Detail, newEmail);
	}
	public void rcn_editEmployee()  {
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		locateElement(Variables.Employee_Detail).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		locateElement(Variables.role_employee).sendKeys("other");
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			clickUsingActions(locateElement(Variables.Edit_Role));
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			clickUsingActions(locateElement(Variables.Edit_Role));
		}
	
		//locateElement(Variables.Edit_Role).click();
		locateElement(Variables.EmployeeIntake).click();
		locateElement(Variables.UpdateEmployee).click();
		waitForVisibilityOfAnElement(Variables.MyProfile_UpdateMessage, 120);

		Message = super.locateElement(Variables.MyProfile_UpdateMessage).getText().trim();

		// Validate amount after adding line
		Assert.assertTrue(Message.equalsIgnoreCase("Your changes have been saved."));
		super.locateElement(Variables.MyProfile_Cont_Btn).click();
	}
	
	
	
	
	public void typo()  {
		locateElement(Variables.Selecting_1stloan).click();
		
		locateElement(Variables. Closing_summary1).click();
		locateElement(Variables.  payment_calculator).click();
		
		Message = super.locateElement(Variables.Total_monthaly_payment).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("TOTAL MONTHLY PAYMENT"));
	
	}
	
	public void add_columns_to_apprisal_grid()  {
		locateElement(Variables.Apprisal).click();
		
		Message = super.locateElement(Variables.loan_officer).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("LO"));
		Message = super.locateElement(Variables.Garunteer).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("Guarantor"));
		Message = super.locateElement(Variables.Stage).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("Stage"));
		Message = super.locateElement(Variables.Est_closing_date).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("Est Closing Date"));
	}
	public void copy_documents_link_in_broker_portal()  {
		locateElement(Variables.Apprisal).click();
		
		Message = super.locateElement(Variables.loan_officer).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("LO"));
		Message = super.locateElement(Variables.Garunteer).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("Guarantor"));
		Message = super.locateElement(Variables.Stage).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("Stage"));
		Message = super.locateElement(Variables.Est_closing_date).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("Est_closing_date"));
		
	
	}
	public void rcn_AddColletral()  {
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		locateElement(Variables.Employee_Detail).click();
		locateElement(Variables.add_employes).click();
		driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		locateElement(Variables.first_name).sendKeys("Harika");
		locateElement(Variables.last_name).sendKeys("Test");
		locateElement(Variables.phone_no).sendKeys("7896541203");
		// Store new email address
		String newEmail = super.generateEmail();
		// Enter new email id
		super.type(Variables.email_id, newEmail);
		locateElement(Variables.add_employee).click();
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		super.type(Variables.Email_Detail, newEmail);
	}

}
