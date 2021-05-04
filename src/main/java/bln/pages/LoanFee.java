package bln.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import bln.util.Driver;
import bln.variables.Variables;

public class LoanFee extends BasePage{
	private String reasonForReship;
	public LoanFee(Driver driver) {
		super(driver);
	}
	public void Filters_Edit_CC() throws InterruptedException {
		//Select credit card from drop down
		selectSpecificValueFromDropdown(Variables.CC_LoanFee_FiltersList, Variables.Select_Unpaid,"Unpaid");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(Variables.CC_LoanFee_Actions, Variables.CC_LoanFee_Actions_Edit);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectSpecificValueFromDropdown(Variables.CC_LoanFee_Actions_Edit_FeeType, 		Variables.CC_LoanFee_Actions_Edit_FeeType_options,"Appraisal/BPO The deposit will be applied toward the total ...");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locateElement(Variables.CC_LoanFee_Actions_Edit_Amount).clear();
		clickUsingActions(locateElement(Variables.CC_LoanFee_Actions_Edit_Amount));
		locateElement(Variables.CC_LoanFee_Actions_Edit_Amount).sendKeys("24.98");
		locateElement(Variables.CC_LoanFee_Actions_Edit_SubmitAmount).click();
	}
	public void Filters_delete() throws InterruptedException {
		// Select credit card from drop down
		selectSpecificValueFromDropdown(Variables.CC_LoanFee_FiltersList, Variables.Select_Unpaid, "Unpaid");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectFromDropdown(Variables.CC_LoanFee_Actions, Variables.CC_LoanFee_Actions_Delete);	
	}
	
	public void Filters_CopyURL() throws InterruptedException {
		
		// Select credit card from drop down
		selectSpecificValueFromDropdown(Variables.CC_LoanFee_FiltersList, Variables.Select_Unpaid, "Unpaid");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selectSpecificValueFromDropdown(Variables.CC_LoanFee_Actions_Select_Amount, Variables.CC_LoanFee_Actions_CopyURL, "Copy Direct Payment URL");
		//selectFromDropdown(Variables.CC_LoanFee_Actions_Select_Amount, Variables.CC_LoanFee_Actions_CopyURL);
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Alert alert = driver.getDriver().switchTo().alert();
		String alerttext = alert.getText();
		alert.accept();	
		driver.getDriver().manage().deleteAllCookies();
		// Navigate to OMSC 
		driver.getDriver().navigate().to(alerttext);
		
		// Accept if bln alert is present
		if (isAlertPresent()) {
			Alert alert1 = driver.getDriver().switchTo().alert();
			alert1.accept();	
		}
	}
	

	
	


}
