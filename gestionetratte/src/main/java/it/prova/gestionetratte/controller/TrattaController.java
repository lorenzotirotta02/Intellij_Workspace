package it.prova.gestionetratte.controller;

import it.prova.gestionetratte.dto.TrattaDTO;
import it.prova.gestionetratte.exception.IdNotNullForInsertException;
import it.prova.gestionetratte.exception.TrattaConIdNonEsistenteException;
import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.service.TrattaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tratta")
public class TrattaController {

    @Autowired
    private TrattaService trattaService;

    @GetMapping
    public List<TrattaDTO> getAll() {
        return TrattaDTO.createTrattaDTOListFromModelList(trattaService.listAllElements(true), true);
    }

    // gli errori di validazione vengono mostrati con 400 Bad Request ma
    // elencandoli grazie al ControllerAdvice
    @PostMapping
    public TrattaDTO createNew(@Valid @RequestBody TrattaDTO trattaInput) {
        // se mi viene inviato un id jpa lo interpreta come update ed a me (producer)
        // non sta bene
        if (trattaInput.getId() != null)
            throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");

        Tratta trattaInserito = trattaService.inserisciNuovo(trattaInput.buildTrattaModel());
        return TrattaDTO.buildTrattaDTOFromModel(trattaInserito, true);
    }

    @GetMapping("/{id}")
    public TrattaDTO findById(@PathVariable(value = "id", required = true) long id) {
        Tratta tratta = trattaService.caricaSingoloElementoEager(id);

        if (tratta == null)
            throw new TrattaConIdNonEsistenteException("Tratta not found con id: " + id);

        return TrattaDTO.buildTrattaDTOFromModel(tratta, true);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(required = true) Long id) {
        trattaService.rimuovi(id);
    }
}
