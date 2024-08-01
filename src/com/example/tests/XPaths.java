package com.example.tests;

import org.openqa.selenium.By;

public class XPaths {
    public static final By usernameField = By.id("username");
    public static final By passwordField = By.id("password");
    public static final By loginButton = By.id("log-in");
    public static final By amountHeader = By.id("amount");
    public static final By amountElementsLocator = By.xpath("//table[@id='transactionsTable']/tbody/tr/td[5]");
    public static final By errorMessage = By.id("error-message");
}
