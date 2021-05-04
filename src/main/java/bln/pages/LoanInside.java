package bln.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import bln.util.Driver;
import bln.variables.Variables;


public class LoanInside extends BasePage {
	private String LoanDeatils;
	private String Message;
	private String UpdatedPurchasePrice;
	public LoanInside(Driver driver) {
		super(driver);
	}
	public void addLog() throws InterruptedException {
		super.locateElement(Variables.Borrower_Message).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_Addlog).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_Addlog_Msg).click();
		super.locateElement(Variables.Borrower_Addlog_Msg).sendKeys("Testing Notes");
		
		super.locateElement(Variables.Borrower_Addlog_Inside).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String log=super.locateElement(Variables.Borrower_logcheck).getText();
		//System.out.println("log" +log);
		// Verify Log  message
		Assert.assertEquals("Testing Notes",log);
	}
	
	public void updatePurchasePrice() {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement searchBox = driver.getDriver().findElement(By.xpath("//div[@id='add-collateral-modal']//button[contains(text(),'Cancel')]"));
		if (isElementPresent(searchBox))
		{
			super.locateElement(Variables.Lender_Collateral_Close).click();
		}
		driver.getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		clickUsingActions(locateElement(Variables.Lender_Collateral));
		// Wait till the 'Enterprise' drop down is displayed
		new WebDriverWait(driver.getDriver(), 60)
				.until(ExpectedConditions.elementToBeClickable(Variables.Lender_PurchasePrice));
		WebElement Phone = super.locateElement(Variables.Lender_PurchasePrice);
		
		// Enter Phone number
		Phone.clear();
		Phone.sendKeys(Variables.gen_purchasePrice);
		super.pageScrollByValue();
		super.locateElement(Variables.Lender_save).click();
		pageScrollUp();
		new WebDriverWait(driver.getDriver(), 60)
		.until(ExpectedConditions.elementToBeClickable(Variables.Lender_Refresh));
		//super.locateElement(Variables.Lender_Refresh).click();
	
		
	}
	/**
	 * Verify Phone Number 
	 * @throws InterruptedException
	 */
	
	public void verifyPurchasePrice() {
		
		new WebDriverWait(driver.getDriver(), 60)
		.until(ExpectedConditions.elementToBeClickable(Variables.Lender_PurchasePrice));
		WebElement Phone = super.locateElement(Variables.Lender_PurchasePrice);
		UpdatedPurchasePrice=Phone.getAttribute("Value").replaceAll("[\\D]", "");
		// Validate amount after adding line
		Assert.assertEquals(UpdatedPurchasePrice,"967600");
		
	}
	public void RCN_LoanProgram()  {
		super.locateElement(Variables.Loan_settings).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	
		waitForVisibilityOfAnElement(Variables.Lender_Program, 120);
		
		Message = super.locateElement(Variables.Lender_Program).getText().trim();
		
		// Validate amount after adding line
		Assert.assertTrue(Message.equalsIgnoreCase("Loan Program:"));
	}
	public void RCN_newCollateral()  {
		super.locateElement(Variables.Loan_collateral).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	
		waitForVisibilityOfAnElement(Variables.Lender_refresh, 120);
		
		Message = super.locateElement(Variables.Lender_refresh).getText().trim();
		
		// Validate amount after adding line
		Assert.assertTrue(Message.equalsIgnoreCase("Refresh Tab"));
	}
	public void creditAuth() throws InterruptedException {
		super.locateElement(Variables.Lender_contact).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		new WebDriverWait(driver.getDriver(), 60)
		.until(ExpectedConditions.elementToBeClickable(Variables.Lender_Guarantor));
		//super.locateElement(Variables.Lender_Guarantor).click();
		String log=super.locateElement(Variables.Auth_URL).getText();
		driver.getDriver().navigate().to(log);
		super.locateElement(Variables.Lender_Guarantor).sendKeys("123-45-6789");	
	}
	public void closingSummary() throws InterruptedException {
		super.locateElement(Variables.Legal_ClosingSummary).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locateElement(Variables.Legal_ClosingSchedule).click();
		Message = super.locateElement(Variables.Legal_ScheduleText).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("SCHEDULED"));
	}
	public void interestRebate() throws InterruptedException {
		super.locateElement(Variables.Lender_LoanSettings).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locateElement(Variables.Legal_AddPointSplit).click();
		/*Message = super.locateElement(Variables.Legal_ScheduleText).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("SCHEDULED"));*/
	}
	public void Lender_addLog() throws InterruptedException {
		super.locateElement(Variables.Lender_Message).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Lender_Addlog).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_Addlog_Msg).click();
		super.locateElement(Variables.Borrower_Addlog_Msg).sendKeys("Testing Notes");
		super.locateElement(Variables.Borrower_Addlog_Inside).click();
		super.locateElement(Variables.Lender_ViewLog).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String log=super.locateElement(Variables.Lender_logcheck).getText();
		//System.out.println("log" +log);
		// Verify Log  message
		Assert.assertEquals("Testing Notes",log);
	}
	public void addMessage() throws InterruptedException {
		super.locateElement(Variables.Borrower_Message).click();
		// Wait For Page To Load
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Wait for item  to become clickable
		super.locateElement(Variables.Borrower_Newmessage).click();
		// Wait for item  to become clickable
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_Subject).click();
		super.locateElement(Variables.Borrower_Subject).sendKeys("Testing");
		driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_SelectAll).click();
		
		
		// Wait for item to become clickable
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_MessageBody).click();
		super.locateElement(Variables.Borrower_MessageBody).sendKeys("Testing");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_SendMessage).click();
		// Wait for item to become clickable
