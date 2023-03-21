package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)// Ele vai executar os testes de forma pelo nome. Não é obrigatorio colocar
public class LoginTest extends BaseTest{
    
    private static LoginPO loginPage;

    @BeforeClass

    public static void prepararTeste(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naodeveLogarNoSistemaComEmailESenhaVazios(){

        loginPage.executarAcaoDeLogar("", "");
        String menssagem = loginPage.obterMessagem();

        assertEquals(menssagem, "Informe usuário e senha, os campos não podem ser brancos."); // Verifica se são iguais as mensagens
    } 
    @Test
    public void TC002_naodeveLogarNoSistemaComEmailIncorretoESenhaVazia(){

        loginPage.executarAcaoDeLogar("teste", "");
        String menssagem = loginPage.obterMessagem();

        assertEquals(menssagem, "Informe usuário e senha, os campos não podem ser brancos."); 
    } 
    @Test
    public void TC003_naodeveLogarNoSistemaComEmaiVaziolESenhaIncorreta(){

        loginPage.executarAcaoDeLogar("", "teste");
        String menssagem = loginPage.obterMessagem();

        assertEquals(menssagem, "Informe usuário e senha, os campos não podem ser brancos."); 
    } 
    @Test
    public void TC004_deveMostrarEmailESenhaInvalidos(){

        loginPage.executarAcaoDeLogar("teste", "teste");
        String menssagem = loginPage.obterMessagem();

        assertEquals(menssagem, "E-mail ou senha inválidos"); 
    }
    @Test
    public void TC005_deveMostrarEmailCorretoESenhaInvalida(){

        loginPage.executarAcaoDeLogar("admi@admin.com", "teste");
        String menssagem = loginPage.obterMessagem();

        assertEquals(menssagem, "E-mail ou senha inválidos"); 
    } 
    @Test
    public void TC006_deveMostrarEmailCorretoInvalidoESenhaCorreto(){

        loginPage.executarAcaoDeLogar("teste", "admi@123");
        String menssagem = loginPage.obterMessagem();

        assertEquals(menssagem, "E-mail ou senha inválidos"); 
    } 
    @Test
    public void TC007_deveLogarNoSistemaEmailCorretoESenhaCorretos(){

        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos"); 
    } 
    

}
