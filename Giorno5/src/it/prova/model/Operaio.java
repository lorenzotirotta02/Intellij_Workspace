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
    public static int contaQuantiFigli(Lavoratore []input){
        int count = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] instanceof Operaio){
                count += 1;
            }
        }
        return count;
    }
}
