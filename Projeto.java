import java.util.ArrayList;

public class Projeto{

    private Gerente gerente;
    private ArrayList<Funcionario> funcionarios;
    private String nomeProjeto;
    private double custoTotal;
    private boolean finalizado;

    public Projeto(Gerente gerente, ArrayList<Funcionario> funcionarios, String nomeProjeto){
        this.gerente = gerente;
        this.funcionarios = funcionarios;
        this.nomeProjeto = nomeProjeto;
    }

    public double calcularCusto(){
        double custo = 0;
        calcularBonusFinalizado();
        calcularBonusGerente();
        for(Funcionario f : funcionarios){
            custo += f.getSalarioFinal();
        }
        custo += this.gerente.getSalarioFinal();
        return custo;
    }

    public void calcularBonusGerente(){
        this.gerente.setBonus((0.01 * gerente.getSalario()) * funcionarios.size());
    }

    public void calcularBonusFinalizado(){
        if(finalizado){
            for (Funcionario f : funcionarios) {
                f.setBonus(f.getSalario() * 0.1);
            }
            this.gerente.setBonus(this.gerente.getSalario * 0.1);
        }
    }

    @Override
    public String toString() {
        String info = "Projeto: " + this.nomeProjeto + "\n";
        info += "Gerente: " + this.gerente.getNome + " | Salario: R$" + "\n";
        info += "Funcionarios: " + "\n";
        for (Funcionario f : funcionarios) {
            info += "Nome: " + f.getNome() + " | Salario: R$" + f.getSalarioFinal() + "\n";
        }
        info += "Custo: R$" + calcularCusto() + "\n";
        return info;
    }
}