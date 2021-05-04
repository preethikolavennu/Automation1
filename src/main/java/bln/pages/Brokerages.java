package bln.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import bln.variables.Variables;
import bln.util.Driver;

public class Brokerages extends BasePage{
	
	public Brokerages(Driver driver) {
		super(driver);
	}
	public void NotesSections_Brokerages() throws InterruptedException {
		
		if (locateElement(Variables.CC_Notes).isDisplayed()) {
			// Click on Apply button
			clickUsingActions(locateElement(Variables.CC_Notes));
			/*waitForVisibilityOfAnElement(Variables.CC_Notes, 30);
			locateElement(Variables.CC_Notes).clear();*/
			locateElement(Variables.CC_Notes).sendKeys("Updated Notes");
			locateElement(Variables.CC_Notes).sendKeys(Keys.ENTER);
			driver.getDriver().navigate().refresh();
			driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Assert.assertTrue(super.locateElement(Variables.CC_Notes).getText().trim().contains("Updated Notes"));
		}
		
	}
	
}
