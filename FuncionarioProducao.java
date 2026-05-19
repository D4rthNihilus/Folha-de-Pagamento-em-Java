package a3uam;

public class FuncionarioProducao extends Funcionario {
    private int pecasProduzidas;
    private double valorDaPeca;

    public FuncionarioProducao(int numeroDeRegistro, String nomeCompleto, int pecasProduzidas, double valorDaPeca){
        super(numeroDeRegistro, nomeCompleto);
        this.pecasProduzidas=pecasProduzidas;
        this.valorDaPeca=valorDaPeca;
    }

    public double calcularProdutividade(){
        return pecasProduzidas*valorDaPeca;
    }

    @Override
    public double calcularSalario(){
        return getSalarioBase()+calcularProdutividade();
    }

    //MÉTODOS GETTERS E SETTERS

    public int getPecasProduzidas(){
        return pecasProduzidas;
    }

    public double getValorDaPeca(){
        return valorDaPeca;
    }

    public void setPecasProduzidas(int pecasProduzidas){
        this.pecasProduzidas=pecasProduzidas;
    }

    public void setValorDaPeca(double valorDaPeca){
        this.valorDaPeca=valorDaPeca;
    }

    //MÉTODO TOSTRING()

    @Override
    public String toString(){
        String string =
        "Nome: "+getNomeCompleto()+"\n"+
        "Matrícula: "+ getNumeroDeRegistro()+"\n"+
        "Salário fixo: "+fmt(getSalarioBase())+"\n"+
        "Produtividade: "+fmt(calcularProdutividade())+"\n"+
        "Salário final: "+fmt(calcularSalario())+"\n";
        return string;
    }
}
