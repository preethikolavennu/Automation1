package bln.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {

	BufferedWriter writer;
	File logFile;
	File dir;
	String date;

	public EventHandler(String testName) {
		try {
			createDirectory();
			logFile = new File("./test-output/Logs/" + date + "/" + testName + "_" + getCurrentTime() + ".txt");
			writer = new BufferedWriter(new FileWriter(logFile));
			writer.write("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Returns current time
	 * 
	 * @return current time
	 */
	public String getCurrentTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hhmmss");
		String currentTime = dateFormat.format(now);
		return currentTime;
	}

	/**
	 * Create new DIR with current date
	 * 
	 * @throws IOException
	 */
	public void createDirectory() throws IOException {
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date = dateFormat.format(now);
		dir = new File("./test-output/Logs/" + date);
		if (!dir.exists()) {
			Files.createDirectory(dir.toPath());
			
		    
		}
	}

	/**
	 * Log the data in the file
	 * 
	 * @param data
	 */
	public void log(String data) {

		try {
			writer = new BufferedWriter(new FileWriter(logFile, true));
			writer.write(data);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		String str = "Navigating to URL:" + url;
		log(str);
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		String str = "Navigated to URL:" + driver.getCurrentUrl();
		log(str);

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		String str = "trying to find element " + by.toString();
		log(str);

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		String str = "";
		try {

			str = "Element found, inner text of element is " + driver.findElement(by).getText();

		} catch (NullPointerException e) {
			// TODO: handle exception
			str = "Element " + by.toString() + " has no inner text";
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

		log(str);
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		String str = "trying to click on " + element.toString();
		log(str);
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub.
		String str;
		try {
			str = "Clicked on element " + element.toString() + " With inner text " + element.getText();
		} catch (NullPointerException | WebDriverException e) {
			// TODO: handle exception
			str = "Exception while reading inner text for element" + element;
		}

		log(str);
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		String str = "Exception thrown" + throwable.getMessage();
		log(str);

	}

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		String str;

		try {
			str = "sent keys to element " + arg0.toString() + " and keyed data is " + Arrays.toString(arg2);
		} catch (WebDriverException e) {
			// TODO: handle exception
			str = "Exception while getting keyed data" + arg0;
		}
		
		log(str);
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}


}
