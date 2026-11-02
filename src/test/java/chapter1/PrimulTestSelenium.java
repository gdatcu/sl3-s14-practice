package chapter1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimulTestSelenium {

    public static void main(String[] args) throws InterruptedException {

        // Pasul 1: Configurează automat chromedriver
        System.out.println("Se configurează WebDriverManager...");
        WebDriverManager.chromedriver().setup();

        // Pasul 2: Inițiază o instanță de WebDriver (deschide browserul Chrome)
        System.out.println("Se deschide browserul Chrome...");
        WebDriver driver = new ChromeDriver();

        // Pasul 3: Maximizează fereastra browserului (opțional, dar recomandat)
        driver.manage().window().maximize();

        // Pasul 4: Navighează la URL-ul aplicației noastre
        String url = "https://apps.qualiadept.eu/hapifyme/login_register.php";
        System.out.println("Se navighează la: " + url);
        driver.get(url);

        // Pasul 5: Obține și afișează titlul paginii
        String expectedTitluPagina = " Welcome to hapifyMe!";
        String titluPagina = driver.getTitle();
        System.out.println("Titlul paginii este: " + titluPagina);

        if (titluPagina.equals(expectedTitluPagina)) {
            throw new RuntimeException("Titlul paginii este incorect!");
        }

        // Pasul 6: Punem o pauză de 3 secunde ca să vedem ce s-a întâmplat
        Thread.sleep(5000); // Folosim Thread.sleep() doar în scop demonstrativ. Vom învăța metode mai bune (Waits).

        // Pasul 7: Închide browserul
        System.out.println("Se închide browserul...");
        driver.quit();

        System.out.println("Testul s-a încheiat.");
    }
}