/*		super.locateElement(Variables.Borrower_cont).click();	*/
	}
	public void addMessage_Lender() throws InterruptedException {
		
		WebElement myLink =super.locateElement(Variables.Lender_Close_Popup);
		if (myLink.isDisplayed())
		{
		   super.locateElement(Variables.Lender_Close).click();
		}
		// Wait For Page To Load
				driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		super.locateElement(Variables.Lender_Message).click();
		// Wait For Page To Load
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Wait for item  to become clickable
		super.locateElement(Variables.Borrower_Newmessage).click();
		// Wait for item  to become clickable
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Lender_NewMessage).click();
		super.locateElement(Variables.Lender_NewMessage).sendKeys("Testing");
		// Wait for item to become clickable
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_MessageBody).click();
		super.locateElement(Variables.Borrower_MessageBody).sendKeys("Testing");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_SendMessage).click();
		// Wait for item to become clickable
		super.locateElement(Variables.Borrower_cont).click();	
	}
	public void cloneLoan() throws InterruptedException {
		try {
		super.locateElement(Variables.Lender_LoanSettings).click();
		String Borrower_Details  =locateElement(Variables.Borrower_Details).getText();
		String Guarantor_Details  =locateElement(Variables.Guarantor_Details).getText();
		List<WebElement> broker = listOfVisibleElements(Variables.LoanFee_Details_values);
		List<String> all_elements_text=new ArrayList<>();
		for(int i=0;i<=broker.size();i++)
		{
			 all_elements_text.add(broker.get(i).getText());
			
		}
		selectFromDropdown(Variables.Lender_ChooseAction, Variables.Lender_ClonetheLoan);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Lender_closealert1).click();
		String Borrower_Details1  =locateElement(Variables.Borrower_Details).getText();
		String Guarantor_Details1 =locateElement(Variables.Guarantor_Details).getText();
		String LoanAmount_Details =locateElement(Variables.LoanAmount_Details).getText();
		Assert.assertEquals(Borrower_Details, Borrower_Details1);
		Assert.assertEquals(Guarantor_Details, Guarantor_Details1);
		Assert.assertEquals(LoanAmount_Details, "$50,000.00");
		
		driver.getDriver().manage().timeouts().implicitlyWait(220, TimeUnit.SECONDS);
		super.locateElement(Variables.Lender_LoanSettings).click();
		Dimension size= super.locateElement(Variables.LoanFee_Details).getSize();
		//System.out.println(size);
		List<WebElement> broker1 = listOfVisibleElements(Variables.LoanFee_Details_values);
		List<String> all_elements_text1=new ArrayList<>();
		for(int i=0;i<=broker1.size();i++)
		{
			 all_elements_text1.add(broker1.get(i).getText());
		}
		
		Assert.assertTrue(all_elements_text.equals(all_elements_text1));
	}
	 catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
	 }
		
	}
	public void addcomments() throws InterruptedException {
		super.locateElement(Variables.Borrower_Lead).click();
		super.locateElement(Variables.Borrower_comment).click();
		super.locateElement(Variables.Borrower_comment).sendKeys("Testing comments");
		super.locateElement(Variables.Borrower_savecomment).click();
	}
	public void holdLoan() throws InterruptedException {
		super.locateElement(Variables.Broker_HoldLoan).click();
		super.locateElement(Variables.Broker_AddcommentsforHold).sendKeys("Testing Hold");
		super.locateElement(Variables.Broker_contforHold).click();
		
	}
	public void killLoan() throws InterruptedException {
		String LoanDeatils  =locateElement(Variables.Broker_loanNumber1).getText();
		System.out.println("Loan Number:" +LoanDeatils);
		super.locateElement(Variables.Broker_denyRequest).click();
		selectFromDropdown(Variables.Broker_denyRequest_Reason, Variables.Broker_denyRequest_Reason_option);
		super.locateElement(Variables.Broker_denyRequest_Reason_cnt).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	public void validateDeniedLoan(String LoanDeatils) throws InterruptedException {
		super.type(Variables.CC_LoaRequest_SearchBar, LoanDeatils);
		String StageDetails  =locateElement(Variables.Broker_stage).getText();
		System.out.println("Stage:" +StageDetails);
		
	}
	public void removeholdLoan() throws InterruptedException {
		super.locateElement(Variables.Broker_RemoveHold).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Close the Alert
		Alert alert_test = driver.getDriver().switchTo().alert();
		alert_test.accept();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String value=super.locateElement(Variables.Broker_Text).getText();
		Assert.assertEquals(value, "The request has been reactivated.");
		super.locateElement(Variables.Broker_cont).click();
		
	}
	public void makePayment() throws InterruptedException {
		super.locateElement(Variables.Borrower_LeadInfo).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_MakePayment).click();
	}
	public void addBroker() throws InterruptedException {
		super.locateElement(Variables.Borrower_Contacts).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_AddBroker).click();
		super.locateElement(Variables.Borrower_searchterm).sendKeys("Test");
		super.locateElement(Variables.Borrower_searchbutton).click();
