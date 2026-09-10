public class MainAgenda{

    public static void main(String[] args){
        Agenda agenda = new Agenda();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU DA AGENDA DE CONTATOS ---");
            System.out.println("1 - Adicionar Contato (Ordenado)");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Buscar Contato");
            System.out.println("4 - Atualizar Contato");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    agenda.adicionarContato(new Contato(nome, telefone, email));
                    break;
                case 2:
                    System.out.print("Digite o nome a remover: ");
                    agenda.removerContato(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Digite o nome a buscar: ");
                    Contato contato = agenda.buscarContato(scanner.nextLine());
                    if (contato == null) {
                        System.out.println("Contato não encontrado");
                    } else {
                        contato.exibirContato();
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome atual: ");
                    String nomeAtual = scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    System.out.print("Digite o novo email: ");
                    String novoEmail = scanner.nextLine();
                    agenda.atualizarContato(nomeAtual, novoNome, novoTelefone, novoEmail);
                    break;
                case 5:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (opcao != 5);

        scanner.close();
    }
}