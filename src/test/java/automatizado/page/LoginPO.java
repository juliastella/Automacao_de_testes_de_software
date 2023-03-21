package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntar;

    @FindBy(id = "mensagem")
    public WebElement mensagemSpan;

    public Object buttonEntrar;


    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public void escrever(WebElement input, String texto){// Escrever nos campos de input
        input.clear(); //Para limbar o campo antes de escrever.
        input.sendKeys(texto + Keys.TAB);
    }
    
    public String obterMessagem(){ // Esse metodo vai retonar a mensagem de texto.
        return mensagemSpan.getText();
    }

    public void executarAcaoDeLogar(String email, String senha){ // metodo que executa a ação de logar no sistema.
        escrever(inputEmail, email); 
        escrever(inputSenha, senha);

        buttonEntar.click(); // Apertar no butão
    }

    public String obterTituloPagina(){
        return driver.getTitle();
    }
}
