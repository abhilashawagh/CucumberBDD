package com.visionit.automation.pageobjects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.visionit.automation.core.WebDriverFactory;
import io.cucumber.java.Scenario;


public class SearchPageObjects {
	private static final Logger logger= LogManager.getLogger(SearchPageObjects.class);
	WebDriver driver;
	Scenario scn;

	//Locators
	private By listOfSuggestedProducts= By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//h2/a");

	//Constructor
	public SearchPageObjects(WebDriver driver, Scenario scn)
	{
		this.driver=driver;
		this.scn=scn;
	}

	//Method to validate search page title
	public void validateSearchPageTitle()
	{
		WebDriverWait wait= new WebDriverWait(driver,20);
		boolean actTitle =wait.until(ExpectedConditions.titleContains("Amazon.in"));
		Assert.assertEquals(true, actTitle);
		logger.info("Validate search page title is : "+driver.getTitle());
		scn.log("Validate search page title is : "+driver.getTitle());
	}

	//method to click on desired product from suggested product lists
	public void clickOnFirstProduct(int index)
	{
		List <WebElement> listOfProducts=driver.findElements(listOfSuggestedProducts);
		logger.info("List of suggested products, its size is: "+ listOfProducts.size());
		listOfProducts.get(index).click();
		logger.info("Click on first product from suggested product list, product name is: "+listOfProducts.get(index).getText() );
		scn.log("Click on first product from suggested product list");
	}

	//Method to show product description on new tap
	public void switchToWindowforProdDescription()
	{
		WebDriverFactory.switchToNewWindow();
		scn.log("switch to new window");
	}


}
