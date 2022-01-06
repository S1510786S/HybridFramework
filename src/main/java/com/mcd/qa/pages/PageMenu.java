package com.mcd.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mcd.qa.base.TestBase;
import com.mcd.qa.util.TestUtil;

public class PageMenu extends TestBase
{
	WebDriver driver;

	By menuBreakfastValueMeals = By.xpath("//span[contains(text(),'Breakfast ')]/parent::a");
	By menuAlaCarteValueMeals = By.xpath("//span[contains(text(),'Ala Carte')]/parent::a");
	By plusbutton = By.xpath("//button[@class='btn btn-increase action-increase btn-black']");
	By btnaddItemsToBag = By.xpath("//text()[contains(.,'ADD ITEMS TO BAG')]/ancestor::button[1]");
	By btnCheckout = By.xpath("//a[text()='Checkout']");

	public PageMenu(WebDriver driver)
	{
		this.driver = driver;
		//        logger=Logger.getLogger(PageMenu.class.getName());
	}

	public void Checkout()
	{
		TestUtil.takeScreenshotAtEndOfTest();
		driver.findElement(btnCheckout).click();
		logger.info("PageMenu - Click Checkout button");
	}

	public boolean BreakfastValueMealsDisplayed()
	{
		driver.findElement(menuBreakfastValueMeals).isDisplayed();
		logger.info("PageMenu - Breakfast Menu Category Displayed");
		return true;
	}

	public void BreakfastValueMealsClick()
	{
		driver.findElement(menuBreakfastValueMeals).click();
		logger.info("PageMenu - Click Breakfast Menu Category");
	}

	public boolean AlaCarteValueMealsDisplayed()
	{
		driver.findElement(menuAlaCarteValueMeals).isDisplayed();
		logger.info("PageMenu - AlaCarte Menu Category Displayed");
		return true;
	}

	public void AlaCarteValueMealsClick()
	{
		driver.findElement(menuAlaCarteValueMeals).click();
		logger.info("PageMenu - Click Ala Carte Menu Category");
	}

	public void plusButtonClick()
	{
		driver.findElement(plusbutton).click();
		logger.info("PageMenu - Click + button");
	}

	public void AddItemsToBag()
	{
		driver.findElement(btnaddItemsToBag).click();
		logger.info("PageMenu - Click Add Items to Bag button");
	}

	public void SelectProduct() throws Exception
	{
		//driver.findElement(By.xpath("//*[contains(text(),'Ala Carte')]")).click();
		//driver.findElement(By.xpath("//*[@class='secondary-menu-item-target']//span[contains(text(),'Breakfast')]")).click();
		//driver.findElement(By.xpath("//*[contains(span,'Sides')]")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Scan Products");
		//btn-yellow OR btn-yellow
		List<WebElement> btnADD = driver.findElements(By.xpath("//a[contains(@class,'btn-yellow')]"));

		btnADD.get(1).click();
		TestUtil.reorderconfirmation();

		//Thread.sleep(3000);
		driver.findElement(By.xpath("//h1[@class='item-name']")).click();
		//System.out.println("Select Product to Order");

		for (int i = 0; i < 9; i++)
		{
			driver.findElement(By.xpath("//button[@class='btn btn-increase action-increase btn-black']")).click();
		}
		   logger.info("PageMenu - Product Added to Cart");


	}
}