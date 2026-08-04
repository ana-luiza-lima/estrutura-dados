package atividade01;

public class Agenda {

    private Contato[] contatos;
    private int tamanho;

    public Agenda(int tamanhoMaximo){
        contatos = new Contato[tamanhoMaximo];
        this.tamanho = 0;
    }

    private boolean verificarNome(String nome){
        for (Contato contato : contatos) {
            if(nome.equals(contato.getNome())){
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

    
    
}
