package bln.pages;

import org.openqa.selenium.Alert;

import bln.util.Driver;
import bln.variables.Variables;

public class CrossVersionDev extends BasePage{
	
	public CrossVersionDev(Driver driver) {
		super(driver);
	}
	public void setBorrower() throws InterruptedException {
		super.locateElement(Variables.New_Borrower).click();
		super.locateElement(Variables.SaveSetting).click();
	}

}
