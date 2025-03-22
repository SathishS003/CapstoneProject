package com.zerobank.steps;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.zerobank.hooks.BankStart;
import com.zerobank.hooks.DriverManager;
import com.zerobank.pages.DownloadFilePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.LogoutPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.pages.TransferPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import org.junit.Assert;

public class BankSteps {
    WebDriver driver;
    LoginPage loginPage;
    OnlineBankingPage onlinePage; 
    TransferPage  transferPage;
    ExtentTest test; 
    PayBillsPage paybill;
    DownloadFilePage fdownload;
    LogoutPage logoutPage;
    public BankSteps() {
        this.driver = BankStart.driver;
        this.test=BankStart.test;
        this.loginPage = new  LoginPage(driver,test);
        this.onlinePage=new OnlineBankingPage(driver,test);
        this.transferPage=new TransferPage(driver,test);
        this.paybill=new PayBillsPage(driver,test);
        this.fdownload=new DownloadFilePage(driver,test);
        this.logoutPage = new LogoutPage(driver, test);
    }

    @Given("I am on the Home Page")
    public void i_am_on_home_page() {
    	
       loginPage.home();
        System.out.println("Navigated to Home Page");
       
        
    }

    @Given("I click on Sign in")
    public void i_click_on_sign_in() {
        loginPage.clickSignInButton();
        System.out.println("Clicked on Sign In");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        System.out.println("Entered username: " + username + " and password: " + password);
    }
    @When("Enter crt username {string} and password {string}")
    public void enter_crt_username_and_password(String string, String string2) {
    	  loginPage.enterUsername(string);
          loginPage.enterPassword(string2);
          System.out.println("Entered username: " + string + " and password: " + string2);
    }


    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
        System.out.println("Clicked the login button");
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        loginPage.goBack();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertNotNull("Error message not displayed", errorMessage);
        System.out.println("Error message: " + errorMessage);
    }

    @Given("I clear the login fields")
    public void i_clear_the_login_fields() {
        loginPage.clearFields();
        System.out.println("Cleared the username and password fields");
    }

    @Given("I go back to the previous page")
    public void i_go_back_to_the_previous_page() {
        loginPage.goBack();
        System.out.println("Navigated back to the previous page");
    }
    @Then("I should be in the same loginpage")
    public void i_should_be_in_the_same_loginpage() {
        loginPage.checkTitle();
    }
    @Then("click Online Banking menu")
    public void click_online_banking_menu() {
        onlinePage.onlineBank();
        System.out.println("clicked on online banke menu");
    }
    @Then("click on Account summary")
    public void click_on_account_summary() {
        onlinePage.accSum();
    }

@Then("Account types and balance is displayed")
public void account_types_and_balance_is_displayed() {
   boolean actresult= onlinePage.displayCash();
   Assert.assertTrue(actresult);
}

@Then("Check Account types are displayed")
public void check_account_types_are_displayed() {
	boolean actresult=onlinePage.checkAccTypes();
	 Assert.assertTrue(actresult);
	
}

@Then("click on Transfer fund menu")
public void click_on_transfer_fund_menu() {
    transferPage.transferfunds();
    
}

@Then("Enter a valid Amount {string}")
public void enter_a_valid_amount(String string) {
   transferPage.enterAmount(string);
}

@Then("click continue")
public void click_continue() {
   transferPage.clickContinue();
   transferPage.clickSubmit();
}

@Then("Successfully transaction in displayed")
public void successfully_transaction_in_displayed() {
	 transferPage.checkResult();
}

@Then("click From and To Accounts")
public void click_from_and_to_accounts() {
  transferPage.fromToAccounts();
}

@Then("Enter a more than Amount {string}")
public void enter_a_more_than_amount(String string) {
	 transferPage.enterAmount(string);
}

@Then("Enter a negative Amount {string}")
public void enter_a_negative_amount(String string) {
  transferPage.enterAmount(string);
}

@Then("{string} should be displayed")
public void should_be_displayed(String string) {
  boolean actresult= transferPage.checkResult2(string);
  Assert.assertTrue(actresult);
}

@Then("click on Pay Bills")
public void click_on_pay_bills() {
    paybill.clickPayBill();
}

@Then("select a Payee")
public void select_a_payee() {
   paybill.clickPayee();
}

