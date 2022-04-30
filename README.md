# Automation-Framework-Project


**For the UI DataDriven Page Object Model Framework.**

There are 5 test cases to cover the main scenarios for the project.
1- Validate the functonality of Sign up.
2- Validate the functionality of Login.
3- Validate the functionality of adding a product to a cart.
4- Validate the functionality of Making an order.
5- Validate that after making a new order, the order is displayed on the order history page.

Before you run the UI test cases, please update the Email value in the excel sheet located in src/test/resources/TestData.xlsx.
You can run all UI test cases from testng.xml.

**The project Structure:**
1- for each page and its elements and all its related actions, you can find the class for each page in src/main/java/pages.
2- the test case class is located in src/test/java/uiTests.
3- for reading the data from excel file, a class DataReader is made in src/main/java/utils.
*************************************************************

**For APIs cucmber restassured framework.**


You can run the TestRunner class to run the Apis automation scripts which validate that the numViews for all patterns are greater than 4000.
