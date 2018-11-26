package formation.dta.ebytback.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;


import formation.dta.ebytback.model.Concert;
import formation.dta.ebytback.repository.ConcertRepository;

@Service
public class ConcertService {
	
	@Autowired
	private ConcertRepository concertRepository;
	
	public Page<Concert> findAll(Pageable pageRequest) {
		return concertRepository.findAll(pageRequest);
	}
	
	public List<Concert> findAll() {
		return concertRepository.findAll();
	}
	
	public Page<Concert> findAllOrderByDateDesc(Pageable pageRequest) {
		return concertRepository.findAllByOrderByDateDesc(pageRequest);
	}
	
	public List<Concert> findAllByOrderByIdAsc() {
		return concertRepository.findAllByOrderByIdAsc();
	}
	
	public List<Concert> findAllByOrderByIdDesc() {
		return concertRepository.findAllByOrderByIdDesc();
	}
	
	public List<Concert> findTop12ByOrderByIdDesc() {
		return concertRepository.findTop12ByOrderByIdDesc();
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
	
	public void deleteConcert(Long id) {
		concertRepository.deleteById(id);
	}
	
	public Optional<Concert> getById(@PathParam("id") Long id) {
		return concertRepository.findById(id);
	}
	
	public Concert updateConcert(Optional<Concert> oConcert, Concert concert) {
		oConcert.get().setName(concert.getName());
		oConcert.get().setArtist(concert.getArtist());
		oConcert.get().setDate(concert.getDate());
		oConcert.get().setPlace(concert.getPlace());
		oConcert.get().setGenre(concert.getGenre());
		oConcert.get().setDescription(concert.getDescription());
		oConcert.get().setNbMaxPlaces(concert.getNbMaxPlaces());
		oConcert.get().setPrice(concert.getPrice());
		oConcert.get().setNbBoughtPlace(concert.getNbBoughtPlace());
		oConcert.get().setActive(concert.isActive());
		oConcert.get().setUrlVideo(concert.getUrlVideo());
		
		Concert updateConcert = concertRepository.save(oConcert.get());
		return updateConcert;
	}
	
	public boolean sauvegarderImage(MultipartFile f) throws IOException
	{
		FileOutputStream sortie = null;
		try 
		{
			File file = new File("/" + f.getOriginalFilename());
			sortie = new FileOutputStream(file);
			sortie.write(f.getBytes());
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			sortie.close();
		}
		return false;
	}

	
	public Concert createConcert(Concert concert) {
		return concertRepository.save(concert);
	}
	
	public void addImage(MultipartFile file, Long id, String type) {
		if(type.equalsIgnoreCase("imgCarre")) {
			System.out.println("imgCarre");
			System.out.println(file);
		}
		else if(type.equalsIgnoreCase("imgCarre")){
			System.out.println("imgRec");
			System.out.println(file);
		}
	}
}
