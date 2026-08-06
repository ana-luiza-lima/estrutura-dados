
public class Main {
    public static void main(String[] args) {
        
        Agenda agenda = new Agenda(20);

        agenda.imprimir();

        agenda.adicionarContato("Fernanda", "48999774194");

        IO.println("Adicionado 1 contato;");

        agenda.imprimir();

                

    }

}