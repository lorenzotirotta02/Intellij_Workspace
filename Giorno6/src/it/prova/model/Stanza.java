package it.prova.model;

import java.util.List;

public class Stanza {
    private int numeroStanza;
    private int quantoAPersona;
    private Hotel hotel;
    private List<Cliente> clienti;

    public Stanza(int numeroStanza, int quantoAPersona, Hotel hotel) {
        this.numeroStanza = numeroStanza;
        this.quantoAPersona = quantoAPersona;
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(List<Cliente> clienti) {
        this.clienti = clienti;
    }

    public int getNumeroStanza() {
        return numeroStanza;
    }

    public void setNumeroStanza(int numeroStanza) {
        this.numeroStanza = numeroStanza;
    }

    public int getQuantoAPersona() {
        return quantoAPersona;
    }

    public void setQuantoAPersona(int quantoAPersona) {
        this.quantoAPersona = quantoAPersona;
    }
}
