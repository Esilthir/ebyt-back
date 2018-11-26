package formation.dta.ebytback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.dta.ebytback.exception.ResourceNotFoundException;
import formation.dta.ebytback.model.Commande;
import formation.dta.ebytback.model.Item;
import formation.dta.ebytback.repository.CommandeRepository;

@Service
public class CommandeService {

	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	ItemService itemService;
	
	public Commande createCommande(Commande commande) {
		for(Item item : commande.getItemCommande()) {			
			itemService.createItem(item);
		}
		return commandeRepository.save(commande);
	}
	
	public Commande getCommandeById (Long id) {
		Optional<Commande> oCommande = commandeRepository.findById(id);
		if(oCommande.isPresent()) {
			return oCommande.get();
		}
		ResourceNotFoundException exceptionNotFound = new ResourceNotFoundException("La commande " + id + " n'a pas été trouvée");
		throw exceptionNotFound;
	}
	
	public List<Commande> getAll() {
		return commandeRepository.findAll();
	}
	
	public Commande updateCommande(Commande commande) {
		return null;
	}
	
	public void deleteCommande(Long id) {
		Commande commandeADelete = this.getCommandeById(id);
		for(Item item : commandeADelete.getItemCommande()) {
			itemService.deleteItem(item.getId());
		}
		commandeRepository.deleteById(id);
	}
	
}
