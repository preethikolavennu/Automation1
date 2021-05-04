 package bln.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import bln.util.Driver;
import bln.variables.Variables;
import bln.variables.VariablesAPI;


public class BasePage {

	/** Driver Reference */
	protected Driver driver;
	private WebElement userNameTextBox;
	private WebElement passwordTextBox;
	private WebElement clickSubmitButton;
	public WebElement RCNEmp;
	public WebElement Officer;
	public WebElement Setting;
	public WebElement Setting_Company;
	public String OfficerList;
	public String sortedList;
	public String sortedList1;
	private String webOrderEmail;
	protected String enteredEmail;
	public String test;
	/**
	 * Wait for element visibility
	 * 
	 * @param by
	 * @param time
	 */
	public void waitForVisibilityOfAnElement(By by, long time) {

		// Wait
		new WebDriverWait(driver.getDriver(), time).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
		
		public void LoanOfficerTest(String OfficerList, String loanList) throws InterruptedException, AWTException {
		 
		 Assert.assertEquals(sortedList1, sortedList);
		 	
		}
		/**
		 * Clears the field and then writes in it
		 * 
		 * @param by
		 *            Element that will be written into
		 * @param s
		 *            String to be written into the field
		 */
		public void type(By by, String s) {

			int count = 0;
			int maxTries = 3;

			do {

				try {
					// Locate element
					WebElement w = locateElement(by);

					// Type data
					type(w, s);

					// Break if data is entered without exception correctly
					break;
				} catch (WebDriverException e) {

					// TODO: handle exception
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (++count == maxTries)
						throw e;
				}
			} while (true);
		}

	/**
	 * List the inner text of all the Web Elements
	 * 
	 * @param by
	 *            identifier of the list element
	 * @return Returns the list of the inner text of the web elements
	 */
	public List<String> listOfVisibleElementText(By by) {

		// List of all the elements
		List<WebElement> elementList = listOfVisibleElements(by);

		// List of the inner text of the web elements
		List<String> elementTextList = new ArrayList<String>();

		for (int i = 0; i < elementList.size(); i++) {
			// Add the inner text to elementListText list
			elementTextList.add(elementList.get(i).getText().trim());
		}

		// Returns elementTextList Object
		return elementTextList;
	}
	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed() || element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * Hover over the given element
	 * 
	 * @param w
	 *            Web Element
	 */
	public void hoverOverElement(WebElement w,WebElement sub) {
		// Create Actions object
		Actions hover = new Actions(driver.getDriver());
		// hover on the element
		/*hover.moveToElement(w);
		// Perform the Action
		hover.perform();*/
		hover.moveToElement(w).moveToElement(sub).click().build().perform();
	}
	
	public void requestInvoice() throws InterruptedException {
	selectFromDropdown(Variables.Lender_Action_LoanSettings, Variables.Lender_Action_LoanSettings_options);
	locateElement(Variables.Lender_Action_LoanSettings).click();
	List<String> elements3 = listOfVisibleElementText(Variables.Lender_Action_LoanSettings_options);
	for(int j=0;j<elements3.size();j++)
	{
		Assert.assertNotSame(elements3, "Request Invoice");
	}
	}
	/**
	 * 
	 * 
	 * 
	 * Check for Alerts
	 * 
	 * @return
	 */
	public Boolean isAlertPresent() {

		try {
			driver.getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			return false;
		}
	}
	public void acceptAlert() {
		if (isAlertPresent()) {
			Alert alert = driver.getDriver().switchTo().alert();
			alert.accept();
		}
	}
	public Select selectDDValue(By by) {
		WebElement w = locateElement(by);
		Select s = new Select(w);
		return s;

	}
	/**
	 * Locate element, and then hover over
	 * 
	 * @param by
	 *            Unique identifier of the element
	 * @throws InterruptedException
	 */
	public void hoverOverElement(By by) throws InterruptedException {
		// Create Actions object
		Actions hover = new Actions(driver.getDriver());
		// Get the field element
		WebElement w = driver.getDriver().findElement(by);
		// hover on the element
		hover.moveToElement(w);
		// Perform the Action
		hover.perform();
		// Pause for 3 seconds
		Thread.sleep(30001);
	}
	/**
	 * Checks whether an element is present on the page or not
	 * 
	 * @param by
	 *            Unique identifier of the element
	 * @return Returns the element or throws an exception
	 */
	public WebElement locateElement(By by) {
		try {
			// Get the element by Unique identifier of the element
			WebElement w = driver.getDriver().findElement(by);
			return w;
		} catch (NoSuchElementException e) {

			
			// Shown Element not found message if the element is not found
			throw new NoSuchElementException(" Element not found");
		}
	}
	/**
	 * Page Scroll Up
	 */
	public void pageScrollUp() {
		locateElement(Variables.pageBody).sendKeys(Keys.HOME);
	}

	/**
	 * Page Scroll Down
	 */
	public void pageScrollDown() {
		locateElement(Variables.pageBody).sendKeys(Keys.END);
	}
	public void scrollUntilElementToDisplay(By by) throws InterruptedException {

		WebElement element = locateElement(by);
		((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);

	}
	/**
	 * Generate an email based on current UNIX time stamp
	 * 
	 * @return Returns the generated email
	 */
	public String generateName() {
		// Create Random object
		Random r = new Random();

		// Returns randomly generated email id

		webOrderEmail = "blntest" + Integer.toString(r.nextInt(32000)) + Integer.toString(r.nextInt(999));
		setEnteredEmail(webOrderEmail);

		return webOrderEmail;

	}

	/**
	 * Generate an email based on current UNIX time stamp
	 * 
	 * @return Returns the generated email
	 */
	public String generateEmail() {
		// Create Random object
		Random r = new Random();

		// Returns randomly generated email id

		webOrderEmail = "blntest" + Integer.toString(r.nextInt(32000)) + Integer.toString(r.nextInt(999))
				+ "@gmail.com";
		setEnteredEmail(webOrderEmail);

		return webOrderEmail;

	}
	/**
	 * Generate an email based on current UNIX time stamp
	 * 
	 * @return Returns the generated email
	 */
	public String generateEmail1() {
		// Create Random object
		Random r = new Random();

		// Returns randomly generated email id

		webOrderEmail = "blntestguarantor" + Integer.toString(r.nextInt(32000)) + Integer.toString(r.nextInt(999))
				+ "@gmail.com";
		setEnteredEmail(webOrderEmail);

		return webOrderEmail;

	}
	/**
	 * Switch to window
	 * 
	 * @param parentWindow
	 */
	public void switchToWindow(String parentWindow) {

		// Store all window handles
		Set<String> allWindows = driver.getDriver().getWindowHandles();

		// Child window
		String childWindow = null;

		for (String windowHandle : allWindows) {

			if (!windowHandle.equals(parentWindow)) {
				childWindow = windowHandle;
				break;
			}
		}

		// Switch to child window
		driver.getDriver().switchTo().window(childWindow);
	}
	/**
	 * Clears the field and then writes in it
	 * 
	 * @param w
	 *            Element that will be written into
	 * @param s
	 *            String to be written into the field
	 * @throws InterruptedException
	 */
	public void type(WebElement w, String s) {

		// Clear the field
		w.clear();
		// Write the string in it
		w.sendKeys(s);

	}

	
	
	/**
	 * Select a random element from the given list of elements
	 * 
	 * @param elementList
	 *            List of elements
	 * @return Returns the randomly selected web element
	 */
	public WebElement randomElementSelection(List<WebElement> elementList) {
		// Create Random Object
		Random r = new Random();
		// Generate random index using the list size
		int index = r.nextInt(elementList.size());
		// Store random element in W
		WebElement w = elementList.get(index);
		// Returns webelement
		return w;
	}
	public void moveUsingActions() throws AWTException {
		Actions actions = new Actions(driver.getDriver());

		Robot robot = new Robot();

		robot.mouseMove(250,250);

		actions.click().build().perform();

		robot.mouseMove(200,70);

		actions.click().build().perform();
	}
	
	/**
	 * Wait for element visibility
	 * 
	 * @param by
	 * @param time
	 */
	public void waitForVisibilityOfAnElement(WebElement w, long time) {

		// Wait
		new WebDriverWait(driver.getDriver(), time).until(ExpectedConditions.visibilityOf(w));
	}

	/**
	 * Wait for element to be clickable
	 * 
	 * @param by
	 * @param time
	 */
	public void waitForElementToBeClickable(By by, long time) {

		// Wait
		new WebDriverWait(driver.getDriver(), time).until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Wait for element to be clickable
	 * 
	 * @param by
	 * @param time
	 */
	public void waitForElementToBeClickable(WebElement w, long time) {

		// Wait
		new WebDriverWait(driver.getDriver(), time).until(ExpectedConditions.elementToBeClickable(w));
	}
	
	
	/**
	 * Base Page constructor, sets the driver
	 * 
	 * @param <Driver>
	 * @param driver
	 *            driver created by BaseTest class
	 */
	public BasePage(Driver driver) {
		this.driver = driver;
	}
	public void clickUsingActions(WebElement w) {
		Actions actions = new Actions(driver.getDriver());
		actions.moveToElement(w).click().perform();
	}

	public void doubleClickUsingAction(WebElement w){
		Actions actions = new Actions(driver.getDriver());
		actions.moveToElement(w).doubleClick().perform();
	}
	public void doubleClickUsingActions(Object object){
		Actions actions = new Actions(driver.getDriver());
		actions.moveToElement((WebElement) object).doubleClick().perform();
	}
	public void EnterKeys(WebElement w, String v) {
		Actions action = new Actions(driver.getDriver());
		action.moveToElement(w).doubleClick().perform();
		action.sendKeys(v).build().perform();
	}

	public void openURLinNewTab(String urlLink) {

	    Actions act = new Actions(driver.getDriver());
	    act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
	    ArrayList<String> tabs = new ArrayList<String> (driver.getDriver().getWindowHandles());
	    driver.getDriver().switchTo().window(tabs.get(2)); //switches to new tab
	    driver.getDriver().get(urlLink);
	
	}
	
	/**
	 * Scroll down the page
	 */
	public void pageScrollByValue() {
		JavascriptExecutor jse = (JavascriptExecutor) driver.getDriver();
		jse.executeScript("scroll(0, 250)");
	}


	/**
	 * Method to login to bln with provided user credentials
	 * 
	 * @throws InterruptedException
	 */
	public void logIntoBLN() throws InterruptedException {
		driver.getDriver().navigate().to("https://aws-stage.blnsoftware.com/members/login/");

		waitForVisibilityOfAnElement(Variables.logIn_userName_tb, 120);

		// Locate the elements in Login Page
		userNameTextBox = locateElement(Variables.logIn_userName_tb);
		passwordTextBox = locateElement(Variables.logIn_pwd_tb);
		clickSubmitButton = locateElement(Variables.logIn_click_Submit_btn);

		// Enter valid credentials and click on Submit button
		type(userNameTextBox, Variables.emailId);
		Thread.sleep(1000l);
		userNameTextBox.sendKeys(Keys.TAB);
		Thread.sleep(1000l);
		type(passwordTextBox, Variables.pswd);
		Thread.sleep(1000l);
		clickSubmitButton.click();
		Thread.sleep(1000l);
	}
	
	
	/**
	 * Method to login to Selenium Broker WordPress Plugin API V2
	 * 
	 * @throws InterruptedException
	 */
	public API logIntoBrokerwpv2API() throws InterruptedException {
		driver.getDriver().navigate().to("https://seleniumbroker.blnsoftware.com/wpv2/");
		
		// Return CustomerSearch page
		return new API(driver);
	}
	
	/**
	 * Method to login to Selenium Broker WordPress Plugin API V3
	 * 
	 * @throws InterruptedException
	 */
	public API logIntoBrokerwpv3API() throws InterruptedException {
		driver.getDriver().navigate().to("https://seleniumbroker.blnsoftware.com/wpv3/");
		// Return CustomerSearch page
		return new API(driver);
	}
	/**
	 * Method to login to Selenium Broker WordPress
	 * 
	 * @throws InterruptedException
	 */
	public API logIntoBrokerAPI() throws InterruptedException {
		driver.getDriver().navigate().to("https://seleniumbroker.blnsoftware.com/");
		// Return CustomerSearch page
		return new API(driver);
	}
	/**
	 *Method to login to Selenium Lender WordPress Plugin API V2
	 * 
	 * @throws InterruptedException
	 */
	public API logIntoLenderwpv2API() throws InterruptedException {
		driver.getDriver().navigate().to("https://seleniumlender.blnsoftware.com/wpv2/");
		// Return CustomerSearch page
		return new API(driver);
	}
	/**
	 *  Method to login to Selenium Lender WordPress Plugin API V3
	 * 
	 * @throws InterruptedException
	 */
	public API logIntoLenderwpv3API() throws InterruptedException {
		driver.getDriver().navigate().to("https://seleniumlender.blnsoftware.com/wpv3/");
		// Return CustomerSearch page
		return new API(driver);
	}
	/**
	 * Method to login to Selenium Lender WordPress Plugin
	 * 
	 * @throws InterruptedException
	 */
	public API logIntoLenderAPI() throws InterruptedException {
		driver.getDriver().navigate().to("https://seleniumlender.blnsoftware.com/");
		// Return CustomerSearch page
		return new API(driver);
	}
	/**
	 * Valdiate header nav 
	 * @throws InterruptedException
	 */
	public void validateHeaderNav() throws InterruptedException {
		try {
		
		List<WebElement> headernav = driver.getDriver().findElements(By.cssSelector("#loan_menu >li >a"));
		//System.out.println(headernav.size());
		for(int i=0;i<=headernav.size();i++)
		{
			System.out.println(headernav.get(i).getText());

			Assert.assertTrue(headernav.get(i).getText().equalsIgnoreCase("My Profile")
					|| headernav.get(i).getText().equalsIgnoreCase("Clients")
					|| headernav.get(i).getText().equalsIgnoreCase("Loan Requests"));
	
		}
		}
		 catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
		 }
	}
	
	

	/**
	 * Checks whether an element is present on the page or not
	 * 
	 * @param by
	 *            Unique identifier of the element
	 * @return Returns true if the element is found, returns false otherwise
	 */
	public Boolean verifyElement(By by) {
		try {
			// Get the element using the Unique identifier of the element
			driver.getDriver().findElement(by);
		} catch (NoSuchElementException e) {
			// Return false if element is not found
			return false;
		} catch (Exception e) {
			return false;
		}
		// Return true if element is found
		return true;
	}
	/**
	 * Selects a value form the Dropdown
	 * 
	 * @param dropdown
	 * @param elements
	 * @throws InterruptedException
	 */
	public String selectFromDropdown(By dropdown, By elements) throws InterruptedException {

		// Store selection
		String selectedValue = "";

		// Locate the Drop-down and click on it
		//locateElement(dropdown).click();
		clickOnElement(locateElement(dropdown));

		// Wait for 5 seconds
		Thread.sleep(5000l);

		// List of all the elements of the drop down
		List<WebElement> elementsInDropdown = driver.getDriver().findElements(elements);

		// Only list the visible elements and click on it
		for (int i = 0; i < elementsInDropdown.size(); i++) {
			if (elementsInDropdown.get(i).isDisplayed()) {
				selectedValue = elementsInDropdown.get(i).getText();
				elementsInDropdown.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		// Return String value
		return selectedValue;
	}
	
	
	//***** this is click on webelement using Action class*********
	public void clickOnElement(WebElement elm) {
		Point p= elm.getLocation();
		Actions actions = new Actions(driver.getDriver());
		actions.moveToElement(elm).moveByOffset(p.x,p.y).click().perform();
	}
	
	/**
	 * Click on element using Java script
	 * 
	 * @param by
	 */
	public void clickOnElementUsingJavaScript(By by) {
		// Get web element
		WebElement w = locateElement(by);

		clickOnElementUsingJavaScript(w);
	}
	/**
	 * Click on element using Java script
	 * 
	 * @param w
	 */
	public void clickOnElementUsingJavaScript(WebElement w) {
		// Initialize Java script executor
		JavascriptExecutor executor = (JavascriptExecutor) driver.getDriver();

		// Click on element
		executor.executeScript("arguments[0].click();", w);
	}

	/**
	 * Selects a value form the Drop down
	 * 
	 * @param dropdown
	 * @param elements
	 * @throws InterruptedException
	 */
	public void selectSpecificValueFromDropdown(By dropdown, By elements, String value) throws InterruptedException {

		clickOnElementUsingJavaScript(dropdown);

		// Locate the Drop-down and click on it
		locateElement(dropdown).click();
		Thread.sleep(5000l);

		// List of all the elements of the drop down
		List<WebElement> elementsInDropdown = driver.getDriver().findElements(elements);

		// Only list the visible elements and click on it
		for (int i = 0; i < elementsInDropdown.size(); i++) {
			if (elementsInDropdown.get(i).isDisplayed()) {
				if (elementsInDropdown.get(i).getText().equalsIgnoreCase(value)) {
					elementsInDropdown.get(i).click();

					locateElement(dropdown).sendKeys(Keys.TAB);
					break;
				}
			}
		}
	}
	
	/**
	 * Selects a value form the Drop down
	 * 
	 * @param dropdown
	 * @param elements
	 * @throws InterruptedException
	 */
	public void selectSpecificValueFromDropdownNoValue(By dropdown, By elements) throws InterruptedException {

		clickOnElementUsingJavaScript(dropdown);

		// Locate the Drop-down and click on it
		locateElement(dropdown).click();
		Thread.sleep(5000l);

		// List of all the elements of the drop down
		List<WebElement> elementsInDropdown = driver.getDriver().findElements(elements);

		// Only list the visible elements and click on it
		for (int i = 0; i < elementsInDropdown.size(); i++) {
			if (elementsInDropdown.get(i).isDisplayed()) {
				{
					elementsInDropdown.get(i).click();
					locateElement(dropdown).sendKeys(Keys.TAB);
					break;
				}
			}
		}
	}
	/**
	 * Selects a value form the Drop down randomly
	 * 
	 * @param dropdown
	 * @param elements
	 * @throws InterruptedException
	 */
	public void selectValueFromDropdownRandomly(By dropdown, By elements) throws InterruptedException {

		clickOnElementUsingJavaScript(dropdown);

		// Locate the Drop-down and click on it
		locateElement(dropdown).click();
		Thread.sleep(5000l);

		// List of all the elements of the drop down
		List<WebElement> elementsInDropdown = driver.getDriver().findElements(elements);
		
		// Only list the visible elements and click on it
		for (int i = 0; i < elementsInDropdown.size(); i++) {
			if (elementsInDropdown.get(i).isDisplayed()) {
				
					elementsInDropdown.get(i).click();
					locateElement(dropdown).sendKeys(Keys.TAB);
					break;
			}
		}
	}
	
	
	
	/**
	 * Click on create order link
	 * @throws InterruptedException 
	 */
	public void LRGColumns() throws InterruptedException {
		// Loan Requests
		locateElement(Variables.Loan_Request_Link).click();
	
		/*List<WebElement> elementList = driver.getDriver().findElements(By.xpath("//div[@class='tabulator-headers']"));
		ArrayList<String> obtainedList = new ArrayList<>();
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
		}*/
		
		 //to catch all web elements into list
	    List<WebElement> myList=driver.getDriver().findElements(By.xpath("//div[@class='tabulator-headers']"));

	    //if you want to get all elements text into array list
	    List<String> all_elements_text=new ArrayList<>();

	    for(int i=0; i<myList.size(); i++){

	        //loading text of each element in to array all_elements_text
	        all_elements_text.add(myList.get(i).getText());

	    }
	    StringBuilder sb = new StringBuilder();
	    for (String s : all_elements_text)
	    {
	        sb.append(s);
	        sb.append("\t");
	    }
	    ArrayList<String> wordArrayList = new ArrayList<String>();
	    for(String word : sb.toString().split("\n")) {
	    	wordArrayList.add(word);
	    }

	    //System.out.println(wordArrayList);
		// List 1
		List<String> HeaderList = Arrays.asList("Actions","Loan","Amount","Brokerage","Client","Lender","Property","Accept Date","Modified Date","Stage","Status","Coordinator	");

		// List 2
		ArrayList<String> otherList = new ArrayList<>();

		// Copy all items from list 1 to list 2
		otherList.addAll(HeaderList);

		//System.out.println(otherList);
		Assert.assertEquals(wordArrayList, otherList);
		

	}
	/**
	 * Click on create order link
	 * @throws InterruptedException 
	 */
	public void SoftCreditPull() throws InterruptedException {
		locateElement(Variables.softPull_Button).click();
		Thread.sleep(1000l);
		 //Get all the mandotory fields in the forum 
		List <WebElement> elements = driver.getDriver().findElements(By.xpath("//div[contains(@class, 'form_label') and contains(.//span, '*')]" )); //Print the Elements in the list for (WebElement webElement: elements) {
		  
		 for (WebElement webElement: elements) {
		
		System.out.println(webElement.getText());
		 }
		 locateElement(Variables.NewLoan_Forum_FirstName).sendKeys("JOHN");
		 locateElement(Variables.NewLoan_Forum_LastName).sendKeys("ALFORD");

		WebElement fromDropDwon = locateElement( Variables.NewLoan_Forum_Address);
		fromDropDwon.click();
		fromDropDwon.sendKeys("10790 KIAWAH");
		fromDropDwon.sendKeys(Keys.ENTER);
		
		//Close the Alert
		Alert alert_test = driver.getDriver().switchTo().alert();
		alert_test.accept();
		// Wait For Page To Load
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
		
		 locateElement(Variables.NewLoan_Forum_City).sendKeys("EDEN PRAIRIE");
		 locateElement(Variables.NewLoan_Forum_State).click();
		 locateElement(Variables.NewLoan_Forum_Postalcode).sendKeys("55344");
		 locateElement(Variables.NewLoan_Forum_SSN).sendKeys("666-22-5801");
		 
		 locateElement(Variables.order_soft_report_button).click();
		 if (locateElement(Variables.Broker_select).isDisplayed()) {
				// Click on Apply button
				//clickUsingActions(locateElement(Variables.Broker_select));
				 locateElement(Variables.Broker_select).click();

			}
		
		// Wait For Page To Load
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
		//locateElement(Variables.See).click();
		// Wait For Page To Load
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		String scoreValue =locateElement(Variables.Score).getText();
		System.out.println(scoreValue);
		
		//Click on Create request
		locateElement(Variables.CreateRequest).click();
		
		
		 
	}
	
	/**
	 * Click on create order link
	 * @throws InterruptedException 
	 */
	public void createRequest() throws InterruptedException {
		//Click on Create request
		locateElement(Variables.CreateRequest).click();
	}
	/**
	 * Click on create order link
	 * @throws InterruptedException 
	 */
	public void rejectRequest() throws InterruptedException {
		// Wait For Page To Load
		driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
		List<WebElement> decision = listOfVisibleElements(Variables.RejectrequestReasons);
		randomElementSelection(decision).click();
		locateElement(Variables.Rejectrequest).click();
		
	}
	/**
	 * Click on create order link
	 * @throws InterruptedException 
	 */
	public void lenderLoanFetch() throws InterruptedException {
		String LoanDeatils  =locateElement(Variables.LoanNum).getText();
		System.out.println("Loan Number:" +LoanDeatils);
	}
	/**
	 * Click on create order link
	 * @throws InterruptedException 
	 */
	public void brokerLoanFetch() throws InterruptedException {
		String LoanDeatils  =locateElement(Variables.Broker_loanNumber1).getText();
		System.out.println("Loan Number:" +LoanDeatils);
	}
	/**
	 * List all the Web elements
	 * 
	 * @param by
	 *            identifier of the list element
	 * @return Returns the list of the web elements
	 */
	public List<WebElement> listOfVisibleElements(By by) {
		// List of all the elements
		List<WebElement> elementList = driver.getDriver().findElements(by);
		// List of all visible elements
		List<WebElement> visiableElementList = new ArrayList<WebElement>();

		for (int i = 0; i < elementList.size(); i++) {
			elementList = driver.getDriver().findElements(by);
			// if check to verify visibility of the element
			if (driver.getDriver().findElements(by).get(i).isDisplayed()) {
				// Add element to visibleElement list
				visiableElementList.add(elementList.get(i));
			}
		}
		// Returns visiableElementList object
		return visiableElementList;
	}
	
	/**
	 * List the all the Web elements and get text
	 * 
	 * @param by
	 *            identifier of the list element
	 * @return Returns the list of the web elements
	 */
	public List<String> listWithElementsText(By by) {
		// List of all the elements
		List<WebElement> elementList = driver.getDriver().findElements(by);
		// List of all visible elements
		List<WebElement> visiableElementList = new ArrayList<WebElement>();
		// Elements Text
		List<String> visableElementsText = new ArrayList<String>();

		for (int i = 0; i < elementList.size(); i++) {
			elementList = driver.getDriver().findElements(by);
			// if check to verify visibility of the element
			if (driver.getDriver().findElements(by).get(i).isDisplayed()) {
				// Add element to visibleElement list
				visiableElementList.add(elementList.get(i));
			}
		}

		for (int x = 0; x < visiableElementList.size(); x++) {
			visableElementsText.add(visiableElementList.get(x).getText());
		}
		// Returns visiableElementList object
		return visableElementsText;
	}
	public String getEnteredEmail() {
		return enteredEmail;
	}

	public void setEnteredEmail(String enteredEmail) {
		this.enteredEmail = enteredEmail;
	}

	
}
