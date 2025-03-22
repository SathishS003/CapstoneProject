package com.zerobank.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features= {"src//test//resources//zerobank.Features"}
		
            ,glue={"com.zerobank.steps","com.zerobank.hooks"},
plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
