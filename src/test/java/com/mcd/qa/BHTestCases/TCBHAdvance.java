package com.mcd.qa.BHTestCases;

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
import com.mcd.qa.pages.PageZPGMPGS;
import com.mcd.qa.util.TestUtil;

public class TCBHAdvance extends TestBase
{
	PageLogin loginpage;
	PageHome homepage;
	PageMenu pagemenu;
	PageReviewAndConfirmOrder revieworder;
	PagePaySelection payselect;
	PageZPG enterpaymentdetails;
	PageZPGMPGS enterpaymentdetailsmpgs;
	PageOrderConfirmation orderconfirm;

	public TCBHAdvance()
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
		enterpaymentdetailsmpgs = new PageZPGMPGS(driver);
		orderconfirm = new PageOrderConfirmation(driver);
	}

	@Test
	public void BHTCAdvanceOrder() throws Exception
	{
//		logger.info("-----BH Registered Advance Order Test Case-----");
		driver.get(pro.getProperty("mcdURLBHTEST"));
		TestUtil.takeScreenshotAtEndOfTest();
		loginpage.LoginMcD();
		homepage.AdvanceOrder();
		TestUtil.reorderconfirmation();
		TestUtil.clickAlaCarteORBreakfast();
		pagemenu.SelectProduct();
		pagemenu.AddItemsToBag();
		Thread.sleep(4000);
		pagemenu.Checkout();
		revieworder.ConfirmOrder();
		payselect.selectCredit();
		payselect.selectUseAnotherCard();
		payselect.selectVisaCard();
		payselect.ProceedToPayment();

		//Enter Card Details
		enterpaymentdetailsmpgs.enterPaymentDetailsMPGS();
		orderconfirm.validate_orderConfirmationPage();
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}