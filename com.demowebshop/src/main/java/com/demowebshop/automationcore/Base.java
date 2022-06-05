package com.demowebshop.automationcore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.annotations.ITest;

import com.demowebshop.constants.Constants;
import com.demowebshop.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public FileInputStream fs;
	
	
	
	/**Base Constructor**/
	
	public Base(){
		prop=new Properties();
		try {
			fs=new FileInputStream(System.getProperty("user.dir")+Constants.CONFIG_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void testInitialise(String browser,String URL) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
		
			try {
                throw new Exception("Invalid browser name");
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitUtility.PAGE_LOAD_WAIT));
	}
	
	@BeforeMethod
	public void setUp() {
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		testInitialise(browser, url);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			// Take Screen shot
		}

		driver.close();
	}
}
