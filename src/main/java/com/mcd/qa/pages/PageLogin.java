package com.mcd.qa.pages;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mcd.qa.base.TestBase;
import com.mcd.qa.util.TestUtil;

public class PageLogin extends TestBase
{
	WebDriver driver;

	By username = By.id("form_login_masthead_username");
	By password = By.id("form_login_masthead_password");
	By btnSignIn = By.xpath("//label[@for='form_login_masthead_rememberme'][text()='Remember Me']/ancestor::fieldset/following-sibling::fieldset//button");
	By btnSignOut = By.xpath("//a[contains(text(),'Sign Out')]");
	By tabguestOrder = By.xpath("//a[contains(text(), 'Guest Order')]");
	By btnGuestOrder = By.xpath("//div[@id='home-tab-new']//following-sibling::a[contains(text(),'Guest Order')]");
	By btnRegisterNow = By.xpath("//a[@class='btn btn-block btn-red btn-xl']//following-sibling::span[contains(text(),'Register Now')]");

	public PageLogin(WebDriver driver)
	{
		this.driver = driver;
		//		logger=Logger.getLogger(PageLogin.class.getName());
	}

	public void LoginMcD()
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys("swapnil.shirsekar@capgemini.com");
				logger.info("PageLogin - Enter UserName");
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("Test@1234");
				logger.info("PageLogin - Enter Password");
		driver.findElement(btnSignIn).click();
				logger.info("PageLogin - Click Sign In");
		TestUtil.takeScreenshotAtEndOfTest();
		
	
	}

	public void LogoutMcD()
	{
		driver.findElement(btnSignOut).click();
		//		logger.info("Signed Out");
	}

	public void guestOrderTAB()
	{
		driver.findElement(tabguestOrder).click();
		//		logger.info("PageHome - Click Guest Order TAB");
		TestUtil.takeScreenshotAtEndOfTest();
	}

	public void guestOrderbuttonclick()
	{
		driver.findElement(btnGuestOrder).click();
		//		logger.info("PageHome - Click GUEST ORDER Button");
		TestUtil.takeScreenshotAtEndOfTest();
	}

	public void registernowbuttonclick()
	{
		driver.findElement(btnRegisterNow).click();
		//		logger.info("PageHome - Click GUEST ORDER Button");
	}

}