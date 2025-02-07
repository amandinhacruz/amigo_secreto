package entity;

public class Participante {
    private String nome;
    private String senha;
    private String amigoSecreto;

    // Construtor que inclui nome, senha e amigo secreto
    public Participante(String nome, String senha, String amigoSecreto) {
        this.nome = nome;
        this.senha = senha;
        this.amigoSecreto = amigoSecreto;
    }

    // Construtor que inclui nome e senha
    public Participante(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.amigoSecreto = ""; // Inicializa amigoSecreto vazio
    }

    // Construtor que inclui apenas o nome
    public Participante(String nome) {
        this.nome = nome;
        this.senha = ""; // Senha vazia inicialmente
        this.amigoSecreto = ""; // Inicializa amigoSecreto vazio
    }

    // Métodos getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAmigoSecreto() {
        return amigoSecreto;
    }

    public void setAmigoSecreto(String amigoSecreto) {
        this.amigoSecreto = amigoSecreto;
    }
}



	
	
	
	
	
	
