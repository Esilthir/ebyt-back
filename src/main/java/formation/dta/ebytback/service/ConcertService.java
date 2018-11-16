package formation.dta.ebytback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import formation.dta.ebytback.model.Concert;
import formation.dta.ebytback.repository.ConcertRepository;

@Service
public class ConcertService {
	
	@Autowired
	private ConcertRepository concertRepository;
	
	public Page<Concert> findAll(Pageable pageRequest) {
		return concertRepository.findAll(pageRequest);
	}
	
	public Page<Concert> findAllOrderByDateDesc(Pageable pageRequest) {
		return concertRepository.findAllByOrderByDateDesc(pageRequest);
	}
	public List<Concert> findAllByName( String name) {
		return concertRepository.findAllByName(name);
	}
	public List<Concert> findAllByArtist( String artist) {
		return concertRepository.findAllByName(artist);
	}
	public List<Concert> findAllByGenre( String genre) {
		return concertRepository.findAllByName(genre);
	}
	public List<Concert> findAllByDate( String date) {
		return concertRepository.findAllByName(date);
	}
	public List<Concert> findAllByPlace( String place) {
		return concertRepository.findAllByName(place);
	}
	
}
