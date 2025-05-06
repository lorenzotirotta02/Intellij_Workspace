package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.service.abstraction.DipendenteService;
import it.prova.gestionesocieta.service.abstraction.ProgettoService;
import it.prova.gestionesocieta.service.abstraction.SocietaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatteriaTestService {
    @Autowired
    private SocietaService societaService;
    @Autowired
    private ProgettoService progettoService;
    @Autowired
    private DipendenteService dipendenteService;

    public void testInserisciNuovoSocieta(){
        System.out.println("testInserisciNuovoSocieta in esecuzione...");

        Societa societaDaInserire = new Societa("Societa Test", "Via Roma", LocalDate.of(1990, 3, 20), LocalDate.of(2030, 4, 15));

        societaService.aggiungiSocieta(societaDaInserire);
        if (societaDaInserire.getId() == null || societaDaInserire.getId() < 1) {
            throw new RuntimeException("testInserisciNuovoSocieta...failed: transient object con id valorizzato");
        }
        System.out.println("testInserisciNuovoSocieta........OK");
    }

    public void testInserisciNuovoDipendente(){
        System.out.println("testInserisciNuovoDipendente in esecuzione...");

        Optional<Societa> societa = societaService.trovaSocietaPerId(1L);

        Dipendente dipendente = new Dipendente("Mario", "Rossi", LocalDate.of(2020, 11, 2), 35700);
        dipendente.setSocieta(societa.get());
        dipendenteService.aggiungiDipendente(dipendente);
        if (dipendente.getId() == null || dipendente.getId() < 1) {
            throw new RuntimeException("testInserisciNuovoDipendente...failed: transient object con id valorizzato");
        }

        System.out.println("testInserisciNuovoDipendente........OK");
    }

    public void testRimozioneSocietà(){
        System.out.println("testRimozioneSocietà in esecuzione...");
        Optional<Societa> societa = societaService.trovaSocietaPerId(1L);

        societaService.eliminaSocieta(societa.get().getId());
        if (societa.get().getId() != null) {
            throw new RuntimeException("testRimozioneSocietà...failed: oggetto non rimosso");
        }

        System.out.println("testRimozioneSocietà........OK");
    }

    public void testInserimentoProgetto(){
        System.out.println("testInserimentoProgetto in esecuzione...");


        Progetto progetto = new Progetto("Progetto Test", "Mario Rossi", 9);
        progettoService.aggiungiProgetto(progetto);
        if (progetto.getId() == null || progetto.getId() < 1) {
            throw new RuntimeException("testInserimentoProgetto...failed: transient object con id valorizzato");
        }

        System.out.println("testInserimentoProgetto........OK");
    }

    public void testAggiuntaDipendenteAProgetti(){
        System.out.println("testAggiuntaDipendenteAProgetto in esecuzione...");

        Optional<Societa> societa = societaService.trovaSocietaPerId(2L);
        Dipendente dipendente = new Dipendente("Mario", "Rossi", LocalDate.of(2020, 11, 2), 35700);
        dipendente.setSocieta(societa.get());
        dipendenteService.aggiungiDipendente(dipendente);
        Progetto progetto = new Progetto("Progetto Test", "Mario Rossi", 5);
        progettoService.aggiungiProgetto(progetto);
        Progetto progetto2 = new Progetto("Progetto Test2", "Mario Rossi", 6);
        progettoService.aggiungiProgetto(progetto2);
        List<Progetto> progetti = new ArrayList<>();
        progetti.add(progetto);
        progetti.add(progetto2);

        dipendenteService.aggiungiProgetti(dipendente, progetti);
        if (dipendente.getProgetti().contains(progetto)) {
            System.out.println("testAggiuntaDipendenteAProgetto........OK");
        } else {
            throw new RuntimeException("testAggiuntaDipendenteAProgetto...failed: oggetto non trovato");
        }
    }

    public void testAggiuntaDipendentiAProgetto(){
        System.out.println("testAggiuntaDipendentiAProgetto in esecuzione...");

        Optional<Societa> societa = societaService.trovaSocietaPerId(2L);
        Dipendente dipendente = new Dipendente("Mario", "Rossi", LocalDate.of(2020, 11, 2), 35700);
        dipendente.setSocieta(societa.get());
        dipendenteService.aggiungiDipendente(dipendente);
        Dipendente dipendente1 = new Dipendente("Luigi", "Verdi", LocalDate.of(2020, 11, 2), 35700);
        dipendente1.setSocieta(societa.get());
        dipendenteService.aggiungiDipendente(dipendente1);

        Progetto progetto = new Progetto("Progetto Test", "Mario Rossi", 5);
        progettoService.aggiungiProgetto(progetto);
        List<Dipendente> dipendenti = new ArrayList<>();
        dipendenti.add(dipendente);
        dipendenti.add(dipendente1);

        progettoService.aggiungiDipendentiAProgetto(progetto, dipendenti);
        System.out.println(progetto);

        if (progetto.getDipendenti().contains(dipendente) && progetto.getDipendenti().contains(dipendente1)) {
            System.out.println("testAggiuntaDipendentiAProgetto........OK");
        } else {
            throw new RuntimeException("testAggiuntaDipendentiAProgetto...failed: oggetto non trovato");
        }

    }

    public void testTrovaClientiPerSocietaId(){
        System.out.println("testTrovaClientiPerSocietaId in esecuzione...");

        Optional<Societa> societa1 = societaService.trovaSocietaPerId(2L);
        List<String> clienti = societaService.trovaTuttiIClientiPerSocieta(societa1.get().getId());

        if (!clienti.isEmpty()) {
            System.out.println("testTrovaClientiPerSocietaId........OK");
            for (String cliente : clienti) {
                System.out.println(cliente);
            }
        } else {
            throw new RuntimeException("testTrovaClientiPerSocietaId...failed: oggetto non trovato");
        }
    }

    public void testTrovaTuttiINomeSocietaConProgettiDurataMaggioreDiUnAnno(){
        System.out.println("testTrovaTuttiINomeSocietaConProgettiDurataMaggioreDiUnAnnoById in esecuzione...");

        Optional<Societa> societa = societaService.trovaSocietaPerId(2L);
        Dipendente dipendente = new Dipendente("Mario", "Rossi", LocalDate.of(2020, 11, 2), 35700);
        dipendente.setSocieta(societa.get());
        dipendenteService.aggiungiDipendente(dipendente);
        Dipendente dipendente1 = new Dipendente("Luigi", "Verdi", LocalDate.of(2020, 11, 2), 35700);
        dipendente1.setSocieta(societa.get());
        dipendenteService.aggiungiDipendente(dipendente1);

        Progetto progetto = new Progetto("Progetto Test", "Mario Rossi", 15);
        progettoService.aggiungiProgetto(progetto);
        List<Dipendente> dipendenti = new ArrayList<>();
        dipendenti.add(dipendente);
        dipendenti.add(dipendente1);

        progettoService.aggiungiDipendentiAProgetto(progetto, dipendenti);

        List<String> societas = societaService.trovaTuttiINomeSocietaConProgettiDurataMaggioreDiUnAnno();


        if (societas.isEmpty()) {
            System.out.println("La societa non ha progetti con durata maggiore di un anno");
        }else{
            for (String nomeSocieta : societas) {
                System.out.println(nomeSocieta);
            }
            System.out.println("testTrovaTuttiINomeSocietaConProgettiDurataMaggioreDiUnAnnoById........OK");
        }if (societas == null){
            throw new RuntimeException("testTrovaTuttiINomeSocietaConProgettiDurataMaggioreDiUnAnnoById...failed: oggetto non trovato");

        }
    }
    public void testTrovaTuttiIDipendentiConDataAssunzionePrimaDiDataFondazione(){
        System.out.println("testTrovaTuttiIDipendentiConDataAssunzionePrimaDiDataFondazione in esecuzione...");

        Societa societa = new Societa("Societa Test456", "Via Roma", LocalDate.of(2540, 3, 20), LocalDate.of(2030, 4, 15));
        societaService.aggiungiSocieta(societa);
        Dipendente dipendente = new Dipendente("Mario", "Rossi", LocalDate.of(2040, 11, 2), 35700);
        dipendente.setSocieta(societa);
        dipendenteService.aggiungiDipendente(dipendente);
        Dipendente dipendente1 = new Dipendente("Luigi", "Verdi", LocalDate.of(2050, 11, 2), 35700);
        dipendente1.setSocieta(societa);
        dipendenteService.aggiungiDipendente(dipendente1);

        List<Societa> societaList = societaService.trovaTuttiIDipendentiConDataAssunzioneDopoDataFondazione();

        if (societaList.isEmpty()) {
            throw new RuntimeException("La societa non ha dipendenti con data assunzione prima della data di fondazione");
        }else{
            for (Societa nomeSocieta : societaList) {
                System.out.println(nomeSocieta);
            }
            System.out.println("testTrovaTuttiIDipendentiConDataAssunzionePrimaDiDataFondazione........OK");
        }
        if (societaList == null){
            throw new RuntimeException("testTrovaTuttiIDipendentiConDataAssunzionePrimaDiDataFondazione...failed: oggetto non trovato");
        }
    }
    public void testTrovaTuttiIProgettiConRedditoMaggioreDi(){
        System.out.println("testTrovaTuttiIDipendentiConRedditoMaggioreDi in esecuzione...");

        List<Progetto> progetti = progettoService.trovaTuttiIProgettiConRedditoAnnualeLordoMaggioreDi(35000);

        if (progetti == null || progetti.isEmpty()) {
            throw new RuntimeException("Nessun progetto trovato!");
        }else{
            for (Progetto progetto : progetti) {
                System.out.println(progetto);
            }
            System.out.println("testTrovaTuttiIDipendentiConRedditoMaggioreDi........OK");
        }
    }
    public void testTrovaTuttiProgettiConDipendentiDiSocietaChiusa(){
        System.out.println("testTrovaTuttiProgettiConDipendentiDiSocietaChiusa in esecuzione...");

        List<Progetto> progettos = progettoService.trovaTuttiIProgettiConDipendentiDiSocietaChiusa();

        if (progettos.isEmpty()) {
            throw new RuntimeException("I progetti non hanno dipendenti di societa' chiusa");
        }else{
            for (Progetto progetto : progettos) {
                System.out.println(progetto);
            }
            System.out.println("testTrovaTuttiProgettiConDipendentiDiSocietaChiusa........OK");
        }
        if (progettos == null){
            throw new RuntimeException("testTrovaTuttiProgettiConDipendentiDiSocietaChiusa...failed: oggetto non trovato");
        }
    }
    public void testTrovaDipendenteConDataAssunzionePrimaDiDataFondazioneEDurataProgettoMaggioreDi(){
        System.out.println("testTrovaDipendenteConDataAssunzionePrimaDiDataFondazioneEDurataProgettoMaggioreDi in esecuzione...");

        Optional<Societa> societa = societaService.trovaSocietaPerId(4L);
        Dipendente dipendente = new Dipendente("Mario", "Rossi", LocalDate.of(2020, 11, 2), 35700);
        dipendente.setSocieta(societa.get());
        dipendenteService.aggiungiDipendente(dipendente);
        Dipendente dipendente1 = new Dipendente("Luigi", "Verdi", LocalDate.of(2020, 11, 2), 35700);
        dipendente1.setSocieta(societa.get());
        dipendenteService.aggiungiDipendente(dipendente1);

        Progetto progetto = new Progetto("Progetto Test", "Mario Rossi", 15);
        progettoService.aggiungiProgetto(progetto);
        List<Dipendente> dipendenti = new ArrayList<>();
        dipendenti.add(dipendente);
        dipendenti.add(dipendente1);

        progettoService.aggiungiDipendentiAProgetto(progetto, dipendenti);

        Dipendente dipendentiTrovati = dipendenteService.trovaDipendentePerDataAssunzionePrimaDiDataFondazioneEDurataProgettoMaggioreDi(societa.get().getDataFondazione(), progetto.getDurataInMesi());

        if (dipendentiTrovati == null) {
            throw new RuntimeException("Nessun dipendente trovato!");
        }else{
            System.out.println(dipendentiTrovati);
            System.out.println("testTrovaDipendenteConDataAssunzionePrimaDiDataFondazioneEDurataProgettoMaggioreDi........OK");
        }
    }
}
