package formation.dta.ebytback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.dta.ebytback.model.Concert;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

}