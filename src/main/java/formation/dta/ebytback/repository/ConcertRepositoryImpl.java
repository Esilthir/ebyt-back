package formation.dta.ebytback.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.util.StringUtils;

import formation.dta.ebytback.model.Concert;

public class ConcertRepositoryImpl implements ConcertRepositoryCustom {

	private EntityManager em;
	
	@Autowired
	public void setJpaContext(JpaContext jpaContext) {
		this.em = jpaContext.getEntityManagerByManagedType(Concert.class);
	}
	
	
	@Override
	public List<Concert> search(String genre, String name, String artist, String date, String place, Double priceMax,
			boolean active) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Concert> query = builder.createQuery(Concert.class);
		Root<Concert> root = query.from(Concert.class);
		Predicate genrePredicate = builder.and();
		Predicate namePredicate = builder.and();
		Predicate artistPredicate = builder.and();
		Predicate datePredicate = builder.and();
		Predicate placePredicate = builder.and();
		Predicate pricemaxPredicate = builder.and();
		Predicate activePredicate = builder.and();
		
		if(!StringUtils.isEmpty(genre)) {
			genrePredicate = builder.like(builder.upper(root.get("genre")),"%" + genre.toUpperCase() + "%");
		}
		if(!StringUtils.isEmpty(name)) {
			namePredicate = builder.like(builder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
		}
		if(!StringUtils.isEmpty(artist)) {
			artistPredicate = builder.like(builder.upper(root.get("artist")), "%" + artist.toUpperCase() + "%");
			}
		// à voir comment faire pour la date
		if(!StringUtils.isEmpty(date)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.parse(date, formatter);
			datePredicate = builder.equal(root.get("date"), localDate);
		}
		if(!StringUtils.isEmpty(place)) {
			placePredicate = builder.like(builder.upper(root.get("place")), "%" + place.toUpperCase() + "%");
		}
		if(!StringUtils.isEmpty(priceMax)) {
			pricemaxPredicate = builder.le(root.get("price"),priceMax);
		}
		activePredicate = builder.isTrue(root.get("active"));

		
		query.where(builder.and(
				genrePredicate,
				namePredicate,
				artistPredicate,
				datePredicate,
				placePredicate,
				pricemaxPredicate,
				activePredicate
				));
		System.out.println(query);
		
		TypedQuery<Concert> concertQuery = em.createQuery(query);
		
		return concertQuery.getResultList();
	}
	
	@Override
	public List<Concert> searchAdmin(String genre, String name, String artist, String date, String place, Double priceMax,
			boolean active) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Concert> query = builder.createQuery(Concert.class);
		Root<Concert> root = query.from(Concert.class);
		Predicate genrePredicate = builder.and();
		Predicate namePredicate = builder.and();
		Predicate artistPredicate = builder.and();
		Predicate datePredicate = builder.and();
		Predicate placePredicate = builder.and();
		Predicate pricemaxPredicate = builder.and();
		Predicate activePredicate = builder.and();
		
		if(!StringUtils.isEmpty(genre)) {
			genrePredicate = builder.like(builder.upper(root.get("genre")),"%" + genre.toUpperCase() + "%");
		}
		if(!StringUtils.isEmpty(name)) {
			namePredicate = builder.like(builder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
		}
		if(!StringUtils.isEmpty(artist)) {
			artistPredicate = builder.like(builder.upper(root.get("artist")), "%" + artist.toUpperCase() + "%");
			}
		// à voir comment faire pour la date
		if(!StringUtils.isEmpty(date)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.parse(date, formatter);
			datePredicate = builder.equal(root.get("date"), localDate);
		}
		if(!StringUtils.isEmpty(place)) {
			placePredicate = builder.like(builder.upper(root.get("place")), "%" + place.toUpperCase() + "%");
		}
		if(!StringUtils.isEmpty(priceMax)) {
			pricemaxPredicate = builder.le(root.get("price"),priceMax);
		}



		
		query.where(builder.and(
				genrePredicate,
				namePredicate,
				artistPredicate,
				datePredicate,
				placePredicate,
				pricemaxPredicate
				));
		System.out.println(query);
		
		TypedQuery<Concert> concertQuery = em.createQuery(query);
		
		return concertQuery.getResultList();
	}

}
