package it.prova.raccoltafilmspringmvc.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ordine")
public class Ordine {

    // Ordine(id, Cliente, lista di Pizza, dataOrdine, CLOSED=true/false, codice, costo totale ordine).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataOrdine;
    private boolean closed;
    private String codice;
    private int costoTotale;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ordine_pizza", joinColumns = @JoinColumn(name = "ordine_id"), inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    private Set<Pizza> pizze = new HashSet<Pizza>();

    public Ordine() {
    }
    public Ordine(Long id, LocalDate dataOrdine, boolean closed, String codice, int costoTotale) {
        this.id = id;
        this.dataOrdine = dataOrdine;
        this.closed = closed;
        this.codice = codice;
        this.costoTotale = costoTotale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCostoTotale() {
        double costoTotale = 0;
        for (Pizza pizza : pizze) {
            costoTotale += pizza.getPrezzoBase();
        }
        return (int) costoTotale;
    }

    public void setCostoTotale(int costoTotale) {
        this.costoTotale = costoTotale;
    }

    public Set<Pizza> getPizze() {
        return pizze;
    }

    public void setPizze(Set<Pizza> pizze) {
        this.pizze = pizze;
    }
}
