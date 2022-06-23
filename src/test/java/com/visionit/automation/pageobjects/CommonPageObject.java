package com.visionit.automation.pageobjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Scenario;

public class CommonPageObject {

	private static final Logger logger= LogManager.getLogger(CommonPageObject.class);
	WebDriver driver;
	Scenario scn;

	//Locators on homepage

	private By searchBox= By.id("twotabsearchtextbox");
	private By searchBtn= By.id("nav-search-submit-button");

	public CommonPageObject(WebDriver driver,Scenario scn)
	{
		this.driver= driver;
		this.scn=scn;
	}

	//Method to match the title of page
	public void validatePageTitle()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		String expectedTitle= "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		boolean a =wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals(true, a);
		scn.log("validate page title, title is: "+ expectedTitle);
		logger.info("validate page title, title is: "+ expectedTitle);
	}

	//Method to enter text in search box
	public void setSearchBox(String product)
	{
		WebElement searchTextBox= driver.findElement(searchBox);
		logger.info("create webelement for searchBox");
		searchTextBox.sendKeys(product);
		scn.log("Enter a product name to be search in search box is: "+ product);
		logger.info("Enter a product name to be search in search box is: "+ product);
	}

	//Method to click on searchBtn
	public void clickOnSearchBtn()
	{
		driver.findElement(searchBtn).click();
		scn.log("Click on search button");
		logger.info("Click on search button");
	}




}
