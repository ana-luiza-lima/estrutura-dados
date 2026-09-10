public class Agenda {
    
    private Vetor<Contato>[] agenda; 

    public Agenda() {
        this.agenda = new Vetor[26];
        for (int i = 0; i < 26; i++) {
            this.agenda[i] = new Vetor<Contato>(10);
        }
    }

    public int extraiPrimeiraLetra(String nome){
        if (nome == null || nome.trim().isEmpty()) {
            return -1;
        }
        char letra = nome.toUpperCase().charAt(0);
        int nArray = letra - 'A';
        return nArray;
    }

    public boolean verificarNomeLivre(String nome) {
        for (Vetor<Contato> vetor : agenda) {
            for (int i = 0; i < vetor.getTamanho(); i++) {
                Contato contato = vetor.ler(i);
                if (contato != null && nome.equalsIgnoreCase(contato.getNome())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verificarTelefoneLivre(String telefone) {
        for (Vetor<Contato> vetor : agenda) {
            for (int i = 0; i < vetor.getTamanho(); i++) {
                Contato contato = vetor.ler(i);
                if (contato != null && telefone.equals(contato.getTelefone())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void adicionarContato(Contato contato) {
        if(!verificarNomeLivre(contato.getNome())){
            System.out.println("Nome já existente");
            return;
        }
        if (!verificarTelefoneLivre(contato.getTelefone())) {
            System.out.println("Número já existente");
            return;
        }
        int indice = extraiPrimeiraLetra(contato.getNome());
        agenda[indice].inserir(contato);
        System.out.println("Contato adicionado com sucesso");
    }

    public void removerContato(String nome) {
        int indice = extraiPrimeiraLetra(nome);
        if (indice < 0) {
            System.out.println("Contato não encontrado");
            return;
        }
        for (int i = 0; i < agenda[indice].getTamanho(); i++) {
            Contato contato = agenda[indice].ler(i);
            if (contato != null && contato.getNome().equalsIgnoreCase(nome)) {
                agenda[indice].remover(i);
                System.out.println("Contato removido");
                return;
            }
        }
        System.out.println("Contato não encontrado");
    }

    public void atualizarContato(String nome, String novoNome, String novoTelefone, String novoEmail) {
        int indiceAntigo = extraiPrimeiraLetra(nome);
        if (indiceAntigo >= 0) {
            for (int i = 0; i < agenda[indiceAntigo].getTamanho(); i++) {
                Contato contato = agenda[indiceAntigo].ler(i);
                if (contato != null && contato.getNome().equalsIgnoreCase(nome)) {
                    if (!novoNome.equalsIgnoreCase(nome) && !verificarNomeLivre(novoNome)) {
                        System.out.println("Nome já está sendo utilizado");
                        return;
                    }
                    if (!novoTelefone.equals(contato.getTelefone()) && !verificarTelefoneLivre(novoTelefone)) {
                        System.out.println("Número já está sendo utilizado");
                        return;
                    }
                    if (extraiPrimeiraLetra(novoNome) < 0) {
                        System.out.println("O novo nome deve começar com uma letra de A a Z");
                        return;
                    }
                    agenda[indiceAntigo].remover(i);
                    contato.setNome(novoNome);
                    contato.setTelefone(novoTelefone);
                    contato.setEmail(novoEmail);
                    adicionarContato(contato);
                    System.out.println("Contato atualizado com sucesso");
                    return;
                }
            }
        }
        System.out.println("Contato não encontrado");
    }

    public Contato buscarContato(String nome) {
        int indice = extraiPrimeiraLetra(nome);
        if (indice < 0) {
            return null;
        }
        for (int i = 0; i < agenda[indice].getTamanho(); i++) {
            Contato contato = agenda[indice].ler(i);
            if (contato != null && contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public void listarContatos() {
        for (Vetor<Contato> vetor : agenda) {
            for (int i = 0; i < vetor.getTamanho(); i++) {
                Contato contato = vetor.ler(i);
                if (contato != null) {
                    contato.exibirContato();
                }
            }
        }
    }

    public void listarPorNome(String input) {
        int indice = extraiPrimeiraLetra(input);
        boolean encontrou = false;
        if (indice >= 0) {
            for (int i = 0; i < agenda[indice].getTamanho(); i++) {
                Contato contato = agenda[indice].ler(i);
                if (contato != null && contato.getNome().regionMatches(true, 0, input, 0, input.length())) {
                    contato.exibirContato();
                    encontrou = true;
                }
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum contato encontrado com esse início de nome.");
        }
    }
}
