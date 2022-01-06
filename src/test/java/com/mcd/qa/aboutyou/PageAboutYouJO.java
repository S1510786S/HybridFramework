
package com.mcd.qa.aboutyou;

//import org.apache.log4j.Logger; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mcd.qa.JOTestCases.TCJORegistration; import
com.mcd.qa.base.TestBase;

public class PageAboutYouJO extends TestBase {

	public PageAboutYouJO(WebDriver driver) { 
		this.driver = driver;
		//  logger=Logger.getLogger(PageAboutYouJO.class.getName());

	}

	public void enterAboutYouDetailsJO() 
	{ 
	try 
		{
		driver.findElement(By.xpath("//*[@id='form_register_title-button']/span[2]")).click();
		driver.findElement(By.xpath("//*[@id='form_register_title-menu']/li[1]/a")).click(); 
		// logger.info("PageAboutYouDetailsBH - Select Salutation");

		driver.findElement(By.name("firstName")).sendKeys("TestFN"); //
		//  logger.info("PageAboutYouDetailsBH - Enter First Name");
		driver.findElement(By.name("lastName")).sendKeys("TestLN"); //
		//  logger.info("PageAboutYouDetailsBH - Enter Last Name");

		driver.findElement(By.xpath("//*[@id='form_register_gender-button']/span[2]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='form_register_gender-menu']/li[2]/a")).click(); // logger.info("PageAboutYouDetailsBH - Select Gender");

		driver.findElement(By.xpath("//*[@id='form_register_dob_day-button']/span[2]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='form_register_dob_day-menu']/li[2]/a")).click(); // logger.info("PageAboutYouDetailsBH - Select Day");

		driver.findElement(By.xpath("//*[@id='form_register_dob_month-button']/span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='form_register_dob_month-menu']/li[2]/a")).click(); // logger.info("PageAboutYouDetailsBH - Select Month");

		driver.findElement(By.xpath("//*[@id='form_register_dob_year-button']/span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='form_register_dob_year-menu']/li[20]/a")).click(); // logger.info("PageAboutYouDetailsBH - Select Year");

		driver.findElement(By.name("contactNo")).sendKeys("789050505");

		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(TCJORegistration.email1);
		driver.findElement(By.name("confirmEmail")).clear();
		driver.findElement(By.name("confirmEmail")).sendKeys(TCJORegistration.email1); 
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("Test@1234");
		driver.findElement(By.name("comfirmPassword")).clear();
		driver.findElement(By.name("comfirmPassword")).sendKeys("Test@1234");

		driver.findElement(By.xpath("//label[@for='form_register_agreetnc']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();

		Thread.sleep(3000);
		driver.switchTo().window(TCJORegistration.tabs.get(1)).close();

		driver.switchTo().window(TCJORegistration.tabs.get(0)); // switch back to main screen

		//Thread.sleep(13000); 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//span[@class='inboxSubject subject-title']/a[contains(@href,'temp')]"),"Sign")); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='inboxSubject subject-title']/a[contains(@href,'temp')]")));

		driver.findElement(By.xpath("//span[@class='inboxSubject subject-title']/a[contains(@href,'temp')]")).click();

		Thread.sleep(4000); driver.findElement(By.xpath("//img[contains(@alt, 'Activate your account and start ordering')]")).click();

	} catch(Exception e) 
	{ System.out.println(e); 
	} 
	} 
}
