package com.visionit.automation.stepdefs;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.visionit.automation.core.WebDriverFactory;
import com.visionit.automation.pageobjects.CommonPageObject;
import com.visionit.automation.pageobjects.ProductDescriptionPageObjects;
import com.visionit.automation.pageobjects.SearchPageObjects;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	private static final Logger logger = LogManager.getLogger(StepDefs.class);
	WebDriver driver;
	Scenario scn;
	String base_url = "https://amazon.in";

	//====================================================================================

	//Create object of Classes for diff. webpages of amazon
	CommonPageObject cmnPageObject;
	SearchPageObjects searchPageObject;
	ProductDescriptionPageObjects prodDescriptionObject;

	@Before
	public void setUp(Scenario scn)
	{
		this.scn=scn;

		//Get the desired browser to be invoked
		String browserName= WebDriverFactory.getBrowserName();
		driver=WebDriverFactory.getWebDriverForBrowser(browserName); 
		scn.log("Browser get invoked");

		//Initialize diff classes objects
		cmnPageObject= new CommonPageObject(driver,scn);
		searchPageObject =new SearchPageObjects(driver,scn);
		prodDescriptionObject= new ProductDescriptionPageObjects(driver,scn);
	}
	
	//Capture screenshot if test case get failed
	@After(order=2)
	public void captureScreenshot(Scenario scn)
	{
		if(scn.isFailed())
		{
			TakesScreenshot srnshot= ((TakesScreenshot)driver);
			byte [] data =srnshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "Name of failed step is: "+ scn.getName());
			scn.log("Attach a screenshot as step get failed");
		}
		else
		{
			scn.log("Test case get passed, no screenshot is captured");
		}
	}
	
	//Close the browser
	@After(order=1)
	public void tearDown()
	{
		WebDriverFactory.quitTheBrowser();
		scn.log("Browser is quit");
	}
	

	@Given("navigate to url and open the home page")
	public void navigate_to_url_and_open_the_home_page() {
		WebDriverFactory.navigateToURL(base_url);
		scn.log("navigate to url: "+ base_url);
		cmnPageObject.validatePageTitle();
	}
	@When("user search for product {string}")
	public void user_search_for_product(String productName) {
		cmnPageObject.setSearchBox(productName);
		cmnPageObject.clickOnSearchBtn();
	}
	@Then("search result should display")
	public void search_result_should_display() {
		searchPageObject.validateSearchPageTitle();
	}

	@When("user click on desired product")
	public void user_click_on_desired_product() {
		searchPageObject.clickOnFirstProduct(0);
	}

	@Then("product description shown on new tab")
	public void product_description_shown_on_new_tab() {
		searchPageObject.switchToWindowforProdDescription();
		prodDescriptionObject.validateProductTitle();
		prodDescriptionObject.validateAddToCartBtn();
	}

    @When("user search product {string}")
    public void user_search_product(String product_name) {
    	cmnPageObject.setSearchBox(product_name);
    	cmnPageObject.clickOnSearchBtn();
    	
   
    }



}
