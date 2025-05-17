package it.prova.pokeronline.dto;

import it.prova.pokeronline.model.Stato;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class UtenteDTO {

    private Long id;

    @NotBlank(message = "{nome.notblank}")
    private String nome;
    @NotBlank(message = "{cognome.notblank}")
    private String cognome;
    @NotBlank(message = "{username.notblank}")
    private String username;
    @NotBlank(message = "{password.notblank}")
    private String password;

    private LocalDate dataRegistrazione;

    private Integer esperienzaAccumulata;

    private Double creditoAccumulato;

    private Stato stato;


}

