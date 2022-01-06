package com.mcd.qa.pages;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mcd.qa.base.TestBase;

public class PageOrderConfirmation extends TestBase
{
	WebDriver driver;

	By menuBreakfastValueMeals = By.xpath("");
	By menuAlaCarteValueMeals = By.xpath("");

	public PageOrderConfirmation(WebDriver driver)
	{
		this.driver = driver;
		//        logger=Logger.getLogger(PageOrderConfirmation.class.getName());
	}

	public void validate_orderConfirmationPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 12);
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("panel-heading"), "We have received your order"));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(text(),'We have received your order')]"), "We have received your order"));
		logger.info("Text displayed - We have received your order");
	}

}