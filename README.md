Project Title:
Amazon-TestAutomation
This is a selenium based java project for web test automation.
Prerequisites:
•	You should have(java 8 installed, jdk and jre)
•	IDE tool(eclipse or intellij)
•	Maven and testNG installed
Structure and Instructions to run the tests:  
•	clone the project from Git, import the project in to your eclipse
•	if having errors, check for maven and testNG dependencies installed in your pom project
•	I am using chrome driver for windows which is under my test resources src folder of the project if you are using Mac, proper chrome driver should be downloaded and put in source folder to run the tests(for test purpose I use one chrome driver as a browser to run the tests) 
•	the project is under maven structure and page object model, there are 2 test classes under test folder, one is scenario one which I use ‘amazon.ae’ site as I solved OTP verification  with messaging with phone number created from twilio which was only available in amazon.ae. Scenario two and three on separate class which I am using amazon.com website.
•	In order to run the test, right click on  test class or each test method in test classes and run as testNG
•	Also you can right click on the project root and run as Maven install, first maven clean then maven install(which runs all the tests I have 3)
Advanced things added to the solution
•	testNg xml is created for Jenkins integration which I did, images and recordings for Jenkins builds result are  added under resources folder of the project
•	manual test cases are added under resources
•	performance report of homepage with Jmeter and images, recordings for test plan I created with Jmeter are added under resources
•	security testcases are added under resources folder
•	I added property file for static test data for different website(loading of property files and initiating them are in base test, same approach can be used for environment for setting different URLs
•	For random test data creation I use faker and java object classes and fields
 Explanation on solutions:
•	For sign up I use twilio(https://www.twilio.com/) to create a phone number and use their APIs to get the OTP from the msg being sent to their number I fetch the OTP with string manipulation method.
•	I have 2 urls for amazon site, one for UAE and one for US, There is one Base Test class for driver initialization on amazo.ae for first scenario which has login and one amazonUSbasetest which extends BaseTest class but initialize driver with US URL(amazon.com) for 2 other tests.
•	Common methods like different waiting’s and selenium common methods are put under driverUtil class
•	TestNG SureFire Report generates under target folder each time we run the tests through maven install, I attach the copy of report generated here.
•	I added utilities package for constants that I use for test assertions 
•	There are recordings for tests execution with explanations of steps and the whole project structure in src/test/resources folder 



 

