package formation.dta.ebytback.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.boolex.Matcher;
import formation.dta.ebytback.model.Concert;
import formation.dta.ebytback.repository.ConcertRepository;
import formation.dta.ebytback.service.ConcertService;

@RestController
@RequestMapping("/concert")
public class ConcertController {

	@Autowired
	ConcertService concertService;
	@Autowired
	ConcertRepository concertRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@CrossOrigin(origins = "*")
	@GetMapping("/")
	public Page<Concert> getAll(
			@RequestParam Integer pageNumber, 
			@RequestParam Integer pageSize, 
			@RequestParam(required = false) String artist,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Date date,
			@RequestParam(required = false) String genre, 
			@RequestParam(required = false) String place) {
		
		Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
		
		//List<Concert> recherche = new ArrayList<Concert>();
		
		if ( artist == "" ) {
			//recherche.addAll(concertRepository. (artist) );
			artist = "IS NOT NULL ";
		}
		if ( name == "" ) {
			//recherche.addAll(concertRepository.findAllByName(name) );
			name = "IS NOT NULL ";
		}
		if ( genre == "" ) {
			//recherche.addAll(concertRepository.findAllByGenre(genre) );
			genre = "IS NOT NULL ";
		}
		if ( place == "" ) {
			//recherche.addAll(concertRepository.findAllByPlace(place) );
			place = "IS NOT NULL ";
		}
//		if ( date == null ) {
//			//recherche.addAll(concertRepository.findAllByDate(date.toString()) );
//		}
		
		String sql = "SELECT * FROM Concert WHERE artist = " + artist + " AND genre = " + genre + " AND name = " + name + " AND place = " + place + " ;";
	
//		pageRequest.getSort().and(Sort.by(Sort.Direction.DESC, "date"));
//		Sort sortByDateDesc = new Sort(Sort.Direction.DESC, "date");

		return concertService.findAllOrderByDateDesc(pageRequest);
//		return concertService.findAll(pageRequest, sortByDateDesc);
	}
	
	
	

	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public void deleteById(@PathParam("id") Long id) {
		concertService.deleteConcert(id);
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@CrossOrigin(origins = "*")
	@PostMapping("/")
	public Concert createConcert( @RequestBody Concert concert) {
		return concertRepository.save(concert);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	@CrossOrigin(origins = "*")
//	@PutMapping("/")
//	public Concert update(Concert concert) {
//		return concertRepository.save(concert);
//	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public  Optional<Concert> getById( @PathParam ("id") @Valid Long id) {
		return concertRepository.findById(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public List<Concert> getAll() {
		return concertService.findAll();
	}
}