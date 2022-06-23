@ui @healthCheck
Feature: E-Commerce website health check

Scenario: User open the browser and navigate to Url and search for product
Given navigate to url and open the home page
When user search for product "Laptop"
Then search result should display

Scenario: user click on desired product and check the product details
Given navigate to url and open the home page
And user search for product "earphone"
When user click on desired product
Then product description shown on new tab
