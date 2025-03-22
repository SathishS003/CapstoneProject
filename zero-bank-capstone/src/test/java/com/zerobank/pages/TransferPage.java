package com.zerobank.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zerobank.utils.Reports;

public class TransferPage {
    WebDriver driver;
    ExtentTest test;
    By fundtransfer=By.xpath("//li[@id=\"transfer_funds_tab\"]/a");
    By amount=By.xpath("//input[@id=\"tf_amount\"]");
    By continues=By.xpath("//button[@id=\"btn_submit\"]");
    By submit=By.xpath("//button[text()=\"Submit\"]");
    By result=By.xpath("//div[@id=\"transfer_funds_content\"]/div/div/div[1]");
	By FAccount=By.xpath("//select[@id=\"tf_fromAccountId\"]");
	By TAccount=By.xpath("//select[@id=\"tf_toAccountId\"]");
    public TransferPage(WebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	public void transferfunds() {
		WebElement transferMenu=driver.findElement(fundtransfer);
		try {
		transferMenu.click();
		Reports.generateReport(driver, test, Status.PASS, "Navigated to transfer Funds");
		}
		catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, " Not Navigated to transfer Funds");
		}
		
	}
	public void fromToAccounts() {
	
			WebElement FAccounts=driver.findElement(FAccount);
			WebElement TAccounts=driver.findElement(TAccount);
          try {
	        FAccounts.isDisplayed();
	        TAccounts.isDisplayed();
	        Reports.generateReport(driver, test, Status.PASS, " AccountTypes Selected");
	        }
          catch(Exception e) {
        	  Reports.generateReport(driver, test, Status.FAIL, "Account Types not Selected");
          }
	}
	public void enterAmount(String a) {
		WebElement amounts=driver.findElement(amount);
		amounts.click();
		amounts.sendKeys(a);
	}
	public void clickContinue() {
		WebElement continew=driver.findElement(continues);
		continew.click();
		
	}
	public void clickSubmit() {
		WebElement submits=driver.findElement(submit);
		submits.click();
		
	}
	public void checkResult() {
		WebElement results=driver.findElement(result);
	    try {
	    	results.isDisplayed();
	    	Reports.generateReport(driver, test, Status.PASS, "Payment is successful");
	    }
		catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Payment is not successful");
		}
	}
	public boolean checkResult2(String mesg) {
		boolean ans=true;
		WebElement results=driver.findElement(result);
	    try {
	    	results.isDisplayed();
	    	Reports.generateReport(driver, test, Status.FAIL, mesg);
	    	ans=false;
	    }
		catch(Exception e) {
		
			Reports.generateReport(driver, test, Status.PASS, mesg);
		}
	    return ans;
	}
	
	

}
