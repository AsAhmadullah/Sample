# PROJECT - AUTOMATION TESTING ON ECOMMERCE WEBSITE - AMAZON

## DESCRIPTION
         Amazon.com, Inc. is an American multinational technology company focusing on e-commerce, cloud computing, online advertising, digital streaming, and artificial intelligence.

## WHAT GOING TO DO
* Find the broken links of the Homepage in the Ecommerce Site.
* Create the Test cases to cover login, Product search and Add to cart Functionalities.
* Implement proper setup and teardown methods to ensure test independence and reusability.
* Generate a test report after executing the test suite, including the test results and logs.
* Finally push the test code in gitHub.

## Tools Used For Automation
* Eclipse IDE
* Selenium WebDriver
* Java
* TestNG - Test Data Driven
* Junit
* GitHub - Source Code Management
* Maven - Build/Project Management Tool

# PROJECT DESCRIPTION
      In Amazon Website, going to find the broken links and compare the product & print the product text on console and generating the reports. Coding done by following Steps:
      
## TEST DATA
Create test case script in Excel Sheet. After creating the script - review and start to automate it.

## AUTOMATION using Updated Version of Selenium Java 

* Create the Maven Project to mantain the dependencies in pom.xml and which we can easily update the version, just by changing it.
* After creation of the Maven add the following dependencies on pom.xml
* Save pom.xml and Update Maven Project.

* Create the Reusabilty Methods on src/main/java
  like Base class, Helper class - File Reader Manager, Configuration Reader & Page object Manager and page object model.

    1. Base class is created for reusability purpose.
    2. File Reader Manager is to restrict object creation in another class.
    3. Configuration Reader fetch the property file to get the URL, Username and password.
    4. Page object manager is to create page's object and also to make sure that the same object should not be created again and again.
    5. Page object model creates an object repository for storing all web elements.(Maintain the locaters in POJO class)
 
* Create the runner class in src/test/java

     Inside the com.package creating a Amazon_Web_Application.java class, Here using the extend Keyword Base class methods are overrided.

  ## Script: Login, Product Page & Add to cart Functionality
  * Launch Browser - data fetched from base class
  * Object creation of page object manager and logger file we can fetch the datas enter on the particular class.
  * Using propertyconfigure we can fetch the data from log4j.properties
  * getUrl to navigate Amazon site
  * Using waits to tell webDriver to poll the DOM for a certain amount of time when trying to find an element.
  * Do Assert for Verification and Validation
  * Login to Homepage by fetch the data from .properties file
  * By passing the string in SearchBox and submit.
  * Navigates to Results Page, Here select the first product from Result text by xpath using Relationship concept of Ancestor,Parent, preceding and following siblings and Descendant.
  * getText and print the text on console.
  * After selection of the product navigates to product page by creating a new window and then using windowshandles switch to particular window.
  * Comparing the selected product text with first product text using if condition , condition is satified navigate to Add to cart Page.
  * Then TakesScreenshot of Add to cart
  * Click on Go to cart and page navigates to shopping cart Page.
  * Compare the Selected product Text with Cart Product Text.
  * Using if condition, condition satifies window will be closed
  * Finally Quit the Browser.
  
 ##  Script: Broken Links
  * Launch Browser
  * Collect all the tags a tags with the help of tagname a and store in list.
  * Iterate the list.
  * get the href value by getAttribute("href")
  * Create a object for URL and pass the parameter as Link.
  * Connect to httpURLConnection ( is a Interface )
  * with the help of connection get the response code and print on console.


  # Both scripts are created using @Test Annotation so we can run the both scripts in testng suite to generate reports. Maintain the Reports in seprate folder.



## Once We Complete the Execution then we push the code into github
## Then clone the project into master branch then will start the work individual users.


