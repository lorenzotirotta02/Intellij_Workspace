package it.prova.model;

import java.util.ArrayList;
import java.util.List;

public class Assicurato {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private int rataPremioAssicurativo;

    public Assicurato(String nome, String cognome, String codiceFiscale, int rataPremioAssicurativo) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.rataPremioAssicurativo = rataPremioAssicurativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public int getRataPremioAssicurativo() {
        return rataPremioAssicurativo;
    }

    public void setRataPremioAssicurativo(int rataPremioAssicurativo) {
        this.rataPremioAssicurativo = rataPremioAssicurativo;
    }

    public boolean presenteInElenco(List assicurati) {
        for (int i = 0; i < assicurati.size(); i++) {
            if (assicurati.get(i).equals(this.codiceFiscale)) {
                return true;
            }
        }
        return false;
    }

    public static int quantiConInizialeNelCognome(List<Assicurato> assicurati, char iniziale) {
        int count = 0;
        for (Assicurato assicurato : assicurati) {
            if (assicurato.getNome().charAt(0) == assicurato.getCognome().charAt(0)) {
                count += 1;
            }
        }
        return count;
    }

    public static List<String> estraiSoloICognomi(List<Assicurato> assicurati) {
        List<String> risultato = new ArrayList<>();
        for (Assicurato assicurato : assicurati) {
            risultato.add(assicurato.getCognome());
        }
        return risultato;
    }

    public static List<Assicurato> estraiQuelliConRataMaggiore(List<Assicurato> assicurati, int sogliaRata) {
        List<Assicurato> risultato = new ArrayList<>();
        for (Assicurato assicurato : assicurati) {
            if (assicurato.getRataPremioAssicurativo() > sogliaRata) {
                risultato.add(assicurato);
            }
        }
        return risultato;
    }
}