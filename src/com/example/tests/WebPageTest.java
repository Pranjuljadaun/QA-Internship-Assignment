package com.example.tests;

import org.openqa.selenium.WebDriver;

public class WebPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    public WebPageTest() {
        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }

    public void testLoginWithValidCredentials() {
        loginPage.navigateToLoginPage("https://sakshingp.github.io/assignment/login.html");
        loginPage.login("validUsername", "validPassword");
        assert !loginPage.isErrorMessageDisplayed() : "Error message should not be displayed with valid credentials.";
    }

    public void testLoginWithInvalidUsername() {
        loginPage.navigateToLoginPage("https://sakshingp.github.io/assignment/login.html");
        loginPage.login("invalidUsername", "validPassword");
        assert loginPage.isErrorMessageDisplayed() : "Error message should be displayed with invalid username.";
    }

    public void testLoginWithInvalidPassword() {
        loginPage.navigateToLoginPage("https://sakshingp.github.io/assignment/login.html");
        loginPage.login("validUsername", "invalidPassword");
        assert loginPage.isErrorMessageDisplayed() : "Error message should be displayed with invalid password.";
    }

    public void testLoginWithBlankUsername() {
        loginPage.navigateToLoginPage("https://sakshingp.github.io/assignment/login.html");
        loginPage.login("", "validPassword");
        assert loginPage.isErrorMessageDisplayed() : "Error message should be displayed with blank username.";
    }

    public void testLoginWithBlankPassword() {
        loginPage.navigateToLoginPage("https://sakshingp.github.io/assignment/login.html");
        loginPage.login("validUsername", "");
        assert loginPage.isErrorMessageDisplayed() : "Error message should be displayed with blank password.";
    }

    public void testLoginWithBothFieldsBlank() {
        loginPage.navigateToLoginPage("https://sakshingp.github.io/assignment/login.html");
        loginPage.login("", "");
        assert loginPage.isErrorMessageDisplayed() : "Error message should be displayed with both fields blank.";
    }

    public void testTransactionValuesSorted() {
        loginPage.navigateToLoginPage("https://sakshingp.github.io/assignment/login.html");
        loginPage.login("testuser", "password");

        if (homePage.isLoginSuccessful()) {
            homePage.clickAmountHeader();
            if (homePage.areTransactionValuesSorted()) {
                System.out.println("Transaction values are sorted correctly.");
            } else {
                System.out.println("Transaction values are not sorted correctly.");
            }
        } else {
            System.out.println("Login was not successful.");
        }
    }

    public static void main(String[] args) {
        WebPageTest test = new WebPageTest();

        test.testLoginWithValidCredentials();
        test.testLoginWithInvalidUsername();
        test.testLoginWithInvalidPassword();
        test.testLoginWithBlankUsername();
        test.testLoginWithBlankPassword();
        test.testLoginWithBothFieldsBlank();
        test.testTransactionValuesSorted();

        DriverManager.quitDriver();
    }
}
