package atividade01;

public class Contato {

    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
        this.email = "";
    }

    public Contato(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public String getEmail(){
        return this.email;
    }


    
}
