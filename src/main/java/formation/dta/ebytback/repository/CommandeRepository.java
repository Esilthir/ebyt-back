package formation.dta.ebytback.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.dta.ebytback.model.Commande;
import formation.dta.ebytback.model.User;

@Repository
@Transactional
public interface CommandeRepository extends JpaRepository<Commande, Long> {

	public List<Commande> findAllByUser(User user);

}
