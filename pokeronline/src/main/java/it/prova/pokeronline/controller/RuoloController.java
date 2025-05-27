package it.prova.pokeronline.controller;


import it.prova.pokeronline.dto.RuoloDTO;
import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.exception.TavoloNonTrovatoException;
import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.service.abstraction.RuoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ruolo")
public class RuoloController {

    @Autowired
    private RuoloService ruoloService;

    @GetMapping("/{codice}")
    public RuoloDTO findByCodice(@PathVariable(value = "codice", required = true) String codice) {
        Ruolo ruolo = ruoloService.cercaRuolo(codice);


        return RuoloDTO.buildRuoloDTOFromModel(ruolo);
    }
}
