package chapter2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {

    WebDriver driver; // Declarăm driver-ul la nivel de clasă

    @BeforeMethod
    public void setup() {
        // Pasul 1: Configurează și deschide browserul
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Pasul 2: Navighează la pagina de login
        driver.get("https://apps.qualiadept.eu/hapifyme/login_register.php");
    }

    @Test
    public void testLoginCuDateValide() throws InterruptedException {
        // Pasul 3: Găsește câmpul de email și introdu text
        Thread.sleep(3000);
        WebElement emailField = driver.findElement(By.id("emailId"));
        emailField.clear();
        emailField.sendKeys("test.automat@qaschool.ro");

        // Pasul 4: Găsește câmpul de parolă și introdu text
        WebElement passwordField = driver.findElement(By.name("log_password"));
        passwordField.clear();
        passwordField.sendKeys("Password@123");

        // Pasul 5: Găsește butonul de login și dă click
        // Vom folosi By.className("btn-default") - deși nu e ideal, e bun pentru exemplu
        WebElement loginButton = driver.findElement(By.className("btn-default"));
        loginButton.click();

        // Pasul 6: Verifică un rezultat
        // Aici ar trebui să așteptăm ca pagina să se încarce.
        // Pentru acum, punem o pauză scurtă (nu e o practică bună pe termen lung!)
        Thread.sleep(2000);

        // Să presupunem că vrem să verificăm dacă am fost redirecționați
        // Un login corect ne duce la 'index.php'
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("index.php"), "Login-ul nu a redirecționat la index.php");

        // Sau, dacă ar apărea un mesaj, am căuta textul.
        // Exemplu (dacă ar exista un element cu id 'loginSuccessMessage'):
        // WebElement successMessage = driver.findElement(By.id("loginSuccessMessage"));
        // Assert.assertEquals(successMessage.getText(), "You are now logged in!");
    }

    @AfterMethod
    public void teardown() {
        // Pasul 7: Închide browserul după fiecare test
        if (driver != null) {
            driver.quit();
        }
    }
}

