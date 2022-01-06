package com.mcd.qa.KWTestCases;

import org.testng.annotations.*;

import com.mcd.qa.address.PageAddressKW;
import com.mcd.qa.base.TestBase;
import com.mcd.qa.pages.PageHome;
import com.mcd.qa.pages.PageLogin;
import com.mcd.qa.pages.PageMenu;
import com.mcd.qa.pages.PageOrderConfirmation;
import com.mcd.qa.pages.PagePaySelection;
import com.mcd.qa.pages.PageReviewAndConfirmOrder;
import com.mcd.qa.pages.PageZPG;
import com.mcd.qa.util.TestUtil;

public class TCKWGuestAdvance extends TestBase
{
	PageLogin loginpage;
	PageHome homepage;
	PageMenu pagemenu;
	PageReviewAndConfirmOrder revieworder;
	PagePaySelection payselect;
	PageZPG enterpaymentdetails;
	PageAddressKW addKW;
	PageOrderConfirmation orderconfirm;

	public TCKWGuestAdvance()
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
		addKW = new PageAddressKW(driver);
		enterpaymentdetails = new PageZPG(driver);
		orderconfirm = new PageOrderConfirmation(driver);
	}

	@Test
	public void KWTCGuestAdvanceOrder() throws Exception
	{
		//logger.info("-----KW Guest Immediate Order Test Case-----");
		driver.get(pro.getProperty("mcdURLKWTEST"));
		TestUtil.takeScreenshotAtEndOfTest();
		loginpage.guestOrderTAB();
		loginpage.guestOrderbuttonclick();
		addKW.enterAddressKW();
		homepage.AdvanceOrder();
		TestUtil.clickAlaCarteORBreakfast();
		pagemenu.SelectProduct();
		pagemenu.AddItemsToBag();
		Thread.sleep(4000);
		pagemenu.Checkout();
		revieworder.ConfirmOrder();
		payselect.selectCredit();
		payselect.checkBoxTermsAndConditions();
		payselect.enterContactNumberKW(); //Market Specific
		payselect.enterEmail();
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