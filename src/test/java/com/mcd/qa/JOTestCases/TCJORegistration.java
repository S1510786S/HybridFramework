package com.mcd.qa.JOTestCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

import com.mcd.qa.aboutyou.PageAboutYouJO;
import com.mcd.qa.address.PageAddressJO;
import com.mcd.qa.base.TestBase;
import com.mcd.qa.pages.PageLogin;

public class TCJORegistration extends TestBase
{
	PageLogin loginpage;
	PageAddressJO addJO;
	PageAboutYouJO aboutYouJO;
	public static String email1;
	public static ArrayList<String> tabs,tabs1;

	public TCJORegistration()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new PageLogin(driver);
		addJO = new PageAddressJO(driver);
		aboutYouJO = new PageAboutYouJO(driver);
	}

	@Test
	public void JORegistration() throws Exception
	{

		/*
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
		 * "\\src\\test\\resources\\BrowserDriversMcd\\chromedriver.exe"); driver = new
		 * ChromeDriver(); //driver.manage().window().maximize();
		 * //driver.manage().deleteAllCookies();
		 * driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 */

		String baseUrl = "https://temp-mail.org/en/";
		driver.get(baseUrl);

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//*[@id='mail']"), ".com"));

		driver.findElement(By.xpath("//*[@id='mail']")).click();
		email1 = driver.findElement(By.xpath("//*[@id='mail']")).getAttribute("value");
		System.out.println(email1);    
		((JavascriptExecutor)driver).executeScript("window.open()");
		//Thread.sleep(3000);

		tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); //switches to new tab
		//driver.get(pro.getProperty("mcdURL"));
		driver.get("https://wos:bhWo$@mcdelivery-stg.mcdonalds.com/jo/?locale=en");
		//Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		loginpage.registernowbuttonclick();
		//driver.findElement(By.xpath("//*[text()='Register Now']")).click();
		addJO.enterAddressJO();
		aboutYouJO.enterAboutYouDetailsJO();

		try
		{
			tabs1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(1));
			driver.findElement(By.xpath("//*[contains(text(),'successfully activated ')]")).click();
			System.out.println("YOU'VE SUCCESSFULLY ACTIVATED YOUR ACCOUNT.");

		}
		catch(Exception e)
		{}
	}

}