package bln.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import bln.util.Driver;
import bln.util.ExtentReporterNG;


public class BaseTest extends ExtentReporterNG {
	
	/** Driver that runs the test, and holds the test parameters */
	protected Driver d;
	protected String testScriptName;
	public static FileOutputStream fos;
	
	/**
	 * Parses variables from Excel
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	@BeforeSuite(alwaysRun=true)
	public void parseData() throws ClassNotFoundException, SQLException, FileNotFoundException {
		
		//createReport file
		createReportFile();
	}
	/**
	 * createReportFile
	 * @throws FileNotFoundException 
	 * 
	 */
	@BeforeSuite
	public void createReportFile() throws FileNotFoundException {
		try{
		// TODO Auto-generated method stub
		File file=new File("./test-output/fileReport.txt");
		 fos=new FileOutputStream(file);
		 File file1=new File("./test-output/myReport.html");
		 PrintWriter printWriter=new PrintWriter(file1);
		 printWriter.write("");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Initializes a remote or local driver based on the flags
	 * @param context  						 Test context which contains all the information for a given test run
	 * @param m								 Test case being run
	 * @param isLocal						 Local flag
	 * @param isMobile						 Mobile flag
	 * @throws MalformedURLException
	 */
	public void initializeDriver(ITestContext context, Method m) throws MalformedURLException {
		outputDirectory = context.getOutputDirectory();
		testScriptName = m.getName();
		this.d = new Driver(m.getName(), context.getName());
		d.getDriver().manage().deleteAllCookies();
		d.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
	/**
	 * uits the driver
	 * @param result			Result of a test
	 * @throws IOException
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {

		if (!result.isSuccess()) {
			File scrFile = ((TakesScreenshot) d.getDriver()).getScreenshotAs(OutputType.FILE);
			
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			FileUtils.copyFile(scrFile,new File("./test-output/"+ result.getName()+System.currentTimeMillis()+".jpeg"));
			
		} else if (result.isSuccess()) {
			File scrFile = ((TakesScreenshot) d.getDriver()).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy
			FileUtils.copyFile(scrFile,
					new File("./test-output/"+ result.getName()+".jpeg"));
		}else {
			
			File scrFile = ((TakesScreenshot) d.getDriver()).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			FileUtils.copyFile(scrFile,
					new File("./test-output/"+ result.getName()+".jpeg"));
			
		}
		
		if (result.getStatus() == ITestResult.SKIP) {
			result.getInstance();
			// Close the driver
			d.getDriver().close();
			d.getDriver().quit();
			
		}

		
		/* d.getExtentReport().endTest(d.getTestCase()); 
		 
		 d.getExtentReport().flush();
		 d.getExtentReport().close();*/
		 

		// Close the driver
		d.getDriver().quit();
	}

	/*@AfterSuite
	public void quitAll() {
		d.getDriver().quit();
		
	}*/

	/**
	 * Returns the value of the given cell
	 * @param r			Row the cell is on
	 * @param i         Index of the cell
	 * @return			Returns the value, null if empty
	 */
	public String returnRow(XSSFRow r, int i) {
		if (r.getCell(i) == null) {
			return null;
		} else if (r.getCell(i).getCellType() == Cell.CELL_TYPE_NUMERIC) {
			return removeSpaces(Integer.toString((int)r.getCell(i).getNumericCellValue()));
		} else if (r.getCell(i).getCellType() == Cell.CELL_TYPE_STRING) {
			return removeSpaces(r.getCell(i).getStringCellValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Removes spaces including no-break spaces(&nbsp)
	 * @param s String to be trimmed
	 * @return
	 */
	public String removeSpaces(String s) {
		s = s.replace("\u00a0","");
		s = s.trim();
		return s;
	}
	
	public String getTestScriptName() {
		return testScriptName;
	}

	public void setTestScriptName(String testScriptName) {
		this.testScriptName = testScriptName;
	}
}
