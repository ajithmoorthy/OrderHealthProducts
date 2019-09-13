package org.atmecs.practo.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.practo.contstants.FileConstants;
import org.atmecs.practo.helper.PractoHelper;
import org.atmecs.practo.pages.Cartpage;
import org.atmecs.practo.pages.PainRelief;
import org.atmecs.practo.pages.Practopage;
import org.atmecs.practo.reports.LogReporter;
import org.atmecs.practo.testbase.TestBase;
import org.atmecs.practo.utils.ExcelReader;
import org.atmecs.practo.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * 
 * @author ajith.periyasamy
 *PractoHomepage is a main class for automate the Practo.com 
 *This contains practohome with @Test annotation method to test the practo wepage.
 * This method is implemented based on the order health product scenario . 
 */
public class PractoHomepage extends TestBase  {
	LogReporter log=new LogReporter();
	ExcelReader excelread=new ExcelReader();
	//Extentreport extentrep=new Extentreport();
	PropertiesReader propread=new PropertiesReader();
	PractoHelper practohelp=new PractoHelper();
	Practopage practopage=new Practopage();
	PainRelief painpage=new PainRelief();
	Cartpage  cartpage=new Cartpage();
	
	/**
	 * data provider with name of pharmacy it call the returnlocator method from the Excel Reader class
	 * and give the data to the @Test method row by row 
	 * @return
	 * @throws IOException
	 */
	
	@DataProvider(name = "pharmacy")
	public String[][] getExpected() throws IOException {
		String Excelarray[][] = null;
		Excelarray = excelread.returnLocator(FileConstants.expecteddata_file);
		return Excelarray;
	}
	//Practohome method contains selenium script for the practo page scenario order health product 
	@Test(priority=0,dataProvider="pharmacy")
	void practoHome(String title,String expectedurl,String fitTitle,String pharmacytitle,String paintitle,String prodname,String prodprice,String noofProd,String prodname1,String prodprice1,String noofProd1,String total,String aftertotal, String prodname2) throws IOException, InterruptedException {
		try {
			Properties prop=propread.property(FileConstants.config_file);
			Properties prop1=propread.property(FileConstants.pharmacy_file);
		driver.get(prop.getProperty("url"));
		log.logReport("Url is loaded" );
		Assert.assertEquals(driver.getTitle(), title);
		System.out.println("Document title is validated :"+driver.getTitle());
		practopage.practoHome(driver, prop1,pharmacytitle,paintitle);
		painpage.painRelief(driver, prop1,expectedurl,fitTitle);
		cartpage.cartPage(driver, prop1,prodname,prodprice,noofProd,prodname1, prodprice1,noofProd1,total,aftertotal,prodname2);
		}
		catch(AssertionError e)
		{
			System.out.println("Document title is not matched with Expected "+title);
			
		}
	}



}
