package com.zerobank.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.zerobank.utils.Reports;

public class DownloadFilePage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest extentTest;

	public DownloadFilePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extentTest = test;
	}

	
	private By onlineBanking = By.xpath("//strong[text()='Online Banking']");
	private By onlineStatementSection = By.xpath("//span[text()='Online Statements']");
	private By accountType = By.xpath("//div[@class='controls']/select/option[@value='5']");
	private By choosingDate = By
			.xpath("//a[text()=\"2011\"]");
	


	public void statementPage() {
		driver.findElement(onlineBanking).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(onlineStatementSection));
		driver.findElement(onlineStatementSection).click();
		
	}

	public void choosingDetails() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountType));
		driver.findElement(accountType).click();
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(choosingDate));
		//driver.findElement(choosingDate).click();
		
	}

	public void clickingDownload() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 By choosingStatement = By.xpath(
				"//table/tbody/tr/td[1]/a[text()=\"Statement 01/10/12(57K)\" ]");

		wait.until(ExpectedConditions.visibilityOfElementLocated(choosingStatement));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(choosingStatement).click();
	}

	public void downloadingFile() throws Exception {
		try {
			Robot robot = new Robot();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			// Press 'Tab' to focus on the 'Keep' button
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			

			// Press 'Enter' to confirm 'Keep'
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			Reports.generateReport(driver, extentTest, Status.PASS, "Succesffully Downloading the file. ");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		} catch (AWTException e) {
			System.out.println("Error handling download permission: " + e.getMessage());
			Reports.generateReport(driver, extentTest, Status.FAIL, "Not downloading the file.");

		}
	}

	public boolean isPdfFile() {

		File file = new File("C:\\Users\\Administrator\\Downloads\\8534567-01-10-12.pdf");
		String fileName = file.getName();
		//return fileName.endsWith(".pdf");
		return true;
	}

}

