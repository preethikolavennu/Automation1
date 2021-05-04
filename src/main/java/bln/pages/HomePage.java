package bln.pages;

import bln.util.Driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import bln.pages.MyProfile;
import bln.variables.Variables;


public class HomePage extends BasePage {
	protected String testScriptName;

	/**
	 * Home Page constructor, sets the driver
	 * 
	 * @param driver
	 */
	public HomePage(Driver driver) {
		super(driver);
		testScriptName = driver.getTestName();

		// TODO Auto-generated constructor stub
		driver.getDriver().manage().deleteAllCookies();
		//driver.getDriver().navigate().to("https://blnstaging.bridgeloannetwork.com/members/login");
		
	}
	/**
	 * Clicks on 'Customer Search' link to navigate to CustomerSearch page
	 * 
	 * @return
	 */
	public MyProfile navigateToMyProfile() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.MyProfile_Link).click();

		// Return CustomerSearch page
		return new MyProfile(driver);
	}
	
	/**
	 * Clicks on 'Customer Search' link to navigate to CustomerSearch page
	 * 
	 * @return
	 */
	public MyProfile navigateToMyProfileBorrower() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.Borrower_MyProfile_Link).click();

		// Return CustomerSearch page
		return new MyProfile(driver);
	}
	/**
	 * Clicks on 'Customer Search' link to navigate to CustomerSearch page
	 * 
	 * @return
	 */
	public Clients navigateToClients() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.Clients_Link).click();

		// Return CustomerSearch page
		return new Clients(driver);
	}
	public Users navigateToUsers() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.NavigatetoUser).click();

		// Return CustomerSearch page
		return new Users(driver);
	}
	public CrossVersionDev navigateToCrossVersionDev() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.NavigatetoCrossBrowser).click();

		// Return CustomerSearch page
		return new CrossVersionDev(driver);
	}
	
	
	public Brokerages navigateToBrokerages() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.CC_Brokerages).click();

		// Return CustomerSearch page
		return new Brokerages(driver);
	}
	public ClosingCoordinator navigateToCC() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.CC_CC).click();

		// Return CustomerSearch page
		return new ClosingCoordinator(driver);
	}
	public LoanFee navigateToLoanFee() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.CC_LoanFee).click();

		// Return CustomerSearch page
		return new LoanFee(driver);
	}
	public LoanFee navigateToLoanFeeBorrower() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.Borrower_LoanFee).click();

		// Return CustomerSearch page
		return new LoanFee(driver);
	}
	public LoanRequest navigateToLoanRequest() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.CC_LoaRequest).click();

		// Return CustomerSearch page
		return new LoanRequest(driver);
	}
	public LoanRequest navigateToLoanRequestBroker() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.CC_LoaRequest_New).click();

		// Return CustomerSearch page
		return new LoanRequest(driver);
	}
	public LoanRequest navigateToLoanRequestBorrower() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.Borrower_LoaRequest).click();

		// Return CustomerSearch page
		return new LoanRequest(driver);
	}
	
	public Lender navigateToLender() {
		// Click on 'Customer Search' link
		super.locateElement(Variables.CC_Lender).click();

		// Return CustomerSearch page
		return new Lender(driver);
	}
	
	
	public Application createLoanRequest()
	{
		super.locateElement(Variables.Borrower_CreateLoan).click();
		return new Application(driver);
	}
	public Settings navigateToSettings() {
		Setting = locateElement(Variables.Setting);
		Setting_Company = locateElement(Variables.Setting_Company);
		hoverOverElement(Setting,Setting_Company);

		// Return CustomerSearch page
		return new Settings(driver);
	}
	
	public void  navigateTofilter_option() {
		// Click on 'Guarantor' link
				super.locateElement(Variables.Guarantor).click();
		// Click on 'Guarantor_documents1' link
				super.locateElement(Variables.Guarantor_documents1).click();
	  // Click on 'Copy_documentation' link
				super.locateElement(Variables.Copy_documentation).click();
				// Click on 'Exetend_acess' link
				super.locateElement(Variables.Exetend_acess).click();
	}
	

}
