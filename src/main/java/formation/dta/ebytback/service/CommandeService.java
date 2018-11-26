package formation.dta.ebytback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import formation.dta.ebytback.exception.ResourceNotFoundException;
import formation.dta.ebytback.model.Commande;
import formation.dta.ebytback.repository.CommandeRepository;

public class CommandeService {

	@Autowired
	CommandeRepository commandeRepository;
	
	public Commande createCommande(Commande commande) {
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
		commandeRepository.deleteById(id);
	}
	
}
