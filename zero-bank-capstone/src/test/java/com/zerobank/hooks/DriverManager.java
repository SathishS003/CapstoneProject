package com.zerobank.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
  public static WebDriver driver;
  public static WebDriver getChromeDriver() {
	  driver=new ChromeDriver();
	  return driver;
  }
  public static WebDriver getFirefoxDriver() {
	  driver=new FirefoxDriver();
	  return driver;
  }
} 
