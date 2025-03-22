package com.zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.zerobank.hooks.BankStart;
import com.zerobank.utils.Reports;

public class LoginPage {
    WebDriver driver;
    ExtentTest test;
     
    public LoginPage(WebDriver driver,ExtentTest test) {
        this.driver = driver; 
       this.test=test;
    } 
    
    private By signInButton=By.xpath("//button[@id=\"signin_button\"]");
    private By usernameField=By.xpath("//input[@name=\"user_login\"]");
    private By passwordField=By.xpath("//input[@name=\"user_password\"]");
    private By loginSubmit=By.name("submit");
    private By errorMessage;
    public void home() {
    	
    	 String title=driver.getTitle();
    	 
    	 if(title.equals("Zero - Personal Banking - Loans - Credit Cards")) {
    		 Reports.generateReport(driver, test, Status.PASS, "I am on Home page");
    	 }
    	 else {
    		 Reports.generateReport(driver, test, Status.FAIL, "Home Page is not visible");
    	 }
    	 }
    public void clickSignInButton() {
       
        WebElement signIn = driver.findElement(signInButton);
        signIn.click();
       
    }

   
    public void enterUsername(String username) {
    	
        WebElement user = driver.findElement(usernameField);
        user.sendKeys(username);
        
    }

   
    public void enterPassword(String password) {
        WebElement pass = driver.findElement(passwordField);
        pass.sendKeys(password);
    }

   
    public void clickLoginButton() {
        WebElement submit = driver.findElement(loginSubmit);
        submit.click();
        driver.navigate().back();
    }

   
    public String getErrorMessage() {
        WebElement error = driver.findElement(errorMessage);
        return error.getText();
    }

    
    public void clearFields() {
        WebElement user = driver.findElement(usernameField);
        WebElement pass = driver.findElement(passwordField);
        user.clear();
        pass.clear();
    }

    
    public void goBack() {
        driver.navigate().back();
        String title=driver.getTitle();
        if(title.equals("Zero - Personal Banking - Loans - Credit Cards")) {
   		 Reports.generateReport(driver, test, Status.PASS, "I am signed in to HomePage");
   	 }
   	 else {
   		 Reports.generateReport(driver, test, Status.FAIL, "Not signed in");
   	 }
    }
   public void checkTitle() {
	   String title=driver.getTitle();
       if(title.equals("Zero - Personal Banking - Loans - Credit Cards")) {
  		 Reports.generateReport(driver, test, Status.FAIL, "Home page");
  	 }
  	 else {
  		 Reports.generateReport(driver, test, Status.PASS, "Not logged in");
  	 }
   }
}

