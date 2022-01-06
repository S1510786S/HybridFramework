package com.mcd.qa.pages;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mcd.qa.base.TestBase;

public class PageZPG extends TestBase
{
	WebDriver driver;

	By card_number = By.name("card_number");
	By exp_month = By.name("exp_month");
	By exp_year = By.name("exp_year");
	By cv2_number = By.name("cv2_number");
	By btnPaymentContinue = By.xpath("//*[@id='continue' or @id='btnSubmit' or text()='Confirm']");

	public PageZPG(WebDriver driver)
	{
		this.driver = driver;
		//        logger=Logger.getLogger(PageZPG.class.getName());
	}

	public void enterPaymentDetails()
	{
		try
		{
			driver.findElement(card_number).sendKeys("4434260000000008");
			logger.info("PG - Card Number entered");
			driver.findElement(exp_month).sendKeys("08");
			logger.info("PG - Expiry Month entered");
			driver.findElement(exp_year).sendKeys("2022");
			logger.info("PG - Expiry Year entered");
			driver.findElement(cv2_number).sendKeys("123");
			logger.info("PG - CVV entered");
			Thread.sleep(3000);
			driver.findElement(btnPaymentContinue).click();
			logger.info("PG - Continue clicked");

		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		if(!driver.findElements(By.xpath("//input[@type='submit']")).isEmpty())
		{
			driver.findElement(By.xpath("//input[@type='submit']")).click();
		}

		/*
		 * if(driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed()) {
		 * driver.findElement(By.xpath("//input[@type='submit']")).click();
		 * logger.info("PG - Submit/Authenticated clicked"); }
		 */
	}

}