/*		selectDDValue(Variables.Borrower_brokerDropdown);
		// Occupancy
		List<WebElement> broker = listOfVisibleElements(Variables.Borrower_brokerDropdownValue);
		randomElementSelection(broker).click();*/
		
		selectFromDropdown(Variables.Borrower_brokerDropdown, Variables.Borrower_brokerDropdownValue);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(Variables.Borrower_empDropdown, Variables.Borrower_empDropdownValue);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Close the Alert
		Alert alert_test = driver.getDriver().switchTo().alert();
		alert_test.accept();
	}
	public void expereince() throws InterruptedException {
		super.locateElement(Variables.Borrower_expereince).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_addProperty).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(Variables.Borrower_collateraltype, Variables.Borrower_collateraltypeValues);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_collateralAddress).sendKeys("720 fifth avenue");
		super.locateElement(Variables.Borrower_collateralcity).sendKeys("new york");
		selectFromDropdown(Variables.Borrower_Statetype, Variables.Borrower_collateraltypeValues);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_collateralzipcode).sendKeys("10019");
		super.locateElement(Variables.Borrower_collateraltitle).sendKeys("mr");
		super.locateElement(Variables.Borrower_collateralownership).sendKeys("20");
		super.locateElement(Variables.Borrower_collateralacquisition).sendKeys("03/05/2020");
		//selectFromDropdown(Variables.Borrower_statustype, Variables.Borrower_collateraltypeValues);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_save).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
	
	public void budgethidden() throws InterruptedException {
		super.locateElement(Variables.Borrower_budgetHide).click();
		driver.getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		List<WebElement> hiddenbudget = driver.getDriver().findElements(By.cssSelector("div[class='tabulator-table'] div[tabulator-field='budget_amount']"));
		int searchcount= hiddenbudget.size();
		
		  for(WebElement i:hiddenbudget)
	        {
	            System.out.println(i.getText());
	            //Reporter.log(i.getText());
	        } 
		/*for(int i=0;i<=searchcount;i++)
		{
			String value = hiddenbudget.get(i).getText();
			Assert.assertNotEquals(value, "0");
		}*/
	}
	public void infoUpdate() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(Variables.Borrower_collateraltype, Variables.Borrower_collateraltypeValues);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_collateralinfoAddress).sendKeys("720 fifth avenue");
		super.locateElement(Variables.Borrower_collateralinfocity).sendKeys("new york");
		selectFromDropdown(Variables.Borrower_Statetype, Variables.Borrower_collateraltypeValues);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_collateralinfozipcode).sendKeys("10019");
		//super.locateElement(Variables.Borrower_infosave).click();
	}
	public void leadtoloaninfo() throws InterruptedException {
		super.locateElement(Variables.Borrower_Lead).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_continue).click();
		driver.getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		String leftnav=super.locateElement(Variables.Borrower_checkpage).getText();
		Assert.assertEquals(leftnav, "Loan Info");
	}
	public void loaninfotocontact() throws InterruptedException {
		super.locateElement(Variables.Borrower_LeadInfo).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_continue).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String leftnav=super.locateElement(Variables.Borrower_checkpage).getText();
		Assert.assertEquals(leftnav, "Contacts");
	}
	public String getOrderNumber() {
		return LoanDeatils;
	}

	public void setOrderNumber(String LoanDeatils) {
		this.LoanDeatils = LoanDeatils;
	}

}
