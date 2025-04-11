package it.prova.model;

public class Operaio extends Lavoratore{
    private int salario;

    public Operaio(String nome, String cognome, int salario) {
        super(nome, cognome);
        this.salario = salario;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String percepisco() {
        return "Io percepisco " + salario;
    }
}
