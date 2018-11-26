package formation.dta.ebytback.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation.dta.ebytback.model.Commande;
import formation.dta.ebytback.model.Item;
import formation.dta.ebytback.service.CommandeService;
import formation.dta.ebytback.service.ItemService;

@RestController
@RequestMapping("/commande")
public class CommandeController {

	@Autowired
	CommandeService commandeService;
	
	

	@CrossOrigin(origins = "*")
	@PostMapping("/")
	public Commande createCommande(@RequestBody @Valid Commande commande) {
		return commandeService.createCommande(commande);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public void deleteCommandeById(@PathVariable("id") Long id) {
		commandeService.deleteCommande(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")

	public Commande getCommande(@PathVariable("id") Long id) {
		return commandeService.getCommandeById(id);
	}
	

	@CrossOrigin(origins = "*")
	@GetMapping("/")
	public List<Commande> getAll() {
		return commandeService.getAll();
	}
	
	@CrossOrigin(origins="*")
	@PutMapping("/{id}")
	public Commande updateCommande(@RequestBody @Valid Commande commande) {
		return commandeService.updateCommande(commande);
	}
}
