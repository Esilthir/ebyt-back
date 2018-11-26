package formation.dta.ebytback.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import formation.dta.ebytback.model.Concert;

public interface ConcertRepositoryCustom {

	public List<Concert> search(String genre, String name, String artist, String date, String place, Double priceMax, boolean active);

	public List<Concert> searchAdmin(String genre, String name, String artist, String date, String place, Double priceMax,
			boolean active);
	
	
	
}
