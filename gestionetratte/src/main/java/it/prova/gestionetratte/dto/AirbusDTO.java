package it.prova.gestionetratte.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.model.Tratta;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class AirbusDTO {

    private Long id;

    @NotBlank(message = "...")
    private String codice;

    @NotBlank(message = "...")
    private String descrizione;

    @NotNull(message = "...")
    private LocalDate dataInizioServizio;

    @NotNull
    @Min(10)
    private Integer numeroPasseggeri;

    private boolean sovrapposizioni;

    @JsonIgnoreProperties(value = { "regista" })
    private Set<TrattaDTO> tratte = new HashSet<TrattaDTO>(0);

    public AirbusDTO() {}

    public AirbusDTO(Long id, String codice, String descrizione, LocalDate dataInizioServizio, Integer numeroPasseggeri) {
        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.dataInizioServizio = dataInizioServizio;
        this.numeroPasseggeri = numeroPasseggeri;
    }

    public AirbusDTO(Long id, boolean sovrapposizioni, Integer numeroPasseggeri,
                     LocalDate dataInizioServizio, String descrizione, String codice) {
        this.id = id;
        this.sovrapposizioni = sovrapposizioni;
        this.numeroPasseggeri = numeroPasseggeri;
        this.dataInizioServizio = dataInizioServizio;
        this.descrizione = descrizione;
        this.codice = codice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public LocalDate getDataInizioServizio() {
        return dataInizioServizio;
    }

    public void setDataInizioServizio(LocalDate dataInizioServizio) {
        this.dataInizioServizio = dataInizioServizio;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getNumeroPasseggeri() {
        return numeroPasseggeri;
    }

    public void setNumeroPasseggeri(Integer numeroPasseggeri) {
        this.numeroPasseggeri = numeroPasseggeri;
    }

    public Set<TrattaDTO> getTratte() {
        return tratte;
    }

    public void setTratte(Set<TrattaDTO> tratte) {
        this.tratte = tratte;
    }

    public boolean isSovrapposizioni() {
        return sovrapposizioni;
    }

    public void setSovrapposizioni(boolean sovrapposizioni) {
        this.sovrapposizioni = sovrapposizioni;
    }

    public Airbus buildAirbusModel() {
        return new Airbus(this.id, this.codice,
                this.descrizione, this.dataInizioServizio, this.numeroPasseggeri);
    }

    public static AirbusDTO buildAirbusDTOFromModel(Airbus airbusModel, boolean includeTratte) {
        AirbusDTO result = new AirbusDTO(airbusModel.getId(), airbusModel.getCodice(), airbusModel.getDescrizione(),
                airbusModel.getDataInizioServizio(), airbusModel.getNumeroPasseggeri());
        if (includeTratte)
            result.setTratte(TrattaDTO.createTrattaDTOSetFromModelSet(airbusModel.getTratte(), false));
        return result;
    }

    public static List<AirbusDTO> createAirbusDTOListFromModelList(List<Airbus> modelListInput,
                                                                     boolean includeTratte) {
        return modelListInput.stream().map(airbusEntity -> {
            AirbusDTO result = AirbusDTO.buildAirbusDTOFromModel(airbusEntity, includeTratte);
            if (includeTratte)
                result.setTratte(TrattaDTO.createTrattaDTOSetFromModelSet(airbusEntity.getTratte(), false));
            return result;
        }).collect(Collectors.toList());
    }

    public static Page<AirbusDTO> fromModelPageToDTOPage(Page<Airbus> input) {
        return new PageImpl<>(createAirbusDTOListFromModelList(input.getContent(), false),
                PageRequest.of(input.getPageable().getPageNumber(), input.getPageable().getPageSize(),
                        input.getPageable().getSort()),
                input.getTotalElements());
    }
}

