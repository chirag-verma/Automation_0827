package com.moodys.qats.stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.moodys.qats.page.*;
import com.moodys.qats.utilities.Util;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	String actionid;
	Actions act;
	WebDriver driver;

	Properties prop;

	CreateQAReviewManualCase createcase;

	QATS_LoginPage loginpage;
	QATS_HomePage homepage;
	MyWork mywork;
	Util util;
	Dashboard dashboard;
	QualityReferenceSheet qrsheet;

	@Given("User Launch Chrome Browser")
	public void User_Launch_Chrome_Browser() throws IOException {

		FileInputStream ip = new FileInputStream(
				"D:\\Users/VermaC/Documents/meerqats-acceptance-test/meerqats-acceptance-test/src/test/resources/Config.Properties");
		prop = new Properties();

		prop.load(ip);

		System.setProperty("webdriver.chrome.driver",
				"D:\\Users/VermaC/Documents/meerqats-acceptance-test/meerqats-acceptance-test/src/test/resources/Drivers/chromedriver.exe");
		/* Launching the browser? */
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		util = new Util(driver);

	}

	@When("User enter the the MeerQATS login page")
	public void User_enter_the_the_MeerQATS_login_page() {

		driver.get("https://pega-orp-qa-11.ad.moodys.net:8443/prweb/PRServlet/");

	}

	@When("After Verifying login page title")
	public void After_Verifying_login_page_title() {
		loginpage = new QATS_LoginPage(driver);
		System.out.println("----------------------------------");
		String title = loginpage.LoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Welcome to PegaRULES");
		System.out.println("Login Page Title Verified as expected- " + title);
		System.out.println("----------------------------------");

	}

	@When("Manager enters Username and Password and click login")
	public void Manager_enters_Username_and_Password_and_click_login() throws InterruptedException, IOException {

		homepage = loginpage.Login(prop.getProperty("ManagerUserName"), prop.getProperty("ManagerPassword"));

		Thread.sleep(4000);
		createcase = new CreateQAReviewManualCase(driver);
		mywork = new MyWork(driver);
		dashboard = new Dashboard(driver);
		qrsheet = new QualityReferenceSheet(driver);

	}

	@When("Reviewer enters Username and Password and click login")
	public void Reviewer_enters_Username_and_Password_and_click_login() throws InterruptedException, IOException {

		homepage = loginpage.Login(prop.getProperty("ReviewerUserName"), prop.getProperty("ReviewerPassword"));

		Thread.sleep(4000);
		createcase = new CreateQAReviewManualCase(driver);
		mywork = new MyWork(driver);

	}

	@Then("Manager enter MeerQATS HomePage")
	public void Manager_enter_MeerQATS_HomePage() {

		String homepagetitle = homepage.HomePageTitle();
		System.out.println("----------------------------------");
		System.out.println(homepage.HomePageTitle());
		Assert.assertEquals(homepagetitle, "QA Manager");
		System.out.println("HomePage Title Verified as expected- " + homepagetitle);
		System.out.println("----------------------------------");

	}

	@Then("Reviewer enter MeerQATS HomePage")
	public void Reviewer_enter_MeerQATS_HomePage() {

		String homepagetitle = homepage.HomePageTitle();
		System.out.println("----------------------------------");
		System.out.println(homepage.HomePageTitle());
		Assert.assertEquals(homepagetitle, "QA Reviewer");
		System.out.println("HomePage Title Verified as expected- " + homepagetitle);
		System.out.println("----------------------------------");

	}

	@When("User Clicks Create QA Review")
	public void User_Clicks_Create_QA_Review() throws InterruptedException {

		homepage.clickonQAReview();

		Thread.sleep(4000);

		driver.switchTo().frame(1);

		Thread.sleep(4000);

	}

	@When("After clicking on Create Manual Case")
	public void After_clicking_on_Create_Manual_Case() {

		createcase.clickoncreatemanualcase();
	}

	@When("User Clicks Create Manual Case")
	public void User_Clicks_Create_Manual_Case() throws InterruptedException {

		homepage.clickonCreateManualCase();

		Thread.sleep(4000);

	}

	@When("After entering Manual Case fields user clicks on create case")
	public void After_entering_Manual_Case_fields_user_clicks_on_create_case()
			throws InterruptedException, IOException {

		createcase.createmanualcaseandclick(prop.getProperty("ActionID"), prop.getProperty("CaseDesc"),
				prop.getProperty("Sourcename"), prop.getProperty("LeadAnalyst"));
		mywork.displaynewlycreatedreviewcase(prop.getProperty("ActionID"));

	}

	@When("After selecting review case and click on Create Case")
	public void After_selecting_review_case_and_click_on_Create_Case() throws InterruptedException {

		List<WebElement> ls = createcase.CreateCase_CheckBoxList();
		ls.get(0).click();

		actionid = createcase.getactionidoffirstcase();
		Thread.sleep(3000);
		createcase.clickoncreatecase();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(4000);

	}

	@Then("Manager Goes to Dashboard")
	public void Manager_Goes_to_Dashboard() throws InterruptedException {

		homepage.clickonDashboardWorkbasket();

		Thread.sleep(2000);
	}

	@Then("Manager clicks on Dashboard")
	public void Manager_clicks_on_Dashboard() throws InterruptedException {

		homepage.clickonDashboardcreatecase();

		Thread.sleep(2000);
	}

	@Then("Validate the created case in Dashboard")
	public void Validate_the_created_case_in_Dashboard() throws InterruptedException, IOException {

		mywork.displaynewlycreatedreviewcase(actionid);

	}

	@When("User Clicks on My Work")
	public void User_Clicks_on_My_Work() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='My Work']")).click();
		Thread.sleep(2000);

	}

	@When("on Selecting a Review Case")
	public void on_Selecting_a_Review_Case() throws InterruptedException, IOException {

		mywork.selectuploadvitalrecordsreviewcase();
	}

	@Then("After Completing the Questionnaire Click on Submit Review")
	public void After_Completing_the_Questionnaire_Click_on_Submit_Review() throws InterruptedException {

		util.PerformQuestionnaire();
	}

	@Then("Manager click on Quality Review Work Queue and validate case status for any case")
	public void Manager_click_on_Quality_Review_Work_Queue_and_validate_case_status_for_any_case()
			throws InterruptedException {

		dashboard.clickonworkbasket("Quality Review Work Queue");
		Thread.sleep(2000);
		dashboard.clickonfirstcase("PegaGadget2Ifr");
		Thread.sleep(3000);

		qrsheet.clickonactionbutton();
		Thread.sleep(2000);

		qrsheet.clickonupdatecasestatus();
		Thread.sleep(2000);

		qrsheet.selectcasestatus("Pending-QAAllocation");

		qrsheet.clickoncontinueconfirm();
		Thread.sleep(2000);
	}

	@Then("Manager click on Pending Vital Records and validate case status for any case")
	public void Manager_click_on_Pending_Vital_Records_and_validate_case_status_for_any_case()
			throws InterruptedException {
		dashboard.clickonworkbasket("Pending Vital Records");
		Thread.sleep(2000);
		dashboard.clickonfirstcase("PegaGadget3Ifr");
		Thread.sleep(3000);

		qrsheet.clickonactionbutton();
		Thread.sleep(2000);

		qrsheet.clickonupdatecasestatus();
		Thread.sleep(2000);

		qrsheet.selectcasestatus("Pending-VitalRecords");

		qrsheet.clickoncontinueconfirm();
		Thread.sleep(2000);

	}

	@Then("Manager click on Awaiting Action Queue and validate case status for any case")
	public void Manager_click_on_Awaiting_Action_Queue_and_validate_case_status_for_any_case()
			throws InterruptedException {
		dashboard.clickonworkbasket("Awaiting Action Queue");
		Thread.sleep(2000);
		dashboard.clickonfirstcase("PegaGadget4Ifr");
		Thread.sleep(3000);

		qrsheet.clickonactionbutton();
		Thread.sleep(2000);

		qrsheet.clickonupdatecasestatus();
		Thread.sleep(2000);

		qrsheet.selectcasestatus("Pending-DocumentsAvailable");

		qrsheet.clickoncontinueconfirm();
		Thread.sleep(2000);

	}

	@Then("Manager click on Documents Available Queue and validate case status for any case")
	public void Manager_click_on_Documents_Available_Queue_and_validate_case_status_for_any_case()
			throws InterruptedException {
		dashboard.clickonworkbasket("Documents Available Queue");
		Thread.sleep(2000);
		dashboard.clickonfirstcase("PegaGadget5Ifr");
		Thread.sleep(3000);

		qrsheet.clickonactionbutton();
		Thread.sleep(2000);

		qrsheet.clickonupdatecasestatus();
		Thread.sleep(2000);

		qrsheet.selectcasestatus("Pending-DefinitiveRating");

		qrsheet.clickoncontinueconfirm();
		Thread.sleep(2000);

	}

	@Then("Manager click on Awaiting Action Release and validate case status for any case")
	public void Manager_click_on_Awaiting_Action_Release_and_validate_case_status_for_any_case()
			throws InterruptedException {

		dashboard.clickonworkbasket("Awaiting Action Release");
		Thread.sleep(2000);
		dashboard.clickonfirstcase("PegaGadget6Ifr");
		Thread.sleep(3000);

		qrsheet.clickonactionbutton();
		Thread.sleep(2000);

		qrsheet.clickonupdatecasestatus();
		Thread.sleep(2000);

		qrsheet.selectcasestatus("Pending-ActionRelease");

		qrsheet.clickoncontinueconfirm();
		Thread.sleep(2000);

	}

	@Then("Manager click on Provisional Pending Definitive Queue and validate case status for any case")
	public void Manager_click_on_Provisional_Pending_Definitive_Queue_and_validate_case_status_for_any_case()
			throws InterruptedException {
		dashboard.clickonworkbasket("Provisional Pending Definitive Queue");
		Thread.sleep(2000);
		dashboard.clickonfirstcase("PegaGadget7Ifr");
		Thread.sleep(3000);

		qrsheet.clickonactionbutton();
		Thread.sleep(2000);

		qrsheet.clickonupdatecasestatus();
		Thread.sleep(2000);

		qrsheet.selectcasestatus("Pending-Query");

		qrsheet.clickoncontinueconfirm();
		Thread.sleep(2000);

	}

	@After
	public void teardown() throws InterruptedException {
		util.teardown();

	}

}
