package com.mcd.qa.BHTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.mcd.qa.base.TestBase;
import com.mcd.qa.pages.PageHome;
import com.mcd.qa.pages.PageLogin;
import com.mcd.qa.pages.PageMenu;
import com.mcd.qa.pages.PageOrderConfirmation;
import com.mcd.qa.pages.PagePaySelection;
import com.mcd.qa.pages.PageReviewAndConfirmOrder;
import com.mcd.qa.util.TestUtil;

public class TCBHImmediate extends TestBase
{
	PageLogin loginpage;
	PageHome homepage;
	PageMenu pagemenu;
	PageReviewAndConfirmOrder revieworder;
	PagePaySelection payselect;
	PageOrderConfirmation orderconfirm;

	public TCBHImmediate()
	{
		super();
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
	public void BHTCImmediateOrder() throws Exception
	{
//		logger.info("-----BH Registered Immediate Order Test Case-----");
		driver.get(pro.getProperty("mcdURLBHTEST"));
		TestUtil.takeScreenshotAtEndOfTest();
		loginpage.LoginMcD();
		homepage.StartNewOrder();
		TestUtil.reorderconfirmation();
		TestUtil.clickAlaCarteORBreakfast();
		pagemenu.SelectProduct();
		pagemenu.AddItemsToBag();
		Thread.sleep(4000);
		pagemenu.Checkout();
		revieworder.ConfirmOrder();
		payselect.selectCash();
		payselect.PlaceOrder();
		orderconfirm.validate_orderConfirmationPage();
		TestUtil.takeScreenshotAtEndOfTest();

		Thread.sleep(3000);
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}