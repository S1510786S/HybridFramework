package com.mcd.qa.LKTestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mcd.qa.base.TestBase;
import com.mcd.qa.pages.PageHome;
import com.mcd.qa.pages.PageLogin;
import com.mcd.qa.pages.PageMenu;
import com.mcd.qa.pages.PageOrderConfirmation;
import com.mcd.qa.pages.PagePaySelection;
import com.mcd.qa.pages.PageReviewAndConfirmOrder;
import com.mcd.qa.util.TestUtil;

public class TCLKImmediate extends TestBase{
	PageLogin loginpage;
	PageHome homepage;
	PageMenu pagemenu;
	PageReviewAndConfirmOrder revieworder;
	PagePaySelection payselect;
	PageOrderConfirmation orderconfirm;

	public TCLKImmediate()
	{
		super();	// call test base class constructor for initialization
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new PageLogin(driver);
		homepage = new PageHome(driver);
		pagemenu = new PageMenu(driver);
		revieworder = new PageReviewAndConfirmOrder(driver);
		payselect = new PagePaySelection(driver);
		orderconfirm = new PageOrderConfirmation(driver);
	}

	@Test
	public void LKTCImmediateOrder() throws Exception
	{
		//logger.info("-----LK Registered Immediate Order Test Case-----");
		driver.get(pro.getProperty("mcdURLLKTEST"));
		TestUtil.takeScreenshotAtEndOfTest();
		loginpage.LoginMcD();
		homepage.StartNewOrder();
		
		//Commit done by Pooja
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
