package com.mcd.qa.address;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mcd.qa.base.TestBase;
import com.mcd.qa.util.TestUtil;

public class PageAddressQA extends TestBase
{
	WebDriver driver;

	By drpCity = By.xpath("//*[@id='wosCity_chosen']/a/div/b");
	By drpCitySelect = By.xpath("//div[@id='wosCity_chosen']/div/ul/li[1]");
	By drpZone = By.xpath("//*[@id='wosDistrict_chosen']/a/div/b");
	By drpZoneSelect = By.xpath("//div[@id='wosDistrict_chosen']/div/ul/li[1]");
	By drpStreetNo = By.xpath("//*[@id='wosZipCode_chosen']/a/div/b");
	By drpStreetNoSelect = By.xpath("//div[@id='wosZipCode_chosen']/div/ul/li[1]");
	By drpStreetName = By.xpath("//*[@id='wosStreet_chosen']/a/div/b");
	By drpStreetNameSelect = By.xpath("//div[@id='wosStreet_chosen']/div/ul/li[1]");
	By radioBldgNo = By.id("lbl_form_deliveryaddress_bldgno_id");
	By txtBldgNo = By.name("wosBldgNo1");
	By txtFloorNo = By.name("wosLevel");
	By txtApartmentNo = By.name("wosUnit");
	By txtCompoundName = By.name("wosGarden");
	By txtDeliveryInstructions = By.name("wosRemarks");

	By btnConfirmDelAddress = By.xpath("//button[contains(text(),'Address')]");


	public PageAddressQA(WebDriver driver)
	{
		this.driver = driver;
		//        logger=Logger.getLogger(PageAddressQA.class.getName());
	}

	public void enterAddressQA()
	{
		try
		{
			driver.findElement(drpCity).click();
			driver.findElement(drpCitySelect).click();
			//logger.info("PageAddressQA - Select City");
			Thread.sleep(2000);

			driver.findElement(drpZone).click();
			driver.findElement(drpZoneSelect).click();
			//logger.info("PageAddressQA - Select Zone");
			Thread.sleep(2000);

			driver.findElement(drpStreetNo).click();
			driver.findElement(drpStreetNoSelect).click();
			//logger.info("PageAddressQA - Select Street No");
			Thread.sleep(2000);

			driver.findElement(drpStreetName).click();
			driver.findElement(drpStreetNameSelect).click();
			//logger.info("PageAddressQA - Select Street Name");

			driver.findElement(radioBldgNo).click();
			//logger.info("PageAddressQA - Click House Number");

			driver.findElement(txtBldgNo).sendKeys("1");
			//logger.info("PageAddressQA - Enter BldgN");

			driver.findElement(txtFloorNo).sendKeys("2");
			//logger.info("PageAddressQA - Enter FloorNo");

			driver.findElement(txtApartmentNo).sendKeys("3");
			//logger.info("PageAddressQA - Enter ApartmentNo");

			driver.findElement(txtCompoundName).sendKeys("4");
			//logger.info("PageAddressQA - Enter Compound Name");

			driver.findElement(txtDeliveryInstructions).sendKeys("Test DeliveryInstructions");
			//logger.info("PageAddressQA - Enter DeliveryInstructions");

			TestUtil.takeScreenshotAtEndOfTest();

			driver.findElement(btnConfirmDelAddress).click();
			//logger.info("PageAddressQA - Click Confirm Delivery Address");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}