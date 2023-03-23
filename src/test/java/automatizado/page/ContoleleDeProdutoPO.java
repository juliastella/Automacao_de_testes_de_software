package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automatizado.builder.ProdutoBuilder;

public class ContoleleDeProdutoPO extends BasePO{

    //Elementos maqpeados

    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;

    @FindBy(css = "div.modal-header>h4")
    public WebElement tituloModal;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;
    
    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "mensagem")
    public WebElement messagemSpan;

    public ContoleleDeProdutoPO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    public void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor, String data){
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade.toString());
        escrever(inputValor, valor.toString());
        escrever(inputData, data);
        
        buttonSalvar.click();
    }
    public void cadastrarProduto(ProdutoBuilder produtoBuilder){
        escrever(inputCodigo, produtoBuilder.codigo);
        escrever(inputNome, produtoBuilder.data);
        escrever(inputQuantidade, produtoBuilder.toString());
        escrever(inputValor, produtoBuilder.valor.toString());
        escrever(inputData, produtoBuilder.data);
        
        buttonSalvar.click();
    }
}
