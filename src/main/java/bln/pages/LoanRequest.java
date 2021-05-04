package bln.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import bln.util.Driver;
import bln.variables.Variables;

public class LoanRequest extends BasePage {
	private String Message;
	public LoanRequest(Driver driver) {
		super(driver);
	}
	
	public void stagnantLoans() throws InterruptedException {
		super.locateElement(Variables.CC_LoaRequest_Stagnant).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 //Get all the mandotory fields in the forum 
		String elements = super.locateElement(Variables. CC_LoaRequest_Stagnant_LoanDeatil).getText();
		System.out.println(elements);
		//Remove stagnanant loan 
		super.locateElement(Variables.CC_LoaRequest_Stagnant_Remove).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		List<WebElement> elements1 = driver.getDriver().findElements(By.cssSelector(".form >div:nth-of-type(1)"));
		for (WebElement webElement : elements1) {
			Assert.assertNotSame(elements, elements1);

		}
	}
	public void selectApprovedLoan()  {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		EnterKeys(locateElement(Variables.Lender_stage),"approved") ;
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Borrower_FirstAddressLink).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void checkMultiUnit() {
		super.locateElement(Variables.Lender_Collateral).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Lender_Collateral_Multi).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		List<WebElement> loan_list = driver.getDriver().findElements(By.cssSelector("div[id='view_multi_unit_info'] input[readonly='readonly']"));
		int searchcount= loan_list.size();
		Assert.assertTrue(searchcount == 10);

	}
	
	public void checkTaxTabEdit() {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement searchBox = driver.getDriver().findElement(By.xpath("//div[@id='add-collateral-modal']//button[contains(text(),'Cancel')]"));
		if (isElementPresent(searchBox))
		{
			super.locateElement(Variables.Lender_Collateral_Close).click();
		}
		driver.getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		clickUsingActions(locateElement(Variables.Lender_Collateral));
		clickUsingActions(locateElement(Variables.Lender_Collateral_Tax));
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	public void checkMultiUnitEdit() {
		
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement searchBox = driver.getDriver().findElement(By.xpath("//div[@id='add-collateral-modal']//button[contains(text(),'Cancel')]"));
		if (isElementPresent(searchBox))
		{
			super.locateElement(Variables.Lender_Collateral_Close).click();
		}
		driver.getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		clickUsingActions(locateElement(Variables.Lender_Collateral));
		clickUsingActions(locateElement(Variables.Lender_Collateral_Multi));
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void checkTaxTab() {
		super.locateElement(Variables.Lender_Collateral).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Lender_Collateral_Tax).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Lender_Collateral_Close).click();
		List<WebElement> loan_list = driver.getDriver().findElements(By.cssSelector("div[id='collateral_info'] >form input[readonly='readonly']"));
		int searchcount= loan_list.size();
		Assert.assertTrue(searchcount == 5);
	
	}
	public void checkInsurance() {
		super.locateElement(Variables.Lender_Collateral).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Lender_Collateral_Insurance).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		/*WebElement searchBox = driver.getDriver().findElement(By.xpath("//div[@id='add-collateral-modal']//button[contains(text(),'Cancel')]"));
		if (isElementPresent(searchBox))
		{
			super.locateElement(Variables.Lender_Collateral_Close).click();
		}*/
		//Assert.assertTrue(super.locateElement(Variables.Lender_InsuranceCheck));
		
		pageScrollDown();
		super.locateElement(Variables.Lender_hoi_insurance).click();
		
	}
	
	
	
	public void legal_ClosingSchedule()  {
		locateElement(Variables.Legal_change).click();
		
		locateElement(Variables.Legal_ClosingScheduleCheckbox).click();
		/*Message = super.locateElement(Variables.Legal_SuccessMessage).getText().trim();
		Assert.assertTrue(Message.equalsIgnoreCase("Changes saved"));*/
	}
	
	public void selectDenyRequest() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			doubleClickUsingAction(locateElement(Variables.Actions_Lender));
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			doubleClickUsingAction(locateElement(Variables.Actions_Lender));
		}
		selectSpecificValueFromDropdown(Variables.broker_Actions_dropdown , Variables.Select_DenyRequest,"Deny Request");
		
		String scoreValue =locateElement(Variables.DenyRequest_PLLText).getText();
		//Assert.assertSame(scoreValue, "Refer to Private Lender Link");
		
		Assert.assertTrue(scoreValue.equalsIgnoreCase("Refer to Private Lender Link"));
		
	}
	
	public void  referToPll() throws InterruptedException {
		// Click on 'Guarantor' link
				//super.locateElement(Variables.Actions_broker).click();
				driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					doubleClickUsingAction(locateElement(Variables.Actions_broker));
				}
				catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
					doubleClickUsingAction(locateElement(Variables.Actions_broker));
				}
				selectSpecificValueFromDropdownNoValue(Variables.broker_Actions_dropdown , Variables.Select_Unassignto_PLL);
				/*List<WebElement> elements1 = driver.getDriver().findElements(By.cssSelector("select[id='action_dropdown'] >option"));
				for(int i=0;i<elements1.size();i++) {
				if(elements1.get(i).getText().equalsIgnoreCase("Unassign From PLL"))
				{
					selectSpecificValueFromDropdown(Variables.broker_Actions_dropdown , Variables.Select_Unassignto_PLL,"Unassign From PLL");
				}
				else if(elements1.get(i).getText().equalsIgnoreCase("Refer to PLL")) {
				selectSpecificValueFromDropdown(Variables.broker_Actions_dropdown , Variables.Select_Unassignto_PLL,"Refer to PLL");
				}
				}*/
			
	}
	public void loanFormatte() throws InterruptedException {
		super.locateElement(Variables.CC_LoanRequest_Column).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 //Get all the mandotory fields in the forum 
		String elements = super.locateElement(Variables. CC_LoaRequest_Stagnant_LoanDeatil).getText();
		System.out.println(elements);
		//Remove stagnanant loan 
		super.locateElement(Variables.CC_LoaRequest_Stagnant_Remove).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		List<WebElement> elements1 = driver.getDriver().findElements(By.cssSelector("div[class='tabulator-col tabulator-sortable'] >div[class='tabulator-col-content'] >div[class='tabulator-col-title']"));

		for (WebElement webElement : elements1) {
			Assert.assertNotSame(elements, elements1);

		}
	}
	
	public void Norequestinvoices() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//super.locateElement(Variables.Lender_SearchBar).click();
		//super.locateElement(Variables.Lender_SearchBar).sendKeys("appro");
		//driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//super.locateElement(Variables.CC_LoaRequest_SearchButton).click();	
		// Click on 'Customer Search' link
		super.locateElement(Variables.Borrower_FirstAddressLink).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Lender_LoanSettings).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		List<WebElement> elements2 = driver.getDriver().findElements(By.cssSelector("table[class='loan-settings-points-table'] >tbody >tr >td:nth-of-type(1)"));
		for(int i=0;i<elements2.size();i++)
		{
			if(elements2.get(i).getText()=="RCN Capital")
			{
				requestInvoice();
			}
			else
			{
				super.locateElement(Variables.Lender_AddPointSplit).click();
				
				selectFromDropdown(Variables.Lender_PaidTo, Variables.Lender_PaidTo_options);
				selectFromDropdown(Variables.Lender_rebate, Variables.Lender_rebate_points);
				driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				super.locateElement(Variables.Lender_points).sendKeys("5");
				//super.locateElement(Variables.Lender_Comments).sendKeys("Lender");
				super.locateElement(Variables.Lender_AddLoanPoints).click();
				//requestInvoice();
			}
		}
		
	}	
	public void resetSearch() throws InterruptedException {
		String LoanNo =	super.locateElement(Variables.CC_LoaRequest_FirstLoanNumber).getText();
		super.locateElement(Variables.CC_LoaRequest_SearchBar).click();
		super.locateElement(Variables.CC_LoaRequest_SearchBar).sendKeys(LoanNo);
		super.locateElement(Variables.CC_LoaRequest_SearchButton).click();	
		List<WebElement> loan_list = driver.getDriver().findElements(By.cssSelector("div[class^='tabulator-row']"));
		int searchcount= loan_list.size();
		Assert.assertTrue(searchcount == 1);
		super.locateElement(Variables.CC_LoaRequest_ResetSearchButton).click();
		List<WebElement> loan_list1 = driver.getDriver().findElements(By.cssSelector("div[class^='tabulator-row']"));
		int resetsearchcount=loan_list1.size();
		Assert.assertNotSame(searchcount, resetsearchcount);
	}
	
	public void selectAll() throws InterruptedException {
		selectFromDropdown(Variables.LoanFee_Filteroption, Variables.LoanFee_Filteroption_ShowAll);
	}
	public void selectActive() throws InterruptedException {
		selectFromDropdown(Variables.LoanFee_Filteroption, Variables.LoanFee_Filteroption_ShowActive);
	}
	
	public void selectActive1() throws InterruptedException {
		selectFromDropdown(Variables.LoanFee_Filteroption, Variables.Filteroption_ShowActive);
	}
	public void selectDenied() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(Variables.LoanFee_Filteroption, Variables.LoanFee_Filteroption_ShowDenied);
	}
	public void selectKilled() throws InterruptedException {
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(Variables.LoanFee_Filteroption, Variables.Lender_Killed);
	}
	public void verifyStatusDenied() throws InterruptedException {
		try {
			
			List<WebElement> headernav = driver.getDriver().findElements(By.xpath("//div[@tabulator-field='stage' and @role='gridcell']"));
			//System.out.println(headernav.size());
			for(int i=0;i<=headernav.size();i++)
			{
				//System.out.println(headernav.get(i).getText());

				Assert.assertTrue(headernav.get(i).getText().equalsIgnoreCase("Denied"));
		
			}
			}
			 catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
			 }
	}
	public void verifyStatusWithDraw() throws InterruptedException {
		try {
			
			List<WebElement> headernav = driver.getDriver().findElements(By.xpath("//div[@tabulator-field='stage' and @role='gridcell']"));
			//System.out.println(headernav.size());
			for(int i=0;i<=headernav.size();i++)
			{
				//System.out.println(headernav.get(i).getText());

				Assert.assertTrue(headernav.get(i).getText().equalsIgnoreCase("killed"));
		
			}
			}
			 catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
			 }
	}
	
	
	public void borrower_resetSearch() throws InterruptedException {
		String LoanNo =	super.locateElement(Variables.Borrower_FirstLoan).getText();
		super.locateElement(Variables.CC_LoaRequest_SearchBar).click();
		super.locateElement(Variables.CC_LoaRequest_SearchBar).sendKeys(LoanNo);
		super.locateElement(Variables.CC_LoaRequest_SearchButton).click();	
		List<WebElement> loan_list = driver.getDriver().findElements(By.cssSelector("div[class^='tabulator-row']"));
		int searchcount= loan_list.size();
		Assert.assertTrue(searchcount == 1);
		super.locateElement(Variables.CC_LoaRequest_ResetSearchButton).click();
		List<WebElement> loan_list1 = driver.getDriver().findElements(By.cssSelector("div[class^='tabulator-row']"));
		int resetsearchcount=loan_list1.size();
		Assert.assertNotSame(searchcount, resetsearchcount);
		
	}
	public void broker_searchLoan() throws InterruptedException {
		String LoanNo =	super.locateElement(Variables.Borrower_FirstLoan).getText();
		super.locateElement(Variables.CC_Loan_SearchBar).click();
		super.locateElement(Variables.CC_Loan_SearchBar).sendKeys(LoanNo);
		//super.locateElement(Variables.CC_LoaRequest_SearchButton).click();	
		/*List<WebElement> loan_list = driver.getDriver().findElements(By.cssSelector("div[class^='tabulator-row']"));
		int searchcount= loan_list.size();
		Assert.assertTrue(searchcount == 1);
		super.locateElement(Variables.CC_LoaRequest_ResetSearchButton).click();
		List<WebElement> loan_list1 = driver.getDriver().findElements(By.cssSelector("div[class^='tabulator-row']"));
		int resetsearchcount=loan_list1.size();
		Assert.assertNotSame(searchcount, resetsearchcount);*/
		
	}
	public void revertToLender() throws InterruptedException {
		try {
			List<String> appeasementText = super.listOfVisibleElementText(Variables.IntakeLender_LoanAction_List);

			Boolean appeasementFlag = false;

			for (int i = 0; i < appeasementText.size(); i++) {
				if (appeasementText.get(i).equalsIgnoreCase(Variables.Revert_to_Lender)) {
					appeasementFlag = true;
					break;
				}
			}

			Assert.assertFalse(appeasementFlag);
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
	}
	}
	public void revertToLender_LoanGrid() throws InterruptedException {
		
		super.locateElement(Variables.IntakeLender_Actions).click();
		try {
			List<String> appeasementText = super.listOfVisibleElementText(Variables.IntakeLender_Actions_List);

			Boolean appeasementFlag = false;

			for (int i = 0; i < appeasementText.size(); i++) {
				if (appeasementText.get(i).equalsIgnoreCase(Variables.Revert_to_Lender)) {
					appeasementFlag = true;
					break;
				}
			}

			Assert.assertFalse(appeasementFlag);
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
	 }
	}
	public void actions() throws InterruptedException {
		try {
			List<String> appeasementText = super.listOfVisibleElementText(Variables.IntakeLender_LoanAction_List);

			Boolean appeasementFlag = false;

			for (int i = 0; i < appeasementText.size(); i++) {
				if (appeasementText.get(i).equalsIgnoreCase(Variables.Title_Request_Email)) {
					appeasementFlag = true;
					break;
				}
			}

			Assert.assertFalse(appeasementFlag);
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
	 }
	}
	public void actions_LoanGrid() throws InterruptedException {
		
		super.locateElement(Variables.IntakeLender_Actions).click();
		try {
			List<String> appeasementText = super.listOfVisibleElementText(Variables.IntakeLender_Actions_List);

			Boolean appeasementFlag = false;

			for (int i = 0; i < appeasementText.size(); i++) {
				if ((appeasementText.get(i).equalsIgnoreCase(Variables.Title_Request_Email))||(appeasementText.get(i).equalsIgnoreCase(Variables.Add_to_Queue))){
					appeasementFlag = true;
					break;
				}
			}

			Assert.assertFalse(appeasementFlag);
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
	 }
	 
	}
