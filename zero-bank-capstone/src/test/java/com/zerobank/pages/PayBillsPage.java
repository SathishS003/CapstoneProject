package com.zerobank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zerobank.utils.Reports;

public class PayBillsPage {
	WebDriver driver;
	ExtentTest test; 
	WebDriverWait wait;
	
 By paybill=By.xpath("//li[@id=\"pay_bills_tab\"]/a[text()=\"Pay Bills\"]");
 By payee=By.xpath("//select[@id=\"sp_payee\"]/option[2]");
 By amount=By.xpath("//input[@id=\"sp_amount\"]");
 By date=By.xpath("//input[@id=\"sp_date\"]");
 By cdate=By.xpath("//table/tbody/tr[5]/td[3]/a[text()=\"25\"]");
 By pay=By.xpath("//input[@id=\"pay_saved_payees\"]");
 By result=By.xpath("//div[@id=\"alert_content\"]/span[text()=\"The payment was successfully submitted.\"]");
 By newpayee=By.xpath("//a[text()=\"Add New Payee\"]");
  By payeeName = By.xpath("//input[@id=\"np_new_payee_name\"]");
	 By payeeAddress = By.id("np_new_payee_address");
 By payeeAccount = By.id("np_new_payee_account");
 By payeeDetails=By.id("np_new_payee_details");
 By successfulAddingNewPayeeMessage=By.id("alert_content");
 By addpayeeButton=By.xpath("//input[@id=\"add_new_payee\"]");
 By newPayeeResult=By.xpath("//div[@id=\"alert_content\"]");
 public PayBillsPage(WebDriver driver,ExtentTest test){
	 this.driver=driver;
	 this.test=test;
	 this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
 }

 public void clickPayBill() {
	 WebElement payBills=driver.findElement(paybill);
	 payBills.click();
 }
 public void clickPayee() {
	 wait.until(ExpectedConditions.visibilityOfElementLocated(payee));
	 WebElement payees=driver.findElement(payee);
	 payees.click();
 }
 public void clickAmountClickDate(String string,String string2) {
	 cdate = By.xpath("//a[text()="+string2+"]");
	 WebElement amounts=driver.findElement(amount);
		//amounts.click();
		amounts.sendKeys(string);
	WebElement dates=driver.findElement(date);
	dates.click();
	WebElement cdates=driver.findElement(cdate);
	cdates.click();
 }
 public void clickPay() {
	 WebElement pays=driver.findElement(pay);
		pays.click();
 }
 public boolean checkresult( String mesg)
 {
	 boolean actresult=true;
	 WebElement results=driver.findElement(result);
	 try{
		 results.isDisplayed();
		 Reports.generateReport(driver, test, Status.PASS,mesg );
	 }
	 catch(Exception e) {
		 actresult=false;
		 Reports.generateReport(driver, test, Status.FAIL,mesg );
	 }
	 return actresult;
 }
 public boolean validateSkippingAmount(String msg) {
		boolean actReasult = true;
		try {

			// String message=driver.findElement(successfulMessage).getText();
			WebElement amounts = driver.findElement(By.id("sp_amount"));
			JavascriptExecutor js = (JavascriptExecutor) driver;

			String message1 = (String) js.executeScript("return arguments[0].validationMessage;", amounts);
			System.out.println(message1+"is printing");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(result));
			// Assert.assertTrue(actReasult)
			
			//Assert.assertEquals("Please fill out this field.",message1);

			Reports.generateReport(driver, test, Status.PASS, msg);
		} catch (Exception e) {
			actReasult = false;
			Reports.generateReport(driver, test, Status.FAIL, msg);
		}
		return actReasult;
	}
 public void enterDate(String dateValue) {
	 cdate = By.xpath("//a[text()="+dateValue+"]");
	 WebElement dates=driver.findElement(date);
		dates.click();
	 WebElement cdates=driver.findElement(cdate);
		cdates.click();
 }
 public void newPayee() {
		driver.findElement(newpayee).click();

	}

	public void addAllPayeeDetails(String name, String address, String accountNo,String details) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(payeeName));
		WebElement names=driver.findElement(payeeName);
		names.click();
		names.sendKeys(name);
		WebElement adress=driver.findElement(payeeAddress);
		adress.click();
		adress.sendKeys(address);
		WebElement acno=driver.findElement(payeeAccount);
		acno.click();
		acno.sendKeys(accountNo);
		WebElement detail=driver.findElement(payeeDetails);
		detail.click();
		detail.sendKeys(details);
	}
 public void addPayee() {
	 driver.findElement(addpayeeButton).click();;
 }
 public boolean newPayeeOutput() {
	 boolean actresult=true;
	 try {
		 WebElement result=driver.findElement(newPayeeResult);
		 result.isDisplayed();
		 Reports.generateReport(driver, test, Status.PASS, "New Payee Added");
	 }
	 catch(Exception e) {
		 actresult=false;
		 Reports.generateReport(driver, test, Status.FAIL, "New Payee cannot be Added");
	 }
	 return actresult;
 }
 public boolean skippingDetails(String msg) {
	 
	 boolean actResult = true;
		
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// String message=driver.findElement(successfulMessage).getText();
			WebElement adres = driver.findElement(payeeAddress);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			String message1 = (String) js.executeScript("return arguments[0].validationMessage;", adres);
			System.out.println(message1+"is printing");
			if(message1.equals(msg)) {
				Reports.generateReport(driver, test, Status.PASS,msg );
			}
			else {
				actResult=false;
				Reports.generateReport(driver, test, Status.FAIL,msg );
			}
			
          return actResult;
		
	}
 
}
