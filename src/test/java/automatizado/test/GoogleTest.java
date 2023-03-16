package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


import automatizado.page.GooglePO;

public class GoogleTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararteste() {
        googlePage = new GooglePO(driver);
    }

   @Test // Isso afirma que é um caso de teste.
   public void TC001_devePesquisarNoGooglrOtextoBatataFrita() {
       iniciar();

       googlePage.pesquisar("Batata frita"); // vai escrever na pagina.

       String resultado = googlePage.obeterResultadoDaPesquisa(); 
     
       assertTrue(resultado, resultado.contains("Aproximadamente")); // Vai testar se o que esta dentro de resulto bate
       driver.quit();
   }
   
    @Test 
    public void TC001_devePesquisarNoGooglrOtextoCasaGrande() {
        iniciar();

        //WebElement inputPesquisa = driver.findElement(By.name("q")); // O webelement é um elemento da web, pode ser; qualquer coisa derivada
                                                                
        googlePage.pesquisar("Casa Grande"); 

        String resultado = googlePage.obeterResultadoDaPesquisa(); 

        assertTrue(resultado, resultado.contains("Aproximadamente")); 
    }

}