public void actions_SetClosingLoan() throws InterruptedException {
		
		super.locateElement(Variables.IntakeLender_Actions).click();
		try {
			List<String> appeasementText = super.listOfVisibleElementText(Variables.IntakeLender_Actions_List);

			super.locateElement(Variables.IntakeLender_Actions_ClosingStatus).click();
			
			driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			locateElement(Variables.Legal_ClosingScheduleCheckbox).click();
			/*Message = super.locateElement(Variables.Legal_SuccessMessage).getText().trim();
			Assert.assertTrue(Message.equalsIgnoreCase("Changes saved"));*/
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
	 }
	 
	}
public void oldTabs() throws InterruptedException {
		try {
			List<String> appeasementText = super.listOfVisibleElementText(Variables.IntakeLender_OldTabs_List);

			Boolean appeasementFlag = false;

			for (int i = 0; i < appeasementText.size(); i++) {
				if ((appeasementText.get(i).equalsIgnoreCase(Variables.Loan_Settings))
						||(appeasementText.get(i).equalsIgnoreCase(Variables.Financial))
						||(appeasementText.get(i).equalsIgnoreCase(Variables.UnderWriting))
						||(appeasementText.get(i).equalsIgnoreCase(Variables.LoanApprovals))){
					appeasementFlag = true;
					break;
				}
			}

			Assert.assertFalse(appeasementFlag);
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
	 }
	 
	}
	/**
	 * Clicks on 'Customer Search' link to navigate to CustomerSearch page
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public LoanInside navigateToLoanInside() throws InterruptedException {
		
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Click on 'Customer Search' link
		super.locateElement(Variables.Borrower_FirstAddressLink).click();
		
		/*Actions actions = new Actions(driver.getDriver());
		WebElement elementLocator = super.locateElement(Variables.Borrower_FirstLoan);
		actions.doubleClick(elementLocator).perform();*/
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Return CustomerSearch page
		return new LoanInside(driver);
	}
	
	/**
	 * Clicks on 'Customer Search' link to navigate to CustomerSearch page
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public Application navigateToApplication() throws InterruptedException {
		
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Click on 'Customer Search' link
		super.locateElement(Variables.Borrower_CreateLoan).click();
		
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Return CustomerSearch page
		return new Application(driver);
	}
}
