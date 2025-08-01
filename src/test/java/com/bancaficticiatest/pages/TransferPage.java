package com.bancaficticiatest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferPage extends BasePage {
    @FindBy(id = "destino")
    private WebElement accountField;
    
    @FindBy(id = "monto")
    private WebElement amountField;
    
    @FindBy(id = "motivo")
    private WebElement reasonField;
    
    @FindBy(css = "#transfer-form button[type='submit']")
    private WebElement submitButton;
    
    @FindBy(id = "transfer-message")
    private WebElement message;

    public TransferPage(WebDriver driver) {
        super(driver);
    }

    public void makeTransfer(String account, String amount, String reason) {
        accountField.clear();
        accountField.sendKeys(account);
        amountField.clear();
        amountField.sendKeys(amount);
        reasonField.clear();
        reasonField.sendKeys(reason);
        submitButton.click();
    }

    public String getMessage() {
        return message.getText();
    }
}