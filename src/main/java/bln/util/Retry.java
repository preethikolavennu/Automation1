package bln.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	private int retryCount = 0;
	private int maxRetryCount = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<maxRetryCount){
	    	System.out.println("Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) +" " +(retryCount + 1) + " time(s).");
	    	// Print exception stack trace
	    	result.getThrowable().printStackTrace();
	    	retryCount++;
	    	return true;
		}
		return false;
	}
	
	/**
	 * Return the status of the test script
	 * @param status
	 * @return
	 */
	public String getResultStatusName(int status){
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAIL";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
		
	}
}
