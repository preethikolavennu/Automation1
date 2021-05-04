package bln.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import bln.pages.BasePage;
import bln.util.Driver;
import bln.variables.Variables;

public class MyProfile extends BasePage{
	
	private String Message;
	private String UpdatedPhoneNumber;
	private String UpdatedEmailId;
	/**
	 * CustomerSearch Page constructor, sets the driver
	 * @param driver
	 */
	public MyProfile(Driver driver) {
		super(driver);
	}
	public void updatePhoneNumber() {
		// Wait till the 'Enterprise' drop down is displayed
		new WebDriverWait(driver.getDriver(), 60)
				.until(ExpectedConditions.elementToBeClickable(Variables.MyProfile_PhoneNumber));
		WebElement Phone = super.locateElement(Variables.MyProfile_PhoneNumber);
		
		// Enter Phone number
		Phone.clear();
		Phone.sendKeys(Variables.gen_phoneNumber);
		super.locateElement(Variables.MyProfile_UpdateProfile).click();
		

		waitForVisibilityOfAnElement(Variables.MyProfile_UpdateMessage, 120);
	
		Message = super.locateElement(Variables.MyProfile_UpdateMessage).getText().trim();
		
		// Validate amount after adding line
		Assert.assertTrue(Message.equalsIgnoreCase("Your changes have been saved."));
		super.locateElement(Variables.MyProfile_Cont_Btn).click();
	
		
	}
	public void updateintakePhoneNumber() {
		// Wait till the 'Enterprise' drop down is displayed
		new WebDriverWait(driver.getDriver(), 60)
				.until(ExpectedConditions.elementToBeClickable(Variables.IntakeLender_Phone));
		WebElement Phone = super.locateElement(Variables.IntakeLender_Phone);
		
		// Enter Phone number
		Phone.clear();
		Phone.sendKeys(Variables.gen_phoneNumber);
		super.locateElement(Variables.MyProfile_UpdateProfile).click();
		

		waitForVisibilityOfAnElement(Variables.MyProfile_UpdateMessage, 120);
	
		Message = super.locateElement(Variables.MyProfile_UpdateMessage).getText().trim();
		
		// Validate amount after adding line
		Assert.assertTrue(Message.equalsIgnoreCase("Your changes have been saved."));
		super.locateElement(Variables.MyProfile_Cont_Btn).click();
	
		
	}
	/**
	 * Verify Phone Number 
	 * @throws InterruptedException
	 */
	
	public void verifyUpdatedPhoneNumber() {
		
		new WebDriverWait(driver.getDriver(), 60)
		.until(ExpectedConditions.elementToBeClickable(Variables.MyProfile_PhoneNumber_Lender));
		WebElement Phone = super.locateElement(Variables.MyProfile_PhoneNumber_Lender);
		UpdatedPhoneNumber=Phone.getAttribute("Value").replaceAll("[\\D]", "");
		// Validate amount after adding line
		Assert.assertEquals(UpdatedPhoneNumber,Variables.gen_phoneNumber);
		
	}
	
	/**
	 * Update email id 
	 * @throws InterruptedException
	 */
	public void updateEmailId() throws InterruptedException {
		
		new WebDriverWait(driver.getDriver(), 60)
		.until(ExpectedConditions.elementToBeClickable(Variables.MyProfile_Email));
		
		WebElement Email = super.locateElement(Variables.MyProfile_Email);
		// Enter EmailId
		Email.clear();
		Email.sendKeys(Variables.gen_Email);
		
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		super.locateElement(Variables.MyProfile_SaveSetting).click();
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		/*UpdatedEmailId =Email.getAttribute("Value");*/
		// Validate amount after adding line
				//Assert.assertTrue(Message.equalsIgnoreCase("Your changes were saved."));
				super.locateElement(Variables.MyProfile_Cont_Btn).click();
			
		UpdatedEmailId =super.locateElement(Variables.MyProfile_Email).getAttribute("Value");
		// Validate email id 
		Assert.assertEquals(UpdatedEmailId,Variables.gen_Email);
		
	}
	

}
