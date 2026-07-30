import java.util.ArrayList;

public class Projeto{

    private Gerente gerente;
    private ArrayList<Funcionario> funcionarios;
    private String nomeProjeto;
    private double custoTotal;
    private boolean finalizado;

    public Projeto(Gerente gerente, String nomeProjeto){
        this.gerente = gerente;
        this.funcionarios = new ArrayList<>();
        this.nomeProjeto = nomeProjeto;
        this.finalizado = false;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void finalizarProjeto() {
        this.finalizado = true;
    }

    public double calcularCusto(){
        this.gerente.setBonus(0);
        for (Funcionario f : funcionarios) {
            f.setBonus(0);
        }
        double custo = 0;

        double bonusSupervisao = (this.gerente.getSalario() * 0.01) * this.funcionarios.size();
        this.gerente.setBonus(bonusSupervisao);

        if(finalizado){
            for (Funcionario f : funcionarios) {
                f.setBonus(f.getSalario() * 0.1);
            }
            this.gerente.setBonus(this.gerente.getSalario() * 0.1);
        }

        for(Funcionario f : funcionarios){
            custo += f.getSalarioFinal();
        }
        custo += this.gerente.getSalarioFinal();
        return custo;
    }

    @Override
    public String toString() {
        double custo = calcularCusto();
        String info = "Projeto: " + this.nomeProjeto + "\n";
        info += "Gerente: " + this.gerente.getNome() + " | Salario: R$" + this.gerente.getSalarioFinal() + "\n";
        info += "Funcionarios: " + "\n";
        for (Funcionario f : funcionarios) {
            info += "Nome: " + f.getNome() + " | Salario: R$" + f.getSalarioFinal() + "\n";
        }
        info += "Custo: R$" + custo + "\n";
        return info;
    }
}