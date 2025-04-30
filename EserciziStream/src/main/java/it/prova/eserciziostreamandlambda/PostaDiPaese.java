package main.java.it.prova.eserciziostreamandlambda;

import java.time.LocalDate;
import java.util.List;

public class PostaDiPaese {

    // PostaDiPaese (denominazione, indirizzoSede, dataApertura, numeroDipendenti, destinatari);
    private String denominazione;
    private String indirizzoSede;
    private LocalDate dataApertura;
    private int numeroDipendenti;
    private List<Destinatario> destinatari;

    public PostaDiPaese(String denominazione, String indirizzoSede, LocalDate dataApertura, int numeroDipendenti,
                        List<Destinatario> destinatari) {
        this.denominazione = denominazione;
        this.indirizzoSede = indirizzoSede;
        this.dataApertura = dataApertura;
        this.numeroDipendenti = numeroDipendenti;
        this.destinatari = destinatari;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getIndirizzoSede() {
        return indirizzoSede;
    }

    public void setIndirizzoSede(String indirizzoSede) {
        this.indirizzoSede = indirizzoSede;
    }

    public LocalDate getDataApertura() {
        return dataApertura;
    }

    public void setDataApertura(LocalDate dataApertura) {
        this.dataApertura = dataApertura;
    }

    public int getNumeroDipendenti() {
        return numeroDipendenti;
    }

    public void setNumeroDipendenti(int numeroDipendenti) {
        this.numeroDipendenti = numeroDipendenti;
    }

    public List<Destinatario> getDestinatari() {
        return destinatari;
    }

    public void setDestinatari(List<Destinatario> destinatari) {
        this.destinatari = destinatari;
    }
}
