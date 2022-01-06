package com.mcd.qa.QATestCases;

import org.testng.annotations.*;

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

public class TCQAGuestAdvance extends TestBase
{
	PageLogin loginpage;
	PageHome homepage;
	PageMenu pagemenu;
	PageReviewAndConfirmOrder revieworder;
	PagePaySelection payselect;
	PageZPG enterpaymentdetails;
	PageAddressQA addQA;
	PageOrderConfirmation orderconfirm;

	public TCQAGuestAdvance()
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
		addQA = new PageAddressQA(driver);
		enterpaymentdetails = new PageZPG(driver);
		orderconfirm = new PageOrderConfirmation(driver);
	}

	@Test
	public void QATCGuestAdvanceOrder() throws Exception
	{
		//logger.info("-----QA Guest Immediate Order Test Case-----");
		driver.get(pro.getProperty("mcdURLQATEST"));
		TestUtil.takeScreenshotAtEndOfTest();
		loginpage.guestOrderTAB();
		loginpage.guestOrderbuttonclick();
		addQA.enterAddressQA();
		homepage.AdvanceOrder();
		TestUtil.clickAlaCarteORBreakfast();
		pagemenu.SelectProduct();
		pagemenu.AddItemsToBag();
		Thread.sleep(4000);
		pagemenu.Checkout();
		revieworder.ConfirmOrder();
		payselect.selectCredit();
		payselect.checkBoxTermsAndConditions();
		payselect.enterContactNumberQA(); //Market Specific
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