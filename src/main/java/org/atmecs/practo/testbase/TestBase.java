package org.atmecs.practo.testbase;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.practo.contstants.FileConstants;
import org.atmecs.practo.reports.LogReporter;
import org.atmecs.practo.utils.ExcelReader;
import org.atmecs.practo.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/*this class will act as the base class for the test it will provide the browser based on the user choice */
public class TestBase {
	protected WebDriver driver;
	PropertiesReader propread = new PropertiesReader();
	ExcelReader excelreader = new ExcelReader();
	LogReporter log = new LogReporter();

	/*
	 * this method will provide the browser driver based on the user need by using
	 * the switch case and properties file
	 */
	@BeforeTest
	public void baseSetup() throws IOException {
		Properties prop = propread.property(FileConstants.config_file);
		switch (prop.getProperty("webdrivername")) {
		case "chrome":
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", FileConstants.chromefile);
			driver = new ChromeDriver(chromeoptions);
			log.logReport("Open chorme browser");
			break;
		case "firefox":
			FirefoxOptions firefoxop = new FirefoxOptions();
			firefoxop.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", FileConstants.firefoxfile);
			driver = new FirefoxDriver(firefoxop);
			log.logReport("Open firefox browser");
			break;
		case "Ie":
			System.setProperty("webdriver.ie.driver", FileConstants.Iefile);
			driver = new InternetExplorerDriver();
			log.logReport("Open Ie browser");
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", FileConstants.edgefile);
			driver = new EdgeDriver();
			log.logReport("Open Edge browser");
			break;
		}
	}

	// close the broser driver after the run the test
	@AfterTest
	public void closedriver() {
		driver.quit();
		log.logReport("browser driver is closed");
	}

}
