package ormva.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ormva.Auth.User;
import ormva.dto.UserRegistrationDto;
import ormva.entities.Dossier;
import ormva.service.IService;

@RestController
@CrossOrigin("*")
public class DossierController {
	
	
	@Autowired IService<Dossier> service;
	
	@PostMapping("/addDossier")
	public Dossier addDossier(@RequestBody Dossier dossier,HttpServletRequest request)
	{
		Object principal = request.getUserPrincipal();
		 return service.add(dossier,(Principal) principal);
		
		
		
	}
	
	@PutMapping("/updateDossier/{id}")
	public Dossier updateDossier(@RequestBody Dossier dossier,HttpServletRequest request, @PathVariable Long id)
	{
		return service.update(dossier, id, null);
	}
	
	@DeleteMapping("/deleteDossier/{id}")
	public void deleteDossier(@PathVariable Long id,HttpServletRequest request)
	{
		service.delete(id, null);
	}

	@PostMapping("/envoyerDossier/{id}")
	public Dossier envoyerDossier(HttpServletRequest request, @PathVariable Long id)
	{
		Principal principal = request.getUserPrincipal();
		return service.envoyer(id, principal, null);
	}
	
}
