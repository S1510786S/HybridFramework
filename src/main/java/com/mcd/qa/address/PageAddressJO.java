package com.mcd.qa.address;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mcd.qa.base.TestBase;
import com.mcd.qa.util.TestUtil;

public class PageAddressJO extends TestBase
{
	WebDriver driver;

	By drpCity = By.xpath("//*[@id='wosCity_chosen']/a/div/b");
	By drpCitySelect = By.xpath("//div[@id='wosCity_chosen']/div/ul/li[1]");
	By drpArea = By.xpath("//*[@id='wosArea_chosen']/a/div/b");
	By drpAreaSelect = By.xpath("//div[@id='wosArea_chosen']/div/ul/li[1]");
	By drpRoad = By.xpath("//*[@id='wosStreet_chosen']/a/div/b");
	By drpRoadSelect = By.xpath("//div[@id='wosStreet_chosen']/div/ul/li[1]");
	By txtbldgno = By.name("wosHouseNo");
	By txtapartmentno = By.name("wosUnit");
	By txtfloorno = By.name("wosLevel");
	By txtlandmark = By.name("wosLandmark");
	By txtdelinstructions = By.name("wosRemarks");
	By btnConfirmDelAddress = By.xpath("//button[contains(text(),'Address')]");


	public PageAddressJO(WebDriver driver)
	{
		this.driver = driver;
		//        logger=Logger.getLogger(PageAddressJO.class.getName());
	}

	public void enterAddressJO()
	{
		try
		{
			driver.findElement(drpCity).click();
			driver.findElement(drpCitySelect).click();
			//logger.info("PageAddressJO - Select City");
			Thread.sleep(2000);

			driver.findElement(drpArea).click();
			driver.findElement(drpAreaSelect).click();
			//logger.info("PageAddressJO - Select Area");

			driver.findElement(drpRoad).click();
			driver.findElement(drpRoadSelect).click();
			//logger.info("PageAddressJO - Select Street");

			driver.findElement(txtbldgno).sendKeys("1");
			//logger.info("PageAddressJO - Enter Building number");

			driver.findElement(txtapartmentno).sendKeys("2");
			//logger.info("PageAddressJO - Enter Apartment number");

			driver.findElement(txtfloorno).sendKeys("3");
			//logger.info("PageAddressJO - Enter Floor number");

			driver.findElement(txtlandmark).sendKeys("4");
			//logger.info("PageAddressJO - Enter Landmark");

			driver.findElement(txtdelinstructions).sendKeys("TEST Delivery Instructions");
			//logger.info("PageAddressJO - Enter Delivery Instrictions");

			TestUtil.takeScreenshotAtEndOfTest();

			driver.findElement(btnConfirmDelAddress).click();
			//logger.info("PageAddressJO - Click Confirm Delivery Address");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}