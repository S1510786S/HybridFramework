package com.mcd.qa.pages;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mcd.qa.base.TestBase;

public class PageReviewAndConfirmOrder extends TestBase
{
	WebDriver driver;

	By btnConfirmOrder = By.xpath("//span[text()='Confirm Order']");

	public PageReviewAndConfirmOrder(WebDriver driver)
	{
		this.driver = driver;
		//        logger=Logger.getLogger(PageReviewAndConfirmOrder.class.getName());
	}

	public void ConfirmOrder()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Confirm Order']")));

		driver.findElement(btnConfirmOrder).click();
		logger.info("PageReviewAndConfirmOrder - Click Confirm Order button");
	}

}