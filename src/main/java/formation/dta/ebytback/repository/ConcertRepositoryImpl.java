package formation.dta.ebytback.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
	public List<Concert> search(String genre, String name, String artist, LocalDate date, String place, Double pricemax,
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
		
		
		if(!StringUtils.isEmpty(genre)) {
			genrePredicate = builder.like(root.get("genre"),"%" + genre + "%");
		}
		if(!StringUtils.isEmpty(name)) {
			namePredicate = builder.like(root.get("name"), "%" + name + "%");
		}
		if(!StringUtils.isEmpty(artist)) {
			artistPredicate= builder.like(root.get("artist"), "%" + artist + "%");
		}
		if(!StringUtils.isEmpty(date)) {
			datePredicate = builder.equal(root.get("date"),date);
		}
		if(!StringUtils.isEmpty(place)) {
			placePredicate = builder.like(root.get("place"), "%" + place +"%");
		}
		if(!StringUtils.isEmpty(pricemax)) {
			pricemaxPredicate = builder.le(root.get("price"),pricemax);
		}
//		if(!StringUtils.isEmpty(active)) {
//			query.where(builder.isTrue(root.get("active")));
//		}
		
		query.where(builder.and(
				genrePredicate,
				namePredicate,
				artistPredicate,
				datePredicate,
				placePredicate,
				pricemaxPredicate
				));
		
		TypedQuery<Concert> concertQuery = em.createQuery(query);
		
		return concertQuery.getResultList();
	}

}
