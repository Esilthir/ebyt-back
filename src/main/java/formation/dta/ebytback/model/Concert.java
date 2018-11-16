package formation.dta.ebytback.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "concert")
public class Concert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String artist;
	@Column
	private Date date;
	@Column
	private String place;
	@Column
	private String genre;
	@Column
	private String description;
	@Column
	private Integer nbMaxPlaces;
	@Column
	private Integer price;
	@Column
	private Integer nbBoughtPlace;

	public Concert() {}

	public Concert(String artist, Date date, String place, String genre, String description, Integer nbMaxPlaces,
			Integer price, Integer nbBoughtPlace) {
		this.artist = artist;
		this.date = date;
		this.place = place;
		this.genre = genre;
		this.description = description;
		this.nbMaxPlaces = nbMaxPlaces;
		this.price = price;
		this.nbBoughtPlace = nbBoughtPlace;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNbMaxPlaces() {
		return nbMaxPlaces;
	}

	public void setNbMaxPlaces(Integer nbMaxPlaces) {
		this.nbMaxPlaces = nbMaxPlaces;
	}

	public Integer getNbBoughtPlace() {
		return nbBoughtPlace;
	}

	public void setNbBoughtPlace(Integer nbBoughtPlace) {
		this.nbBoughtPlace = nbBoughtPlace;
	}
}