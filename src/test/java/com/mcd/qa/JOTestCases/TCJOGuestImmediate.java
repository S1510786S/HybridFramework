package com.mcd.qa.JOTestCases;

import org.testng.annotations.*;

import com.mcd.qa.address.PageAddressBH;
import com.mcd.qa.address.PageAddressJO;
import com.mcd.qa.address.PageAddressKW;
import com.mcd.qa.address.PageAddressQA;
import com.mcd.qa.base.TestBase;
import com.mcd.qa.pages.PageHome;
import com.mcd.qa.pages.PageLogin;
import com.mcd.qa.pages.PageMenu;
import com.mcd.qa.pages.PageOrderConfirmation;
import com.mcd.qa.pages.PagePaySelection;
import com.mcd.qa.pages.PageReviewAndConfirmOrder;
import com.mcd.qa.pages.PageZPG;
import com.mcd.qa.util.TestUtil;

public class TCJOGuestImmediate extends TestBase
{
	PageLogin loginpage;
	PageHome homepage;
	PageMenu pagemenu;
	PageReviewAndConfirmOrder revieworder;
	PagePaySelection payselect;
	PageZPG enterpaymentdetails;
	PageAddressJO addJO;
	PageAddressBH addBH;
	PageAddressKW addKW;
	PageAddressQA addQA;
	PageOrderConfirmation orderconfirm;

	public TCJOGuestImmediate()
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
		addJO = new PageAddressJO(driver);
		addBH = new PageAddressBH(driver);
		addKW = new PageAddressKW(driver);
		addQA = new PageAddressQA(driver);
		enterpaymentdetails = new PageZPG(driver);
		orderconfirm = new PageOrderConfirmation(driver);
	}

	@Test
	public void JOTCGuestImmediateOrder() throws Exception
	{
		//logger.info("-----JO Guest Immediate Order Test Case-----");
		driver.get(pro.getProperty("mcdURLJOTEST"));
		TestUtil.takeScreenshotAtEndOfTest();
		loginpage.guestOrderTAB();
		loginpage.guestOrderbuttonclick();
		addJO.enterAddressJO();
		homepage.StartNewOrder();
		TestUtil.reorderconfirmation();
		TestUtil.clickAlaCarteORBreakfast();
		pagemenu.SelectProduct();
		pagemenu.AddItemsToBag();
		Thread.sleep(4000);
		pagemenu.Checkout();
		revieworder.ConfirmOrder();
		payselect.selectCredit();
		payselect.checkBoxTermsAndConditions();
		payselect.enterContactNumberJO(); //Market Specific
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