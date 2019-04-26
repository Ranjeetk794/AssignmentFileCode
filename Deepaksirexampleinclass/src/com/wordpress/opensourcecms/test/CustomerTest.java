package com.wordpress.opensourcecms.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wordpress.genericlib.FileLib;
import com.wordpress.genericlib.WebDriverCommanLib;
/**
 * 
 * @author Ranjeet Kumar
 *
 */
public class CustomerTest {
	public static void main(String[] args) throws Throwable {
		FileLib fLib=new FileLib();
		WebDriverCommanLib wLib=new WebDriverCommanLib();
		String Url=fLib.getPropetyKeyValue("url");
		String userName=fLib.getPropetyKeyValue("username");
		String password=fLib.getPropetyKeyValue("password");
		System.out.println("Url=====>"+Url);
		System.out.println("value of user name===>"+userName);
		System.out.println("value of user name===>"+password);
		String customerName=fLib.getExcellData("sheet1", 2, 2);
		System.out.println("Excell sheet1 row 2 and 2 cell value===>"+customerName);
		WebDriver Driver=new FirefoxDriver();
		wLib.waitForPageToLoad(Driver);
		Driver.get(Url);
	}

}
