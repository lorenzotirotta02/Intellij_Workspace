package it.prova.gestioneedifici;

import it.prova.gestioneedifici.service.BatteriaTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestioneedificiApplication implements CommandLineRunner {

	@Autowired
	private BatteriaTestService batteriaDiTestService;

	public static void main(String[] args) {
		SpringApplication.run(GestioneedificiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//batteriaDiTestService.testInserimentoEdificio();
    	batteriaDiTestService.testInserimentoInquilino();
	//	batteriaDiTestService.testOttieniMappaInversa();
	}
}
