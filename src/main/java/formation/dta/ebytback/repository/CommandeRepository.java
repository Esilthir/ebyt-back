package formation.dta.ebytback.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.dta.ebytback.model.Commande;

@Repository
@Transactional
public interface CommandeRepository extends JpaRepository<Commande, Long> {

	
	
}
