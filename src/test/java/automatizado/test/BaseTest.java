package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *  Classe base que serve de herança para todas as classes de teste.
 */
public abstract class BaseTest {
    
    /*
    *  Driver do navegador da pagona atual.
    */
    protected static WebDriver driver;
    /*Caminho base da URL do sistema a ser testado.*/
    private static String URL_BASE = "http://127.0.0.1:5500/sistema/login.html";

     /*
      * Metodo para iniciar o drive do navegador antes de qualquer classe de teste.
     */
    @BeforeClass //  vem do junit e impõem que essa class vai ser chamada antes de qualquer outra class
    public static void iniciar(){ // Isso vai fazer com que inicie o drive
        System.setProperty("webdriver.chrome.driver", "src/test/java/automatizado/resource/chromedriver"); // Isso vai setar um programa especifico
        driver = new ChromeDriver();// instaciar o webDriver
        driver.manage().window().maximize();
        driver.get(URL_BASE); // para que ele nave na url base.
     }// A variavel caminho_driver vai esta o chrome.
    
    /*
      * Metodo para finalizar o drive do navegador antes de qualquer classe de teste.
    */
    @AfterClass // vem do junit, vai ser o ultimo a rodar dos casos de testes.
    public static void finalizar(){
        driver.quit();
     }
}
