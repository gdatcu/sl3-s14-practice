package chapter2;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;


public class TestInregistrare {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://apps.qualiadept.eu/hapifyme/login_register.php");
        Thread.sleep(3000);
    }

    @Test
    public void testCompletareFormularInregistrare() throws InterruptedException {
        // Găsește și dă click pe link-ul de înregistrare
        WebElement signupLink = driver.findElement(By.partialLinkText("Register here!"));
        signupLink.click();

        // O mică pauză ca să se extindă formularul (vom învăța "waits" pentru asta)
        Thread.sleep(1000);
        Date date = new Date();
        String timestamp = date.toString().replace(" ", "_").replace(":", "");

        // Găsește elementele după 'name' sau 'id' și completează
        driver.findElement(By.name("reg_fname")).sendKeys("Popescu");
        driver.findElement(By.name("reg_lname")).sendKeys("Ion");
        driver.findElement(By.name("reg_email")).sendKeys("popescu.ion.test" + timestamp + "@qaschool.ro");
        driver.findElement(By.name("reg_email2")).sendKeys("popescu.ion.test" + timestamp + "@qaschool.ro");
        driver.findElement(By.id("reg_password")).sendKeys("ParolaSuperSigura123!");
        driver.findElement(By.id("reg_password2")).sendKeys("ParolaSuperSigura123!");

        // Pauză ca să vedem rezultatul
        Thread.sleep(3000);

        // Aici am da click pe butonul de Register (name: "register_button")
        // WebElement registerButton = driver.findElement(By.name("register_button"));
        // registerButton.click();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}