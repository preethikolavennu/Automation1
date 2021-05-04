package bln.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
	

public class ExtentReporterNG implements IReporter,IAnnotationTransformer  {
	protected ExtentReports report;
	protected Driver d;
	protected String currentDate	= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	protected String outputDirectory;
	protected String suiteName;
	

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		report = new ExtentReports("./test-output/ExtentTestReport.html", true);
		report.loadConfig(new File("src/main/resources/extentreports/config/extent-config.xml"));
		this.outputDirectory = outputDirectory;
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				
				suiteName = context.getCurrentXmlTest().getSuite().getName();
				
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		
		for (String s : Reporter.getOutput()) {
			report.setTestRunnerOutput(s);
		}
		
		report.flush();
		report.close();
		generateHtmlReport(xmlSuites, suites, outputDirectory);
	}
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();		
	}
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = report.startTest(result.getMethod().getMethodName());

				test.getTest().setStartedTime(getTime(result.getStartMillis()));
				test.getTest().setEndedTime(getTime(result.getEndMillis()));
				
				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					System.out.println(suiteName);
					test.log(status, ExceptionUtils.getStackTrace(result.getThrowable()),test.addScreenCapture(".\\"+ result.getName()+".jpeg"));
				}
				else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed",test.addScreenCapture(".\\"+ result.getName()+".jpeg"));
				}
				
				report.endTest(test);
			}
		}
	}
	
	

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	
    	
    	// Store list if test script names
    	List<String> testScriptsNames	 = new ArrayList<String>();
    	
    	// Add names to list
    	testScriptsNames.add("NewLoanRequest");
    	
	}
	public void generateHtmlReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		int failedCount=0;
		int passedCount=0;
		int skippedCount=0;
		int totalcount=0;
		// TODO Auto-generated method stub
				StringBuilder sb=new StringBuilder();				
				for (ISuite suite : suites) {
					Map<String, ISuiteResult> result = suite.getResults();
					for (ISuiteResult r : result.values()) {
						ITestContext context = r.getTestContext();
						IResultMap map1=context.getFailedTests();
						IResultMap map2=context.getPassedTests();
						IResultMap map3=context.getSkippedTests();
						Collection<ITestNGMethod> l1=map1.getAllMethods();
						Collection<ITestNGMethod> l2=map2.getAllMethods();
						Collection<ITestNGMethod> l3=map3.getAllMethods();
						failedCount=map1.size();
						passedCount=map2.size();
						skippedCount=map3.size();
						totalcount=failedCount+passedCount+skippedCount;
						sb=sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
						sb=sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">" + 
								"<head>" + 
								"<style>" + 
								"table,td,tr,th{border:1px solid black;border-collapse: collapse;}"+
						
								"</style>" + 
								"</head>" + 
								"<body>" + 
								"<table>" + 
								"  <tr><b>" + 
								"    TestResults" + 
								"  </b></tr>" + 
								"  <tr>" + 
								"    <td bgcolor='ffce33'>TotalScenarios</td>" + 
								"    <td><font color='ffce33'>"+totalcount+"</font></td>" + 
								"  </tr>" + 
								"  <tr>" + 
								"	   <td bgcolor='42ff33'>Passed</td>"+ 
								"    <td><font color=42ff33>"+passedCount+"</font></td> " + 
								"  </tr>" + 
								"  <tr>" + 
								"    <td bgcolor='ff3f33'>Failed</td>" + 
								"    <td><font color=ff3f33>"+failedCount+"</font></td> " + 
								"  </tr>" + 
								"   <tr>" + 
								"    <td bgcolor='337dff'>Skipped</td>"+ 
								"    <td><font color=337dff>"+skippedCount+"</font></td>" + 
								"  </tr>" + 
								"</table><br><br><br>"+
								"<table>" + 
								"  <tr><b>" + 
								"Scenario-wise TestResults" + 
								"  </b></tr>" + 
								"  <tr>" + 
								"    <th bgcolor=\"#00FFFF\">Scenario</th>" + 
								"    <th bgcolor=\"#00FFFF\">Result</th> " + 
								"    <th bgcolor=\"#00FFFF\">TestData</th>" + 
								"  </tr>");
						
						
						for (ITestNGMethod iTestNGMethod : l1) {
							sb.append("<tr >" + 
									"				   <td><b>"+iTestNGMethod.getMethodName()+"</b></td> " + 
									"	   <td><font color=\"ff3f33\">Fail</font></td>" +
									"				   <td><b>"+getReport(iTestNGMethod.getMethodName())+"</b></td> "+
									"		 </tr>");
							
						}
						for (ITestNGMethod iTestNGMethod : l2) {
							sb.append("<tr>" + 
									"				   <td><b>"+iTestNGMethod.getMethodName()+"</b></td> " + 
									"				   <td><font color=\"42ff33\">Pass</font></td>" +
									"				   <td><b>"+getReport(iTestNGMethod.getMethodName())+"</b></td> "+
									"				  </tr>");
						}
						for (ITestNGMethod iTestNGMethod : l3) {
							sb.append("<tr>" + 
									"				   <td><b>"+iTestNGMethod.getMethodName()+"</b></td> " + 
									"				   <td><font color=\"337dff\">Skipped</font></td>" + 
									"				   <td><b>"+getReport(iTestNGMethod.getMethodName())+"</b></td> "+
									"				  </tr>");
							
						}
					}
				}
				sb=sb.append("</table>");
				for (ISuite suite : suites) {
					Map<String, ISuiteResult> result = suite.getResults();
				for(ISuiteResult r : result.values()){
					ITestContext context = r.getTestContext();
					String suiteName=context.getCurrentXmlTest().getName();
					if(suiteName.equalsIgnoreCase("Regression_CreateLoan_Bln")){
					sb=sb.append("<br><br><table><tr><th bgcolor=\"#00FFFF\">HTML Test Report</th></tr>"+
                                         "<tr><td><a href='https://web.bridgeloannetwork.com:4343/job/BLNAutomation/BLN_Automation_Report/'>https://web.bridgeloannetwork.com:4343/job/BLNAutomation/BLN_Automation_Report/</a></td></tr></table>");
					}
					
				}
				}
				
					sb=sb.append(
							"</body>" + 
							"</html><br><br>");
					File fi=new File("./test-output/myReport.html");
					OutputStream ois=null;
					try {
						 ois=new FileOutputStream(fi);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					byte[] b=sb.toString().getBytes();
					try {
						ois.write(b);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					File f=new File("./test-output/fileReport.txt");
					try {
						PrintWriter printWriterInFile=new PrintWriter(f);
						//PrintWriter printWriterInFile1=new PrintWriter(fi);
						printWriterInFile.write("");
						//printWriterInFile1.write("");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
	
	public synchronized String getReport(String TestName) {
		String testCaseName=null;
		File file=new File("./test-output/fileReport.txt");
		BufferedReader bis=null;
		try {
			 bis=new BufferedReader(new FileReader(file));
			while((testCaseName=bis.readLine())!=null) {
				if(testCaseName.contains(TestName)) {
					testCaseName=testCaseName.substring(testCaseName.indexOf('#')+1);
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
		bis.close();
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testCaseName;
	}
}