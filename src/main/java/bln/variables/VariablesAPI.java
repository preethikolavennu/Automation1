package bln.variables;

import org.openqa.selenium.By;

public class VariablesAPI {
	
	public static final By API_PropertyState  			=  By.cssSelector("select[id='w_property_state']");
	public static final By API_PropertyStateOptions  	=  By.cssSelector("#w_property_state >option[value='NY']");
	public static final By API_CollateralType  			=  By.cssSelector("select[id='w_property_type']");
	public static final By API_CollateralTypeOptions  	=  By.cssSelector("#w_property_type >option[value='6']");
	public static final By API_PropertyStatus  			=  By.cssSelector("#w_property_occupancy0");
	public static final By API_Next 					=  By.xpath("(//button[@value='Next'])[1]");
	public static final By API_EmailAddress 			=  By.cssSelector("#w_search_email");
	public static final By API_Submit 					=  By.cssSelector("#w_search_button");
	public static final By API_FirstName 				=  By.xpath("(//input[@id='w_applicant_first_name'])[1]");
	public static final By API_LastName 				=  By.xpath("(//input[@id='w_applicant_last_name'])[1]");
	public static final By API_PhoneNumber				=  By.xpath("(//input[@id='w_applicant_phone'])[1]");
	public static final By API_NavigateNext 			=  By.cssSelector("#w_search_button_no_next");
	public static final By API_ZipCode 					=  By.cssSelector("#property_zipcode");
	public static final By API_Address 					=  By.cssSelector("#property_address");
	public static final By API_CollateralType1  		=  By.cssSelector("select[id='property_type']");
	public static final By API_CollateralTypeOptions1  	=  By.cssSelector("#property_type >option[value='6']");
	public static final By API_PurchaseRefinance	 	=  By.cssSelector("#own_property0");
	public static final By API_PurchasePrice	 		=  By.cssSelector("#purchase_price");
	public static final By API_RehabCost			 	=  By.cssSelector("#rehab_costs");
	public static final By API_AfterRepair			 	=  By.cssSelector("#after_repair_value");
	public static final By API_AsisValue			 	=  By.cssSelector("#asis_value");
	public static final By API_AmountRequested			=  By.cssSelector("#amount_requested");
	public static final By API_desired_terms 			=  By.cssSelector("select[id='desired_terms']");
	public static final By API_desired_termsOptions  	=  By.cssSelector("#desired_terms >option[value='1']");
	public static final By API_loan_purpose				=  By.cssSelector("select[id='loan_purpose']");
	public static final By API_loan_purposeOptions  	=  By.cssSelector("#loan_purpose >option[value='1']");
	public static final By API_exit_strategy 			=  By.cssSelector("select[id='exit_strategy']");
	public static final By API_exit_strategyOptions  	=  By.cssSelector("#exit_strategy >option[value='0']");
	public static final By API_TermAgreement		  	=  By.cssSelector("#terms_agreement");
	public static final By API_SubmitRequest		  	=  By.cssSelector("input[value='Submit Request']");
	//public static final By API_LoanNumber			  	=  By.cssSelector("#loan_identifier .col-lg-3:nth-of-type(1) >div:nth-of-type(1) >div:nth-of-type(2)");
	public static final By API_Password				  	=  By.cssSelector("input[name='data[pwd]']");
	public static final By API_PasswordCheck		  	=  By.cssSelector("input[name='data[pwd_check]']");
	public static final By API_Recaptcha			  	=  By.cssSelector("span[class^='recaptcha-checkbox'] >div:nth-of-type(1)");
	public static final By API_sign			  			=  By.cssSelector("#submit_0");
	public static final By API_LoanNumber		  		=  By.xpath("(//div[contains(text(),'Loan Number:')])[2]/following-sibling::div");
	public static final By API_AreYou			  		=  By.cssSelector("#w_contact_type5");
	public static final By API_Broker			  		=  By.cssSelector("#w_contact_type3");
	public static final By API_Company			  		=  By.cssSelector("#w_search_company");
	public static final By API_FirstName_Guarantor		=  By.cssSelector("#member_first_name");
	public static final By API_LastName_Guarantor		=  By.cssSelector("#member_last_name");
	public static final By API_email_Guarantor		    =  By.cssSelector("#member_email");
	
	
	
	
		
	
}
