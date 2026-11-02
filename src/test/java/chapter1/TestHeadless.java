package chapter1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Importăm clasa Options

public class TestHeadless {

    public static void main(String[] args) {
        // Pasul 1: Creăm un obiect de tip ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Pasul 2: Adăugăm argumentele necesare pentru modul headless
        options.addArguments("--headless=new"); // "new" e noul mod headless recomandat
        options.addArguments("--window-size=1920,1080"); // Recomandat, previne ca elementele să fie ascunse

        // Pasul 3: Configurăm WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Pasul 4: Lansăm ChromeDriver, dar de data aceasta îi dăm și obiectul 'options'
        System.out.println("Se lansează Chrome în modul HEADLESS...");
        WebDriver driver = new ChromeDriver(options);

        // Restul testului este identic
        String url = "https://apps.qualiadept.eu/hapifyme/login_register.php";
        System.out.println("Se navighează la: " + url);
        driver.get(url);

        String titluPagina = driver.getTitle();
        System.out.println("Titlul paginii este: " + titluPagina);

        // Pasul 5: Închidem browserul
        driver.quit();
        System.out.println("Testul headless s-a încheiat.");
    }
}