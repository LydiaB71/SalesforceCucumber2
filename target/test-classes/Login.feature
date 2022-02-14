#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

 
 Feature: Login to Salesforce application
Scenario: Login with valid username and no password
	Given user is on the login page
		When user enters "lbierer@gmail.com" into username field
		And user enters "" into password field
		And user click on login button
		Then verify no password error message is "Please enter your password."


  Scenario: Login with valid username and valid password
	Given user is on the login page
		When user enters "lbierer@gmail.com" into username field
		And user enters "tx2200108" into password field
		And user click on login button
		Then verify page title "Home Page ~ Salesforce - Developer Edition"
		


		Scenario: Check Remember me to store username
	Given user enters correct username and password
		When user clicks on Remember Me check box
		And user click on login button
		And user clicks on logout button
		Then verify username field is "lbierer@gmail.com"
	
	Scenario: Check forgot password by clicking on forgot password
	Given user enters correct username 
	When user clicks on Forgot password
	And user provides username "lbierer@gmail.com"
	And user clicks on continue button
	Then password reset message is "We’ve sent you an email with a link to finish resetting your password."
		
	Scenario: Check forgot password by entering wrong username and password
	Given user is on the login page 
	When user enters "123" into username field
	And user enters "22131" into password field
	And user click on login button
	Then password error message is "Please check your username and password. If you still can't log in, contact your Salesforce administrator."
		
