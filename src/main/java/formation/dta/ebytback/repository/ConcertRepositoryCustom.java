package formation.dta.ebytback.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import formation.dta.ebytback.model.Concert;

public interface ConcertRepositoryCustom {

	public List<Concert> search(String genre, String name, String artist, LocalDate date, String place, Double price, boolean active);
	
	
	
}
