package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * Classe base para criação das novas PagesObjects.
 * Toda as pages devem ser herdadas desta classe.
 */
public abstract class BasePO {
    /**Driver base que será usado pelas pages*/
    protected WebDriver driver;
    
    /**Costrutor base para a criação da fabrica de elemntos (PageFactory)*/
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    } // O PageFactory vai é fabrica de pagina, você para de ficar buscando e capturando codigos grandes, pois ele gera isso.
    //  O PageFactory, é uma biblioteca que aplica um padrão de fabrica.
}
