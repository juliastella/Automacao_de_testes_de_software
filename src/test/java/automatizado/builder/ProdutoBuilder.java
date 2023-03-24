package automatizado.builder;

import automatizado.page.ContoleleDeProdutoPO;

/*
* Classe que sabe construir ou adicionar na tela.
*/
public class ProdutoBuilder {
    
    // Um builder deve conter valores padrões.
    private String codigo = "00001";// se o usuario não passar um codigo ele passa um valor default que um valor pre determinado.
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "03/11/2021";

    private ContoleleDeProdutoPO contoleleDeProdutoPO; // driver é a pagina em que se estar

    /** Construtor do ProdutoBuilder que recebe a pagina de controle produtos.*/
    public ProdutoBuilder(ContoleleDeProdutoPO contoleleDeProdutoPO) {
        this.contoleleDeProdutoPO = contoleleDeProdutoPO;
    }
    /** Metodo que sabe adicionar um código ao builder*/
    public ProdutoBuilder adicionarCodigo(String codigo){ // Os metodos de builder retornam a propria instacia.
        this.codigo = codigo; // pega o codigo que usuario passou
        return this; // e retorna no atributo mundando o defualt
    }
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
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
    /*
     * É o metodo que vai saber construir um produto. 
     */
    public void builder(){
        
        contoleleDeProdutoPO.escrever(contoleleDeProdutoPO.inputNome, nome); // tratando para não ser null, cotudo informa erro.
        contoleleDeProdutoPO.escrever(contoleleDeProdutoPO.inputCodigo, codigo);
        contoleleDeProdutoPO.escrever(contoleleDeProdutoPO.inputQuantidade, (quantidade != null ) ? quantidade.toString(): "");
        contoleleDeProdutoPO.escrever(contoleleDeProdutoPO.inputValor, (valor != null ) ? valor.toString() : "");
        contoleleDeProdutoPO.escrever(contoleleDeProdutoPO.inputData, data);

        contoleleDeProdutoPO.buttonSalvar.click();
    }
}
