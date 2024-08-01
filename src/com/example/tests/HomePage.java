package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HomePage extends LoginPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginSuccessful() {
        WebElement amountHeader = waitForElement(XPaths.amountHeader);
        return amountHeader.isDisplayed();
    }

    public void clickAmountHeader() {
        WebElement amountHeader = waitForElement(XPaths.amountHeader);
        amountHeader.click();
    }

    public boolean areTransactionValuesSorted() {
        List<WebElement> amountElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(XPaths.amountElementsLocator));
        double[] amounts = new double[amountElements.size()];

        for (int i = 0; i < amountElements.size(); i++) {
            String amountText = amountElements.get(i).getText()
                    .replace("$", "")
                    .replace(",", "")
                    .replace("USD", "")
                    .replace(" ", "")
                    .trim();

            // Handle negative values correctly
            if (amountText.startsWith("-")) {
                amounts[i] = -Double.parseDouble(amountText.substring(1));
            } else {
                amounts[i] = Double.parseDouble(amountText);
            }
        }

        double[] sortedAmounts = amounts.clone();
        Arrays.sort(sortedAmounts);

        return Arrays.equals(amounts, sortedAmounts);
    }
}
