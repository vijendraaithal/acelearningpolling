package com.acelearning.pollingcheck;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPDFCheck {

	@Test
	public void testPDF() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Started the actual test to check if Services are opening the page in stipulated time");
		driver.get("http://learn.acedigilearn.com/login");
		
		driver.findElement(By.xpath("//*[@id='loginWithMemberId']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='loginOrgName']")).sendKeys("ACE");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='memberLoginForm']/div/div/div[2]/div/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='loginMemberId']")).sendKeys("PUS2");
		driver.findElement(By.xpath("//*[@id='userPasswordMEMBER_LOGIN']")).sendKeys("ace123");
		driver.findElement(By.xpath("//*[@id='clickToLogin']")).click();
		Thread.sleep(5000);
		// Click on Library
		driver.findElement(By.xpath("//*[@id='instPageNavigator']/div/div[2]/span[2]")).click();
		Thread.sleep(5000);
		//Click on program dropdown
		driver.findElement(By.xpath("//*[@id='instituteHome']/div/div/div/div[2]/div[1]/div[1]/div[1]/div[1]/div/div[1]/span[2]")).click();
		Thread.sleep(5000);
		// Select Learning Module
		driver.findElement(By.xpath("//*[@id='instituteHome']/div/div/div/div[2]/div[1]/div[1]/div[1]/div[1]/div/div[2]/div[3]/div")).click();
		Thread.sleep(5000);
		// Select on click Open on PDF - Orange button
		driver.findElement(By.xpath("//*[@id='instituteHome']/div/div/div/div[2]/div[2]/div[4]/div[2]/div[1]/div[1]/a")).click();
										
									Thread.sleep(5000);
		// Click on NCERT Book
									
									
		driver.findElement(By.xpath("//*[@id='moduleEntriesHolder']/a[1]/div[2]")).click();
		Thread.sleep(5000);
		
		driver.switchTo().frame("docViewerIframe");

		String testValue = driver.findElement(By.xpath("//div[text()='ELECTROSTATIC************FAILTHIS']")).getAttribute("dir");
		if (testValue.equals("ltr"))
			testValue = "Found the ELECTROSTATIC TEXT IN PDF";
		else 
			testValue = "DID NOT FIND the ELECTROSTATIC TEXT IN PDF";
		System.out.println(testValue);
		
		
		System.out.println("Ending the test, found everything to be OK and opening in stipulated time");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		driver.close();
		driver.quit();

	}
}

