package it.prova.model;

public class Biblioteca {
    private MaterialeBiblioteca[] materiali;

    public Biblioteca(MaterialeBiblioteca[] materiali) {
        this.materiali = materiali;
    }

    public MaterialeBiblioteca[] getMateriali() {
        return materiali;
    }

    public void setMateriali(MaterialeBiblioteca[] materiali) {
        this.materiali = materiali;
    }

    public void aggiungiMateriale(MaterialeBiblioteca m) {
        MaterialeBiblioteca[] materialeBibliotecas = new MaterialeBiblioteca[materiali.length + 1];
        for (int i = 0; i < materiali.length; i++) {
            materialeBibliotecas[i] = materiali[i];
        }
        materialeBibliotecas[materiali.length] = m;
        materiali = materialeBibliotecas;
    }
//    public void aggiungiMateriale2(MaterialeBiblioteca m){
//        for(int i = 0; i < materiali.length; i++){
//            if(materiali[i] == null){
//                materiali[i] = m;
//                System.out.println("Materiale " + m.getTitolo() + " aggiunto con successo");
//                return;
//            } else if(materiali[i] != null) {
//                System.out.println("La biblioteca è piena!");
//            }
//        }
//    }
    public MaterialeBiblioteca[] cercaMaterialePerTitolo(String titolo){
        int count = 0;
        for(MaterialeBiblioteca materiale : materiali){
            if(materiale.getTitolo().equalsIgnoreCase(titolo)){
                count += 1;
            }
        }
        MaterialeBiblioteca[] risultato = new MaterialeBiblioteca[count];
        count = 0;
        for(MaterialeBiblioteca materiale : materiali){
            if (materiale.getTitolo().equalsIgnoreCase(titolo)){
                risultato[count] = materiale;
            }
            count += 1;
        }
        return risultato;

    }
    public MaterialeBiblioteca[] elencaMaterialiDisponibili(){
        int count = 0;
        for(MaterialeBiblioteca materiale : materiali){
            if(materiale.isDisponibile()){
                count += 1;
            }
        }
        MaterialeBiblioteca[] risultato = new MaterialeBiblioteca[count];
        count = 0;
        for(MaterialeBiblioteca materiale : materiali){
            if (materiale.isDisponibile()){
                risultato[count] = materiale;
                count += 1;
            }
        }
        return risultato;

    }
    public MaterialeBiblioteca[] elencaMaterialiInPrestito(){
        int count = 0;
        for(MaterialeBiblioteca materiale : materiali){
            if(!materiale.isDisponibile()){
                count += 1;
            }
        }
        MaterialeBiblioteca[] risultato = new MaterialeBiblioteca[count];
        count = 0;
        for(MaterialeBiblioteca materiale : materiali){
            if (!materiale.isDisponibile()){
                risultato[count] = materiale;
                count += 1;
            }
        }
        return risultato;

    }
}
