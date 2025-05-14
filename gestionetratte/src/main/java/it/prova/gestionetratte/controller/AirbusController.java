package it.prova.gestionetratte.controller;

import it.prova.gestionetratte.dto.AirbusDTO;
import it.prova.gestionetratte.exception.AirbusConIdNonEsistenteException;
import it.prova.gestionetratte.exception.IdNotNullForInsertException;
import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.service.AirbusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airbus")
public class AirbusController {

    @Autowired
    private AirbusService airbusService;

    @GetMapping
    public List<AirbusDTO> getAll() {
        // senza DTO qui hibernate dava il problema del N + 1 SELECT
        // (probabilmente dovuto alle librerie che serializzano in JSON)
        return AirbusDTO.createAirbusDTOListFromModelList(airbusService.listAllElementsEager(true), true);
    }

    @GetMapping("/{id}")
    public AirbusDTO findById(@PathVariable(value = "id", required = true) long id) {
        Airbus airbus = airbusService.caricaSingoloElementoEager(id);

        if (airbus == null)
            throw new AirbusConIdNonEsistenteException("Airbus not found con id: " + id);

        return AirbusDTO.buildAirbusDTOFromModel(airbus, true);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirbusDTO createNew(@Valid @RequestBody AirbusDTO airbusInput) {

        if (airbusInput.getId() != null)
            throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");

        Airbus airbusInserito = airbusService.inserisciNuovo(airbusInput.buildAirbusModel());
        return AirbusDTO.buildAirbusDTOFromModel(airbusInserito, false);
    }

    @PutMapping("/{id}")
    public AirbusDTO update(@Valid @RequestBody AirbusDTO airbusInput, @PathVariable(required = true) Long id) {
        Airbus regista = airbusService.caricaSingoloElemento(id);

        if (regista == null)
            throw new AirbusConIdNonEsistenteException("Regista not found con id: " + id);

        airbusInput.setId(id);
        Airbus airbusAggiornato = airbusService.aggiorna(airbusInput.buildAirbusModel());
        return AirbusDTO.buildAirbusDTOFromModel(airbusAggiornato, false);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(required = true) Long id) {
        airbusService.rimuovi(id);
    }
    @GetMapping("/trovaAirbusConSovrapposizioni")
    public List<AirbusDTO> trovaAirbusConSovrapposizioni() {
        return airbusService.trovaTuttiConSovrapposizioni();
    }

}
