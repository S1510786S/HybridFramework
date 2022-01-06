package com.mcd.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase
{
	public static WebDriver driver = null;
	static File file;
	static FileInputStream fis;
	public static Properties pro;	
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public TestBase()
	{
		try
		{
			file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mcd\\qa\\config\\config.properties");
			fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
		String browserName = pro.getProperty("mcdBrowser");
		switch (browserName)
		{
		case "Chrome":

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\BrowserDriversMcd\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-geolocation");
			option.addArguments("disable-notifications");
			driver = new ChromeDriver(option);
			
			break;

			// ----------Incognito Chrome---------
			// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\BrowserDriversMcd\\chromedriver.exe");
			// ChromeOptions o= new ChromeOptions();
			// o.addArguments("--incognito");
			// DesiredCapabilities c = DesiredCapabilities.chrome();
			// c.setCapability(ChromeOptions.CAPABILITY, o);
			// driver = new  ChromeDriver(o);
			// break;

		default:
			break;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// driver.get(pro.getProperty("mcdURL"));
		// TestUtil.takeScreenshotAtEndOfTest();
		
		
	}


}