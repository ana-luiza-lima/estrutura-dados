
public class App{
    public static void main(String[] args){

        Gerente novoGerente = new Gerente("Roberta Silva", 8000.00);

        Projeto novoProjeto = new Projeto(novoGerente, "Projeto Inicial");

        novoProjeto.adicionarFuncionario(new Funcionario("Suzanne Castro", 2000.00));
        novoProjeto.adicionarFuncionario(new Funcionario("Aline Gomes", 3000.00));

        System.out.println("Projeto iniciado");
        System.out.println(novoProjeto.toString());

        novoProjeto.finalizarProjeto();

        System.out.println("Projeto finalizado");
        System.out.println(novoProjeto.toString());

    }
}