package com.pracc.com.TestMeApppp;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMe {
	/*
	@Test
	public void Testt()
	{
		WebDriver driver;
		
		@BeforeTest
		public void getdriver()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		}*/
		
		@Test
		public void TestMeVerify() throws InterruptedException
		{
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "D:\\cucumber files\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
			
			
			
			
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
			driver.findElement(By.name("userName")).sendKeys("lalitha");
			driver.findElement(By.name("password")).sendKeys("password123");
			driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
			
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/a/span"))).build().perform();
			Thread.sleep(2000);
			a.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/a/span"))).build().perform();
			Thread.sleep(2000);
			a.moveToElement(driver.findElement(By.linkText("Chennai"))).click().build().perform();
			
//			String win = driver.getWindowHandle();
			Set<String> win = driver.getWindowHandles();
			System.out.println("Total Windows "+win.size());
			Iterator<String> i = win.iterator();
			String mainwindow = i.next();
			String firstwindow = i.next();
			driver.switchTo().window(firstwindow);
			
			
			driver.switchTo().frame("main_page");
			String s = driver.findElement(By.xpath("//*[@id=\"demo3\"]")).getText();
					
			System.out.println(s);
			if(s.contains("Testme Inc."))
			{
				System.out.println("Address matched");
			}
			else
			{
				System.out.println("did not matched");
			}
			driver.close();
			
			driver.switchTo().window(mainwindow);
			driver.close();
			
		}
		

		
		
		
		
		
		
		
	
		
		
		
	}


