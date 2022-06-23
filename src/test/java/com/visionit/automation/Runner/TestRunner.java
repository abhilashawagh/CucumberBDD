package com.visionit.automation.Runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
	        features="classpath:Features",//to tell cucumber where is feature file
	        glue="com.visionit.automation.stepdefs", // to tell cucumber where is step def code
	        tags="", // to tell which tagged feature file to execute
	        plugin = {"pretty", // to generate reports
	            "html:target/html/htmlReport.html",
	            "json:target/json/jsonReport.json",
	            },
	        monochrome=true,
	        publish= true,
	        dryRun=false// to tell whether to get skeleton for scenarios(true) or actual run(false)
	        )

	public class TestRunner {

	}


	

