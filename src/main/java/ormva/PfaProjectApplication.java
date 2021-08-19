package ormva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ormva.service.IOrmvaService;

@SpringBootApplication
public class PfaProjectApplication implements CommandLineRunner {

	@Autowired IOrmvaService ormvaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PfaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ormvaService.initRole();
		ormvaService.initAntenne();
		ormvaService.initAgriculteur();
		ormvaService.initCda();
		ormvaService.initEmplacement();
		ormvaService.initEtape();
		ormvaService.initRubrique();
		ormvaService.initSousRubrique();
		//ormvaService.initDossier();
		//ormvaService.initNote();
	}

}
