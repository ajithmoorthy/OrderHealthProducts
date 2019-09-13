package org.atmecs.practo.contstants;
/* file canstants are created for the user can run any system the program should run 
 * and the file location is access is make easier using this class */
public class FileConstants {
	//creating file constants for the properties files
	public static final String config_file = "./src/test/resources/testdata/config.properties";
	public static final String pharmacy_file = "./src/test/resources/locators/pharmacy.properties";
	public static final String expecteddata_file="./src/test/resources/testdata/expecteddata.xlsx";
	public static final String cart_file="./src/test/resources/locators/cart.properties";
	public static final String cartdata_file="./src/test/resources/testdata/carttestdata.xlsx";
	
	////creating file constants for the browser exe files
	public static final String chromefile ="./libs/chromedriver.exe";
	public static final String firefoxfile ="./libs/geckodriver.exe";
	public static final String Iefile="./libs/IEDriverServer.exe";
	public static final String edgefile="./libs/msedgedriver.exe";
	
	////creating file constants for the log4j files
	public static final String logfile ="./src/test/resources/log4j/log4j.properties";
	
	////creating file constants for the extend report files
	public static final String extentfile ="./src/test/resources/extent/extent.html";
	public static final String pngfile="./src/test/resources/extent/"+System.currentTimeMillis()+".png";
	public static final String extentconfigfile ="./src/test/resources/extent/extent-config.xml";
	
	}
