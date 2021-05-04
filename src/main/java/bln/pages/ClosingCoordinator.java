package bln.pages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import bln.util.Driver;
import bln.variables.Variables;


public class ClosingCoordinator extends BasePage{
	
	public ClosingCoordinator(Driver driver) {
		super(driver);
	}
	public void add_CC() throws InterruptedException {
		locateElement(Variables.CC_AddCoordinator).click();
		//wait until  forum opens
		waitForVisibilityOfAnElement(Variables.CC_FirstName, 30);
		//enter forum details 
 		super.locateElement(Variables.CC_FirstName).sendKeys("testing");
 		super.locateElement(Variables.CC_last_name).sendKeys("data");
 		super.locateElement(Variables.CC_username).sendKeys("test");
 		super.locateElement(Variables.CC_ClosingCoordinatorEmail).sendKeys("test@gmail.com");
 		super.locateElement(Variables.CC_ClosingCoordinatorPhone).sendKeys("7896541203");
 		locateElement(Variables.CC_AddCoordinator).click();
 		
 		//System.out.println(super.locateElement(Variables.CC_ClosingCoordinatorDetails).getText());
 		
	}
	public void delete_CC() throws InterruptedException {
		super.locateElement(Variables.CC_second_page).click();
		waitForVisibilityOfAnElement(Variables.CC_ClosingCoordinatorDelete, 30);
		super.locateElement(Variables.CC_ClosingCoordinatorDelete).click();
		// Close the Alert
		Alert alert_test = driver.getDriver().switchTo().alert();
		alert_test.accept();
 		
	}
	
	
}
