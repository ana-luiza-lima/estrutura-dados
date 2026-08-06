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

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
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

    public String exibirContato(){
        return "Nome: " + this.nome + "/n" +
                "Telefone: " + this.telefone + "/n" + 
                "Email: " + this.email + "/n";

    }


    
}
