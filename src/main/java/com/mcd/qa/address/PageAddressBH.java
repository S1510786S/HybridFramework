package com.mcd.qa.address;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mcd.qa.base.TestBase;
import com.mcd.qa.util.TestUtil;

public class PageAddressBH extends TestBase
{
	WebDriver driver;

	By drpCity = By.xpath("//*[@id='wosDistrict_chosen']/a/div/b");
	By drpCitySelect = By.xpath("//div[@id='wosDistrict_chosen']/div/ul/li[1]");
	By drpRoad = By.xpath("//*[@id='wosStreet_chosen']/a/div/b");
	By drpRoadSelect = By.xpath("//div[@id='wosStreet_chosen']/div/ul/li[1]");
	By txtbldgno = By.name("wosHouseNo");
	By txtflatno = By.name("wosUnit");
	By txtfloorno = By.name("wosLevel");
	By txtlandmark = By.name("wosLandmark");
	By txtGardenno = By.name("wosCompanyName");
	By txtSpecialInstructions = By.name("wosRemarks");

	By btnConfirmDelAddress = By.xpath("//button[contains(text(),'Address')]");

	public PageAddressBH(WebDriver driver)
	{
		this.driver = driver;
//		logger=Logger.getLogger(PageAddressBH.class.getName());
	}

	public void enterAddressBH()
	{
		try
		{
			driver.findElement(drpCity).click();
			driver.findElement(drpCitySelect).click();
//			logger.info("PageAddressBH - Select City");
			Thread.sleep(2000);

			driver.findElement(drpRoad).click();
			driver.findElement(drpRoadSelect).click();
//			logger.info("PageAddressBH - Select Road");

			driver.findElement(txtbldgno).sendKeys("1");
//			logger.info("PageAddressBH - Enter Building number");

			driver.findElement(txtflatno).sendKeys("1");
//			logger.info("PageAddressBH - Enter Floor number");

			driver.findElement(txtfloorno).sendKeys("2");
//			logger.info("PageAddressBH - Enter Floor number");

			driver.findElement(txtlandmark).sendKeys("3");
//			logger.info("PageAddressBH - Enter Floor number");

			driver.findElement(txtGardenno).sendKeys("4");
//			logger.info("PageAddressBH - Enter Floor number");

			driver.findElement(txtSpecialInstructions).sendKeys("5");
//			logger.info("PageAddressBH - Enter Floor number");

			TestUtil.takeScreenshotAtEndOfTest();

			driver.findElement(btnConfirmDelAddress).click();
//			logger.info("PageAddressBH - Click Confirm Delivery Address");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}