package com.zerobank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zerobank.utils.Reports;

public class LogoutPage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest extentTest;

	
	public LogoutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extentTest = test;
	}
	private By username=By.xpath("//ul[@class=\"nav float-right\"]/li[3]/a");
	private By logoutBytton=By.xpath("//a[@id='logout_link']");
	private By signIn = By.id("signin_button");

	public void logout() {
	    driver.findElement(username).click();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));	    
	    wait.until(ExpectedConditions.elementToBeClickable(logoutBytton));
	    driver.findElement(logoutBytton).click();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(signIn));
	}
	
	public boolean validateSignInPage() {
		boolean actReasult=true;
		try {
			WebElement loginVerifyPage=driver.findElement(signIn);
			boolean isDisplayed=loginVerifyPage.isDisplayed();
			Assert.assertTrue(isDisplayed, "Sign-in button should be displayed after logout.");
			Reports.generateReport(driver, extentTest, Status.PASS, "Successfully Logged Out");
		} catch (Exception e) {
			actReasult=false;
			Reports.generateReport(driver, extentTest, Status.FAIL, "Not logged out successfully");
		}
		return actReasult;
	}
	public void navigatingBack() {
		driver.navigate().back();
	}
	
	
}
