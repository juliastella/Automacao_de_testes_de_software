package automatizado.builder;

import org.openqa.selenium.WebDriver;

import automatizado.page.ContoleleDeProdutoPO;

public class ProdutoBuilder {
    
    // Um builder deve conter valores padrões.
    public String codigo = "0001";// se o usuario não passar um codigo ele passa um valor default que um valor pre determinado.
    public String nome = "Produto Padrão";
    public Integer quantidade = 1;
    public Double valor = 1.4;
    public String data = "03/11/2021";

    private ControleleDeProdutoPo contoleleDeProdutoPO; // driver é a pagina em que se estar

    public void ProdutorBuilder(ControleleDeProdutoPo contoleleDeProdutoPO){
        this.driver = driver;
    }

    public ProdutoBuilder adicionarCodigo(String codigo){ // Os metodos de builder retornam a propria instacia.
        this.codigo = codigo; // pega o codigo que usuario passou
        return this; // e retorna no atributo mundando o defualt
    }
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }
    public ProdutoBuilder adicionarQuantida(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    public void builder(){
        
       ControleleDeProdutoPo new ContoleleDeProdutoPO(this.driver);
    }
}
