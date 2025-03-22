package com.zerobank.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zerobank.utils.Reports;

public class OnlineBankingPage {
	WebDriver driver;
	ExtentTest test; 
	public OnlineBankingPage(WebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	private By onlineBanking=By.xpath("//li[@id=\"onlineBankingMenu\"]/div/strong");
	private By accsummary=By.xpath("//span[@id=\"account_summary_link\"]");
	private By cash=By.xpath("//div/div/h2[text()=\"Cash Accounts\"]");
	private By saving=By.xpath("//table/tbody/tr[1]/td[1]/a[text()=\"Savings\"]");
	private By checking=By.xpath("//a[text()=\"Checking\"]");
	private By creditcard=By.xpath("//a[text()=\"Credit Card\"]");
	private By loan=By.xpath("//table/tbody/tr[1]/td[1]/a[text()=\"Loan\"]");
//	private By savings=By.xpath("");
	 public void onlineBank() {
	    	WebElement onlinebankmenu=driver.findElement(onlineBanking);
	    	onlinebankmenu.click();
	    }
	 public void accSum() {
	    	WebElement accountSum=driver.findElement(accsummary);
	    	accountSum.click();
	    	System.out.println("clicked on Account sum");
	    }
	 public boolean displayCash() {
		 boolean actresult=true;
	    	WebElement acccash=driver.findElement(cash);
	    	try {
	    		acccash.isDisplayed();
	    		 Reports.generateReport(driver, test, Status.PASS,"Account types and balance is displayed");
	    	}
	    	catch(Exception e) {
	    		actresult=false;
	    		 Reports.generateReport(driver, test, Status.FAIL, "Account types and balance not displayed");
	    	}
	    	return actresult;
	    }
	 public boolean checkAccTypes() {
		 boolean actresult =true;
		 WebElement checkings=driver.findElement(checking);
		 WebElement savings=driver.findElement(saving);
		 WebElement creditCards=driver.findElement(creditcard);
		 WebElement loans=driver.findElement(loan);
		 try {
		 checkings.isDisplayed();
		 savings.isDisplayed();
		 creditCards.isDisplayed();
		 loans.isDisplayed();
		 Reports.generateReport(driver, test, Status.PASS, "All types of accounts are displayed");
		 }
		 catch(Exception e) {
			 actresult =false;
			 Reports.generateReport(driver, test, Status.FAIL, "All types of accounts are not displayed");
		 }
		 return actresult;
	 }
}
