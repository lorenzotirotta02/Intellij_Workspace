package it.prova.gestionesmartphoneapp.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String marca;
    public String modello;
    public double prezzo;
    public String versioneOs;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "smartphone_app", joinColumns = @JoinColumn(name = "smartphone_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "app_id", referencedColumnName = "ID"))
    private Set<App> apps = new HashSet<App>();

    public Smartphone() {
    }

    public Smartphone(String marca, String modello, double prezzo, String versioneOs) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.versioneOs = versioneOs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Set<App> getApps() {
        return apps;
    }

    public void setApps(Set<App> apps) {
        this.apps = apps;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getVersioneOs() {
        return versioneOs;
    }

    public void setVersioneOs(String versioneOs) {
        this.versioneOs = versioneOs;
    }
}
