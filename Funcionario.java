package a3uam;

public abstract class Funcionario {
    private int numeroDeRegistro;
    private String nomeCompleto;

    final static double SALARIO_BASE = 2000.00;

    public Funcionario(int numeroDeRegistro, String nomeCompleto){
        this.numeroDeRegistro=numeroDeRegistro;
        this.nomeCompleto=nomeCompleto;
    }

    //MÉTODOS PADRÕES

    public abstract double calcularSalario();

    public String fmt (double numero){
        return String.format("%.2f", numero);
    }

    //MÉTODOS GETTERS E SETTERS

    public int getNumeroDeRegistro(){
        return numeroDeRegistro;
    }

    public String getNomeCompleto(){
        return nomeCompleto;
    }

    public double getSalarioBase(){
        return SALARIO_BASE;
    }

    public void setNumeroDeRegistro(int numeroDeRegistro){
        this.numeroDeRegistro=numeroDeRegistro;
    }

    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto=nomeCompleto;
    }
}
