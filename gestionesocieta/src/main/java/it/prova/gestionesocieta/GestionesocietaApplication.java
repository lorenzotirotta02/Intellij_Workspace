package it.prova.gestionesocieta;

import it.prova.gestionesocieta.service.BatteriaTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionesocietaApplication implements CommandLineRunner {
	@Autowired
	private BatteriaTestService batteriaDiTestService;

	public static void main(String[] args) {
		SpringApplication.run(GestionesocietaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("################ START   #################");
		System.out.println("################ eseguo i test  #################");

		//batteriaDiTestService.testInserisciNuovoSocieta();
		//batteriaDiTestService.testInserisciNuovoDipendente();
		//batteriaDiTestService.testRimozioneSocietà();
//		batteriaDiTestService.testInserimentoProgetti();
		//batteriaDiTestService.testAggiuntaDipendenteAProgetto();
		//batteriaDiTestService.testAggiuntaDipendentiAProgetto();
		//batteriaDiTestService.testTrovaClientiPerSocietaId();
		//batteriaDiTestService.testTrovaTuttiINomeSocietaConProgettiDurataMaggioreDiUnAnno();
		//batteriaDiTestService.testTrovaTuttiIDipendentiConDataAssunzionePrimaDiDataFondazione();
		//batteriaDiTestService.testTrovaTuttiIProgettiConRedditoMaggioreDi();
		//batteriaDiTestService.testTrovaTuttiProgettiConDipendentiDiSocietaChiusa();
		batteriaDiTestService.testTrovaDipendenteConDataAssunzionePrimaDiDataFondazioneEDurataProgettoMaggioreDi();
	}
}
