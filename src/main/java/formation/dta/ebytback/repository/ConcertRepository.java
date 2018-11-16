package formation.dta.ebytback.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import formation.dta.ebytback.model.Concert;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
	
	List<Concert> findAll();

	Page<Concert> findAll(Pageable pageRequest);
	
	Page<Concert> findAllByOrderByDateDesc(Pageable pageRequest);
}