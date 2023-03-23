package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ContoleleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContoleleDeProdutoTest extends BaseTest{
    
    private static LoginPO loginPage;
    private static ContoleleDeProdutoPO ContoleleDeProdutoPage;

    @BeforeClass
    public static void prepararTeste(){ // é preciso para logar e  posteriomente chegar na pagina de produtos.
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
    
        ContoleleDeProdutoPage = new ContoleleDeProdutoPO(driver);
        assertEquals(ContoleleDeProdutoPage.obterTituloPagina(), "Controle de Produtos");
    
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        ContoleleDeProdutoPage.buttonAdicionar.click();
        //TODO: Remover esse clique assim que o sistema for corrigido.
        ContoleleDeProdutoPage.buttonAdicionar.click();// O segundo click, pois existe um bug.

        String titulo = ContoleleDeProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);
        ContoleleDeProdutoPage.buttonSair.click();
        ContoleleDeProdutoPage.buttonSair.click();
    }
    // @Test
    // public void TC002_deveAbrirModalParaCadastrarUmProdutoSemPreencherodosOsCampos(){ 
    //     ContoleleDeProdutoPage.buttonAdicionar.click();

    //     ContoleleDeProdutoPage.cadastrarProduto("0001", "caneta", 2, 2.00, "");
    //     // Aqui captura a mensagem de erro
    //     String messagem = ContoleleDeProdutoPage.messagemSpan.getText();

    //     assertEquals("Todos os campos são obrigatórios para o cadastro!", messagem);
    // }
    @Test
    public void TC003_deveAbrirModalParaCadastrarUmProdutoSemPreencherodosOsCampos(){ 
        ContoleleDeProdutoPage.buttonAdicionar.click();
        ContoleleDeProdutoPage.buttonAdicionar.click();

        ProdutoBuilder produtoBuilder = new ProdutoBuilder();
        ContoleleDeProdutoPage.cadastrarProduto(produtoBuilder);
        
        // Aqui captura a mensagem de erro
        String messagem = ContoleleDeProdutoPage.messagemSpan.getText();

        assertEquals("Todos os campos são obrigatórios para o cadastro!", messagem);
    }
}
