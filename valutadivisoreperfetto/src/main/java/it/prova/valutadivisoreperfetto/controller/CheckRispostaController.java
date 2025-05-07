package it.prova.valutadivisoreperfetto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckRispostaController {

    // Metodo per mostrare la pagina principale del questionario
    @GetMapping("/")
    public String mostraHome() {
        return "home";
    }

    // Metodo per gestire la risposta inviata dall'utente
    @PostMapping("/verificaNumero")
    public String valuta(@RequestParam("dividendo") int dividendo, @RequestParam("divisore") int divisore,
            Model model) {
        if (dividendo % divisore == 0) {
            int quoziente = dividendo / divisore;
            model.addAttribute("dividendo", dividendo);
            model.addAttribute("divisore", divisore);
            model.addAttribute("quoziente", quoziente);
            return "multiplo";
        } else {
            int resto = dividendo % divisore;
            model.addAttribute("dividendo", dividendo);
            model.addAttribute("divisore", divisore);
            model.addAttribute("resto", resto);
            return "divisioneconresto";
        }
    }
}

