package com.mcd.qa.JOTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.mcd.qa.base.TestBase;
import com.mcd.qa.pages.PageHome;
import com.mcd.qa.pages.PageLogin;
import com.mcd.qa.pages.PageMenu;
import com.mcd.qa.pages.PageOrderConfirmation;
import com.mcd.qa.pages.PagePaySelection;
import com.mcd.qa.pages.PageReviewAndConfirmOrder;
import com.mcd.qa.pages.PageZPG;
import com.mcd.qa.util.TestUtil;

public class TCJOAdvance extends TestBase
{
	PageLogin loginpage;
	PageHome homepage;
	PageMenu pagemenu;
	PageReviewAndConfirmOrder revieworder;
	PagePaySelection payselect;
	PageZPG enterpaymentdetails;
	PageOrderConfirmation orderconfirm;

	public TCJOAdvance()
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
		enterpaymentdetails = new PageZPG(driver);
		orderconfirm = new PageOrderConfirmation(driver);
	}

	@Test
	public void JOTCAdvanceOrder() throws Exception
	{
		//logger.info("-----JO Registered Advance Order Test Case-----");
		driver.get(pro.getProperty("mcdURLJOTEST"));
		TestUtil.takeScreenshotAtEndOfTest();
		loginpage.LoginMcD();
		homepage.AdvanceOrder();
		TestUtil.clickAlaCarteORBreakfast();
		pagemenu.SelectProduct();
		pagemenu.AddItemsToBag();
		Thread.sleep(4000);
		pagemenu.Checkout();
		revieworder.ConfirmOrder();
		//payselect.selectCash();
		//payselect.PlaceOrder();
		payselect.selectCredit();
		payselect.selectUseAnotherCard();
		payselect.ProceedToPayment();

		//Enter Card Details
		enterpaymentdetails.enterPaymentDetails();
		orderconfirm.validate_orderConfirmationPage();
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}