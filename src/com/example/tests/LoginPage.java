package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public void login(String username, String password) {
        WebElement usernameInput = waitForElement(XPaths.usernameField);
        WebElement passwordInput = waitForElement(XPaths.passwordField);
        WebElement loginBtn = waitForElement(XPaths.loginButton);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WebElement errorMessage = waitForElement(XPaths.errorMessage);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
