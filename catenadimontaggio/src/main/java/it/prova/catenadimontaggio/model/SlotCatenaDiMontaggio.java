package it.prova.catenadimontaggio.model;

import java.util.ArrayList;
import java.util.List;

public class SlotCatenaDiMontaggio {
    public Long id;
    public String brand;
    public String country;
    public List<Automobile> automobili = new ArrayList<Automobile>();

    public SlotCatenaDiMontaggio(Long id, String brand, String country) {
        this.id = id;
        this.brand = brand;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Automobile> getAutomobili() {
        return automobili;
    }

    public void setAutomobili(List<Automobile> automobili) {
        this.automobili = automobili;
    }
}
