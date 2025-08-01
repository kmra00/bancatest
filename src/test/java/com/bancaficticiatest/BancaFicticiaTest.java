package com.bancaficticiatest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bancaficticiatest.pages.BalancePage;
import com.bancaficticiatest.pages.LoginPage;
import com.bancaficticiatest.pages.MenuPage;
import com.bancaficticiatest.pages.TransferPage;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BancaFicticiaTest {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static MenuPage menuPage;
    private static TransferPage transferPage;
    private static BalancePage balancePage;

    private final String URL = "https://bco-selenium.netlify.app//";
    private final String VALID_USER = "sofia";
    private final String VALID_PASSWORD = "academy";
    private final String INVALID_USER = "usuario";
    private final String INVALID_PASSWORD = "incorrecta";

    @BeforeAll
    void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void testLoginExitoso() {
        loginPage.login(VALID_USER, VALID_PASSWORD);
        menuPage = new MenuPage(driver);

        assertEquals(VALID_USER, menuPage.getLoggedInUsername(),
                "El nombre de usuario mostrado debe coincidir con el usuario logueado");
    }

    @Test
    @Order(2)
    public void testLoginFallido() {
        loginPage.login(INVALID_USER, INVALID_PASSWORD);

        String message = loginPage.getLoginMessage().toLowerCase();
        assertTrue(message.contains("incorrectas"),
                "Debería mostrar mensaje de credenciales incorrectas");
    }

    @Test
    @Order(3)
    public void testConsultaSaldo() {
        loginPage.login(VALID_USER, VALID_PASSWORD);
        menuPage = new MenuPage(driver);
        menuPage.clickBalance();

        balancePage = new BalancePage(driver);
        assertTrue(balancePage.getBalanceInfo().contains("Saldo"),
                "La consulta de saldo debe mostrar información del saldo");
    }

    @Test
    @Order(4)
    public void testTransferenciaExitosa() {
        loginPage.login(VALID_USER, VALID_PASSWORD);
        menuPage = new MenuPage(driver);
        menuPage.clickTransfer();

        transferPage = new TransferPage(driver);
        transferPage.makeTransfer("12345678", "100", "Prueba automatizada");

        String message = transferPage.getMessage().toLowerCase();
        assertTrue(message.contains("éxito") || message.contains("exitosa"),
                "Debería mostrar mensaje de transferencia exitosa");
    }

    @Test
    @Order(5)
    public void testTransferenciaSaldoInsuficiente() {
        loginPage.login(VALID_USER, VALID_PASSWORD);
        menuPage = new MenuPage(driver);
        menuPage.clickTransfer();

        transferPage = new TransferPage(driver);
        transferPage.makeTransfer("12345678", "999999", "Prueba saldo insuficiente");

        String message = transferPage.getMessage().toLowerCase();
        assertTrue(message.contains("insuficiente") || message.contains("error"),
                "Debería mostrar mensaje de saldo insuficiente");
    }

    @Test
    @Order(6)
    public void testLogout() {
        loginPage.login(VALID_USER, VALID_PASSWORD);
        menuPage = new MenuPage(driver);
        menuPage.clickLogout();

        assertTrue(loginPage.getLoginMessage().isEmpty(),
                "Debería volver a la página de login después del logout");
    }
}