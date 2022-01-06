package com.mcd.qa.address;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mcd.qa.base.TestBase;
import com.mcd.qa.util.TestUtil;

public class PageAddressKW extends TestBase
{
WebDriver driver;

By drpGov = By.xpath("//*[@id='wosState_chosen']/a/div/b");
By drpGovSelect = By.xpath("//div[@id='wosState_chosen']/div/ul/li[1]");
By drpDistrict = By.xpath("//*[@id='wosCity_chosen']/a/div/b");
By drpDistrictSelect = By.xpath("//div[@id='wosCity_chosen']/div/ul/li[1]");
By drpBlockNo = By.xpath("//*[@id='wosArea_chosen']/a/div/b");
By drpBlockNoSelect = By.xpath("//div[@id='wosArea_chosen']/div/ul/li[1]");
By txtStreetName = By.name("wosStreet");
By txtJadah = By.name("wosStreetLonNo");
By txtBldgNo = By.name("wosBldg");
By txtFloorNo = By.name("wosLevel");
By txtApartmentNo = By.name("wosHouseNo");
By txtCompound = By.name("wosGarden");
By txtLandmark = By.name("wosLandmark");
By txtDeliveryInstructions = By.name("wosRemarks");

By btnConfirmDelAddress = By.xpath("//button[contains(text(),'Address')]");


public PageAddressKW(WebDriver driver)
{
        this.driver = driver;
//        logger=Logger.getLogger(PageAddressKW.class.getName());
    }

public void enterAddressKW()
{
try
{
driver.findElement(drpGov).click();
driver.findElement(drpGovSelect).click();
//logger.info("PageAddressKW - Select Governance");
Thread.sleep(2000);

driver.findElement(drpDistrict).click();
driver.findElement(drpDistrictSelect).click();
//logger.info("PageAddressKW - Select District");
Thread.sleep(2000);

driver.findElement(drpBlockNo).click();
driver.findElement(drpBlockNoSelect).click();
//logger.info("PageAddressKW - Select Block No");

driver.findElement(txtStreetName).sendKeys("Kuwait Test street");
//logger.info("PageAddressKW - Enter Street Name/No");

driver.findElement(txtJadah).sendKeys("1");
//logger.info("PageAddressKW - Enter Street Name/No");

driver.findElement(txtBldgNo).sendKeys("2");
//logger.info("PageAddressKW - Enter BldgNo");

driver.findElement(txtFloorNo).sendKeys("3");
//logger.info("PageAddressKW - Enter FloorNo");

driver.findElement(txtApartmentNo).sendKeys("4");
//logger.info("PageAddressKW - Enter ApartmentNo");

driver.findElement(txtCompound).sendKeys("5");
//logger.info("PageAddressKW - Enter Compound");

driver.findElement(txtLandmark).sendKeys("6");
//logger.info("PageAddressKW - Enter Landmark");

driver.findElement(txtDeliveryInstructions).sendKeys("Test DeliveryInstructions");
//logger.info("PageAddressKW - Enter DeliveryInstructions");

TestUtil.takeScreenshotAtEndOfTest();

driver.findElement(btnConfirmDelAddress).click();
//logger.info("PageAddressKW - Click Confirm Delivery Address");
}
catch(Exception e)
{
System.out.println(e);
}
}

}