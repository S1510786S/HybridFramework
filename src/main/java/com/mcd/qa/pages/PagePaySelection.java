package com.mcd.qa.pages;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mcd.qa.base.TestBase;

public class PagePaySelection extends TestBase
{
	WebDriver driver;

	By radioCash = By.xpath("//label[text()='Cash']");
	By radioCredit = By.xpath("//label[contains(text(),'Credit')]");
	By radioUseAnotherCard = By.xpath("//label[contains(text(),'Use another card')]");
	By btnPlaceOrder = By.xpath("//button[contains(text(),'Place Order')]");
	By btnProceedToPayment = By.xpath("//*[text()='Proceed to payment']");
	By checkBoxTermCondition = By.xpath("//label[@for='form_order_payment_agreetnc']");
	By contactno = By.id("form_order_payment_guest_mobileno");
	By radioMasterCard = By.xpath("//label[@class='radio-label card-icons-sprite card-icons-master']");
	By radioVisaCard = By.xpath("//label[@class='radio-label card-icons-sprite card-icons-visa']");
	By radioAmexCard = By.xpath("//label[@class='radio-label card-icons-sprite card-icons-amex']");
	By txtEmail = By.name("form_order_verification_email");
	By txtQAAmount = By.name("form_order_payment_type_cashdenomination_cash");

	public PagePaySelection(WebDriver driver)
	{
		this.driver = driver;
//		logger=Logger.getLogger(PagePaySelection.class.getName());
	}

	//label[contains(text(),'Cash')]

	public void selectCash()
	{
		driver.findElement(radioCash).click();
		logger.info("PagePaySelection - Select Cash");
	}

	public void selectCashQAAmount()
	{
		driver.findElement(txtQAAmount).sendKeys("150");
		logger.info("PagePaySelection - Select Cash - Enter Amount");
	}

	public void selectCredit()
	{
		driver.findElement(radioCredit).click();
		logger.info("PagePaySelection - Select Credit");
	}

	public void selectUseAnotherCard()
	{
		/*
		 * if(driver.findElement(radioUseAnotherCard).isDisplayed()) {
		 * driver.findElement(radioUseAnotherCard).click();
		 * logger.info("PagePaySelection - Select Use another card"); }
		 */
		try
		{
			driver.findElement(radioUseAnotherCard).click();
			logger.info("PagePaySelection - Select Use another card");
		}
		catch(Exception e)
		{
			logger.info("PagePaySelection - No Use another card Option");
		}
	}

	public void selectMasterCard()
	{
		driver.findElement(radioMasterCard).click();
		logger.info("PagePaySelection - Select Master");
	}

	public void selectVisaCard()
	{
		driver.findElement(radioVisaCard).click();
		logger.info("PagePaySelection - Select Visa");
	}

	public void selectAmexCard()
	{
		driver.findElement(radioAmexCard).click();
		logger.info("PagePaySelection - Select Amex");
	}

	public void PlaceOrder()
	{
		driver.findElement(btnPlaceOrder).click();
		logger.info("PagePaySelection - Click Place Order button");
	}

	public void ProceedToPayment()
	{
		driver.findElement(btnProceedToPayment).click();
		logger.info("PagePaySelection - Click Proceed to Payment button");
	}

	public void checkBoxTermsAndConditions()
	{
		driver.findElement(checkBoxTermCondition).click();
		logger.info("PagePaySelection - Check Terms and Condition Checkbox");
	}

	public void enterContactNumberJO()
	{
		driver.findElement(contactno).sendKeys("789050505");
		logger.info("PagePaySelection - Enter Contact Number");
	}

	public void enterContactNumberBH()
	{
		driver.findElement(contactno).sendKeys("0097312312311");
		logger.info("PagePaySelection - Enter Contact Number");
	}

	public void enterContactNumberKW()
	{
		driver.findElement(contactno).sendKeys("98706650");
		logger.info("PagePaySelection - Enter Contact Number");
	}

	public void enterContactNumberQA()
	{
		driver.findElement(contactno).sendKeys("9969090909");
		logger.info("PagePaySelection - Enter Contact Number");
	}

	public void enterContactNumberUAE()
	{
		driver.findElement(contactno).sendKeys("0501234567");
		logger.info("PagePaySelection - Enter Contact Number");
	}

	public void enterEmail()
	{
		driver.findElement(txtEmail).sendKeys("swapnil.shirsekar@capgemini.com");
		logger.info("PagePaySelection - Enter Email");
	}


}