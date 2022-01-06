package com.mcd.qa.pages;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mcd.qa.base.TestBase;

public class PageZPGMPGS extends TestBase
{
	WebDriver driver;

	By card_number = By.id("cardNumber");
	By exp_month = By.id("expiryMonth");
	By exp_year = By.id("expiryYear");
	By cardHolder_name = By.id("cardHolderName");
	By cv2_number = By.id("csc");
	//By btnPayNow = By.xpath("//button[contains(text(),'Pay now')]/parent::div[@id='button-row2']");
	By btnPayNow = By.xpath("//a[contains(@class, 'cancelButton')]//following-sibling::button[contains(text(),'Pay')]");

	public PageZPGMPGS(WebDriver driver)
	{
		this.driver = driver;
		//        logger=Logger.getLogger(PageZPGMPGS.class.getName());
	}

	public void enterPaymentDetailsMPGS()
	{
		try
		{
			Select expmonth = new Select(driver.findElement(By.id("expiryMonth")));
			Select expyear = new Select(driver.findElement(By.id("expiryYear")));

			driver.findElement(card_number).sendKeys("4434 2600 0000 0008");
			logger.info("PG - Card Number entered");
			//driver.findElement(exp_month).sendKeys("08");
			//logger.info("PG - Expiry Month entered");
			//driver.findElement(exp_year).sendKeys("2021");
			//logger.info("PG - Expiry Year entered");
			expmonth.selectByIndex(8);
			logger.info("PG - Select Month");
			expyear.selectByIndex(3);
			logger.info("PG - Select Year");
			driver.findElement(cardHolder_name).sendKeys("TEST");
			logger.info("PG - Card Holder Name entered");
			driver.findElement(cv2_number).sendKeys("123");
			logger.info("PG - CVV entered");
			Thread.sleep(3000);
			driver.findElement(btnPayNow).click();
			logger.info("PG - Pay Now clicked");
			//input[@type='submit']
			//driver.findElement(By.xpath("//input[@type='submit']")).click();

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
		 * logger.info("PG - Submit clicked"); }
		 */
	}

}