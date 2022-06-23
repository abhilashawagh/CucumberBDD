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


public class ProductDescriptionPageObjects {
	private static final Logger logger= LogManager.getLogger(ProductDescriptionPageObjects.class);
	WebDriver driver;
	Scenario scn;

	//Locators
	private By addToCartBtn= By.id("add-to-cart-button");
	private By productTitle= By.id("productTitle");

	//Constructor
	public ProductDescriptionPageObjects(WebDriver driver, Scenario scn)
	{
		this.driver=driver;
		this.scn=scn;
	}

	//Method to validate product title
	public void validateProductTitle()
	{
		boolean actTitle= driver.findElement(productTitle).isDisplayed();
		Assert.assertEquals("Assert for product title is passed", true, actTitle);
		logger.info("Validate product title on new tab");
		scn.log("Validate product title");
	}

	//Method to validate add to cart button
	public void validateAddToCartBtn()
	{
		WebElement addToCartElement  =driver.findElement(addToCartBtn);
		WebDriverWait wait= new WebDriverWait(driver,30);
		boolean b =(wait.until(ExpectedConditions.presenceOfElementLocated(addToCartBtn))).isDisplayed();
		Assert.assertEquals("Assert for add to cart btn get passed", true, b);
		logger.info("Validate add to cart btn on new tab");
		scn.log("Validate add to cart btn");
	}


}
