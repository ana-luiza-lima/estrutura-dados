package AgendaVetorGenérico;

public class MainAgenda {

    public static void main(String[] args) {
        AgendaVetorGenérico agenda = new AgendaVetorGenérico(10);

        Contato contato1 = new Contato("Bob Esponja", "111111", "esponja@email.com");
        Contato contato2 = new Contato("Bob Esfregão", "2222222", "esfregão@email.com");
        Contato contato3 = new Contato("Bob Bombril", "3333333", "bombril@email.com");
        Contato contato4 = new Contato("Patrick Estrela", "4444444", "patrick@email.com");
        Contato contato5 = new Contato("Patrick Lua", "5555555", "patrick.Lua@email.com");

        System.out.println("\n /////////////////Adicionar contatos///////////////////////  ");


        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        agenda.adicionarContato(contato3);
        agenda.adicionarContato(contato4);
        agenda.adicionarContato(contato5);

        System.out.println("\n /////////////////Listar contatos///////////////////////  ");

        agenda.listarContatos();


        System.out.println("\n /////////////////Listar Pats///////////////////////  ");
        agenda.listarPorNome("Pat");


        System.out.println("\n /////////////////Atualizar Bob Molusco///////////////////////  ");
        agenda.atualizarContato("Bob Esponja", "Bob Molusco", "111111", "bob.molusco@email.com");
        agenda.listarContatos();


        System.out.println("\n /////////////////Remover Patrick Estrela///////////////////////  ");
        agenda.removerContato("Patrick Estrela");
        agenda.listarContatos();
    }
}
