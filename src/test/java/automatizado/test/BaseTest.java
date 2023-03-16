package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    
    protected static WebDriver driver;
    private static String URL_BASE = "https://www.google.com/";

    @BeforeClass //  vem do junit e impõem que essa class vai ser chamada antes de qualquer outra class
    public static void iniciar(){ // Isso vai fazer com que inicie o drive
        System.setProperty("webdriver.chrome.driver", "src/test/java/automatizado/resource/chromedriver"); // Isso vai setar um programa especifico
        driver = new ChromeDriver();// instaciar o webDriver
        driver.manage().window().maximize();
        driver.get(URL_BASE); // para que ele nave na url base.
     }// A variavel caminho_driver vai esta o chrome.
    
    @AfterClass // vem do junit, vai ser o ultimo a rodar dos casos de testes.
    public static void finalizar(){
        driver.quit();
     }
}
