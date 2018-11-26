package formation.dta.ebytback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.dta.ebytback.exception.ResourceNotFoundException;
import formation.dta.ebytback.model.Commande;
import formation.dta.ebytback.model.Item;
import formation.dta.ebytback.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public Item createItem(Item item) {
		return itemRepository.save(item);
	}
	
	public Item getItemById (Long id) {
		Optional<Item> oCommande = itemRepository.findById(id);
		if(oCommande.isPresent()) {
			return oCommande.get();
		}
		ResourceNotFoundException exceptionNotFound = new ResourceNotFoundException("L'item " + id + " n'a pas été trouvé");
		throw exceptionNotFound;
	}
	
	public List<Item> getAll() {
		return itemRepository.findAll();
	}
	
	public Item updateItem(Commande commande) {
		return null;
	}
	
	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}
	
}
