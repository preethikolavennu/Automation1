package bln.pages;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import bln.util.Driver;
import bln.variables.Variables;
import bln.variables.VariablesAPI;

public class Settings extends BasePage{
	private String Message;
	public Settings(Driver driver) {
		super(driver);
	}  
	public void updatePhoneNumber() {
		// Wait till the 'Enterprise' drop down is displayed
		new WebDriverWait(driver.getDriver(), 60)
				.until(ExpectedConditions.elementToBeClickable(Variables.BrokeragePhone));
		WebElement Phone = super.locateElement(Variables.BrokeragePhone);
		
		// Enter Phone number
		Phone.clear();
		Phone.sendKeys(Variables.gen_phoneNumber);
		super.locateElement(Variables.BrokerageSaveButton).click();
		

		waitForVisibilityOfAnElement(Variables.MyProfile_UpdateMessage, 120);
	
		Message = super.locateElement(Variables.MyProfile_UpdateMessage).getText().trim();
		
		// Validate amount after adding line
		Assert.assertTrue(Message.equalsIgnoreCase("Your changes were saved."));
		super.locateElement(Variables.MyProfile_Cont_Btn).click();
	}
	public void lenderAssignment() {
		/*new WebDriverWait(driver.getDriver(), 60)
		.until(ExpectedConditions.elementToBeClickable(Variables.Broker_LenderAssignment));*/
		super.locateElement(Variables.Broker_LenderAssignment).click();
	}
	public void Add_Lender() throws InterruptedException {
		super.locateElement(Variables.Broker_AddLender).click();
	/*	super.locateElement(Variables.Broker_NewLender).sendKeys("5");
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/
		super.locateElement(Variables.Broker_NewLender).click();
		/*String newLender = super.generateName();

		// Enter new email id
		super.type(Variables.Broker_NewLenderName, newLender);*/
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		super.locateElement(Variables.Broker_NewLenderName).sendKeys("Testingharika");
		super.locateElement(Variables.Broker_NewLenderName).sendKeys(Keys.ENTER);
		
	}

	public void featureAccess() {
		new WebDriverWait(driver.getDriver(), 60)
		.until(ExpectedConditions.elementToBeClickable(Variables.Broker_FeatureAccess));
	}
	public void fee_AddAutoFee() throws InterruptedException {
		super.locateElement(Variables.Broker_Fee).click();
		super.locateElement(Variables.Broker_AddFee).click();
		selectValueFromDropdownRandomly(Variables.Broker_SelectFeeType, Variables.Broker_SelectFeeType_Value);
		super.locateElement(Variables.Broker_DefaultAmount).sendKeys("5");
		super.locateElement(Variables.Broker_Description).sendKeys("Testing Auto Fee");
		super.locateElement(Variables.Broker_AddFeeButton).click();
	}
	public void fee_RemoveAutoFee() throws InterruptedException {
		super.locateElement(Variables.Broker_Fee).click();
		super.locateElement(Variables.Broker_RemoveFee).click();
		Alert alert_test = driver.getDriver().switchTo().alert();
		alert_test.accept();
	}
	public void hardCreditReport() {
		assertTrue(!locateElement(Variables.Broker_hardCreditReport).isEnabled(), "Recall button is enabled");
	}
	public void navigateTofilter_option() {
		// TODO Auto-generated method stub
		
	}
}
