package it.prova.catenadimontaggio.model;

import java.time.LocalDate;

public class Automobile {
    public Long id;
    public String modello;
    public String telaio;
    public LocalDate dataProduzione;
    public SlotCatenaDiMontaggio slotCatenaDiMontaggio;

    public Automobile(Long id, String modello, String telaio, LocalDate dataProduzione) {
        this.id = id;
        this.modello = modello;
        this.telaio = telaio;
        this.dataProduzione = dataProduzione;
    }

    public SlotCatenaDiMontaggio getSlotCatenaDiMontaggio() {
        return slotCatenaDiMontaggio;
    }

    public void setSlotCatenaDiMontaggio(SlotCatenaDiMontaggio slotCatenaDiMontaggio) {
        this.slotCatenaDiMontaggio = slotCatenaDiMontaggio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTelaio() {
        return telaio;
    }

    public void setTelaio(String telaio) {
        this.telaio = telaio;
    }

    public LocalDate getDataProduzione() {
        return dataProduzione;
    }

    public void setDataProduzione(LocalDate dataProduzione) {
        this.dataProduzione = dataProduzione;
    }
}
