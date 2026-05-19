package a3uam;

public class FuncionarioComissionado extends Funcionario{
    private double faturamentoVendas;
    private double comissaoPercentual;

    public FuncionarioComissionado(int numeroDeRegistro, String nomeCompleto, double faturamentoVendas, double comissaoPercentual){
        super(numeroDeRegistro, nomeCompleto);
        this.faturamentoVendas=faturamentoVendas;
        this.comissaoPercentual=comissaoPercentual;
    }

    public double calcularComissao(){
        return faturamentoVendas*(comissaoPercentual/100);
    }

    @Override
    public double calcularSalario(){
        return getSalarioBase()+calcularComissao();
    }

    //MÉTODOS GETTERS E SETTERS

    public double getFaturamentoVendas(){
        return faturamentoVendas;
    }

    public double getComissaoPercentual(){
        return comissaoPercentual;
    }

    public void setFaturamentoVendas(double faturamentoVendas){
        this.faturamentoVendas=faturamentoVendas;
    }

    public void setComissaoPercentual(double comissaoPercentual){
        this.comissaoPercentual=comissaoPercentual;
    }

    //MÉTODO TOSTRING()

    @Override
    public String toString(){
        String string =
        "Nome: "+getNomeCompleto()+"\n"+
        "Matrícula: "+ getNumeroDeRegistro()+"\n"+
        "Salário fixo: "+fmt(getSalarioBase())+"\n"+
        "Comissão: "+fmt(calcularComissao())+"\n"+
        "Salário final: "+fmt(calcularSalario())+"\n";
        return string;
    }
}
