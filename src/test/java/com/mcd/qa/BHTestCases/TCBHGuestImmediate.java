package com.mcd.qa.BHTestCases;

import org.testng.annotations.*;

import com.mcd.qa.address.PageAddressBH;
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

public class TCBHGuestImmediate extends TestBase
{
	PageLogin loginpage;
	PageHome homepage;
	PageMenu pagemenu;
	PageReviewAndConfirmOrder revieworder;
	PagePaySelection payselect;
	PageZPG enterpaymentdetails;
	PageZPGMPGS enterpaymentdetailsmpgs;
	PageAddressBH addBH;
	PageOrderConfirmation orderconfirm;

	public TCBHGuestImmediate()
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
		addBH = new PageAddressBH(driver);
		enterpaymentdetails = new PageZPG(driver);
		enterpaymentdetailsmpgs = new PageZPGMPGS(driver);
		orderconfirm = new PageOrderConfirmation(driver);
	}

	@Test
	public void BHTCGuestImmediateOrder() throws Exception
	{
		//logger.info("-----BH Guest Immediate Order Test Case-----");
		driver.get(pro.getProperty("mcdURLBHTEST"));
		TestUtil.takeScreenshotAtEndOfTest();
		loginpage.guestOrderTAB();
		loginpage.guestOrderbuttonclick();
		addBH.enterAddressBH();
		homepage.StartNewOrder();
		TestUtil.reorderconfirmation();
		TestUtil.clickAlaCarteORBreakfast();
		pagemenu.SelectProduct();
		pagemenu.AddItemsToBag();
		Thread.sleep(4000);
		pagemenu.Checkout();
		revieworder.ConfirmOrder();
		payselect.selectCredit();
		payselect.selectVisaCard();
		payselect.checkBoxTermsAndConditions();
		payselect.enterContactNumberBH();
		payselect.enterEmail();
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