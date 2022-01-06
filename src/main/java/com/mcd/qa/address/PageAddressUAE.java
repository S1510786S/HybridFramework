package com.mcd.qa.address;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mcd.qa.base.TestBase;
import com.mcd.qa.util.TestUtil;

public class PageAddressUAE extends TestBase
{
	WebDriver driver;

	By drpCity = By.xpath("//*[@id='wosCity_chosen']/a/div/b");
	By drpCitySelect = By.xpath("//div[@id='wosCity_chosen']/div/ul/li[1]");
	By drpArea = By.xpath("//*[@id='wosArea_chosen']/a/div/b");
	

	By btnConfirmDelAddress = By.xpath("//button[contains(text(),'Address')]");


	public PageAddressUAE(WebDriver driver)
	{
		this.driver = driver;
		//        logger=Logger.getLogger(PageAddressUAE.class.getName());
	}

	public void enterAddressUAE()
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("apaFrame")));
			
			//driver.switchTo().frame(driver.findElement(By.id("apaFrame")));
			driver.findElement(By.xpath("//input[@placeholder='E.g. Golden Tower or Villa 23 or Spinneys']")).sendKeys("404898");
			driver.findElement(By.xpath("//a[contains(text(),'You have entered a GRL; Click Search button to locate.')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'CONFIRM ADDRESS')]")).click();
			driver.findElement(By.xpath("//input[@id='Door_Number']")).sendKeys("123");
			TestUtil.takeScreenshotAtEndOfTest();
			driver.findElement(By.xpath("//span[contains(text(),'SAVE ADDRESS')]")).click();
			//logger.info("PageAddressJO - Click Confirm Delivery Address");.bon;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}