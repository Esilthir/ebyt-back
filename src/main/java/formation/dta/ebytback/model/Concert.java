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
	private int nbMaxPlaces;
	@Column
	private int price;
	@Column
	private int nbBoughtPlace;

	public Concert() {}

	public Concert(String artist, Date date, String place, String genre, String description, int nbMaxPlaces,
			int price, int nbBoughtPlace) {
		this.artist = artist;
		this.date = date;
		this.place = place;
		this.genre = genre;
		this.description = "";
		this.nbMaxPlaces = 0;
		this.price = 0;
		this.nbBoughtPlace = 0;
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


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNbMaxPlaces() {
		return nbMaxPlaces;
	}

	public void setNbMaxPlaces(int nbMaxPlaces) {
		this.nbMaxPlaces = nbMaxPlaces;
	}

	public int getNbBoughtPlace() {
		return nbBoughtPlace;
	}

	public void setNbBoughtPlace(int nbBoughtPlace) {
		this.nbBoughtPlace = nbBoughtPlace;
	}
	
	


}