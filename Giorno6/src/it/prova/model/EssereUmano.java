package it.prova.model;

public class EssereUmano implements Mammifero{
    public String nutrimento;

    public EssereUmano(String nutrimento) {
        this.nutrimento = nutrimento;
    }

    public String getNutrimento() {
        return nutrimento;
    }

    public void setNutrimento(String nutrimento) {
        this.nutrimento = nutrimento;
    }


    @Override
    public void siNutre() {
        System.out.println(getNutrimento());
    }
    public boolean siNutronoAlloStessoModo(Mammifero u) {
        if (!(u instanceof EssereUmano)) {
            return false;
        } else {
            EssereUmano temp = (EssereUmano) u;
            return this.nutrimento.equalsIgnoreCase(getNutrimento());
        }
    }
}
