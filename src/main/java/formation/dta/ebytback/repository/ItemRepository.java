package formation.dta.ebytback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.dta.ebytback.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

	
}
