package com.bancaficticiatest.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userNameLabel;
    
    @FindBy(id = "btn-transfer")
    private WebElement transferButton;
    
    @FindBy(id = "btn-balance")
    private WebElement balanceButton;
    
    @FindBy(id = "btn-logout")
    private WebElement logoutButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUsername() {
        return userNameLabel.getText();
    }

    public void clickTransfer() {
        transferButton.click();
    }

    public void clickBalance() {
        balanceButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }
}