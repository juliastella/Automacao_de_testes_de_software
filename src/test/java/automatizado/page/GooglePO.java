package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO{

    @FindBy(name = "q") // Do PageFactory, vai construir objetos 
    public WebElement inpuPesquisa;

    @FindBy(id = "result-stats")
    public WebElement divResultadoPesquisa;

    /*
     *  Construtor para a criação da página do Google.
     */
    public GooglePO(WebDriver driver) {
        super(driver);
    }
    /*
     *  Metodo que irá efetuar uma pesquisa no google baseando no texto, concluindo com enter.
    */
    public void pesquisar(String texto){
        inpuPesquisa.sendKeys(texto + Keys.ENTER);
    }
    /*
     * Metodo que retorna o resultado aproximado da pesquisa.
     */
    public String obeterResultadoDaPesquisa(){
        return divResultadoPesquisa.getText();        // A propriedade .getText devolve o conteudo em texto
    }
}
