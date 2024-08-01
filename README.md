
# QA Internship Assignment

## Overview

This project includes automation scripts for testing a web application. The application is tested using Selenium WebDriver with Java. The main focus is on verifying the functionality of the Login Page and the Home Page of the web application.

### Application URL

The web application under test is accessible at: [https://sakshingp.github.io/assignment/login.html](https://sakshingp.github.io/assignment/login.html)

## Project Structure

- **`src/com/example/tests/`**
  - `DriverManager.java`: Manages WebDriver initialization and cleanup.
  - `LoginPage.java`: Contains methods for interacting with the login page.
  - `HomePage.java`: Contains methods for interacting with the home page and verifying transaction sorting.
  - `WebPageTest.java`: Entry point with `main` method that runs the test scenarios.
  - `XPaths.java`: Defines locators for page elements used in the test scripts.

## Prerequisites

- **Java Development Kit (JDK)**: Version 11 or later is required.
- **Selenium WebDriver**: Make sure you have the Selenium WebDriver library.
- **ChromeDriver**: Download and install ChromeDriver that matches your Chrome browser version from [ChromeDriver download page](https://sites.google.com/a/chromium.org/chromedriver/downloads).

## Setup

1. **Clone the Repository**

   Clone this repository to your local machine using:

   ```bash
   git clone https://github.com/Pranjuljadaun/QA-Internship-Assignment.git
   cd QA-Internship-Assignment

2. **Set Up WebDriver**
  - Download the ChromeDriver from the [ChromeDriver download page](https://sites.google.com/a/chromium.org/chromedriver/downloads).
  - Place the chromedriver executable in a known directory, for example: C:\path\to\chromedriver.exe.
  - Update the DriverManager class in DriverManager.java to point to the location of your chromedriver.
3. **Install Selenium WebDriver**

  - Download the Selenium WebDriver JAR file from the Selenium website and include it in your project’s classpath.

4. **Build and Run**

  - Compile the Java files and run the WebPageTest class to execute the tests. You can do this using an IDE like IntelliJ IDEA or Eclipse, or from the command line:
  ```bash
  javac -cp "path/to/selenium-server-<version>.jar" src/com/example/tests/*.java
  java -cp "path/to/selenium-server-<version>.jar;." com.example.tests.WebPageTest.
  ```


## Test Case

**Login Page**

1. **Successful Login**
  - Verify login with valid credentials.
  - Ensure successful navigation to the home page.

2. **Invalid Credentials**
  - Verify login with incorrect username or password.
  - Check for appropriate error messages.

3. **Blank Username**
  - Attempt login with a blank username field.
  - Validate error handling.

4. **Blank Password**
  - Attempt login with a blank password field.
  - Validate error handling.

5. **Blank Username and Password**
  - Attempt login with both fields blank.
  - Validate error handling.

**Home Page**
1. **Transaction Values Sorting** 
  - After successful login, click on the "AMOUNT" header in the transaction table.
  - Verify that the transaction values are sorted correctly in ascending order.

## Code Structure
  - `DriverManager.java`: Initializes and manages the WebDriver lifecycle.
  - `LoginPage.java`: Contains methods to interact with the login page and perform login actions.
  - `HomePage.java`: Contains methods to interact with the home page, verify successful login, and check transaction sorting.
  - `WebPageTest.java`: Main class with the main method that orchestrates the test execution.
  - `XPaths.java`: Contains all the locators used in the test scripts.

## Additional Information
- **Error Handling**: The scripts handle potential errors, such as missing elements or parsing issues.
- **Assertions**: Assertions are used to verify that the application behaves as expected.
- **Reporting**: The current setup does not include HTML reporting. Consider integrating a reporting library for enhanced test reporting.
