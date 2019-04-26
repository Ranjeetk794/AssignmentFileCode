package com.wordpress.genericlib;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Ranjeet Kumar
 *
 */
public class WebDriverCommanLib {
  /**
   * its used to implicitly wait for Globally Element
   * @param Driver
   */
	public void waitForPageToLoad(WebDriver Driver)
	{
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 *its used to Explicitly wait for Target Element 
	 * @param Driver
	 * @param element
	 */
	public void waitForElementPresent(WebDriver Driver ,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(Driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * its used for Select Element
	 * @param element
	 * @param option
	 */
	public void select(WebElement element , String option)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(option);	
	}

}
