public class Agenda {

    private Contato[] contatos;
    private int tamanho;

    public Agenda(int tamanhoMaximo){
        contatos = new Contato[tamanhoMaximo];
        this.tamanho = 0;
    }

    private boolean verificarNome(String nome){
        for (Contato c : contatos) {
            if(nome.equals(c.getNome())){
                return true;
            }
        }
        return false;
    }

    private boolean verificarTelefone(String telefone){
        for (Contato contato : contatos) {
            if(telefone.equals(contato.getTelefone())){
                return true;
            }
        }
        return false;
    }

    public void adicionarContato(String nome, String telefone){
        if(verificarNome(nome) || verificarTelefone(telefone)){
            System.out.println("Nome ou telefone já existentes");
        } else {
            Contato novoContato = new Contato(nome, telefone);
            inserirNaAgenda(novoContato);
        }
    }

    private void inserirNaAgenda(Contato elemento){
        if(tamanho < contatos.length){
            contatos[tamanho] = elemento;
            tamanho++;
        }else{
            System.out.println("Não existe posição disponível");
        }
    }

    public String buscarContato(String nome){
        for(Contato c : contatos){
            if(c.getNome().equals(nome)){
                return "Nome: " + c.getNome() + "/n" +
                        "Telefone: " + c.getTelefone() + "/n" + 
                        "Email: " + c.getEmail() + "/n";
            }
        }
        return "Contato não encontrado";
    }

    public void removerContato(String nome){
        for(int i = 0; i < tamanho; i++){
            if(contatos[i].getNome().equals(nome)){
                remover(i);
                return;
            }
        }
    }

    private void remover(int indice){
        if(indice < 0 || indice >= tamanho){
            System.out.println("Índice inválido");
            return;
        }
        for(int i = indice; i < tamanho; i++){
            contatos[i] = contatos[i+1];
        }
        contatos[tamanho-1] = null;
        tamanho--;
    }

    public void atualizarContatoNome(String nome, String novoNome){
        for(int i = 0; i < tamanho; i++){
            if(contatos[i].getNome().equals(nome)){
                contatos[i].setNome(novoNome);
            }
        }
    }

    public void atualizarContatoTelefone(String telefone, String novotelefone){
        for(int i = 0; i < tamanho; i++){
            if(contatos[i].getTelefone().equals(telefone)){
                contatos[i].setNome(novotelefone);
            }
        }
    }

    public void imprimir(){
        if(tamanho != 0){
            System.out.print("[");
            for (int i =0; i< contatos.length; i++){
                if(contatos[i] != null){
                    contatos[i].exibirContato();
                }
                if(i < tamanho -1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } else {
            System.out.println("Array vazio");
        }
    }

    

    
    
}
