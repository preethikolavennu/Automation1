package bln.util;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


import bln.variables.Variables;
import bln.util.Driver;

public class Driver {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	/*
	 * protected ExtentReports extentReport; private ExtentTest testCase;
	 */

	/** Name of the test case. */
	private String testName;

	/** Name of the test defined in the TestNG file. */
	private String testArea;

	/** Email IDs parsed from Jenkins */
	private String allEmailIDs;

	/** browser being tested; either defined in Variables file or Jenkins. */
	private String browsername;
	/**
	 * Browser to be used for running the scripts; either defined in Variables file
	 * or Jenkins.
	 */
	private String browser;

	/** Opearting system from Bamboo */
	private String operatingSystem;

	Map<String, Object> chromeOptions;
	private ChromeOptions chromeProfile;

	private static ThreadLocal<EventFiringWebDriver> eventFiringWebDriver = new ThreadLocal<EventFiringWebDriver>();

	/**
	 * Browser capabilities being used. For list of capabilities available, please
	 * visit:
	 * http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/remote/DesiredCapabilities.html
	 */
	private DesiredCapabilities capabilities = new DesiredCapabilities();

	private ChromeOptions options = new ChromeOptions();

	/*
	 * *************************** Elements related to WCC+WCS
	 **************************/
	private String language;
	/**
	 * Type of the device being tested; either defined in Variables file or Jenkins.
	 */
	private String deviceType = "Desktop";
	private String OS = "Centos7";
	private String emailId;

	/**
	 * Environment being tested; either defined in Variables file or Jenkins.
	 */
	private String environment;
	// public static final String environment = "stage";

	public Driver(String testName, String testArea) throws MalformedURLException {
		// Set variables
		this.testName = testName;
		this.testArea = testArea;

		// Create driver
		createDriver();
		
		//createDockerDriver();
	}
	/**
	 * Create Driver
	 * @throws MalformedURLException 
	 */
	private void createDockerDriver() throws MalformedURLException {
	DesiredCapabilities cap = DesiredCapabilities.chrome();
	cap.setBrowserName("chrome");

	 URL Node = new URL("http://ipaddress:3334/wd/hub");
	RemoteWebDriver driver = new RemoteWebDriver(Node,capabilities);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	// Launch website
	driver.navigate().to("https://blnstaging.bridgeloannetwork.com/members/login");
	driver.manage().window().maximize();
	}
	
	/**
	 * Create Driver
	 * @throws MalformedURLException 
	 */
	private void createDriver() throws MalformedURLException {


		if (Variables.isIE) {

			// Set IE Driver path
			System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");

			// Initialize IE driver
			Driver.driver.set(new InternetExplorerDriver());

			// Maximize window
			Driver.driver.get().manage().window().maximize();
		}

		else {
			// New file to load chrome driver
			File chromeDriver;

			try {

				
				chromeDriver = new File(System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");

				// Set chrome properties
				System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());

				// Initialize chrome options
				this.chromeProfile = new ChromeOptions();
				options.setExperimentalOption("useAutomationExtension", false);
				// Initialize chrome options
				chromeOptions = new HashMap<String, Object>();
				Driver.driver.set(new ChromeDriver(chromeProfile));
			}
			catch (IllegalStateException e) {

				options.addArguments("--no-sandbox"); // Bypass OS security model
				options.addArguments("start-maximized"); // open Browser in maximized mode
				options.addArguments("disable-infobars"); // disabling infobars
				options.addArguments("--disable-extensions"); // disabling extensions
				options.addArguments("--disable-gpu"); // applicable to windows os only
				options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				
				
				chromeDriver = new File(System.getProperty("user.dir") + "/src/main/resources/chromedriver79");
				if (!chromeDriver.canExecute())
					chromeDriver.setExecutable(true);
				// Set chrome properties
				System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());

				ChromeOptions options = new ChromeOptions();
				options.setBinary("/usr/bin/google-chrome-stable");

				// Initialize chrome options
				this.chromeProfile = new ChromeOptions();

				// Initialize chrome options
				chromeOptions = new HashMap<String, Object>();

				// Get extension set capabilities
				chromeProfile.addArguments("test-type");

				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				String driverPath = System.getProperty("user.dir") + "/exe/chromedriver";
				System.setProperty("webdriver.chrome.driver", driverPath);
				capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
				capabilities.setPlatform(Platform.LINUX);
				URL gamelan = new URL("http://ipaddress:3331/wd/hub");
				RemoteWebDriver driver = new RemoteWebDriver(gamelan, capabilities);

				chromeProfile.addArguments("--user-agent=Moose and Seagull Unit Tests");
				chromeProfile.addArguments("--start-maximized");
				/* capabilities.setCapability(ChromeOptions.CAPABILITY, chromeProfile); */
				Driver.driver.set(new ChromeDriver(chromeProfile));
				
			}
			// Maximize window
			Driver.driver.get().manage().window().maximize();

			eventFiringWebDriver.set(new EventFiringWebDriver(driver.get()));
			EventHandler eventHandler = new EventHandler(getTestName());
			eventFiringWebDriver.get().register(eventHandler);
			//capabilities.setCapability("screen-resolution", "1280x1024");

		}
	}

	public EventFiringWebDriver getDriver() {
		return eventFiringWebDriver.get();
	}

	public static void setDriver(ThreadLocal<WebDriver> driver) {
		Driver.driver = driver;
	}

	public String getTestName() {
		return testName;
	}

	public String getTestArea() {
		return testArea;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getBrowsername() {
		return browsername;
	}

	public void setBrowsername(String browsername) {
		this.browsername = browsername;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setTestArea(String testArea) {
		this.testArea = testArea;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public void loggerInfo(ExtentTest logger, String status) {
		logger.log(LogStatus.INFO, status);
	}

	public void loggerPass(ExtentTest logger, String status) {
		logger.log(LogStatus.PASS, status);
	}

}
