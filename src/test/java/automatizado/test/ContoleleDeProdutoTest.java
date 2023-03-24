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
    public static ContoleleDeProdutoPO contoleleDeProdutoPage;

    @BeforeClass
    public static void prepararTeste(){ // é preciso para logar e  posteriomente chegar na pagina de produtos.
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
    
        contoleleDeProdutoPage = new ContoleleDeProdutoPO(driver);
        assertEquals(contoleleDeProdutoPage.obterTituloPagina(), "Controle de Produtos");
    
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        contoleleDeProdutoPage.buttonAdicionar.click();
        //TODO: Remover esse clique assim que o sistema for corrigido.
        contoleleDeProdutoPage.buttonAdicionar.click();// O segundo click, pois existe um bug.

        String titulo = contoleleDeProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);
        contoleleDeProdutoPage.buttonSair.click();
        contoleleDeProdutoPage.buttonSair.click();
    }
    // @Test
    // public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){ 
    //     contoleleDeProdutoPage.buttonAdicionar.click();
    //     contoleleDeProdutoPage.buttonAdicionar.click();

    //     contoleleDeProdutoPage.cadastrarProduto("0001", "", 2, 2.00, "03/11/2021");
    //     // Aqui captura a mensagem de erro
    //     String messagem = contoleleDeProdutoPage.SpanMensagem.getText();

    //     assertEquals("Todos os campos são obrigatórios para o cadastro!", messagem);
    // }
    @Test
    public void TC003_naodeveAbrirModalParaCadastrarUmProdutoSemPreencherodosOsCampos(){ 
        contoleleDeProdutoPage.buttonAdicionar.click();
        contoleleDeProdutoPage.buttonAdicionar.click();

        // Aqui cria o objeto paraadicionar na tela.
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(contoleleDeProdutoPage);
    
        // Aqui realmente ele adiciona as informações na tela.
        
        produtoBuilder.adicionarNome("café")
        .adicionarCodigo("233")
        .adicionarQuantidade(3)
        .builder();

        
        produtoBuilder.adicionarNome("garrafa")
        .adicionarData("23/11/2023")
        .adicionarQuantidade(3)
        .adicionarValor(60.0);

        // Aqui captura a mensagem de erro
        String messagem = contoleleDeProdutoPage.SpanMensagem.getText();

        assertEquals("Todos os campos são obrigatórios para o cadastro!", messagem);

        contoleleDeProdutoPage.buttonSair.click();
        contoleleDeProdutoPage.buttonSair.click();
    }
}
