package com.bancaficticiatest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BalancePage extends BasePage {
    @FindBy(id = "balance-info")
    private WebElement balanceInfo;
    
    @FindBy(id = "back-menu")
    private WebElement backButton;

    public BalancePage(WebDriver driver) {
        super(driver);
    }

    public String getBalanceInfo() {
        return balanceInfo.getText();
    }
}