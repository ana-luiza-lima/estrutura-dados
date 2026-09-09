package AgendaVetorGenérico;

public class AgendaVetorGenérico {

    private Vetor<Contato> agenda;

    public AgendaVetorGenérico(int tamanho) {
        this.agenda = new Vetor<>(tamanho);
    }

    public boolean verificarNomeLivre(String nome) {
        for (int i = 0; i < agenda.getTamanho(); i++) {
            Contato contato = agenda.ler(i);

            if (contato != null && nome.equals(contato.getNome())) {
                return false;
            }
        }

        return true;
    }

    public boolean verificarTelefoneLivre(String telefone) {
        for (int i = 0; i < agenda.getTamanho(); i++) {
            Contato contato = agenda.ler(i);

            if (contato != null && telefone.equals(contato.getTelefone())) {
                return false;
            }
        }

        return true;
    }

    public void adicionarContato(Contato contato) {

        if (!verificarNomeLivre(contato.getNome())) {
            System.out.println("Nome de contato já registrado.");
            return;
        }

        if (!verificarTelefoneLivre(contato.getTelefone())) {
            System.out.println("Número já associado.");
            return;
        }

        agenda.inserir(contato);
        System.out.println("Contato adicionado com sucesso.");
    }

    public void removerContato(String nome) {

        for (int i = 0; i < agenda.getTamanho(); i++) {

            Contato contato = agenda.ler(i);

            if (contato != null && contato.getNome().equals(nome)) {
                agenda.remover(i);
                System.out.println("Contato removido com sucesso.");
                return;
            }
        }

        System.out.println("Contato não encontrado.");
    }

    public void atualizarContato(
            String nome,
            String novoNome,
            String novoTelefone,
            String novoEmail) {

        for (int i = 0; i < agenda.getTamanho(); i++) {

            Contato contato = agenda.ler(i);

            if (contato != null && contato.getNome().equals(nome)) {

                if (!novoNome.equals(nome)
                        && !verificarNomeLivre(novoNome)) {

                    System.out.println("Nome já está sendo utilizado.");
                    return;
                }

                if (!novoTelefone.equals(contato.getTelefone())
                        && !verificarTelefoneLivre(novoTelefone)) {

                    System.out.println("Número já está sendo utilizado.");
                    return;
                }

                contato.setNome(novoNome);
                contato.setTelefone(novoTelefone);
                contato.setEmail(novoEmail);

                System.out.println("Contato atualizado com sucesso.");
                return;
            }
        }

        System.out.println("Contato não encontrado.");
    }

    public void listarContatos() {

        if (agenda.getTamanho() == 0) {
            System.out.println("Agenda vazia.");
            return;
        }

        for (int i = 0; i < agenda.getTamanho(); i++) {

            Contato contato = agenda.ler(i);

            if (contato != null) {
                contato.exibirContato();
            }
        }
    }

    public void listarPorNome(String input) {

        boolean encontrou = false;

        for (int i = 0; i < agenda.getTamanho(); i++) {

            Contato contato = agenda.ler(i);

            if (contato != null && contato.getNome().startsWith(input)) {
                contato.exibirContato();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println(
                    "Nenhum contato encontrado com esse início de nome."
            );
        }
    }
}