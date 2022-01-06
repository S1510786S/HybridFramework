package com.mcd.qa.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mcd.qa.base.TestBase;

public class PageHome extends TestBase
{
	WebDriver driver;

	By btnStartNewOrder = By.xpath("//a[text()='START NEW ORDER']");
	By btnOrderInAdvance = By.xpath("//a[contains(text(),'Order in Advance')]");
	By btnContinue = By.xpath("//button[@type='submit' and text()='Continue'][1]");
	

	public PageHome(WebDriver driver)
	{
		this.driver = driver;
//		logger=Logger.getLogger(PageHome.class.getName());
	}

	public void StartNewOrder()
	{
		driver.findElement(btnStartNewOrder).click();
		logger.info("PageHome - Click Start New Order button");
	}

	public void AdvanceOrder() throws InterruptedException
	{
		driver.findElement(btnOrderInAdvance).click();
		logger.info("PageHome - Click Order In Advance button");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);

		String parentwindowhandler= driver.getWindowHandle(); // store your parent window..
		String subwindowhandler=null;
		Set<String> handles= driver.getWindowHandles();
		Iterator<String> iterator= handles.iterator();
		while(iterator.hasNext()){
			subwindowhandler= iterator.next();
		}
		driver.switchTo().window(subwindowhandler);

		driver.findElement(By.xpath("//label[contains(text(),'Order in Advance')]")).click();
		System.out.println("Order in Advance selected");
		driver.findElement(By.xpath("//a[@id='form_deliveryoptions_date-button']//span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='form_deliveryoptions_date-menu']/li[2]/a")).click();
		Thread.sleep(2000);
		logger.info("PageHome - Selected Date in Advance Order Pop Up Window");

		//driver.findElement(By.xpath("//a[@id='form_deliveryoptions_time-button']")).click();
		driver.findElement(By.xpath("//a[@id='form_deliveryoptions_time-button']//span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='form_deliveryoptions_time-menu']/li[42]/a")).click();
		//For UAE,
		//driver.findElement(By.xpath("//*[@id='form_deliveryoptions_time-menu']/li[2]/a")).click();
		//Thread.sleep(2000);
		logger.info("PageHome - Selected Time in Advance Order Pop Up Window");

		driver.findElement(btnContinue).click();
		logger.info("PageHome - Click Continue button");
	}



}