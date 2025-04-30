package it.prova.catenadimontaggio;

import it.prova.catenadimontaggio.model.Automobile;
import it.prova.catenadimontaggio.model.SlotCatenaDiMontaggio;
import it.prova.catenadimontaggio.service.CatenaDiMontaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CatenadimontaggioApplication implements CommandLineRunner {

	@Autowired
	private CatenaDiMontaggioService catenaDiMontaggioService;

	public static void main(String[] args) {
		SpringApplication.run(CatenadimontaggioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SlotCatenaDiMontaggio slotCatenaDiMontaggio = catenaDiMontaggioService.findById(1L);

		Automobile automobile = new Automobile(144L, "Panda", "Blu", null);

		catenaDiMontaggioService.aggiungiAutomobile(automobile, slotCatenaDiMontaggio);

		catenaDiMontaggioService.ControlloAuto(slotCatenaDiMontaggio);
	}
}
