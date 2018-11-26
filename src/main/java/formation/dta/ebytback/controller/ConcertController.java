package formation.dta.ebytback.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import formation.dta.ebytback.exception.DeleteException;
import formation.dta.ebytback.exception.ResourceNotFoundException;
import formation.dta.ebytback.model.Concert;
import formation.dta.ebytback.model.EnumGenres;
import formation.dta.ebytback.repository.ConcertRepository;
import formation.dta.ebytback.repository.ConcertRepositoryImpl;
import formation.dta.ebytback.service.ConcertService;

@RestController
@RequestMapping("/concert")
public class ConcertController {

	@Autowired
	ConcertService concertService;
	@Autowired
	ConcertRepository concertRepository;
	@Autowired
	ConcertRepositoryImpl concertRepositoryCustom;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	Concert concert = new Concert();

	@CrossOrigin(origins = "*")
	@GetMapping("/")
	public Page<Concert> getAll(@RequestParam Integer pageNumber, @RequestParam Integer pageSize,
			@RequestParam(required = false) String artist, @RequestParam(required = false) String name,
			@RequestParam(required = false) LocalDate date, @RequestParam(required = false) String genre,
			@RequestParam(required = false) String place) {

		Pageable pageRequest = PageRequest.of(pageNumber, pageSize);

		// List<Concert> recherche = new ArrayList<Concert>();

		if (artist == "") {
			// recherche.addAll(concertRepository. (artist) );
			artist = "IS NOT NULL ";
		}
		if (name == "") {
			// recherche.addAll(concertRepository.findAllByName(name) );
			name = "IS NOT NULL ";
		}
		if (genre == "") {
			// recherche.addAll(concertRepository.findAllByGenre(genre) );
			genre = "IS NOT NULL ";
		}
		if (place == "") {
			// recherche.addAll(concertRepository.findAllByPlace(place) );
			place = "IS NOT NULL ";
		}
//		if ( date == null ) {
//			//recherche.addAll(concertRepository.findAllByDate(date.toString()) );
//		}

		String sql = "SELECT * FROM Concert WHERE artist = " + artist + " AND genre = " + genre + " AND name = " + name
				+ " AND place = " + place + " ;";

//		pageRequest.getSort().and(Sort.by(Sort.Direction.DESC, "date"));
//		Sort sortByDateDesc = new Sort(Sort.Direction.DESC, "date");

		return concertService.findAllOrderByDateDesc(pageRequest);
//		return concertService.findAll(pageRequest, sortByDateDesc);
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@CrossOrigin(origins = "*")
	@PostMapping("/")
	public Concert createConcert(@RequestBody Concert concert) {
		return concertRepository.save(concert);
	}

	
	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public Concert update(@PathVariable("id")Long id, @RequestBody Concert concert) {
		Optional<Concert> oConcert = concertService.getById(id);
		if (oConcert.isPresent()) {
			return concertService.updateConcert(oConcert, concert);
		}
		ResourceNotFoundException exceptionNotFound = new ResourceNotFoundException("Le concert " + id + " n'a pas été trouvé");
		throw exceptionNotFound;
		

	}

	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Concert getById(@PathVariable("id") Long id) {
		Optional<Concert> oConcert = concertService.getById(id);
		if(oConcert.isPresent()) {
			return oConcert.get();
		}
		ResourceNotFoundException exceptionNotFound = new ResourceNotFoundException("Le concert " + id + " n'a pas été trouvé");
		throw exceptionNotFound;
		
	}

	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public void deleteConcert(@PathVariable("id") Long id) {
		// si des réservations ont déjà été faites sur le concert, renvoie un message
		Optional<Concert> oConcert = concertService.getById(id);
		if(oConcert.isPresent()) {
			concert = oConcert.get();
			if (concert.getNbBoughtPlace() == null || concert.getNbBoughtPlace() == 0) {
				concertRepository.deleteById(id);
				return;
			}
			DeleteException exceptionDelete = new DeleteException();
			throw exceptionDelete;
		}
		ResourceNotFoundException exceptionNotFound = new ResourceNotFoundException("Le concert " + id + " n'a pas été trouvé");
		throw exceptionNotFound;

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public List<Concert> getAll() {
		return concertService.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/fame")
	public List<Concert> getFameConcerts() {
		List<Concert> allConcert =  concertService.findAllByOrderByIdAsc();
		List<Concert> concertFame = new ArrayList<Concert>();
		for (Concert concert : allConcert) {
			concertFame.add(concert);
			if ( concert.getId() == 4 ) {
				break;
			}
		}
		return concertFame;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/last")
	public List<Concert> getLastConcerts() {
		return concertService.findTop12ByOrderByIdDesc();
//		List<Concert> concertLast = new ArrayList<Concert>();
//		for (Concert concert : allConcert) {
//			concertLast.add(concert);
//			if (concertLast.size() == 12) {
//				break;
//			}
//		}
//		return concertLast;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/getAll")
	public List<Concert> getConcerts(
			@RequestParam(required = false) String genre,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String artist,
			@RequestParam(required = false) String place,
			@RequestParam(required = false) Double priceMax,
			@RequestParam(required = false) boolean active
			) {
		return concertRepositoryCustom.search(genre, name, artist, place, priceMax, active);

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getAllAdmin")
	public List<Concert> getConcertsAdmin(
			@RequestParam(required = false) String genre,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String artist,
			@RequestParam(required = false) String place,
			@RequestParam(required = false) Double priceMax,
			@RequestParam(required = false) boolean active
			) {
		return concertRepositoryCustom.searchAdmin(genre, name, artist, place, priceMax, active);

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/count")
	public long countConcerts() {
		return concertRepository.count();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/stocker/")
    public void stocker(@RequestParam MultipartFile file) {
		try {
			this.concertService.sauvegarderImage(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping("/allGenres")
    public List<String> allGenres()
	{
		return EnumGenres.getAllGenres();
    }
}