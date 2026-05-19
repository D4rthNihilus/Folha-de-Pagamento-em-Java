package a3uam;

public class FuncionarioPadrao extends Funcionario{
    private double qtdExtras;

    private final double CARGA_HORARIA_DIA = 10.0;
    private final double DIAS_DE_TRABALHO_MES = 22.0;

    public FuncionarioPadrao(int numeroDeRegistro, String nomeCompleto, double qtdExtras){
        super(numeroDeRegistro, nomeCompleto);
        this.qtdExtras=qtdExtras;
    }

    @Override
    public double calcularSalario(){
        double cargaHorariaMensal = getCargaHoraria()*getDiasDeTrabalho();
        double valorDaHoraExtra = (getSalarioBase()/cargaHorariaMensal)*1.5;
        double remuneracaoExtras = valorDaHoraExtra*getQtdExtras();
        return getSalarioBase()+remuneracaoExtras;
    }

    //MÉTODOS GETTERS E SETTERS

    public double getQtdExtras(){
        return qtdExtras;
    }

    public double getCargaHoraria(){
        return CARGA_HORARIA_DIA;
    }

    public double getDiasDeTrabalho(){
        return DIAS_DE_TRABALHO_MES;
    }

    public void setQtdExtras(double qtdExtras){
        this.qtdExtras=qtdExtras;
    }

    //MÉTODO TOSTRING()

    @Override
    public String toString(){
        String string =
        "Nome: "+getNomeCompleto()+"\n"+
        "Matrícula: "+ getNumeroDeRegistro()+"\n"+
        "Salário fixo: "+fmt(getSalarioBase())+"\n"+
        "Extras: "+fmt(getQtdExtras())+"\n"+
        "Salário final: "+fmt(calcularSalario())+"\n";
        return string;
    }
}
