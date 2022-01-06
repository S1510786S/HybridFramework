package com.mcd.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mcd.qa.base.TestBase;


public class TestUtil extends TestBase {
	// static WebDriver driver;

	public static void takeScreenshotAtEndOfTest() {

		String strMain = driver.getCurrentUrl();
		String[] arrSplit = strMain.split("/");
		//System.out.println("Market"+ arrSplit[3]);

		String timestamp = new SimpleDateFormat("yyyy_MM_dd").format(new Date());

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot,
					new File("C:\\Selenium\\projectScreenshots\\" + arrSplit[3]+timestamp+System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void reorderconfirmation()
	{
		try
		{
			driver.findElement(By.xpath("//*[contains(text(),'Order Again')]")).click();
			System.out.println("Re-Order Confirmation pop up present");  
		}
		catch(Exception e)
		{}
	}

	public static void clickAlaCarteORBreakfast()
	{
		List<WebElement> categories = driver.findElements(By.xpath("//*[@class='secondary-menu-item-target']"));
		//System.out.println(categories.size());
		for(int i=0;i<categories.size();i++)
		{
			//System.out.println(categories.get(i).getText());
			if(categories.get(i).getText().contains("Breakfast"))
			{
				driver.findElement(By.xpath("//span[contains(text(),'Breakfast ')]/parent::a")).click();
				break;
			}
			else if(categories.get(i).getText().contains("Ala"))
			{
				driver.findElement(By.xpath("//span[contains(text(),'Ala Carte')]/parent::a")).click();
				break;
			}
		}
	}

}