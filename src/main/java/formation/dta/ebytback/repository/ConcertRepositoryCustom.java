package formation.dta.ebytback.repository;

import java.util.List;
import formation.dta.ebytback.model.Concert;

public interface ConcertRepositoryCustom {

	public List<Concert> search(String genre, String name, String artist, String place, Double priceMax, boolean active);

	public List<Concert> searchAdmin(String genre, String name, String artist, String place, Double priceMax,
			boolean active);
	
	
	
}