@Then("Enter a valid amount {string} and {string} date")
public void enter_a_valid_amount_and_date(String string, String string2) {
   paybill.clickAmountClickDate(string,string2);
}

@Then("click on pay button")
public void click_on_pay_button() {
   paybill.clickPay();
}

@Then("{string} is displayed")
public void is_displayed(String string) {
    boolean actresult=paybill.checkresult(string);
    Assert.assertTrue(actresult);
}

@Then("Enter a valid amount {string} and future date {string} on date")
public void enter_a_valid_amount_and_future_date_on_date(String string, String string2) {
	 paybill.clickAmountClickDate(string,string2);
}

@Then("Leave the Amount empty and Enter date {string} on date")
public void leave_the_amount_empty_and_enter_date_on_date(String string) {
   paybill.enterDate(string);
}

@Then("{string} alert is displayed")
public void alert_is_displayed(String string) {
  boolean actresult= paybill.validateSkippingAmount(string);
  Assert.assertTrue(actresult);
}

@Then("click on add new payee")
public void click_on_add_new_payee() {
   paybill.newPayee();
}

@Then("add name {string},address {string},accountno {string},detatils {string}.")
public void add_name_address_accountno_detatils(String string, String string2, String string3, String string4) {
   paybill.addAllPayeeDetails(string, string2, string3, string4);
}


@Then("click Add button")
public void click_add_button() {
   paybill.addPayee();
}

@Then("New payee success message is displayed")
public void new_payee_success_message_is_displayed() {
   boolean actresult= paybill.newPayeeOutput();
   Assert.assertTrue(actresult);
}

@Then("Error {string} should be displayed.")
public void error_should_be_displayed(String string) {
	 boolean actresult= paybill.skippingDetails(string);
	  Assert.assertTrue(actresult);
}

@When("user navigate to Statements & Documents")
public void user_navigate_to_statements_documents() {
	try {
		fdownload.statementPage();
	} catch (Exception e) {
		Assert.fail("Error occured: "+e.getMessage());
	}
}

@Then("user select an account and a date range")
public void user_select_an_account_and_a_date_range() {
	
		fdownload.choosingDetails();
	
}

@Then("click on Download PDF button")
public void click_on_download_pdf_button() {

		fdownload.clickingDownload();
	
}

@Then("user clicks on Keep in the download permission")
public void user_clicks_on_keep_in_the_download_permission() throws Exception{
	try {
        fdownload.downloadingFile();
    } catch (Exception e) {
        Assert.fail("Error occurred while handling download permission: " + e.getMessage());
    }
}

@Then("the user should verify the downloaded PDF file in the download section")
public void the_user_should_verify_the_downloaded_pdf_file_in_the_download_section() {
	try {
		boolean validate=fdownload.isPdfFile();
		Assert.assertTrue(validate);
	} catch (Exception e) {
		Assert.fail("Error occured: "+e.getMessage());
	}
}

@When("The user clicks on the Logout button")
public void the_user_clicks_on_the_logout_button() {
	try {
		
		logoutPage.logout();
	} catch (Exception e) {
		Assert.fail("Error occured: " + e.getMessage());
	}
}

@Then("The user should be redirected to the login page")
public void the_user_should_be_redirected_to_the_login_page() {
	try {
		boolean validate = logoutPage.validateSignInPage();
		Assert.assertTrue(validate);
	} catch (Exception e) {
		Assert.fail("Error occured" + e.getMessage());
	}
}

@Given("The user logs out of the application")
public void the_user_logs_out_of_the_application() {
	try {
		
		logoutPage.logout();
	} catch (Exception e) {
		Assert.fail("Error occured: " + e.getMessage());
	}
}

@When("The user clicks the Back button in the browser")
public void the_user_clicks_the_back_button_in_the_browser() {
	try {
		logoutPage.navigatingBack();
	} catch (Exception e) {
		Assert.fail("Error occured: " + e.getMessage());
	}
}

@Then("The user should not be able to access the previous page")
public void the_user_should_not_be_able_to_access_the_previous_page() {
	try {
		boolean validate = logoutPage.validateSignInPage();
		Assert.assertTrue(validate);
	} catch (Exception e) {
		Assert.fail("Error occured" + e.getMessage());
	}



}}
