package it.prova.onetomany;

public class Raccoglitore {
    private String colore;
    private String spessore;

    private Foglio[] fogli;

    public Raccoglitore(String colore, String spessore, Foglio[] fogli) {
        this.colore = colore;
        this.spessore = spessore;
        this.fogli = fogli;
    }

    public String getColore() {
        return colore;
    }

    public String getSpessore() {
        return spessore;
    }

    public Foglio[] getFogli() {
        return fogli;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public void setFogli(Foglio[] fogli) {
        this.fogli = fogli;
    }

    public void setSpessore(String spessore) {
        this.spessore = spessore;
    }
    public void addToFogli(Foglio foglio){
        Foglio[] f = new Foglio[this.fogli.length + 1];
        for(int i = 0; i < fogli.length; i++){
            f[i] = this.fogli[i];

        }
        f[f.length - 1] = foglio;
        this.setFogli(f);
    }
    public boolean removeFogli(int index){
        if(index < 0 || this.fogli.length < index){
            return false;
        }
        Foglio[] f = new Foglio[this.fogli.length - 1];
        int scarto = 0;
        for(int i = 0; i < f.length; i++){
            if(i == index){
                scarto += 1;
            }
            f[i] = this.getFogli()[i+1];
        }
        this.setFogli(f);
        return true;
    }
    public boolean esisteAlmenoUnFoglioAQuadretti(){
        int count = 0;
        String tipo = "Quadretti";
        for(int i = 0; i < this.fogli.length; i++){
            if(this.fogli[i].getTipologia().equals(tipo)){
                count += 1;
            }
        }
        if(count >= 1){
            return true;
        }
        return false;
    }

}
