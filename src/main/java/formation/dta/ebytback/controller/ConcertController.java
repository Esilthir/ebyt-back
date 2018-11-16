package formation.dta.ebytback.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
			@RequestParam Integer pageSize) {
		Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
		
//		pageRequest.getSort().and(Sort.by(Sort.Direction.DESC, "date"));
//		Sort sortByDateDesc = new Sort(Sort.Direction.DESC, "date");

		return concertService.findAllOrderByDateDesc(pageRequest);
//		return concertService.findAll(pageRequest, sortByDateDesc);
	}
	
	 
	
	
	
//	@CrossOrigin(origins = "*")
//	@GetMapping("/{size}/{size2}")
//	public List<Concert> getAllPagination( @PathParam ("size") @Valid Long taille1, @PathParam ("size2") @Valid Long taille2 ) {
//		
//		//Sort desc = new Sort(Sort.Direction.DESC, "id");
//		
//		return concertRepository.findAll( desc );
//	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	@CrossOrigin(origins = "*")
//	@DeleteMapping("/{id}")
//	public void deleteById(long id) {
//	}
	
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
//	@CrossOrigin(origins = "*")
//	@GetMapping("/{id}")
//	public  Optional<Concert> getById( @PathParam ("id") @Valid Long id) {
//		return concertRepository.findById(id);
//	}
	
}