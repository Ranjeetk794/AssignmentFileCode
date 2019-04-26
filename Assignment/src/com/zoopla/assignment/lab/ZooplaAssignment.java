package com.zoopla.assignment.lab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Ranjeet Kumar
 *
 */
public class ZooplaAssignment {
	public static void main(String[] args) {
		/*Launch The Browser */
		WebDriver Driver =new ChromeDriver();
		/* Implicitly wait */
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/* Navigate the Link */
		Driver.get("https://www.zoopla.co.uk/");
		/* Search box in "London"  */
		WebElement SearchBox=Driver.findElement(By.xpath("//input[@name='q']"));
		SearchBox.sendKeys("London");
		/* Click the Search button */
		WebElement SearchBtn=Driver.findElement(By.xpath("//button[text()='Search']"));
		SearchBtn.click();
		/* X-path of All the Price value  */
		String Xpath="//div[@id='content']/ul/li/div/div[2]/a[@class='listing-results-price text-price']";
		/*Explicitly wait for specific Element */
		WebDriverWait wait=new WebDriverWait(Driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
		List<WebElement> AllPrice=Driver.findElements(By.xpath(Xpath));
		System.out.println("Total Size of the price property====>"+AllPrice.size());
		List<Object> ActualList=new ArrayList<Object>();
		for(WebElement ele:AllPrice)
		{
			String data=ele.getText();
			ActualList.add(data);
		}
		List<Object> temp=new ArrayList<Object>();
		temp.addAll(ActualList);
		Collections.sort(temp, Collections.reverseOrder());
		Iterator<Object> itr=temp.iterator();
		while(itr.hasNext())
		{
		System.out.println(itr.next());
		}
		String Xpath1="(//div[@id='content']/ul/li/div/div[2]/a[@class='listing-results-price text-price'])[5]";
		WebDriverWait wait1=new WebDriverWait(Driver, 15);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath1)));
		Driver.findElement(By.xpath("(//div[@id='content']/ul/li/div/div[2]/a[@class='listing-results-price text-price'])[5]")).click();
		WebElement AgentName=Driver.findElement(By.xpath("(//div[@class='ui-agent__text']/h4)[1]"));
		String ExpectedResult=AgentName.getText();
		System.out.println("ExpectedText Result Text Name======>"+ExpectedResult);
		AgentName.click();
		WebElement ActResult=Driver.findElement(By.xpath("//div[@class='main-content-area wrap clearfix']/div[2]/div/div/h1"));
		String ActualResult=ActResult.getText();
		System.out.println("ActualResult Result Text Name======>"+ActualResult);
		if(ActualResult.contains(ExpectedResult))
		{
			System.out.println("Expected Result Matched=====>Pass");
		}
			else
			{
				System.out.println("Expected Result Didn't Matched====>Fail");
			}
		Date date=new Date();
		System.out.println("Execution Date of the Zoopla===>"+date);

	}

}
