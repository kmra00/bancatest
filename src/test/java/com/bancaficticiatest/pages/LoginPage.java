package com.bancaficticiatest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(css = "#login-form button[type='submit']")
    private WebElement loginButton;
    
    @FindBy(id = "login-message")
    private WebElement loginMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getLoginMessage() {
        return loginMessage.getText();
    }
}
