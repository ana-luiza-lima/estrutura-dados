public class Funcionario {


    private String nome;
    private double salario;
    private double bonus;
    

    public Funcionario(String nome, double salario){
        setNome(nome);
        setSalario(salario);
        this.bonus = 0;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public double getBonus(){
        return bonus;
    }

    public double getSalario(){
        return this.salario;
    } 

    public double getSalarioFinal(){
        return this.salario + this.bonus;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString() {
        return "Funcionário: " + this.nome + 
                "\nSalário: " + this.salario;
    }





}